package com.example.demo;



import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

	private static Map<Long, Product> productRepo= new HashMap<>();
	static{
		
		Product first= new Product();
		first.setId((long)454545);
		first.setName("a Product");
		first.setPrice(5.3);
		
		Product second= new Product();
		second.setId((long)2323232);
		second.setName("another Product");
		second.setPrice(7.4);
		
		productRepo.put(first.getId(),first);
		productRepo.put(second.getId(),second);
	}
	
	//GET method
	@RequestMapping(value= "/products", method= RequestMethod.GET)
	public ResponseEntity<Object> getProduct() {
		return new ResponseEntity<>(productRepo.values(),HttpStatus.OK);
	}
	
	//GET method
	@RequestMapping(value= "/products/{id}", method= RequestMethod.GET)
	public ResponseEntity<Object> getOneProduct(@PathVariable("id") Long id) {
		return new ResponseEntity<>(productRepo.get(id),HttpStatus.OK);
	}
	
	//POST Method
	@RequestMapping(value= "/products", method= RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		
		productRepo.put(product.getId(),product);	
		return new ResponseEntity<>("Your product was created", HttpStatus.CREATED);
		
	}
	
	//PUT Method
	@RequestMapping(value="/products/{id}", method= RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id,@RequestBody Product product) {
		
		productRepo.remove(id);
	    product.setId(id);
	    productRepo.put(id, product);
		return new ResponseEntity<>("your product was updated",HttpStatus.OK);
	}
	
	//DELETE Method
	@RequestMapping(value="/products/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") Long id) {
		
		productRepo.remove(id);
		return new ResponseEntity<>("your product was deleted", HttpStatus.OK);
	}
}