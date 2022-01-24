package mjv.easy_job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mjv.easy_job.model.Cadastro;
import mjv.easy_job.model.Profissao;

public interface CadastroRepository extends JpaRepository<Cadastro, Integer>{
	
	public Cadastro getById(Integer id);
	
	public List<Cadastro> getByProfissao(Profissao prof);
}
