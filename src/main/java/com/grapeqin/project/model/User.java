package com.grapeqin.project.model;

import java.util.Date;
import lombok.Data;

/**
 * @description
 * @author qinzy
 * @date 2020-04-13
 */
@Data
public class User {
	private Long id;

	private String name;

	private Integer age;

	private Date createTime;

	private Date updateTime;
}
