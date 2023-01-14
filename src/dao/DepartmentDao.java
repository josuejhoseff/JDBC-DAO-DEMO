package dao;

import java.util.List;

import entities.Department;

public interface DepartmentDao {
	
	void insert(Department dep);
	void update(Department dep);
	void deletById(Integer id);
	Department findById(Integer id);
	List<Department> findAll();
}
