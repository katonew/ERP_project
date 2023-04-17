package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import model.dto.InfoRequestDto;
import model.dto.ProductDto;
import model.dto.RequestDto;


@WebServlet("/request")
public class Request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Request() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = (String)request.getParameter("type");
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<RequestDto> result = new ArrayList<>();
		if(type.equals("1")) {
			result = RequestDao.getInstance().allrequest();
		}else if(type.equals("2")) {
			int rno = Integer.parseInt(request.getParameter("rno"));
			result = RequestDao.getInstance().getRequest(rno);
		}
		String json = mapper.writeValueAsString(result);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ObjectMapper mapper = new ObjectMapper();
	    RequestDto requestDto = mapper.readValue(request.getInputStream(), RequestDto.class);
	    String delivery_date = requestDto.getDelivery_date();
	    System.out.println("enter_date : " + delivery_date);
	    int custno = requestDto.getCustno();
	    System.out.println("custno : " + custno);
	    int empno = requestDto.getEmpno();
	    System.out.println("empno : " + empno);
	    int comno = requestDto.getComno();
	    System.out.println("comno : " + comno);
	    List<InfoRequestDto> products = requestDto.getProducts();
	    System.out.println("products : " + products);
	    RequestDto dto = new RequestDto(delivery_date, empno, custno, comno, products);
		boolean result = RequestDao.getInstance().newrequest(dto);
		response.getWriter().print(result);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = (String)request.getParameter("type");
		boolean result = false;
		int rno = Integer.parseInt(request.getParameter("rno"));
		if(type.equals("1")) {
			request.setCharacterEncoding("UTF-8");
			int custno = Integer.parseInt(request.getParameter("custno"));
			int pno = Integer.parseInt(request.getParameter("pno"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			result = RequestDao.getInstance().requestUpdate(rno,custno,pno,quantity);
		}else if(type.equals("2")) {
			boolean state = Boolean.parseBoolean(request.getParameter("state"));
			result = RequestDao.getInstance().stateUpdate(rno,state);
		}
		response.getWriter().print(result);
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("가져온 rno : " + request.getParameter("rno"));
		int rno = Integer.parseInt(request.getParameter("rno"));
		boolean result = RequestDao.getInstance().requestDelete(rno);
		response.getWriter().print(result);
	}

}
