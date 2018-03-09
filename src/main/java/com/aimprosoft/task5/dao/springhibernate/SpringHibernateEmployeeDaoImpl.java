package com.aimprosoft.task5.dao.springhibernate;

import com.aimprosoft.task5.dao.EmployeeDao;
import com.aimprosoft.task5.model.Department;
import com.aimprosoft.task5.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


<<<<<<< HEAD
@Repository
public class SpringHibernateEmployeeDaoImpl implements EmployeeDao, HqlStatements {

	@Autowired
=======
import javax.persistence.PersistenceException;


public class SpringHibernateEmployeeDaoImpl implements EmployeeDao, HqlStatements {

>>>>>>> f38a99bc174e231dfec3b61970ee1e9d99663a85
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
    	this.sessionFactory=sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<Employee> list(String departmentName) {
        Query<Employee> query = sessionFactory.getCurrentSession()
                .createQuery(EMPLOYEES_ALL_HQL + DEPARTMENT_CONDITION);
        query.setParameter("department", departmentName);
        return query.list();
    }

    @Override
    public Employee getById(long id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Employee getByEmail(String email) {

        Query<Employee> query = sessionFactory.getCurrentSession()
                .createQuery(EMPLOYEES_ALL_HQL + EMAIL_CONDITION);
        query.setParameter("email", email);
        return query.uniqueResult();
    }

    @Override
    public boolean add(Employee employee){

        Session session = sessionFactory.getCurrentSession();
        Query<Department> querySelect = session.createQuery(DEPARTMENTS_ALL_HQL + NAME_CONDITION);
        querySelect.setParameter("name", employee.getDepartment());
        if (querySelect.getResultList().isEmpty()) {
            return false;
        }
        session.persist(employee);
        return true;
    }

    @Override
    public boolean delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        session.delete(employee);
        return true;
    }

    @Override
    public boolean update(long id, Employee newEmployee) {

        Session session = sessionFactory.getCurrentSession();
        Query<Department> querySelect = session.createQuery(DEPARTMENTS_ALL_HQL + NAME_CONDITION);
        querySelect.setParameter("name", newEmployee.getDepartment());
        if (querySelect.getResultList().isEmpty()) {
            return false;
        }
        Employee employee = session.get(Employee.class, id);
        fillEmployee(employee, newEmployee);
        session.update(employee);
        return true;

    }

    private void fillEmployee(Employee employee, Employee newEmployee) {
        employee.setName(newEmployee.getName());
        employee.setEmail(newEmployee.getEmail());
        employee.setBirthday(newEmployee.getBirthday());
        employee.setRoom(newEmployee.getRoom());
        employee.setDepartment(newEmployee.getDepartment());
    }

    private void fillQuery(Query<Employee> query, Employee newEmployee) {
        query.setParameter("name", newEmployee.getName());
        query.setParameter("email", newEmployee.getEmail());
        query.setParameter("birthday", newEmployee.getBirthday());
        query.setParameter("room", newEmployee.getRoom());
        query.setParameter("department", newEmployee.getDepartment());


    }
}
