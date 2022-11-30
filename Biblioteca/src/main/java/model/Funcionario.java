package model;

public class Funcionario {
	
	private String email;
	private String senha;
	private String confirmaSenha;
	private String cargo;
	private String RF;
	
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
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getRF() {
		return RF;
	}
	public void setRF(String rF) {
		RF = rF;
	}
	@Override
	public String toString() {
		return "Funcionario [email=" + email + ", senha=" + senha + ", confirmaSenha=" + confirmaSenha + ", cargo="
				+ cargo + ", RF=" + RF + "]";
	}
	
}
