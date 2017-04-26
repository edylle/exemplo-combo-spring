package br.com.combo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.combo.model.Cliente;

@Component
public class ClienteConverter implements Converter<String, Cliente> {

	@Override
	public Cliente convert(String id) {

		Cliente cliente = new Cliente();

		cliente.setId(Long.valueOf(id));
		cliente.setNome("Cliente " + id);

		return cliente;
	}

}
