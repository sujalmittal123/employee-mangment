package com.employee.employee_mangment.repository;

import com.employee.employee_mangment.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeRepository {

    private final SessionFactory sessionFactory;

    public EmployeeRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Employee employee) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }
    }

    public Employee findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Employee.class, id);
        }
    }

    public List<Employee> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Employee", Employee.class).list();
        }
    }

    public void update(Employee employee) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        }
    }

    public void delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.delete(employee);
            }
            session.getTransaction().commit();
        }
    }
}