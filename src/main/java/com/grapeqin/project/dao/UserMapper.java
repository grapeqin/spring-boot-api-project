package com.grapeqin.project.dao;

import com.grapeqin.project.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @description
 * @author qinzy
 * @date 2020-04-13
 */
@Mapper
public interface UserMapper {

	User getUserById(@Param("id") Long id);

	User getUserById(User user);

	@Select("select id,name,age,create_time,update_time from user")
	@Results(
			value = {
					@Result(column = "create_time", property = "createTime"),
					@Result(column = "update_time", property = "updateTime")
			})
	List<User> getAllUsers();
}
