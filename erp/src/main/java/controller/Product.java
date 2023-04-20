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
import model.dto.CustDto;
import model.dto.ProductDto;


@WebServlet("/product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Product() {super();}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ProductDto> result = new ArrayList<>();
		int type = Integer.parseInt(request.getParameter("type"));
		if(type==1) {
			result = ProductDao.getInstance().allproduct();
		}else if(type==2) {
			int pno = Integer.parseInt(request.getParameter("pno"));
			result = ProductDao.getInstance().getproduct(pno);
		}else if(type==3) {
			String search = request.getParameter("search");
			result = ProductDao.getInstance().searchproduct(search);
		}
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(result);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pname = request.getParameter("pname");
		int pprice = Integer.parseInt(request.getParameter("pprice"));
		int comno = Integer.parseInt((String)request.getSession().getAttribute("comno"));
		
		ProductDto dto = new ProductDto(0, pname, pprice, comno);
		
		boolean result = ProductDao.getInstance().newproduct(dto);
		response.getWriter().print(result);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int pno = Integer.parseInt(request.getParameter("pno"));
		String pname = request.getParameter("pname");
		int pprice = Integer.parseInt(request.getParameter("pprice"));
		int comno = Integer.parseInt(String.valueOf(request.getSession().getAttribute("comno"))) ;
		ProductDto dto = new ProductDto(pno, pname, pprice, comno);
		boolean result = ProductDao.getInstance().pupdate(dto);
		response.getWriter().print(result);
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno"));
		boolean result = ProductDao.getInstance().deleteProduct(pno);
		response.getWriter().print(result);
	}

}
