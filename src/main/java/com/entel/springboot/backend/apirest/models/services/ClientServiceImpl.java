package com.entel.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.entel.springboot.backend.apirest.models.dao.IClientDao;
import com.entel.springboot.backend.apirest.models.entity.Client;

public class ClientServiceImpl implements IClientService{
	
	@Autowired
	private IClientDao clientDao;
	
	@Override
	@Transactional(readOnly = true)	// Manejo de transacciones, se puede omitir
	public List<Client> findAll() {

		return (List<Client>) clientDao.findAll();
	}

}
