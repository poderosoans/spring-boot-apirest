package com.entel.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.entel.springboot.backend.apirest.models.entity.Invoice;
import com.entel.springboot.backend.apirest.models.entity.Product;
import com.entel.springboot.backend.apirest.models.services.IClientService;

@CrossOrigin(origins= {"http:localhost:4200","*"})
@RestController
@RequestMapping("/api")
public class InvoiceRestController {
	@Autowired
	private IClientService clientService;
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/invoices/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public Invoice show(@PathVariable Long id) {
		
		return clientService.findInvoiceById(id);
	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/invoices/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clientService.deleteInvoice(id);
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("invoices/product-filter/{term}")
	@ResponseStatus(code=HttpStatus.OK)
	public List<Product> productsFilter(@PathVariable String term) {
		return clientService.findProductByName(term);
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/invoices")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Invoice create(@RequestBody Invoice invoice) {
		return clientService.saveInvoice(invoice);
		
	}
}
