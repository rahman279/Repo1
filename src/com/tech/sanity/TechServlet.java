package com.tech.sanity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TechServlet
 */

public class TechServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public TechServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	String name = "hgf";
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("user");
		String pwd = request.getParameter("pass");
		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// to get data from properties file

		Properties props = null;

		props = getProperties("WEB-INF/classes/Demo.properties");

		if (props.containsKey(uname)) {
			if (props.getProperty(uname).equals(pwd)) {

				request.getRequestDispatcher("jmsTest.jsp").forward(request, response);
				request.getSession().setAttribute("name", uname);
			} else {

				request.getRequestDispatcher("login.jsp").include(request, response);
				out.print("please enter valid credential");

			}
		} else {

			request.getRequestDispatcher("login.jsp").include(request, response);
			out.print("please enter valid username");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// method to read data from properties file

	public Properties getProperties(String fileName) throws IOException {

		Properties props = new Properties();
		props.load(getServletContext().getResourceAsStream(fileName));
		return props;
	}
	
	/*public String test(){
		
		return name;
		
	}*/

}
