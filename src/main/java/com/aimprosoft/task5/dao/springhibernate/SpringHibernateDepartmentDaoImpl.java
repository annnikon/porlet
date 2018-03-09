package com.aimprosoft.task5.dao.springhibernate;

import com.aimprosoft.task5.dao.DepartmentDao;
import com.aimprosoft.task5.model.Department;

import com.aimprosoft.task5.model.Employee;
<<<<<<< HEAD
import org.hibernate.Session;
import org.hibernate.SessionFactory;
=======
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.GenericJDBCException;
>>>>>>> f38a99bc174e231dfec3b61970ee1e9d99663a85
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


<<<<<<< HEAD
@Repository
public class SpringHibernateDepartmentDaoImpl implements DepartmentDao, HqlStatements {

	@Autowired
=======
import javax.persistence.PersistenceException;
import java.util.List;

public class SpringHibernateDepartmentDaoImpl implements DepartmentDao, HqlStatements {

  
>>>>>>> f38a99bc174e231dfec3b61970ee1e9d99663a85
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
    	this.sessionFactory=sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<Department> list() {
        return sessionFactory.getCurrentSession().createQuery(DEPARTMENTS_ALL_HQL).list();
    }

    @Override
    public Department getById(long id)   {
        return sessionFactory.getCurrentSession().get(Department.class, id);
   }

    @Override
    @SuppressWarnings("unchecked")
    public Department getByName(String name)   {
        Query<Department> query = sessionFactory.getCurrentSession()
                .createQuery(DEPARTMENTS_ALL_HQL + NAME_CONDITION);
        query.setParameter("name", name);
        return query.uniqueResult();

    }

    @Override
    public boolean add(Department department)   {
        sessionFactory.getCurrentSession().persist(department);
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Department department = session.get(Department.class, id);
        Query<Employee> querySelect = session.createQuery(EMPLOYEES_ALL_HQL + DEPARTMENT_CONDITION);
        querySelect.setParameter("department", department.getName());
        if (!querySelect.getResultList().isEmpty()) {
            return false;
        }
        session.delete(department);
        return true;

    }

    @Override
    public boolean update(long id, Department newDepartment)   {
        Session session = sessionFactory.getCurrentSession();
        Department department = session.get(Department.class, id);
        fillDepartent(department, newDepartment);
        session.update(department);
        return true;
    }

    private void fillDepartent(Department department, Department newDepartment) {
        department.setName(newDepartment.getName());
        department.setInfo(newDepartment.getInfo());
    }
}
