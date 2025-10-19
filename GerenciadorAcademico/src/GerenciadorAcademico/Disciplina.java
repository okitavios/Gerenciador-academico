package GerenciadorAcademico;

public class Disciplina {
	private String codigo;
	private String nomeM;
	
	public Disciplina(String codigo, String nomeM) {
		this.codigo=codigo;
		this.nomeM=nomeM;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo=codigo;
	}
	public String getNomeM() {
		return nomeM;
	}
	public void setNomeM(String nomeM) {
		this.nomeM=nomeM;
	}
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true; 
	        if (obj == null || getClass() != obj.getClass()) return false;
	        Disciplina diciplina = (Disciplina) obj;
	        return codigo.equalsIgnoreCase(diciplina.codigo); 
	    }

	    @Override
	    public int hashCode() {
	        return codigo.toLowerCase().hashCode();
	    }

}
