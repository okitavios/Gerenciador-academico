package GerenciadorAcademico;
import java.util.ArrayList;
import java.util.List;

public class ListaDeEstudantes {
	 public List<Estudante> lista;
	 
	 private ListaDeEstudantes() {
		 this.lista=new ArrayList<>();
	 }
	 
	 public void adicionarEstudante(Estudante e) {
		 lista.add(e);
	 }
	 public void removerEstudantePorId(int id) {
		 lista.remove(id);
	 }

}
