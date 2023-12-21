<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, org.json.*"  %>  
<%@ page import="com.jsp.dao.*, com.jsp.dto.*, com.jsp.system.DBConnector "%> 

<%-- 게시글 작성 api 제작 --%>
<%-- 게시글 삭제 api 제작 --%>
<%-- 작성은 유저 name과 유저 password를 받아서 해당 유저인지 판별 후 아니면 Reject--%>
<%-- 맞다면 받아온 title로 해당 유저의 게시글로 작성 --%>
<%-- 게시글 삭제는 유저 name과 유저 password로 해당 유저인지 판별 후 아니면 Reject --%>
<%-- 맞다면 받아온 board id로 삭제 --%>

<%-- 게시글을 유저 아이디로 검색하는 기능(포함) --%>
<%-- 게시글을 번호로 검색하는 기능(정확) --%>
<%-- 게시글을 가져오면 테이블로 게시글번호, 게시글 타이틀, 작성자명으로 띄워주는 페이지 --%>
<%-- 단, 한 페이지당 5개로 제한하며 페이지 번호로 검색 --%>

<%	
	try(DBConnector con = new DBConnector();){
		BoardDAO map = con.OpenMap(request, BoardDAO.class);
		List<Board> exec = null;
		
		if(request.getParameter("searchtype") == null ||
				request.getParameter("searchtype").equalsIgnoreCase("all"))
			exec = map.getBoardAll();
		else if(request.getParameter("searchtype").equalsIgnoreCase("title"))
			exec = map.getBoardByTitle(request.getParameter("title"));
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", exec);
		response.getWriter().write(new JSONObject(result).toString());
}
	catch(Exception e){
	}
%>