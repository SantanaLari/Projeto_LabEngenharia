package model;

public class Locacao {

	private int id;
	private Livro livro;
	private String dataIni;
	private String dataFim;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
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
		return "Locacao [id=" + id + ", livro=" + livro + ", dataIni=" + dataIni + ", dataFim=" + dataFim + "]";
	}

}
