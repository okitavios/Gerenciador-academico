package GerenciadorAcademico;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class ListaDeEstudantes {
	 public List<Estudante> lista;
	 
	 public ListaDeEstudantes() {
		 this.lista=new ArrayList<>();
	 }
	 
	 public void adicionarEstudante(Estudante e) {
		 lista.add(e);
	 }
	 public void removerEstudantePorId(int id) {
		 lista.remove(id);
	 }
	 
     public Estudante obterEstudantePorIndice(int indice) {
    	 return lista.get(indice);
     }
     public List<Estudante> buscarEstudantesPorNome(String substring) {
    	    List<Estudante> resultados = new ArrayList<>();

    	    for (Estudante e : lista) {
    	        if (e.getNome().toLowerCase().contains(substring.toLowerCase())) {
    	            resultados.add(e);
    	        }
    	    }

    	    return resultados;
    	}
     public void ordenarEstudantesPorNome() {
    	    Collections.sort(lista, Comparator.comparing(Estudante::getNome, String.CASE_INSENSITIVE_ORDER));
    	}
     public List<Estudante> getLista() {
         return lista;
     }

     public void setLista(List<Estudante> lista) {
         this.lista = lista;
     }
 }
     


