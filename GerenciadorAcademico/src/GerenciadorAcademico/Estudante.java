package GerenciadorAcademico;

public class Estudante {
	private String nome;
	private int id;
	
	public Estudante(int id,String nome) {
		this.id=id;
		this.nome=nome;
		
	}
	public String getNome(){
		return nome;
	}
	public void setnome(String nome) {
		this.nome=nome;
	}

	public int getid(){
		return id;
	}
	public void setid(int id) {
		this.id=id;
	}
	@Override
    public String toString() {
        return id + " - " + nome;
    }
	
}
