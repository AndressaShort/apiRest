package br.com.attornatus.cliente.api.service;

import br.com.attornatus.cliente.api.domain.Cliente;
import br.com.attornatus.cliente.api.exception.NotFoundException;
import br.com.attornatus.cliente.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente findById(Long id) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		return optional.orElseThrow(() -> new NotFoundException("Não existe cliente com id: " + id));
	}

	public List<Cliente> findAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes;
	}

}
