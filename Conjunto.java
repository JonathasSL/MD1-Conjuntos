import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Conjunto {
	// Nome do conjunto
	private String nome;
	// String recebida como conjunto
	private String strConjunto;
	// Conjunto separado em lista
	static private Set<String> elementos;

	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Conjunto() {
		setNome("teste");
	}

	public Conjunto(String conjunto) {
		setStrConjunto(conjunto);
		setElementos(conjunto.replaceAll(" ", ""));
		setSize(conjunto.length());
	}

	/**
	 * @param metodo
	 *            publico que transforma a string recebida numa lista que armazena
	 *            os elementos
	 */
	//EDIT: Correção para conjuntos de string. Aceita entradas sem chave no início e fim
	//Trata as chaves como subconjunto
	public void setElementos(String conjunto) {
		elementos = new HashSet<>();
		String concatena = "";
		int cont = 0;
		String lista = conjunto.toString();
		String[] el = lista.split(",");
		for (int i = 0; i < el.length; i++) {
			if (el[i].contains("{")) {
				cont = i;
				while (!el[cont - 1].endsWith("}")) {
					concatena = concatena + el[cont] + ", ";
					cont++;
				}
				System.out.println("CONCAT = " + concatena);
				elementos.add(concatena);
			} else if (el[i].contains("}")) {

			} else
				elementos.add(el[i]);
		}
	}

	public String getElemento(int i) {
		Iterator<String> it = elementos.iterator();
		int aux = 0;
		String elemento = null;
		while (it.hasNext() && aux <= i) {
			elemento = it.next();
			aux++;
		}
		return elemento;
	}

	public int getCardinalidade() {
		return elementos.size();
	}

	public String getStringCardinalidade() {
		return "|" + nome + "| = " + getCardinalidade();
	}

	@Override
	public String toString() {
		return elementos.toString().replace("[", "{").replace("]", "}");
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the strConjunto
	 */
	public String getStrConjunto() {
		return strConjunto;
	}

	/**
	 * @param strConjunto
	 *            the strConjunto to set
	 */
	public void setStrConjunto(String strConjunto) {
		this.strConjunto = strConjunto;
	}

	/**
	 * @return o array
	 */
	public Set<String> getElementos() {
		return elementos;
	}

	public boolean vazio(Conjunto a) {
		if (a.getSize() != 0) {
			return false;
		} else
			return true;
	}

	public void addElemento(String elemento) {
		System.out.println("ENTREI");

		elementos.add(elemento);
		System.out.println("SAI");
	}

	//Ainda em implementação
	public static void complementar(Conjunto primeiro, Conjunto segundo) {
		ArrayList conjunto1 = new ArrayList();
		ArrayList conjunto2 = new ArrayList();
		String lista1 = elementos.toString().replace("[", "").replace("]", "");
		String lista2 = elementos.toString().replace("[", "").replace("]", "");

		System.out.println("Lista " + lista1);
	}

	//Sobrecarga para entradas padrão, como todos os inteiros ou todas as letras
	public static void complementar(String universo, Conjunto segundo) {

	}

}
