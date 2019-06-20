package com.app.runner;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepository;
@Component
public class ConsoleRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;
	
	public void run(String... args) throws Exception {
		
		List<Product> list = repo.findAll();
		list.stream()
		.filter(p->p.getProdCode() != null)
		.sorted((p1, p2)->p2.getProdId()-p1.getProdId())
		.map(p->p.getProdId()+", "+p.getProdCost()+", "+p.getProdCode())
		.forEach(System.out::println);
		
	}

}
