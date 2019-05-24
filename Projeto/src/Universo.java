import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Universo {
	//Classe para manipulacao dos conjuntos
	private ArrayList<Conjunto> subConjuntos;
	private Conjunto universo;
	
	public Universo(String elementos) {
		subConjuntos = new ArrayList<>();
		subConjuntos.add(new Conjunto(elementos));
	}
	
	public Universo(Conjunto conjunto) {
		subConjuntos = new ArrayList<>();
		subConjuntos.add(conjunto);
	}
	
	public void addConjunto(String conjunto) {
		subConjuntos.add(new Conjunto(conjunto));
	}
	
	public Set getUniao() {
		Set<Conjunto> uni = new HashSet<>();
		for (int i = 0 ; i<subConjuntos.size() ; i++) {
			
		}
		return uni;
	}
	

}
