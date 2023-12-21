package com.jsp.system;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jsp.test.DBMap;

public class DBConnector implements Closeable{
	private SqlSession session = null;
	
	
	public <T> T
		OpenMap(HttpServletRequest req, Class<T> map) throws IOException{
		InputStream in = 
			req
			.getServletContext()
			.getResourceAsStream("/WEB-INF/config/mybatis_config.xml");
	
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(in);
		factory.getConfiguration().addMapper(map);
		session = factory.openSession(true);
		return session.getMapper(map);
	}		


	@Override
	public void close() throws IOException{
		session.close();
		
	}
	
}
