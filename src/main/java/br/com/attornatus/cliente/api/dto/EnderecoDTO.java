package br.com.attornatus.cliente.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDTO {

	private Long id;
	private String logradouro;
	private String numero;
	private String cidade;
	private String cep;
	private ClienteDTO cliente;

}
