package br.com.mbarbosa.beans;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import br.com.mbarbosa.model.EstadoCivil;
import br.com.mbarbosa.model.Pessoa;
import br.com.mbarbosa.util.FacesMessages;
import javassist.NotFoundException;

@ManagedBean
public class PessoasMB {

	private static Map<Integer, Pessoa> pessoas = new HashMap<>();;
	
	private Pessoa pessoaEdicao = new Pessoa();
	
	public Map<Integer, Pessoa> getPessoas() {
		return pessoas;
	}

	
	public void setPessoas(Map<Integer, Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	public Pessoa getPessoaEdicao() {
		return pessoaEdicao;
	}
	
	public void setPessoaEdicao(Pessoa pessoaEdicao) {
		this.pessoaEdicao = pessoaEdicao;
	}
	
	public void salvar() {
		
		String mensagemInfo = null;
		
		if(pessoaEdicao.getId() != null) {
			mensagemInfo = "Pessoa de nome " + pessoaEdicao.getNome() + " atualizada com sucesso!";
		} else {
			pessoaEdicao.setId(pessoas.size() + 1);
			mensagemInfo = "Pessoa de nome " + pessoaEdicao.getNome() + " cadastrada com sucesso!";
		}
		
		pessoas.put(pessoaEdicao.getId(), pessoaEdicao);
		pessoaEdicao = new Pessoa();
		FacesMessages.info(mensagemInfo);
		
	}
	
	public void editar(int id) {
		
		try {
			
			if(!pessoas.containsKey(id)) {
				throw new NotFoundException("Não existe pessoa com código " + id + " no sistema!");
			}

			pessoaEdicao = pessoas.get(id);
		
		} catch(NotFoundException e) {
			FacesMessages.error(e.getMessage());
		}
		
	}
	
	public void remover(Pessoa p) {

		try {
			if(!pessoas.containsKey(p.getId())) {
				throw new NotFoundException("Pessoa de código " + p.getId() + " não está cadastrada no sistema");
			}

			pessoas.remove(p.getId());
			FacesMessages.info("Pessa de nome " + p.getNome() + " removida com sucesso!");
		
		} catch(NotFoundException e) {
			FacesMessages.error(e.getMessage() + "!");
		}
		
	}
	
	public EstadoCivil[] getEstadosCivis() {
		return EstadoCivil.values();
	}
	
}
