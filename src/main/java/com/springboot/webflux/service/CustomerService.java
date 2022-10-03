package com.springboot.webflux.service;

import com.springboot.webflux.dao.CustomerDao;
import com.springboot.webflux.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
@Service
public class CustomerService {
    @Autowired
    private CustomerDao dao;



    public List<Customer> loadAllCustomer(){
        long StartValue = System.currentTimeMillis();
        List<Customer> customers = dao.getCustomers();
        long endValue = System.currentTimeMillis();
        System.out.println("total execution time "+(endValue-StartValue));
        return customers;
    }



    public Flux<Customer> loadAllCustomerStream(){
        long StartValue = System.currentTimeMillis();
        Flux<Customer> customers = dao.getCustomersStream();
        long endValue = System.currentTimeMillis();
        System.out.println("total execution time "+(endValue-StartValue));
        return customers;
    }


}
