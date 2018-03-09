package com.aimprosoft.task5.dao;


import com.aimprosoft.task5.model.Employee;

public interface EmployeeDao {

    Iterable<Employee> list(String departmentName);

    Employee getById(long id);

    Employee getByEmail(String email);

    boolean add(Employee employee);

    boolean delete(long id);

    boolean update(long id, Employee employee);
}
