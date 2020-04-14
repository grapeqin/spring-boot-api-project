package com.grapeqin.project;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grapeqin.project.dao.DepartmentMapper;
import com.grapeqin.project.model.Department;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description
 * @author qinzy
 * @date 2020-04-14
 */
public class DepartmentMapperTest extends Tester {
	@Autowired
	private DepartmentMapper departmentMapper;

	@Test
	public void testDepartmentMapperSelect() {
		Department department = departmentMapper.selectByPrimaryKey(1);
		Assert.assertNotNull(department);
		Assert.assertEquals(Integer.valueOf(1), department.getDepartmentId());
		Assert.assertEquals("用户", department.getDepartmentName());

		department = Department.builder().departmentName("营销").build();
		List<Department> result = departmentMapper.select(department);
		Assert.assertEquals(result.size(), 1);
		result.stream().forEach(department1 -> System.out.println(department1));

		result = departmentMapper.selectAll();
		Assert.assertEquals(3, result.size());
		Assert.assertEquals(
				Department.builder().departmentId(1).departmentName("用户").build(), result.get(0));
		Assert.assertEquals(
				Department.builder().departmentName("营销").departmentId(2).build(), result.get(1));
		Assert.assertEquals(
				Department.builder().departmentName("培训部").departmentId(3).build(), result.get(2));
	}

	@Test
	public void testDepartmentMapperCUD() {
		Department department1 = Department.builder().departmentId(4).build();
		int count = departmentMapper.insert(department1);
		Assert.assertEquals(1, count);
		Department result = departmentMapper.selectByPrimaryKey(4);
		Assert.assertEquals(department1.getDepartmentName(),
				result.getDepartmentName());

		department1.setDepartmentName("设计部");
		count = departmentMapper.updateByPrimaryKey(department1);
		Assert.assertEquals(1, count);
		result = departmentMapper.selectByPrimaryKey(4);
		Assert.assertEquals(department1.getDepartmentName(),
				result.getDepartmentName());

		count = departmentMapper.selectCount(null);
		Assert.assertEquals(4, count);

		count = departmentMapper.deleteByPrimaryKey(4);
		Assert.assertEquals(1, count);
		result = departmentMapper.selectByPrimaryKey(4);
		Assert.assertNull(result);
	}

	@Test
	public void testDepartmentMapperPage() {
		PageHelper.startPage(1, 1);
		PageInfo<Department> pageInfo =
				PageInfo.of(departmentMapper.selectAll());
		Assert.assertNotNull(pageInfo);
		Assert.assertEquals(pageInfo.getPages(), 3);
		Assert.assertEquals(pageInfo.getTotal(), 3);
		Assert.assertEquals(pageInfo.getStartRow(), 1);

	}
}
