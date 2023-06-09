package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.CustDao;
import model.dto.CustDto;


@WebServlet("/cust")
public class Cust extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Cust() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		ArrayList<CustDto> result = null;
		if(type.equals("1")) {
			result = CustDao.getInstance().allcust();
		}else if(type.equals("2")) {
			int custno = Integer.parseInt(request.getParameter("custno"));
			result = CustDao.getInstance().getcust(custno);
		}else if(type.equals("3")) {
			String search = request.getParameter("search");
			result = CustDao.getInstance().searchcust(search);
		}
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(result);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cname = request.getParameter("cname");
		String custemp = request.getParameter("custemp");
		String custphone = request.getParameter("custphone");
		String custaddress = request.getParameter("custaddress");
		
		CustDto dto = new CustDto(0, cname, custemp, custphone, custaddress, 1);
		
		boolean result = CustDao.getInstance().newcust(dto);
		
		response.getWriter().print(result);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int custno = Integer.parseInt(request.getParameter("custno"));
		String cname = request.getParameter("cname");
		String custemp = request.getParameter("custemp");
		String custphone = request.getParameter("custphone");
		String custaddress = request.getParameter("custaddress");
		int comno = Integer.parseInt(String.valueOf(request.getSession().getAttribute("comno")));
		CustDto dto = new CustDto(custno, cname, custemp, custphone, custaddress, comno);
		
		boolean result = CustDao.getInstance().custupdate(dto);
		
		response.getWriter().print(result);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int custno = Integer.parseInt(request.getParameter("custno"));
		boolean result = CustDao.getInstance().deleteCust(custno);
		response.getWriter().print(result);
	}

}
