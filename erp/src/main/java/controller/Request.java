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
import model.dao.ProductDao;
import model.dao.RequestDao;
import model.dto.CustDto;
import model.dto.ProductDto;
import model.dto.RequestDto;


@WebServlet("/request")
public class Request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Request() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<RequestDto> result = RequestDao.getInstance().allproduct();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(result);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String enter_date = request.getParameter("enter_date");
		int custno = Integer.parseInt(request.getParameter("custno"));
		int pno = Integer.parseInt(request.getParameter("pno"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		RequestDto dto = new RequestDto(enter_date, 1, pno, quantity, custno, 1);
		boolean result = RequestDao.getInstance().newrequest(dto);
		response.getWriter().print(result);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
