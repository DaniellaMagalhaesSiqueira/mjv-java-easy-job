package mjv.easy_job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mjv.easy_job.model.Cadastro;
import mjv.easy_job.model.Endereco;
import mjv.easy_job.model.Profissao;
import mjv.easy_job.service.CadastroService;
import mjv.easy_job.service.ProfissaoService;

@Controller
@RequestMapping("/")
@ComponentScan
public class EasyJobController {

	@Autowired
	private ProfissaoService profServ;

	@Autowired
	private CadastroService cadServ;


	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("cadastros", cadServ.listar());
		mv.addObject("profissoes", profServ.listar());
		mv.addObject("ver_cadastro", "ver_cadastro/");
		return mv;
	}
	
	@GetMapping("/novo_cadastro")
	public String formularioCadastro(Model model) {
		model.addAttribute("profissoes", profServ.listar());
		return "cadastro";
	}
	@GetMapping("/listar_profissao")
	public String listarProfissao(Model model) {
		model.addAttribute("profissoes", profServ.listar());
		return "profissoes";
	}
	
	@PostMapping("/grava")
	public ModelAndView save(@Validated Cadastro cadastro, 
			@Validated Endereco endereco, Profissao profissao) {
		cadServ.inserirCaminhoImagem(cadastro);
		cadServ.salvarCadastro(cadastro, endereco, profissao);
		return index();
	}
	
	@RequestMapping("/salvar_profissao")
	public String saveProfissao(@Validated Profissao profissao, Model model) {
		model.addAttribute("profissoes", profServ.listar());
		profServ.salvar(profissao);	
		return listarProfissao(model);
	}
	@GetMapping("/form_profissao")
	public String cadastrarProfissao() {
		return "form_profissao";
	}
	@GetMapping("/form_profissao_alterar/{id}")
	public String formAlterarProfissao(@PathVariable Integer id, Model model) {
		model.addAttribute("profissao", profServ.obterPorId(id));
		return "form_profissao_alterar";
	}
	
	
	@PostMapping("/update")
	public ModelAndView alterar(@Validated Cadastro formCadastro,@Validated  Endereco endereco, Profissao profissao) {
		cadServ.alterarCaminhoImagem(formCadastro);
		formCadastro.setEndereco(endereco);
		formCadastro.setProfissao(profissao);
		cadServ.editarCadastro(formCadastro);
		return index();
	}
	
	@PostMapping("/alterar_profissao")
	public String alterarProfissao(@Validated Profissao profissao, Model model) {
		profServ.alterar(profissao);		
		model.addAttribute("profissoes", profServ.listar());
		return listarProfissao(model);
	}
	
	@RequestMapping("/editar/{id}")
	public String irEditarCadastro(@PathVariable ("id") Integer id, Model model) {
		Cadastro cadastroCarregado = cadServ.obterPorId(id);
		model.addAttribute("cadastro", cadastroCarregado);
		model.addAttribute("profissoes", profServ.listar());		
		return "editar";
	}
	
	@GetMapping("/ver_cadastro/{id}")
	public String irVerCadastro(@PathVariable ("id") Integer id, Model model) {
		Cadastro cadastro = cadServ.obterPorId(id);
		model.addAttribute("cadastro", cadastro);
		return "ver_cadastro";
	}
	
	@GetMapping("/voltar")
	public ModelAndView irParaHome() {
		return index();
	}
	
	@GetMapping("/excluir/{id}")
	public String excluirCadastro(@PathVariable ("id") Integer id) {
		cadServ.excluirCadastro(id);
		return "redirect:/voltar";
	}
	
	@GetMapping("/excluir_profissao/{id}")
	public String excluirProfissao(@PathVariable ("id") Integer id, Model model) {
		profServ.excluir(id);
		model.addAttribute("profissoes", profServ.listar());
		return listarProfissao(model);
	}
}
