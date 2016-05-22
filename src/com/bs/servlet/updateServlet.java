package com.bs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.service.CompanyConvertService;
import com.bs.service.PersonConvertService;
import com.bs.service.updateCompanyThread;
import com.bs.service.updatePersonThread;
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public updateServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Thread t1 = new updateCompanyThread();
		//t1.start();
		Thread t2 = new updatePersonThread();
		t2.start();
		request.getRequestDispatcher("index.jsp").forward(request, response);	
	}
}
