package br.com.attornatus.cliente.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import br.com.attornatus.cliente.api.builder.ClienteBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.attornatus.cliente.api.domain.Cliente;
import br.com.attornatus.cliente.api.service.ClienteService;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteResourceTest extends TestCase {

	@Mock
	private ClienteService clienteService;

	@Test
    public void findByIdTest() {
        
		Cliente cliente = ClienteBuilder.build().ComCliente().get();
		when(this.clienteService.findById(1L)).thenReturn(cliente);

    }
	
}
