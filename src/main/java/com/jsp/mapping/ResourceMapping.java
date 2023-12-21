package com.jsp.mapping;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; // request -> 요청
import javax.servlet.http.HttpServletResponse; // response -> 응답
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet; 

@WebServlet(urlPatterns = {
		"/resources/*",
		"/resource/*"
		}, initParams = {
				@WebInitParam(name="key",value="값")
		})

public class ResourceMapping extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("utf-8");
		
		String info = req.getPathInfo();
		String token = info.substring(info.lastIndexOf('.') + 1);
		if(token.equalsIgnoreCase("js")) {
			resp.setContentType("application/javascript");
			try(OutputStream out = resp.getOutputStream();
					InputStream in = getServletContext().getResourceAsStream("/WEB-INF/resource/" + token + info);){
				out.write(in.readAllBytes());
			}catch(Exception e) {}	
		}
		else if(token.equalsIgnoreCase("css")) {
			resp.setContentType("text/css");
			try(OutputStream out = resp.getOutputStream();
					InputStream in = getServletContext().getResourceAsStream("/WEB-INF/resource/" + token + info);){
				out.write(in.readAllBytes());
			}catch(Exception e) {}	
		}
		else if(token.equalsIgnoreCase("jpeg") || token.equalsIgnoreCase("jpg")) {
			resp.setContentType("image/jpeg");
			try(OutputStream out = resp.getOutputStream();
					InputStream in = getServletContext().getResourceAsStream("/WEB-INF/resource/" + "image/original" + info);){
				out.write(in.readAllBytes());
			}catch(Exception e) {}
		}
		else if(token.equalsIgnoreCase("png")) {
			resp.setContentType("image/png");
			try(OutputStream out = resp.getOutputStream();
					InputStream in = getServletContext().getResourceAsStream("/WEB-INF/resource/" + "image/original" + info);){
				out.write(in.readAllBytes());
			}catch(Exception e) {}	
		}
		else if(token.equalsIgnoreCase("gif")) {
			resp.setContentType("image/gif");
			try(OutputStream out = resp.getOutputStream();
					InputStream in = getServletContext().getResourceAsStream("/WEB-INF/resource/" + "image/original" + info);){
				out.write(in.readAllBytes());
			}catch(Exception e) {}	
		}
	}
}