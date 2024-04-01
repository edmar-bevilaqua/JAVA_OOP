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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.springboot.bo.ProdutoBO;
import br.com.springboot.model.Produto;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoBO bo;
	
	@GetMapping(value = "/novo")
	public ModelAndView novo(ModelMap model) {
		model.addAttribute("produto", new Produto());
		return new ModelAndView("produtos/formulario", model);
	}
	
	@PostMapping(value = "/salva")
	public String salva(@Valid @ModelAttribute("produto") Produto produto, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "produtos/formulario";
		}
		if (produto.getId() == null) {
			bo.insere(produto);
			attr.addFlashAttribute("feedback", "Produto cadastrado com sucesso!");
		}
		else {
			bo.atualiza(produto);
			attr.addFlashAttribute("feedback", "Produto atualizado com sucesso!");
		}
		return "redirect:/produtos";
	}
	
	@GetMapping(value = "")
	public ModelAndView lista(ModelMap model) {
		model.addAttribute("produtos", bo.lista());
		return new ModelAndView("produtos/lista", model);
		}

	@GetMapping(value = "/edita/{id}")
	public ModelAndView edita(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("produto", bo.pesquisaPeloID(id));
		return new ModelAndView("produtos/formulario", model);
	}

	@GetMapping(value = "/ativa/{id}")
	public String ativa(@PathVariable("id") Long id, ModelMap model, RedirectAttributes attr) {
		Produto produto = bo.pesquisaPeloID(id);
		bo.ativa(produto);
		attr.addFlashAttribute("feedback", "Produto ativado com sucesso!");
		return "redirect:/fornecedores";
	}
	
	@GetMapping(value = "/inativa/{id}")
	public String inativa(@PathVariable("id") Long id, ModelMap model , RedirectAttributes attr) {
		Produto produto = bo.pesquisaPeloID(id);
		bo.inativa(produto);
		attr.addFlashAttribute("feedback", "Produto inativado com sucesso!");
		return "redirect:/produtos";
	}
}
