package mjv.easy_job.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mjv.easy_job.model.Cadastro;
import mjv.easy_job.model.Endereco;
import mjv.easy_job.model.Profissao;
import mjv.easy_job.model.Sexo;
import mjv.easy_job.repository.CadastroRepository;

@Service
public class CadastroService {

	@Autowired
	private CadastroRepository repository;

	private Random random = new Random();

	public List<Cadastro> listar() {
		return repository.findAll();
	}
	
	public List<Cadastro> listarPorProfissao(Profissao prof){
		return repository.getByProfissao(prof);
	}

	public void salvarCadastro(Cadastro cadastro, Endereco endereco, Profissao profissao) {
		cadastro.setEndereco(endereco);
		cadastro.setProfissao(profissao);
		repository.save(cadastro);
	}

	public void editarCadastro(Cadastro cadastro) {
		Cadastro cad = repository.getById(cadastro.getId());
		cad = cadastro;
		repository.save(cad);
	}

	public Cadastro obterPorId(Integer id) {
		return repository.getById(id);
	}

	public void excluirCadastro(Integer id) {
		repository.deleteById(id);
	}

	public void inserirCaminhoImagem(Cadastro cadastro) {
		System.out.println(cadastro.toString());
		if (cadastro.getArquivo() == null || cadastro.getArquivo().isEmpty()) {
			if (cadastro.getSexo() == Sexo.M) {
				Integer num = random.nextInt(4) + 1;
				String numero = num.toString();
				String caminho = "assets/img/team/masc" + numero + ".jpg";
				cadastro.setCaminhoImagem(caminho);
			} else if (cadastro.getSexo() == Sexo.F) {
				Integer num = random.nextInt(5) + 1;
				String numero = num.toString();
				String caminho = "assets/img/team/fem" + numero + ".jpg";
				cadastro.setCaminhoImagem(caminho);
			} else {
				cadastro.setCaminhoImagem("assets/img/team/user.jpg");
			}
		} else {
			try {
				// Pegando o arquivo e salvando no disco ou servidor

				byte[] bytes = cadastro.getArquivo().getBytes();
				Path path = Paths.get(
						"D:\\PROJETOS\\projeto_final_java_mjv\\mjv_easy_job\\src\\main\\resources\\static\\assets\\img\\team\\"
								+ cadastro.getArquivo().getOriginalFilename());
				Files.write(path, bytes);

				cadastro.setCaminhoImagem("assets/img/team/" + cadastro.getArquivo().getOriginalFilename());

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void alterarCaminhoImagem(Cadastro cadastro) {
		System.out.println(cadastro.toString());
		if (cadastro.getArquivo() == null || cadastro.getArquivo().isEmpty()) {
			return;
		} else {
			try {
				System.out.println("Entrando aqui");
				// Pegando o arquivo e salvando no disco ou servidor
				byte[] bytes = cadastro.getArquivo().getBytes();
				Path path = Paths.get(
						"D:\\PROJETOS\\projeto_final_java_mjv\\mjv_easy_job\\src\\main\\resources\\static\\assets\\img\\team\\"
								+ cadastro.getArquivo().getOriginalFilename());
				Files.write(path, bytes);

				cadastro.setCaminhoImagem("assets/img/team/" + cadastro.getArquivo().getOriginalFilename());

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
