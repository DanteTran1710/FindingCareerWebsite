/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.findingcareer.repository.impl;

import com.findingcareer.pojo.Employee;
import com.findingcareer.repository.EmployeeRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hp
 */
@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    
    @Override
    public boolean addEmployee(Employee e) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        
        try{
            session.save(e);
            
            return true;
        } catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        
        return false;
    }

    @Override
    public boolean updateEmployee(Employee empl) {
        return false;
    }
    
}