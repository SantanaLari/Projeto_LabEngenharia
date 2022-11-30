package model;

public class Locacao {

	private Livro idLivro;
	private String email;
	private String dataIni;
	private String dataFim;

	public Livro getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Livro idLivro) {
		this.idLivro = idLivro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataIni() {
		return dataIni;
	}

	public void setDataIni(String dataIni) {
		this.dataIni = dataIni;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public String toString() {
		return "Locacao [idLivro=" + idLivro + ", email=" + email + ", dataIni=" + dataIni + ", dataFim=" + dataFim
				+ "]";
	}

}
