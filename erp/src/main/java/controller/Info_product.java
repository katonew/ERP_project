package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import model.dao.RequestDao;
import model.dto.InfoRequestDto;
import model.dto.ProductDto;
import model.dto.RequestDto;

/**
 * Servlet implementation class Info_product
 */
@WebServlet("/request/info_product")
public class Info_product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Info_product() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		System.out.println("넘어옴");
		ObjectMapper mapper = new ObjectMapper();
	    RequestDto requestDto = mapper.readValue(request.getInputStream(), RequestDto.class);
	    System.out.println("requestDto : " + requestDto);
	    List<InfoRequestDto> products = requestDto.getProducts();
	    boolean result = false;
    	for(int i=0;i<products.size();i++) {
    		int ino = products.get(i).getIno();
    		System.out.println("ino :" + ino);
    		int quantity = products.get(i).getQuantity();
    		System.out.println("quantity :" + quantity);
    		result = RequestDao.getInstance().iupdate(ino,quantity);
    	}
		response.getWriter().print(result);
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
