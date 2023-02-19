package br.com.attornatus.cliente.api.resource;

import br.com.attornatus.cliente.api.converter.EnderecoConverter;
import br.com.attornatus.cliente.api.domain.Cliente;
import br.com.attornatus.cliente.api.domain.Endereco;
import br.com.attornatus.cliente.api.dto.ClienteDTO;
import br.com.attornatus.cliente.api.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "cliente")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private EnderecoConverter enderecoConverter;

	@PostMapping
	@Transactional
	public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		BeanUtils.copyProperties(clienteDTO, cliente, "enderecos");
		cliente = clienteService.save(cliente);

		if (!CollectionUtils.isEmpty(clienteDTO.getEnderecos())) {
			List<Endereco> enderecos = enderecoConverter.converterToEnderecosPorClienteDTO(clienteDTO, cliente);
			cliente.setEnderecos(enderecos);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Cliente> update(@PathVariable(name = "id") Long id,
			@RequestBody @Valid ClienteDTO clienteDTO) {

		Cliente cliente = clienteService.findById(id);
		BeanUtils.copyProperties(clienteDTO, cliente, "enderecos", "id");
		cliente = clienteService.save(cliente);

		if (!CollectionUtils.isEmpty(clienteDTO.getEnderecos())) {
			List<Endereco> enderecos = enderecoConverter.converterToEnderecosPorClienteDTO(clienteDTO, cliente);
			cliente.setEnderecos(enderecos);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable(name = "id") Long id) {
		Cliente cliente = clienteService.findById(id);
		return ResponseEntity.ok().body(cliente);
	}


	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> clientes = clienteService.findAll();
		return ResponseEntity.ok(clientes);
	}

}
