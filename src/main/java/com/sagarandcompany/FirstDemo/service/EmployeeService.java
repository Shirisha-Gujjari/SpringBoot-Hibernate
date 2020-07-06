package com.sagarandcompany.FirstDemo.service;

import com.sagarandcompany.FirstDemo.domain.Employee;
import com.sagarandcompany.FirstDemo.repository.EmployeeRepository;
import com.sagarandcompany.FirstDemo.util.ResponseDTO;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @PersistenceContext
    EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED,, rollbackFor = {DataIntegrityViolationException.class})
    public Employee save(Employee employee) throws Exception {
        Session session = entityManager.unwrap(Session.class);
        test(employee);
        session.persist(employee);
        return employee;
    }

    @Transactional(propagation = Propagation.NEVER)
    public void test(Employee employee) {

//        employee.setEmail("test@gmail.com");
//        entityManager.persist(employee);
    }

    public ResponseDTO findByEmail(String email) {
        Optional<Employee> optional = employeeRepository.findByEmail(email);
        ResponseDTO responseDTO = new ResponseDTO();
        if (optional.isPresent()) {
            responseDTO.setData(optional.get());
            return responseDTO;
        }
        responseDTO.setMessage("Record is not found");
        responseDTO.setStatus(false);
        return responseDTO;
    }

    public Employee get(Long id) {
        System.out.println("i am in get metod...............");
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.find(Employee.class, id);
//        Employee empp = new Employee();
//        BeanUtils.copyProperties(employee, empp);
        return employee;
    }

}
