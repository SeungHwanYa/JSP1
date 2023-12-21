<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, org.json.*"  %>  
<%@ page import="com.jsp.dao.*, com.jsp.dto.*, com.jsp.system.DBConnector "%> 
   
<%	
	try(DBConnector con = new DBConnector();){
		if( ! request.getMethod().equalsIgnoreCase("GET")) throw new Exception();
		BoardDAO map = con.OpenMap(request, BoardDAO.class);

		BoardUser user = 
				map.getBoardUserCheck(request.getParameter("id"), request.getParameter("pw"));
		if(user == null) throw new Exception();
		
		map.insertBoard(request.getParameter("title"), user.getId());
		
		response.getWriter().write("Succeed!");
}
	catch(Exception e){
		response.getWriter().write("잘못된 접속이거나 정보를 전달하였습니다.");
	}
%>