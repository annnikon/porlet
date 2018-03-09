package com.aimprosoft.task5.service;

import com.aimprosoft.task5.model.Employee;


public interface EmployeeService {

    boolean addEmployee(Employee employee);

    Iterable<Employee> listEmployees(String department);

    boolean deleteEmployee(long id);

    boolean editEmployee(long id, Employee employee);

    Employee getById(long id);

    Employee getByEmail(String email);

    boolean isEmailUnique(long id, String email);

}
