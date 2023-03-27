package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.CompanyDao;
import model.dao.MemberDao;
import model.dto.emp.EmpDto;



@WebServlet("/member/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int empno = Integer.parseInt(request.getParameter("empno"));
		System.out.println("empno : " + empno);
		if(empno==0) { // 로그인 안되어있으면
			response.getWriter().print(false);
		}else {
			EmpDto result = MemberDao.getInstance().getEmpInfo(empno);
			System.out.println("반환할 dto : " + result);
			
			ObjectMapper mapper = new ObjectMapper();
			String json= mapper.writeValueAsString(result);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(json);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post로 넘어옴");
		request.setCharacterEncoding("UTF-8");
		int cloginno = Integer.parseInt(request.getParameter("cloginno"));
		System.out.println("cloginno : " +cloginno);
		String empid = request.getParameter("empid");
		System.out.println("empid : " +empid);
		String emppwd = request.getParameter("emppwd");
		System.out.println("emppwd : " +emppwd);
		int empno = MemberDao.getInstance().getEmpno(empid);
		int comno = CompanyDao.getInstance().getcomno(cloginno);
		System.out.println("empno : " +empno);
		// 2. DAO 호출해서 요청데이터를 보내서 결과 얻기 
		boolean result = MemberDao.getInstance().login(cloginno, empid, emppwd);
		if( result == true ) { // 만약에 로그인 성공했으면 
			request.getSession().setAttribute( "comno", comno );
			request.getSession().setAttribute( "empno", empno );
		}
		// 3. Dao 받은 결과를 AJAX에게 전달 
		response.getWriter().print(result);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
