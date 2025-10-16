package GerenciadorAcademico;

public class matricula {
    private String nome;
    private int matricula;
    private String turma;
    private int anoLetivo;
    private double notaMedia;
    private String disciplina;

    public matricula(String nome, int matricula, String turma, int anoLetivo, double notaMedia,  String disciplina) {
        this.nome = nome;
        this.matricula = matricula;
        this.turma = turma;
        this.anoLetivo = anoLetivo;
        this.notaMedia = notaMedia;
        this.disciplina = disciplina;
    }
        public String getnome(){
           return nome;
        }
        public int getmatricula(){
        return matricula;
        }
        public String getturma(){
        return turma;
        }
        public int getanoLetivo(){
        return anoLetivo;
        }
        public double getnotaMedia(){
        return notaMedia;
        }
        public String getdisciplina(){
        return disciplina;
        }


}

