package mjv.easy_job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mjv.easy_job.model.Profissao;

public interface ProfissaoRepository extends JpaRepository<Profissao, Integer> {

	public boolean existsByIdProfissao(Integer id);
	public boolean existsByNomeProfissao(String nome);
	public Profissao findByNomeProfissao(String nome);
	public Profissao getById(Integer id);
}
