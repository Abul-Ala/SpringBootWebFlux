package com.springboot.webflux.handler;

import com.springboot.webflux.dao.CustomerDao;
import com.springboot.webflux.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {

    @Autowired
    private CustomerDao dao;

    public Mono<ServerResponse> getCustomers(ServerRequest request){
        Flux<Customer> customersStream = dao.getCustomersStream();
        return ServerResponse.ok().body(customersStream,Customer.class);

    }
}
