package br.com.mbarbosa.beans;

import java.text.Collator;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import br.com.mbarbosa.model.EstadoCivil;
import br.com.mbarbosa.model.Pessoa;
import br.com.mbarbosa.util.FacesMessages;

@ManagedBean
public class PessoasMB {

	private static Map<Integer, Pessoa> pessoas = new HashMap<>();;
	
	private Pessoa pessoaEdicao = new Pessoa();
	
	public PessoasMB() {
		
//		Pessoa p1 = new Pessoa();
//		p1.setNome("Marcos Barbosa");
//		p1.setCpf("123456789");
//		p1.setEstadoCivil("Casado");
//		p1.setTelefoneContato("12341561");
//		
//		Pessoa p2 = new Pessoa();
//		p2.setNome("Fulano Silva");
//		p2.setCpf("123456789");
//		p2.setEstadoCivil("Casado");
//		p2.setTelefoneContato("12341561");
//
//		pessoas.add(p1);
//		pessoas.add(p2);
		
	}

	public Collection<Pessoa> getPessoas() {
		return pessoas.values();
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
		
		if(pessoas.containsKey(pessoaEdicao.getId())) {
			mensagemInfo = "Pessoa atualizada com sucesso!";
		} else {
			mensagemInfo = "Pessoa cadastrada com sucesso!";
		}
		
		pessoas.put(pessoaEdicao.getId(), pessoaEdicao);
		pessoaEdicao = new Pessoa();
		FacesMessages.info(mensagemInfo);
		
	}
	
	public void editar(Pessoa p) {
		pessoaEdicao = p;
	}
	
	public void remover(Pessoa p) {
		pessoas.remove(p.getId());
		FacesMessages.info("Registro removido com sucesso!");
	}
	
	public EstadoCivil[] getEstadosCivis() {
		return EstadoCivil.values();
	}
	
}
