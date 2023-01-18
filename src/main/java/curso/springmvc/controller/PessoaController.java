package curso.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import curso.springmvc.model.Pessoa;
import curso.springmvc.repository.PessoaRepository;

@Controller
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/cadastropessoa")
	public String inicio() {
		return "cadastro/cadastropessoa";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/salvarpessoa")
	public ModelAndView salvar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
		ModelAndView andView = new ModelAndView("cadastro/cadastropessoa");
		Iterable<Pessoa> pessoas = pessoaRepository.findAll();
		andView.addObject("pessoas", pessoas);
		return andView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listapessoas")
	public ModelAndView pessoas() {
		ModelAndView andView = new ModelAndView("cadastro/cadastropessoa");
		Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
		andView.addObject("pessoas", pessoasIt);
		return andView;
	}
	
}
