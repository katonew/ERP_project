package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProductDao;
import model.dao.RequestDao;
import model.dto.ProductDto;
import model.dto.RequestDto;


@WebServlet("/request")
public class Request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Request() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String enter_date = request.getParameter("enter_date");
		int custno = Integer.parseInt(request.getParameter("custno"));
		int pno = Integer.parseInt(request.getParameter("pno"));
		RequestDto dto = new RequestDto(enter_date, 1, pno, custno, pno);
		boolean result = RequestDao.getInstance().newrequest(dto);
		response.getWriter().print(result);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
