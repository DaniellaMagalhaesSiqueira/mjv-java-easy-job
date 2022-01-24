package mjv.easy_job.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mjv.easy_job.model.Profissao;
import mjv.easy_job.repository.ProfissaoRepository;

@Service
public class ProfissaoService {

	@Autowired
	private ProfissaoRepository repository;


	public List<Profissao> listar() {
		return repository.findAll();
	}
	
	public Profissao obterPorId(Integer idProfissao) {
		return repository.getById(idProfissao);
	}
	
	public void salvar(Profissao profissao) {
		if(repository.existsByNomeProfissao(profissao.getNomeProfissao().toUpperCase())) {
			System.out.println("Profissão já foi criada");
			return;
		}
		profissao.setNomeProfissao(profissao.getNomeProfissao().toUpperCase());
		repository.save(profissao);
	}
	
	public void alterar(Profissao profissao) {

		Profissao p = repository.getById(profissao.getIdProfissao());
		p = profissao;
		p.setNomeProfissao(profissao.getNomeProfissao().toUpperCase());
		repository.save(p);
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}

}
