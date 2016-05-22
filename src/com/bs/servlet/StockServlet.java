package com.bs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import com.bs.service.CompanyConvertService;
import com.bs.service.CompanyService;
import com.bs.service.PersonConvertService;
import com.bs.service.RelationService;

@WebServlet("/StockServlet")
public class StockServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StockServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("in");
		name = new String(name.getBytes("ISO-8859-1"),"utf-8");
		//RelationService rs = new RelationService();
//		for(int i=116;i<=40313;i++){
//			System.out.println("********"+i);
//			rs.getRelationByPersonId3(i);
//		}
		//CompanyService cs = new CompanyService();
	//	cs.getJsonFile();
		
		if(name.length()<4){
			PersonConvertService pcs = new PersonConvertService();
			int fileId = pcs.getPersonIdByName(name);
			request.setAttribute("fileName", String.valueOf(fileId));
			request.setAttribute("personName", name);
			request.getRequestDispatcher("/person/person.jsp").forward(request, response);
		}
		if(name.length()>=4){
			CompanyConvertService ccs = new CompanyConvertService();
			String fileId = ccs.getStockIdByName(name);
			request.setAttribute("fileName", fileId);
			request.setAttribute("companyName", name);
			request.getRequestDispatcher("/company/company.jsp").forward(request, response);
		}
		
	}
}
