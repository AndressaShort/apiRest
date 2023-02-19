package br.com.attornatus.cliente.api.builder;

import java.time.LocalDate;

import br.com.attornatus.cliente.api.domain.Cliente;

public class ClienteBuilder {

	private Cliente cliente;
	
	public static ClienteBuilder build() {
	return new ClienteBuilder();
	}

	public Cliente get() {
		return this.cliente; 
	}
	
	public ClienteBuilder ComCliente() {
		this.cliente = Cliente.builder()
				.id(1L)
				.nome("Mario")
				.dataNascimento(LocalDate.now().minusYears(25l))
				.build();
		return this;
	}
	
}
