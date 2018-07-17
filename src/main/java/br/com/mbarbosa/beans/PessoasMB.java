package br.com.mbarbosa.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.mbarbosa.model.EstadoCivil;
import br.com.mbarbosa.model.Pessoa;
import br.com.mbarbosa.util.FacesMessages;

@ManagedBean
public class PessoasMB {

	private static List<Pessoa> pessoas = new ArrayList<>();;
	
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

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	public Pessoa getPessoaEdicao() {
		return pessoaEdicao;
	}
	
	public void setPessoaEdicao(Pessoa pessoaEdicao) {
		this.pessoaEdicao = pessoaEdicao;
	}
	
	public void adicionar() {
		pessoas.add(pessoaEdicao);
		this.pessoaEdicao = new Pessoa();
	}
	
	public void editar() {
		pessoaEdicao.setNome("Teste editar");
	}
	
	public void remover(Pessoa p) {
		pessoas.remove(p);
		FacesMessages.info("Registro removido com sucesso!");
	}
	
	public EstadoCivil[] getEstadosCivis() {
		return EstadoCivil.values();
	}
	
}
