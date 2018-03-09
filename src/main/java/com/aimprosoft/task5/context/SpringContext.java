package com.aimprosoft.task5.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aimprosoft.task5.service.DepartmentService;
import com.aimprosoft.task5.service.EmployeeService;

public class SpringContext {
    static ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

    public static DepartmentService getDepartmentService() {
        return context.getBean("departmentService", DepartmentService.class);
    }

    public static EmployeeService getEmloyeeService() {
        return context.getBean("employeeService", EmployeeService.class);
    }
}