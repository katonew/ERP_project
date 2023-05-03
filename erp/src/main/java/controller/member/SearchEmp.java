package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dto.emp.EmpDto;

@WebServlet("/searchemp")
public class SearchEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchEmp() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int type = Integer.parseInt(request.getParameter("type"));
		int comno =  Integer.parseInt((String) request.getSession().getAttribute("comno"));
		ArrayList<EmpDto>  result = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		if(type==1) {
			result = MemberDao.getInstance().getAllList(comno);
		}else if(type==2) {
			String search = request.getParameter("search");
			result = MemberDao.getInstance().getSearchList(comno,search);
		}
		String json = mapper.writeValueAsString(result);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
