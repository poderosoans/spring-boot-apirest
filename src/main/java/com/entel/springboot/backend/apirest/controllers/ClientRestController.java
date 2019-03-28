package com.entel.springboot.backend.apirest.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entel.springboot.backend.apirest.models.entity.Client;
import com.entel.springboot.backend.apirest.models.services.IClientService;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/api")
public class ClientRestController {
	
	@Autowired
	private IClientService clientService;
	
	@GetMapping("/clients")
	public List<Client> index() {
		return clientService.findAll();
	}
	
	@GetMapping("/clients/{id}")
	//@ResponseStatus(HttpStatus.OK)	// Default 200
	public ResponseEntity<?> show(@PathVariable Long id) {
		Client client = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			client = clientService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(client == null) {
			response.put("mensaje", "El cliente con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	@PostMapping("/clients")
	public ResponseEntity<?> create(@Valid @RequestBody Client client, BindingResult result) {
		
		Client clientNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			/*
			List<String> errors = new ArrayList<>();
			for(FieldError err: result.getFieldErrors()) {
				errors.add("El campo '"+ err.getField() + "'" + err.getDefaultMessage());
			}
			*/
			
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> {
						return "El campo '"+ err.getField() + "' " + err.getDefaultMessage();
					})
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			clientNew =  clientService.save(client);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos.");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El cliente ha sido creado con éxito");
		response.put("cliente", clientNew);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/clients/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Client client, BindingResult result, @PathVariable Long id) {
		
		Client clientAct = clientService.findById(id);
		Client clientUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> {
						return "El campo '"+ err.getField() + "' "  + err.getDefaultMessage();
					})
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(clientAct == null) {
			response.put("mensaje", "Error: no se pudo editar, el cliente con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			clientAct.setLastname(client.getLastname());
			clientAct.setName(client.getName());
			clientAct.setEmail(client.getEmail());
			clientAct.setCreatedAt(client.getCreatedAt());
			
			clientUpdated = clientService.save(clientAct);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar el cliente en la base de datos.");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El cliente ha sido actualizado con éxito");
		response.put("cliente", clientUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/clients/{id}")
	public ResponseEntity<?> detele(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
		
		clientService.delete(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar el cliente en la base de datos.");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente fue eliminado con éxito.");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}

}
