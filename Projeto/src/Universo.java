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
	
	//Adiciona um novo subconjunto ao universo pela sua representacao em String
	public void addConjunto(String conjunto) {
		subConjuntos.add(new Conjunto(conjunto));
	}
	
	//Adiciona um novo subconjunto
	public void addConjunto(Conjunto conjunto) {
		subConjuntos.add(conjunto);
	}
	
	//Retorna a uniao do universo e todos seus subconjuntos
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
		if(universo!=null)
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
	
	public Conjunto uniao(ArrayList<String> conjuntosDigitados) {//Recebe uma lista contendo os nomes dos conjuntos que foram inseridos pelo usu�rio
		Set<String> conjuntoSemRepeticao = new HashSet<>();
				Conjunto uniao = new Conjunto();
				uniao.setNome(toString(conjuntosDigitados));
		for (int i = 0; i < conjuntosDigitados.size(); i ++) {//Percorre todas as posi��es do conjunto digitado
			for (int j = 0; j < subConjuntos.size(); j ++) {//Para cada posi��o do conjunto digitado, todas as posi��es do conjunto universo s�o acessadas
				Conjunto aux = subConjuntos.get(j);//aux recebe os valores do conjunto universo que est�o naquela posi��o
				if (conjuntosDigitados.get(i).equalsIgnoreCase(aux.getNome())) {//Verifica se o nome do conjunto � igual ao nome do sub conjunto do conjunto universo
					for (int k = 0; k < aux.getCardinalidade(); k ++) {//Verifica a cardinalidade (n�mero de elementos) de aux, e executa o "for". Cada itera��o representa um desses elementos da cardinalidade;
						conjuntoSemRepeticao.add(aux.getElemento(k));//Adiciona em "conjuntoSemRepeticao" o elemento de aux naquela posi��o
						uniao.addElemento(aux.getElemento(k));
					}
				}
			}
		}
//		Iterator <String> it = conjuntoSemRepeticao.iterator();
//		String elemento = null;
//		while (it.hasNext()) {
//			elemento = it.next();
//			System.out.println(elemento);
//		}
//		System.out.println(toString(conjuntosDigitados, conjuntoSemRepeticao));
		return uniao;
	}
	
	public void subtracao(Conjunto conjuntoA, Conjunto conjuntoB) {
		boolean achou;
		ArrayList<String> lista = new ArrayList<>();
		for (int i = 0; i < conjuntoA.getCardinalidade(); i ++) {
			achou = false;
				for (int j = 0; j < conjuntoB.getCardinalidade(); j ++) {
						if (conjuntoA.getElemento(i).equalsIgnoreCase(conjuntoB.getElemento(j)))
							achou = true;
					}
				if (!achou)
					lista.add(conjuntoA.getElemento(i));				
			}
		System.out.println(conjuntoA.toString());
		System.out.println(conjuntoB.toString());
		System.out.println(conjuntoA.getNome() + " - " + conjuntoB.getNome() + " = " + lista.toString());
		}
	
	public String toString(ArrayList<String> conjuntosDigitados/*, Set<String> conjuntoSemRepeticao*/) {
		String uniao = null;//String que ser� utilizada para imprimir a uni�o de todo o conjunto
		for (int i = 0; i < conjuntosDigitados.size(); i ++) {//Faz "n" itera��es. Uma para cada posi��o do "conjuntosDigitados"
			if (i + 1 == conjuntosDigitados.size())//Verifica se a pr�xima posi��o ser� igual ao tamanho de "conjuntosDigitados". Se for, ent�o quer dizer que a atual posi��o � a �ltima
				uniao += conjuntosDigitados.get(i) /*+ " = " + conjuntoSemRepeticao*/;//Caso seja a �ltima posi��o, � inserido o nome do �ltimo conjunto e a uni�o completa. Por exemplo: "A U B U "(valor antigo) + "C = [1, 12, 34, 2, 3, 4, 18, 8, 9, {1,2}]"(novo valor) = A U B U C = [1, 12, 34, 2, 3, 4, 18, 8, 9, {1,2}] 
			else if (uniao == null)//Verifica se a vari�vel est� vazia
				uniao = conjuntosDigitados.get(i) + " U ";//Se estiver vazia, a primeira String � adicionada. O resultado, por exemplo, seria: "A U " (A uni�o com...)
			else if (uniao != null)//Verifica se a vari�vel j� possui valores
				uniao += conjuntosDigitados.get(i) + " U ";//Se possuir valores, ent�o a String � concatenada � anterior. Por exemplo: "A U "(antigo valor) + "B U"(valor a ser inserido agora) = "A U B U "
		}
		return uniao;
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

