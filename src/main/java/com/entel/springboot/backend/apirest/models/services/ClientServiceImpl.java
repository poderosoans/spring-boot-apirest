package com.entel.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entel.springboot.backend.apirest.models.dao.IClientDao;
import com.entel.springboot.backend.apirest.models.dao.IInvoiceDao;
import com.entel.springboot.backend.apirest.models.dao.IProductDao;
import com.entel.springboot.backend.apirest.models.entity.Client;
import com.entel.springboot.backend.apirest.models.entity.Invoice;
import com.entel.springboot.backend.apirest.models.entity.Product;
import com.entel.springboot.backend.apirest.models.entity.Region;

@Service
public class ClientServiceImpl implements IClientService{
	
	@Autowired
	private IClientDao clientDao;
	
	@Autowired
	private IInvoiceDao invoiceDao;
	
	@Autowired
	private IProductDao productDao;
	
	@Override
	@Transactional(readOnly = true)	// Manejo de transacciones, se puede omitir
	public List<Client> findAll() {
		return (List<Client>) clientDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Client> findAll(Pageable pageable) {
		return clientDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Client findById(Long id) {
		return clientDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Client save(Client client) {
		return clientDao.save(client);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clientDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Region> findAllRegiones() {
		
		return clientDao.findAllRegiones();
	}

	@Override
	@Transactional(readOnly = true)
	public Invoice findInvoiceById(Long id) {	
		return invoiceDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Invoice saveInvoice(Invoice invoice) {		
		return invoiceDao.save(invoice);
	}

	@Override
	@Transactional
	public void deleteInvoice(Long id) {
		invoiceDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> findProductByName(String term) {
		
		return productDao.findByNameStartingWithIgnoreCase(term);
	}

}
