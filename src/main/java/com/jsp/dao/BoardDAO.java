package com.jsp.dao;

import java.io.*;
import java.util.*;
import org.apache.ibatis.annotations.*;
import com.jsp.dto.*;

public interface BoardDAO {
	
	// Mysql vs Oracle
	// 게시글을 유저 아이디로 검색하는 기능(포함) 
	// 게시글을 번호로 검색하는 기능(정확) 
	// 게시글을 가져오면 테이블로 게시글번호, 게시글 타이틀, 작성자명으로 띄워주는 페이지
	// 단, 한 페이지당 5개로 제한하며 페이지 번호로 검색  
	
	@Select("select * from boardlist where id = #{id}")
	public List<Board> getBoardById(@Param("id") String id);
	
	@Select("select * from boardlist where title like '%${title}'")
	public List<Board> getBoardByTitle(@Param("title") String title);
	
	@Select("select * from boarduser where name = #{id} and password = #{pw}")
	public BoardUser getBoardUserCheck(@Param("id") String id, @Param("pw") String pw);
	@Delete("delete from boardlist where id = #{id}")
	public void deleteBoard(@Param("id") int id);
	@Insert("insert into boardlist values(seqbd.nextval, #{title}, #{id})")
	public void insertBoard(@Param("title") String title, @Param("id") int author_id);
	
	
	@Insert("insert into boarduser values(seqbu.nextval, #{id}, #{pw})")
	public void insertBoardUser(@Param("id") String id, @Param("pw") String pw);
	@Select("select * from boarduser")
	public List<BoardUser> getBoardUserAll();
	@Select("select * from boarduser where id = #{id}")
	public BoardUser getBoardUserById(@Param("id") int id);
	@Select("select * from boarduser where name = #{name}")
	public BoardUser getBoardUserByName(@Param("name") String name);
	@Results( id = "Board", value = {
			@Result(property="id", column="id"),
			@Result(property="title", column="title"),
			@Result(property="user", column="author_id", one=@One(select="getBoardUserById"))
	})
	@Select("select * from boardlist order by id desc")
	public List<Board> getBoardAll();
	
	@Select("select x.id, x.title, x.author_id from (select ROWNUM as num, result.* from (select * from boardlist order by id desc) result) x where num <= #{limit}")
	public List<Board> getBoardLimit(@Param("limit") int limit);
	
	@Select("select x.id, x.title, x.author_id from (select ROWNUM as num, result.* from (select * from boardlist order by id desc) result) x where num between #{limit} * #{page} + 1 and #{limit} * (#{page} + 1)")
	public List<Board> getBoardPage(@Param("limit") int limit, @Param("page")  int page);
	
}

 





