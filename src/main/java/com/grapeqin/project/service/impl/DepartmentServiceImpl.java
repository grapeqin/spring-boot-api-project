package com.grapeqin.project.service.impl;

import com.grapeqin.project.dao.DepartmentMapper;
import com.grapeqin.project.model.Department;
import com.grapeqin.project.service.DepartmentService;
import com.grapeqin.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
* Created by CodeGenerator on 2020/04/13.
*/
@Service
@Transactional
public class DepartmentServiceImpl extends AbstractService<Department> implements DepartmentService {
@Resource
private DepartmentMapper departmentMapper;

}
