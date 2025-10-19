package GerenciadorAcademico;

public class Matricula {
    private double nota;
    private String codigoDisciplina;

    public Matricula (String codigoDisciplina,double nota) {
        this.codigoDisciplina = codigoDisciplina;
        this.nota = nota;
    }
        public double getnota(){
        return nota;
        }
    public void setnota(double nota){
        this.nota = nota;
    }
        public String getcodigoDisciplina(){
        return codigoDisciplina;
        }
    public void setcodigoDisciplina(String codigoDisciplina){
         this.codigoDisciplina = codigoDisciplina;
    }
    @Override
    public String toString(){
        return codigoDisciplina + "(" + nota + ")";
        

    }
}

