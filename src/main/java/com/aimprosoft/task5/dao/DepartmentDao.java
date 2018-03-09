package com.aimprosoft.task5.dao;

import com.aimprosoft.task5.model.Department;


public interface DepartmentDao {

    Iterable<Department> list();

    Department getById(long id);

    Department getByName(String name);

    boolean add(Department department);

    boolean delete(long id);

    boolean update(long id, Department department);
}
