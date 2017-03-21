import java.io.*;
import java.util.ArrayList;

public class Pesquisa implements Serializable{
	
	private String nome;
	private ArrayList<Pergunta> perguntas;

	Pesquisa(){
		
	}
	
	Pesquisa(String nome){
		this.nome = nome;
		this.perguntas = new ArrayList<Pergunta>();
	}

	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void addPergunta(Pergunta pergunta){
		perguntas.add(pergunta);
	}
	
	public void excluirPergunta(Pergunta pergunta){
		perguntas.remove(pergunta);
	}
	
	public ArrayList<Pergunta> getPerguntas(){
		return this.perguntas;
	}
	
}
