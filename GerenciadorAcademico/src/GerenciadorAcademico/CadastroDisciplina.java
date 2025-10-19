package GerenciadorAcademico;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CadastroDisciplina {
	private Set<Disciplina> disciplinas;
	public CadastroDisciplina() {
        this.disciplinas = new LinkedHashSet<>();
    }
	 public void adicionarDisciplina(Disciplina d) {
	        disciplinas.add(d);
	    }
	 public boolean verificarDisciplina(String codigo) {
	        return disciplinas.stream()
	                .anyMatch(d -> d.getCodigo().equalsIgnoreCase(codigo));
	    }
	 public void removerDisciplina(String codigo) {
	        disciplinas.removeIf(d -> d.getCodigo().equalsIgnoreCase(codigo));
	    }
	 public Set<Disciplina> obterTodasDisciplinas() {
	        return disciplinas;
	    }
	 public Set<Disciplina> detectarDuplicatasNaImportacao(List<Disciplina> importadas) {
	        Set<Disciplina> duplicadas = new LinkedHashSet<>();
	        for (Disciplina d : importadas) {
	            if (disciplinas.contains(d) || !disciplinas.add(d)) {
	                duplicadas.add(d);
	            }
	        }
	        return duplicadas;
	    }
	 public String listarCodigosSeparadosPorVirgula() {
	        return disciplinas.stream()
	                .map(Disciplina::getCodigo)
	                .collect(Collectors.joining(", "));
	    }


}
