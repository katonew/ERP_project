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
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
