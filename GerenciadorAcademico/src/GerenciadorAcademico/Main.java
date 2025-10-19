package GerenciadorAcademico;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        
        ListaDeEstudantes lista = new ListaDeEstudantes();
        CadastroDisciplina cadastro = new CadastroDisciplina();
        HistoricoNotas historico = new HistoricoNotas();

        
        lista.adicionarEstudante(new Estudante(1,"Maria"));
        lista.adicionarEstudante(new Estudante(2,"João"));
        lista.adicionarEstudante(new Estudante(3,"Ana"));
        lista.adicionarEstudante(new Estudante(4, "Lucas"));
        lista.adicionarEstudante(new Estudante(5, "Elisa"));
        
        cadastro.adicionarDisciplina(new Disciplina("MAT101", "Matemática"));
        cadastro.adicionarDisciplina(new Disciplina("PRG201", "Programação"));
        cadastro.adicionarDisciplina(new Disciplina("BD301",  "Banco de Dados"));
        cadastro.adicionarDisciplina(new Disciplina("EDF110", "Educação Física"));

        historico.adicionarMatricula(1, "MAT101", 8.5);
        historico.adicionarMatricula(1, "PRG201", 9.0);

        historico.adicionarMatricula(2, "PRG201", 7.0);
        historico.adicionarMatricula(2, "MAT101", 5.0);
        
        historico.adicionarMatricula(3, "BD301", 6.5);
        historico.adicionarMatricula(3, "MAT101", 7.5); 
        
        historico.adicionarMatricula(4, "PRG201", 8.0);
        historico.adicionarMatricula(5, "EDF110", 10.0);
        
        System.out.println("== Lista de Estudantes (ordem de cadastro) ==");
        lista.getLista().forEach(e -> System.out.println(e.getid() + " - " + e.getNome()));
        System.out.println();

        
        lista.ordenarEstudantesPorNome();
        System.out.println("== Lista de Estudantes (ordenada) ==");
        String ordenados = lista.getLista().stream()
                .map(Estudante::getNome)
                .collect(Collectors.joining(", "));
        System.out.println(ordenados);
        System.out.println();

        
        System.out.println("== Disciplinas (inserção) ==");
        System.out.println(cadastro.listarCodigosSeparadosPorVirgula());
        System.out.println();

       
        System.out.println("== Duplicatas detectadas na importação ==");
        
        System.out.println("(nenhuma)");
        System.out.println();

       
        System.out.println("== Matrículas ==");
        for (Estudante e : lista.getLista()) {
            List<Matricula> mats = historico.obterMatriculas(e.getid());
            String matérias = mats.stream()
                                  .map(Matricula::toString)
                                  .collect(Collectors.joining(", "));
            double media = historico.mediaDoEstudante(e.getid());
            System.out.printf("%s: %s  Média: %.2f%n", e.getNome(), matérias.isEmpty() ? "(nenhuma)" : matérias, media);
        }
        System.out.println();

        
        System.out.println("== Médias por Disciplina ==");
        Set<Disciplina> todas = cadastro.obterTodasDisciplinas();
        for (Disciplina d : todas) {
            double m = historico.mediaDaDisciplina(d.getCodigo());
            System.out.printf("%s: %.2f%n", d.getCodigo(), m);
        }
        System.out.println();

        
        System.out.println("== Top 3 alunos por média ==");
        List<Estudante> top3 = historico.topNEstudantesPorMedia(3, lista);
        for (int i = 0; i < top3.size(); i++) {
            Estudante e = top3.get(i);
            System.out.printf("%d) %s - %.2f%n", i+1, e.getNome(), historico.mediaDoEstudante(e.getid()));
        }
        System.out.println();


        System.out.println("== Alunos com média >= 8.0 ==");
        List<Estudante> acima8 = historico.alunosComMediaMaiorIgual(8.0, lista);
        System.out.println(acima8.stream().map(Estudante::getNome).collect(Collectors.joining(", ")));
        System.out.println();

       
        System.out.println("== Disciplinas com média < 6.0 ==");
        List<String> discBaixa = historico.disciplinasComMediaMenorQue(6.0);
        if (discBaixa.isEmpty()) {
            System.out.println("(nenhuma)");
        } else {
            System.out.println(String.join(", ", discBaixa));
        }
    }
        

        
}
