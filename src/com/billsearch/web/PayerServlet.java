package com.billsearch.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.billsearch.bean.Payer;
import com.billsearch.dao.PayerDao;

/**
 * Servlet implementation class PayerServlet
 */
@WebServlet("/")
public class PayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PayerDao payerdao;   
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		payerdao = new PayerDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		
		switch(action)
		{
			case "/search":
				showPayerData(request, response);
				break;
			default:
				break;
		}
	}

	private void showPayerData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<Payer> payer;
		String name = request.getParameter("name");
		payer = payerdao.selectPayer(name);
		request.setAttribute("payer", payer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("payer-form.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("list");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
