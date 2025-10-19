package GerenciadorAcademico;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class HistoricoNotas {
	private Map<Integer, List<Matricula>> historico; 

    public HistoricoNotas() {
        this.historico = new HashMap<>();
    }

    
    public void adicionarMatricula(int idEstudante, String codigoDisciplina, double nota) {
        historico.computeIfAbsent(idEstudante, k -> new ArrayList<>())
                 .add(new Matricula(codigoDisciplina,nota));
    }

    
    public List<Matricula> obterMatriculas(int idEstudante) {
        return historico.getOrDefault(idEstudante, new ArrayList<>());
    }

    
    public Optional<Double> obterNota(int idEstudante, String codigoDisciplina) {
        return obterMatriculas(idEstudante).stream()
                .filter(m -> m.getcodigoDisciplina().equalsIgnoreCase(codigoDisciplina))
                .map(Matricula::getnota)
                .findFirst();
    }

    
    public boolean removerMatricula(int idEstudante, String codigoDisciplina) {
        List<Matricula> lista = historico.get(idEstudante);
        if (lista == null) return false;
        boolean removed = lista.removeIf(m -> m.getcodigoDisciplina().equalsIgnoreCase(codigoDisciplina));
        if (lista.isEmpty()) historico.remove(idEstudante);
        return removed;
    }

    
    public double mediaDoEstudante(int idEstudante) {
        List<Matricula> lista = obterMatriculas(idEstudante);
        return lista.stream()
                .mapToDouble(Matricula::getnota)
                .average()
                .orElse(0.0);
    }

    
    public double mediaDaDisciplina(String codigoDisciplina) {
        List<Double> notas = new ArrayList<>();
        for (List<Matricula> lm : historico.values()) {
            lm.stream()
              .filter(m -> m.getcodigoDisciplina().equalsIgnoreCase(codigoDisciplina))
              .map(Matricula::getnota)
              .forEach(notas::add);
        }
        return notas.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

   
    public List<Estudante> topNEstudantesPorMedia(int N, ListaDeEstudantes listaEstudantes) {
        return listaEstudantes.getLista().stream()
                .map(e -> new EstudanteComMedia(e, mediaDoEstudante(e.getid())))
                .sorted(Comparator.comparingDouble(EstudanteComMedia::getMedia).reversed())
                .limit(N)
                .map(EstudanteComMedia::getEstudante)
                .collect(Collectors.toList());
    }

    
    public List<Estudante> alunosComMediaMaiorIgual(double limite, ListaDeEstudantes listaEstudantes) {
        return listaEstudantes.getLista().stream()
                .filter(e -> mediaDoEstudante(e.getid()) >= limite)
                .collect(Collectors.toList());
    }

    public List<String> disciplinasComMediaMenorQue(double limite) {
        
        Map<String, List<Double>> notasPorDisc = new HashMap<>();
        for (List<Matricula> lm : historico.values()) {
            for (Matricula m : lm) {
                notasPorDisc.computeIfAbsent(m.getcodigoDisciplina().toUpperCase(), k -> new ArrayList<>())
                            .add(m.getnota());
            }
        }
        return notasPorDisc.entrySet().stream()
                .filter(en -> en.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0.0) < limite)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    
    private static class EstudanteComMedia {
        private Estudante estudante;
        private double media;

        public EstudanteComMedia(Estudante estudante, double media) {
            this.estudante = estudante;
            this.media = media;
        }

        public Estudante getEstudante() { return estudante; }
        public double getMedia() { return media; }
    }
}
