import java.io.Serializable;

public class Resposta implements Serializable {

	private int alternativa;
	
	Resposta(){}
	
	Resposta(int alternativa){
		this.alternativa = alternativa;
	}
	
	public int getAlternativa(){
		return this.alternativa;
	}
	
}
