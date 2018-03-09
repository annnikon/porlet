package com.aimprosoft.task5.dao.springhibernate;

public interface HqlStatements {

    String DEPARTMENTS_ALL_HQL = " FROM Department ";
    String DEPARTMENT_DELETE_HQL = " DELETE "+DEPARTMENTS_ALL_HQL;

    String EMPLOYEES_ALL_HQL = " FROM Employee ";
    String EMPLOYEE_DECLARED_FIELDS = " (email, name, birthday, room, department) ";
    String EMPLOYEE_NEW_FIELDS = " (:email, :name, :birthday, :room, :department ";
    String EMPLOYEE_UPDATED_FIELDS = "email = :email, name = :name, birthday = :birthday, room = :room, department = :department";
    String EMPLOYEE_INSERT_HQL = " INSERT INTO Employee "+EMPLOYEE_DECLARED_FIELDS+" VALUES "+EMPLOYEE_NEW_FIELDS;
    String EMPLOYEE_UPDATE_HQL ="UPDATE Employee SET "+EMPLOYEE_UPDATED_FIELDS;

    String ID_CONDITION = " WHERE id = :id";
    String NAME_CONDITION = " WHERE name = :name";
    String EMAIL_CONDITION = " WHERE email = :email";
    String DEPARTMENT_CONDITION = " WHERE department = :department";

}
