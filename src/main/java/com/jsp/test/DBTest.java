package com.jsp.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@WebServlet(urlPatterns = {
		"/test"
})

public class DBTest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(InputStream in = 
				req.getServletContext().getResourceAsStream("/WEB-INF/config/mybatis_config.xml");)
		{
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(in);
			factory.getConfiguration().addMapper(DBMap.class);
			SqlSession session = factory.openSession(true);
			// AutoCommit
			
//			session.commit();
//			session.rollback();
			
			// interface Mapping
			
//			List<MovieDTO> movies = map.getMovies();
			
			
			
			
//			for(MovieDTO dto : movies) {
//				System.out.println(dto.getName());
//			}
//			
			DBMap map = session.getMapper(DBMap.class);
			
			map.insertProd(5, "남준형");
			
			List<ProdDTO> prods = map.selectProd();
			
			for(ProdDTO dto : prods) {
				System.out.println(dto.getId());
				System.out.println(dto.getName());
			}
			
			session.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
