package com.aimprosoft.task5.service.impl;

import com.aimprosoft.task5.dao.DepartmentDao;
import com.aimprosoft.task5.model.Department;
import com.aimprosoft.task5.service.DepartmentService;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;

<<<<<<< HEAD
@Service
=======

>>>>>>> f38a99bc174e231dfec3b61970ee1e9d99663a85
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;
    
    public void setDepartmentDao(DepartmentDao departmentDao) {
    	this.departmentDao=departmentDao;
    }


<<<<<<< HEAD
=======

>>>>>>> f38a99bc174e231dfec3b61970ee1e9d99663a85
    public boolean addDepartment(Department department) {
        return departmentDao.add(department);
    }

    public Iterable<Department> listDepartments() {
        return departmentDao.list();
    }


    public boolean deleteDepartment(long id) {
        return departmentDao.delete(id);

    }

    public boolean editDepartment(long id, Department department) {
        return departmentDao.update(id, department);
    }

    public Department getById(long id) {
        return departmentDao.getById(id);
    }


    public Department getByName(String name) {
        return departmentDao.getByName(name);
    }

    public boolean isNameUnique(long id, String name) {
        Department existing = getByName(name);
        return existing == null || existing.getId() == id;
    }

}
