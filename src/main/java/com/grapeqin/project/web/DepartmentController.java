package com.grapeqin.project.web;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grapeqin.project.core.Result;
import com.grapeqin.project.core.ResultGenerator;
import com.grapeqin.project.model.Department;
import com.grapeqin.project.service.DepartmentService;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** Created by CodeGenerator on 2020/04/13. */
@RestController
@RequestMapping("/department")
public class DepartmentController {
  @Resource private DepartmentService departmentService;

  @PostMapping("/add")
  public Result add(Department department) {
    departmentService.save(department);
    return ResultGenerator.genSuccessResult();
  }

  @PostMapping("/delete")
  public Result delete(@RequestParam Integer id) {
    departmentService.deleteById(id);
    return ResultGenerator.genSuccessResult();
  }

  @PostMapping("/update")
  public Result update(Department department) {
    departmentService.update(department);
    return ResultGenerator.genSuccessResult();
  }

  @PostMapping("/detail")
  public Result detail(@RequestParam Integer id) {
    Department department = departmentService.findById(id);
    return ResultGenerator.genSuccessResult(department);
  }

  @PostMapping("/list")
  public Result list(
      @RequestParam(defaultValue = "0") Integer page,
      @RequestParam(defaultValue = "0") Integer size) {
    PageHelper.startPage(page, size);
    List<Department> list = departmentService.findAll();
    PageInfo pageInfo = new PageInfo(list);
    return ResultGenerator.genSuccessResult(pageInfo);
  }
}
