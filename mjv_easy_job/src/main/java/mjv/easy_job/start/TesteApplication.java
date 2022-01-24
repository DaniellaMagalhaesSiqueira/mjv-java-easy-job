package mjv.easy_job.start;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import mjv.easy_job.repository.ProfissaoRepository;
import mjv.easy_job.service.CadastroService;
import mjv.easy_job.service.ProfissaoService;

@Component
public class TesteApplication implements CommandLineRunner{

	@Autowired
	private CadastroService cadastroService;
	
	@Autowired
	private ProfissaoRepository repository;
	
	@Autowired
	private ProfissaoService profissaoService;
	
	@Override
	public void run(String... args) throws Exception {
		

//		Endereco end = new Endereco();
//		end.setLogradouro("Rua Sidney V. Aguiar");
//		end.setNumero("SN");
//		end.setBairro("Glória");
//		end.setUf(UnidadeFederativa.RJ);
//		end.setMunicipio("Macaé");
//		end.setCep("27937-010");
//		
//		Cadastro cadastro = new Cadastro();
//		cadastro.setEndereco(end);
//		cadastro.setCpf("08681014781");
//		cadastro.setNome("DANIELLA MAGALHÃES SIQUEIRA");
//		cadastro.setSexo(Sexo.F);
//		cadastro.setCelular("022997876567");
//		cadastro.setTelefone("022226776567");
//		cadastro.setDataNascimento(LocalDate.of(1980, 10, 28));
//		cadastro.setEscolaridade(Escolaridade.SUP);
//		cadastro.setEstrangeiro(false);
//		cadastro.setEmail("daniella@email.com");
//		cadastro.setNacionalidade("Brasileira");
//		cadastro.setNaturalidade("São Gonçalo - RJ");
//		cadastro.setRg("12333456-7");
//		
//		Profissao profissao =  profissaoService.buscarPorId(4);
//		System.out.println(profissao.getNome());
//		cadastro.setProfissao(profissao);
//		cadastroService.salvarCadastro(cadastro);
		
	}


}
