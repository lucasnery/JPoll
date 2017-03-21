import java.io.*;

public class Alternativa implements Serializable{
	private String alternativa;

	Alternativa(){
		
	}
	
	Alternativa(String alternativa){
		setAlternativa(alternativa);
	}
	
	public String getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(String alternativa) {
		this.alternativa = alternativa;
	}
	
	

}
