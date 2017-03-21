import java.io.*;
import java.util.ArrayList;

public class Pergunta implements Serializable{
	private String pergunta;
	private ArrayList<Alternativa> alternativas;
	private ArrayList<Integer> respostas;
	
	Pergunta(){
		
	}
	
	Pergunta(String pergunta){
		this.alternativas = new ArrayList<Alternativa>();
		this.pergunta = pergunta;
		this.respostas = new ArrayList<Integer>();
	}
	
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	
	public void addAlternativa(Alternativa alternativa){
		this.alternativas.add(alternativa);
	}
	
	public ArrayList<Alternativa> getAlternativas(){
		return alternativas;
	}
	
	public void addResposta(int alternativa){
		this.respostas.add(alternativa);
	}
		
	public ArrayList<Integer> getRespostas(){
		return this.respostas;
	}
	
}
