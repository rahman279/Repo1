<%@page import = "com.tech.sanity.*" %>
<%@page import = "java.io.*" %>

<%


String newUser = (String)request.getParameter("newUser");
String user = (String)request.getParameter("user");
String option = (String)request.getParameter("option");

if(option != null){
	System.out.println("option = "+option);
	System.out.println("newUser = "+newUser);
	System.out.println("user = "+user);
	
	response.setContentType("text/html");
	PrintWriter printWriter = response.getWriter();
	if(option.equalsIgnoreCase("add")){
		int ret = Test.addUser(newUser);
		if(ret == Test.USER_ALREADY_EXIST){
			request.getRequestDispatcher("createUser.jsp").include(request, response);
			printWriter.print("user already exist, try another user");
		}
		else if(ret == Test.USER_ADDED){
			printWriter.print("user created");
		}
		else if(ret == Test.INVALID_USER){
			printWriter.print("invalid user");
		}
		else if(ret == Test.UPDATION_FAILED){
			printWriter.print("updation failed");
		}
		
		
	}
	else{
		int ret = Test.deleteUser(user);
		if(ret == Test.USER_DOES_NOT_EXIST){
			request.getRequestDispatcher("deleteUser.jsp").include(request, response);
			printWriter.print("requested user does not exist");
		}
		else if(ret == Test.USER_DELETED){
			printWriter.print("user deleted");
		}
		else if(ret == Test.DELETION_FAILED){
			printWriter.print("deletion failed");
		}
		else if(ret == Test.PROBLEMS_OCCURED_WHILE_STORING){
			printWriter.print("problems occured while storing");
		}
		
		
	}

}

%>