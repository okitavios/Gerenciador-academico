package GerenciadorAcademico;

public class matricula {
    private double nota;
    private String codigoDisciplina;

    public matricula (double nota,  String codigoDisciplina) {
        this.nota = nota;
        this.codigoDisciplina = codigoDisciplina;
    }
        public double getnota(){
        return nota;
        }
    public void setnota{
        this.nota = nota;
    }
        public String getcodigoDisciplina(){
        return disciplina;
        }
    public void setcodigoDisciplina(String codigoDisciplina){
         this.codigoDisciplina = codigoDisciplina
    }
    @Override
    public String toString(){
        return codigoDisciplina + "(" + nota + ")";
        )


}


