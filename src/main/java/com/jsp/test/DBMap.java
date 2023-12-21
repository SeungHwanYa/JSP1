package com.jsp.test;

import java.io.*;
import java.util.*;

import org.apache.ibatis.annotations.*;

import com.jsp.test.*;

@Mapper
public interface DBMap {
	
	@Insert("insert into Prod values (#{id}, #{name})")
	public void insertProd(@Param("id") int id, @Param("name") String name);
	
	@Select("select * from prod where id = #{id}")
	public ProdDTO selectProdById(@Param("id") int id);
	
	@Select("select * from prod")
	public List<ProdDTO> selectProd();


	
//	@SelectProvider(type=com.jsp.test.Provider.class, method="selectProvider")
//	public ProdDTO getProd2(@Param("id") int id);
//	
//	@Insert("insert into prod values (#{id},#{name})")
//	public void insertProd(@Param("id") int id, @Param("name") String name);
//	
//	@Select("select * from prod")
//	@Results(id="prodList", value= {
//			@Result(property="id", column="id", id=true ),  // 이 줄은 기본키라는 의미이다
//			@Result(property="name", column="name")
//		}
//	)
//	public List<ProdDTO> getProd();
//	
//	// 검색을 하다보면 정해진 검색이 아니라 매번 변화하는 검색을 하는 경우도 매우 많다
//	// 어노테이션에 특정위치에 내가 작성한 값이 들어가도록 변경하는 기능
//	// @Param 어노테이션, #{}
//	// #{} prepared -> 자동으로 문자열화 -> '4' -> ?
//	// ${} statement -> 붙이기 방식 -> a_${5} -> a_5
//	// 계정 검색
//	// select * from users where id = #{} and pw = #{B}
//	// select * from users where id = 'A' and pw = 'B'
//	// select * from users where id = ${'' or true} and pw = ${'' or true}
//    // select * from users where id = '' or pw = 'B'
//	// 매개변수 앞에 @Param("이름") -> 내가 질의문에 #{이름}이라고 적으면 해당 위치에 
//	// 매개변수 값을 문자열로 변형해서 넣어줄거야
//	
//	@Select("select * from prod where prod.id = #{prodid}")
//	public ProdDTO getProdById(@Param("prodid") int prodid);
//	
//	@Select("select * from movie")
//	@Results(id="moveDTO", value= {
//			@Result(property="id", column="id", id=true ),  // 이 줄은 기본키라는 의미이다
//			@Result(property="name", column="name"),
//			@Result(property="prod", column="prodid", one=@One(select="getProdById"))
//		}
//	)
//	public List<MovieDTO> getMovies();

}
