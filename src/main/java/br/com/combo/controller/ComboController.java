package br.com.combo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.combo.model.Cliente;
import br.com.combo.model.Loja;

@Controller
@RequestMapping("/comboController")
public class ComboController {

	private Loja loja;
	private List<Cliente> clientes;

	@RequestMapping
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject(new Loja());

		return mv;
	}

	@RequestMapping(value = "/salvar-loja", method = RequestMethod.POST)
	public String cadastrarProdutoPost(@Validated Loja loja) {

		System.out.println("Nome da Loja: " + loja.getNome());
		System.out.println("Nome do Cliente selecionado: " + loja.getCliente().getNome());

		return "redirect:/comboController";
	}

	@ModelAttribute("todosClientes")
	public List<Cliente> todasClientesList() {
		clientes = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			Cliente cliente = new Cliente();

			cliente.setId(Long.valueOf(i));
			cliente.setNome("Cliente " + i);

			clientes.add(cliente);
		}

		return clientes;
	}

	// GETTERS AND SETTERS
	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
