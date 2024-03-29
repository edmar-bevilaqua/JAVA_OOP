package br.com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.springboot.bo.FornecedorBO;
import br.com.springboot.model.Fornecedor;
import jakarta.validation.Valid;

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
	
	@RequestMapping(value = "/salva", method = RequestMethod.POST)
	public String salva(@Valid @ModelAttribute("fornecedor") Fornecedor fornecedor, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "fornecedores/formulario";
		}
		if (fornecedor.getId() == null){
			bo.insere(fornecedor);
			attr.addFlashAttribute("feedback", "Fornecedor cadastrado com sucesso!");
		}
		else {
			bo.atualiza(fornecedor);
			attr.addFlashAttribute("feedback", "Fornecedor atualizado com sucesso!");
		}
		return "redirect:/fornecedores";
	}
	
	@GetMapping("")
	public ModelAndView lista(ModelMap model) {
		model.addAttribute("fornecedores", bo.lista());
		return new ModelAndView("fornecedores/lista", model);
	}
	
	@GetMapping(value = "/edita/{id}")
	public ModelAndView edita(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("fornecedor", bo.pesquisaPeloID(id));
		return new ModelAndView("fornecedores/formulario", model);
	}
	
	@GetMapping(value = "/ativa/{id}")
	public String ativa(@PathVariable("id") Long id, ModelMap model, RedirectAttributes attr) {
		Fornecedor fornecedor = bo.pesquisaPeloID(id);
		bo.ativa(fornecedor);
		attr.addFlashAttribute("feedback", "Fornecedor ativado com sucesso!");
		return "redirect:/fornecedores";
	}
	
	@GetMapping(value = "/inativa/{id}")
	public String inativa(@PathVariable("id") Long id, ModelMap model , RedirectAttributes attr) {
		Fornecedor fornecedor = bo.pesquisaPeloID(id);
		bo.inativa(fornecedor);
		attr.addFlashAttribute("feedback", "Fornecedor inativado com sucesso!");
		return "redirect:/fornecedores";
	}
}
