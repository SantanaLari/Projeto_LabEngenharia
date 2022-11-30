package model;

public class Estudante {
	
	private String email;
	private String senha;
	private String confirmaSenha;
	private String curso;
	private String RA;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getRA() {
		return RA;
	}
	public void setRA(String rA) {
		RA = rA;
	}
	@Override
	public String toString() {
		return "Estudante [email=" + email + ", senha=" + senha + ", confirmaSenha=" + confirmaSenha + ", curso="
				+ curso + ", RA=" + RA + "]";
	}
	
	
}
