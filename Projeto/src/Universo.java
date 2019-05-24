import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Universo {
	//Classe para manipulacao dos conjuntos
	private ArrayList<Conjunto> subConjuntos;
	//Elementos que nao estao dentro de nenhum sub conjunto
	private Conjunto universo;
	//Todos os elementos do universo
	private Conjunto all;
	
	//Cria o universo com seus elementos proprios
	public Universo(String elementos) {
		subConjuntos = new ArrayList<>();
		setUniverso(new Conjunto(elementos));
	}
	
	//Cria o universo com um subConjunto
	public Universo(Conjunto conjunto) {
		subConjuntos = new ArrayList<>();
		subConjuntos.add(conjunto);
	}
	
	public void addConjunto(String conjunto) {
		subConjuntos.add(new Conjunto(conjunto));
	}
	
	public void addConjunto(Conjunto conjunto) {
		subConjuntos.add(conjunto);
	}
	
	public void getUniao() {
		setUniao();
		return;
	}
	private void setUniao() {
		Set<String> s = new HashSet<>();
		Conjunto aux;
		for (int i = 0 ; i<subConjuntos.size() ; i++) {
			aux = subConjuntos.get(i);
			for(int e = 0 ; e < aux.getCardinalidade() ; e++) {
				
			}
		}
	}

	/**
	 * @return the universo
	 */
	public Conjunto getUniverso() {
		return universo;
	}

	/**
	 * @param universo the universo to set
	 */
	public void setUniverso(Conjunto universo) {
		this.universo = universo;
	}

	
	/**
	 * @return the elementos
	 */
	public Conjunto getElementos() {
		return all;
	}

	/**
	 * @param elementos the elementos to set
	 */
	public void setElementos(Conjunto conjunto) {
		this.all = conjunto;
	}
	

}
