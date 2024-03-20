package br.com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.springboot.bo.ClienteBO;
import br.com.springboot.model.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteBO bo;
	
	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelMap model) {
		model.addAttribute("cliente", new Cliente());
		return new ModelAndView("clientes/formulario", model);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String salva(@ModelAttribute Cliente cliente) {
		bo.insere(cliente);
		return "redirect:/clientes";
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView lista(ModelMap model) {
		model.addAttribute("clientes", bo.lista());
		return new ModelAndView("clientes/lista", model);
	}
	
	@RequestMapping(value = "/edita/{id}", method = RequestMethod.GET)
	public ModelAndView edita(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cliente", bo.pesquisaPeloID(id));
		return new ModelAndView("clientes/formulario", model);
	}
	
	@RequestMapping(value = "/inativa/{id}", method = RequestMethod.GET)
	public String inativa(@PathVariable("id") Long id, ModelMap model) {
		Cliente cliente = bo.pesquisaPeloID(id);
		bo.inativa(cliente);
		return "redirect:/clientes";
	}
	
	@RequestMapping(value = "/ativa/{id}", method = RequestMethod.GET)
	public String ativa(@PathVariable("id") Long id, ModelMap model) {
		Cliente cliente = bo.pesquisaPeloID(id);
		bo.ativa(cliente);
		return "redirect:/clientes";
	}

}
