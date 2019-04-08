package com.entel.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.entel.springboot.backend.apirest.models.entity.Client;
import com.entel.springboot.backend.apirest.models.entity.Invoice;
import com.entel.springboot.backend.apirest.models.entity.Region;

public interface IClientService {
	public List<Client> findAll();
	
	public Page<Client> findAll(Pageable pageable);
	
	public Client findById(Long id);
	
	public Client save(Client client);
	
	public void delete (Long id);
	
	public List<Region> findAllRegiones();
	
	public Invoice findInvoiceById(Long id);
	
	public Invoice saveInvoice(Invoice invoice);
	
	public void deleteInvoice(Long id);
}
