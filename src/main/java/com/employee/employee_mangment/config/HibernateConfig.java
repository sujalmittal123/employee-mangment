package com.employee.employee_mangment.config;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.employee.employee_mangment.entity.Employee;

@Configuration
public class HibernateConfig {

    @Bean
    public SessionFactory sessionFactory(DataSource dataSource) {
        try {
            return new org.hibernate.cfg.Configuration()
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
                    .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/employeedb")
                    .setProperty("hibernate.connection.username", "root")
                    .setProperty("hibernate.connection.password", "Admin@123")
                    .setProperty("hibernate.show_sql", "true")
                    .setProperty("hibernate.hbm2ddl.auto", "update")
                    .setProperty("hibernate.connection.autocommit", "false")
                    .setProperty("hibernate.jdbc.batch_size", "20")
                    .addAnnotatedClass(Employee.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException("Failed to configure Hibernate SessionFactory", e);
        }
    }
}
