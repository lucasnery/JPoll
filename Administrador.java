import java.io.*;

public class Administrador implements Serializable{
	private int codigo, senha;
	private String usuario;
	
	Administrador(){}
	
	public Administrador(int codigo, String usuario, int senha){
		this.setCodigo(codigo);
		this.setUsuario(usuario);
		this.setSenha(senha);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public boolean setCodigo(int codigo) {
		if ( codigo > 0 ) {
			this.codigo = codigo;
			return true;
		}
		return false;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
