package br.com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.springboot.bo.FornecedorBO;
import br.com.springboot.model.Fornecedor;

@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {
	
	@Autowired
	private FornecedorBO bo;
	
	@GetMapping(value = "/novo")
	public ModelAndView novo(ModelMap model) {
		model.addAttribute("fornecedor", new Fornecedor());
		return new ModelAndView("fornecedores/formulario", model);
	}
}
