package com.grapeqin.project;

import com.grapeqin.project.dao.DepartmentMapper;
import com.grapeqin.project.dao.UserMapper;
import com.grapeqin.project.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 启动类 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private DepartmentMapper departmentMapper;

	@Autowired
	private UserMapper userMapper;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userMapper.getAllUsers().stream()
				.forEach(
						(u) -> {
							System.out.println(u);
						});

		User user = new User();
		user.setId(1L);
		System.out.println(userMapper.getUserById(user));

		System.out.println(userMapper.getUserById(1L));

		System.out.println("========");
		departmentMapper.selectAll().stream().forEach(department -> System.out.println(department));

		//		departmentMapper.insert(Department.builder().departmentId(3)
		//		.departmentName("培训部").build());
		System.out.println(
				departmentMapper.selectByPrimaryKey(3));
	}
}
