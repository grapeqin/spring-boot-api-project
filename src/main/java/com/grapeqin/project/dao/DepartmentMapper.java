package com.grapeqin.project.dao;

import com.github.pagehelper.PageInfo;
import com.grapeqin.project.core.Mapper;
import com.grapeqin.project.model.Department;
import java.util.List;

public interface DepartmentMapper extends Mapper<Department> {
	List<Department> selectByPageInfo(PageInfo pageInfo);
}
