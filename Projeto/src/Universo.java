import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Universo {
	//Classe para manipulacao dos conjuntos
	private ArrayList<Conjunto> subConjuntos;
	//Elementos que nao estao dentro de nenhum subConjunto
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
	
	public Conjunto getUniverso(ArrayList<String> nomes) {
		setUniversoCompleto();
		return all;
	}
	
	private void setUniversoCompleto() {
		Set<String> s = new HashSet<>();
		Conjunto aux;
		all = new Conjunto();
		all.setNome("Universo");
		
		for (int i = 0 ; i<subConjuntos.size() ; i++) {
			aux = subConjuntos.get(i);
			for(int e = 0 ; e < aux.getCardinalidade() ; e++) {
				all.addElemento(aux.getElemento(e));
			}
		}
		for(int i=0;i<universo.getCardinalidade();i++) {
			all.addElemento(universo.getElemento(i));
		}
	}
	
	private Conjunto getConjuntoConjunto(Set<String> conjunto) {
		return universo;
	}

	/**
	 * @return the universo
	 */
 	public Conjunto getUniverso() {
 		setUniversoCompleto();
 		return all;
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
	
	public void uniao(ArrayList<String> conjuntosDigitados) {//Recebe uma lista contendo os nomes dos conjuntos que foram inseridos pelo usuário
		Set<String> conjuntoSemRepeticao = new HashSet<>();
		//		Conjunto uniao = new Conjunto();
		//		uniao.setNome("Uniao");
		for (int i = 0; i < conjuntosDigitados.size(); i ++) {//Percorre todas as posições do conjunto digitado
			for (int j = 0; j < subConjuntos.size(); j ++) {//Para cada posição do conjunto digitado, todas as posições do conjunto universo são acessadas
				Conjunto aux = subConjuntos.get(j);//aux recebe os valores do conjunto universo que estão naquela posição
				if (conjuntosDigitados.get(i).equalsIgnoreCase(aux.getNome())) {//Verifica se o nome do conjunto é igual ao nome do sub conjunto do conjunto universo
					for (int k = 0; k < aux.getCardinalidade(); k ++) {//Verifica a cardinalidade (número de elementos) de aux, e executa o "for". Cada iteração representa um desses elementos da cardinalidade;
						conjuntoSemRepeticao.add(aux.getElemento(k));//Adiciona em "conjuntoSemRepeticao" o elemento de aux naquela posição
						//						uniao.addElemento(aux.getElemento(k));
					}
				}
			}	
		}
		Iterator <String> it = conjuntoSemRepeticao.iterator();
		String elemento = null;
		while (it.hasNext()) {
			elemento = it.next();
			System.out.println(elemento);
		}
	}

//	public void pertinencia() {
//		setUniao();
//		for (int j = 0; j < all.getCardinalidade(); j ++) {
//			for (int i = 0; i < subConjuntos.size(); i ++) {
//				if (subConjuntos.get(i).contains(all.getElemento(j)))
//					System.out.println(subConjuntos.get(i).getElemento(i));
//			}
//		}
//	}

}
