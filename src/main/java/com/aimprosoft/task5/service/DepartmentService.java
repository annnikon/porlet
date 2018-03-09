package com.aimprosoft.task5.service;


import com.aimprosoft.task5.model.Department;

public interface DepartmentService {

    Iterable<Department> listDepartments();

    boolean addDepartment(Department department);

    boolean deleteDepartment(long id);

    boolean editDepartment(long id, Department department);

    Department getById(long id);

    Department getByName(String name);

    boolean isNameUnique(long id, String name);
}
