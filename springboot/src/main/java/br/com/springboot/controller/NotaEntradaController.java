package br.com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.springboot.bo.FornecedorBO;
import br.com.springboot.bo.NotaEntradaBO;
import br.com.springboot.model.NotaEntrada;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/nota-entrada")
public class NotaEntradaController {
	
	@Autowired
	private NotaEntradaBO notaEntradaBO;
	
	@Autowired
	private FornecedorBO fornecedorBO;
	
	@GetMapping(value = "/novo")
	public ModelAndView novo(ModelMap model) {
		model.addAttribute("notaEntrada", new NotaEntrada());
		model.addAttribute("fornecedores", fornecedorBO.lista());
		return new ModelAndView("nota-entrada/formulario", model);
	}
	@PostMapping(value = "/salva")
	public String salva(@Valid @ModelAttribute("notaEntrada") NotaEntrada notaEntrada, BindingResult result, RedirectAttributes attr, ModelMap model) {
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
		    for (FieldError error : errors) {
		        System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
		    }
		    model.addAttribute("fornecedores", fornecedorBO.lista());
			return "nota-entrada/formulario";
		}
		if (notaEntrada.getId() == null) {
			notaEntradaBO.insere(notaEntrada);
			attr.addFlashAttribute("feedback", "Nota de Entrada cadastrada com sucesso!");
			return "redirect:/nota-entrada";
		}
		else {
			notaEntradaBO.atualiza(notaEntrada);
			attr.addFlashAttribute("feedback", "Nota de Entrada atualizada com sucesso!");
			return "redirect:/nota-entrada";
		}
	}
	
	@GetMapping(value = "")
	public ModelAndView lista(ModelMap model) {
		model.addAttribute("nota-entrada", notaEntradaBO.lista());
		return new ModelAndView("nota-entrada", model);
	}
	
	@GetMapping(value = "/edita/{id}")
	public ModelAndView edita(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("notaEntrada", notaEntradaBO.pesquisaPeloID(id));
		return new ModelAndView("nota-entrada/formulario", model);
	}

}
