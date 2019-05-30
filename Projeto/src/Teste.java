import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Teste {
	static int cont = 0;
	private static ArrayList<String> l;

	public static void main(String[] args) {
		Universo u = new Universo();
		String s = "A = {1,2,3}";
		String b = "B = {1,4,5,2,{1,2}}";
		String bla = "C = {Eu, Tu, Nos, Vos, {Eles, Elas}}";
		Conjunto palavras = new Conjunto(bla);
		Conjunto a = new Conjunto(s);
		Conjunto c = new Conjunto(b);
		partes(a);
		conjuntoDasPartes(palavras);
		complementar(c, a);
		relacaoDeDivisao(c, a);
	}

	public static boolean contem(Conjunto a, Conjunto b) {
		int cont = 0;

		for (int i = 0; i < b.getCardinalidade(); i++) {
			if (a.getElemento(i).contains(b.getElemento(i))) {
				cont++;
			}

		}
		if (cont == a.getCardinalidade()) {
			return true;
		}
		return false;

	}

	public static void multiplicacao(Conjunto a, Conjunto b) {
		HashSet elementos = new HashSet<>();

		String novoConjunto = a.getNome() + " x " + b.getNome() + "= {";
		for (int i = 0; i < a.getCardinalidade(); i++) {
			for (int j = 0; j < b.getCardinalidade(); j++) {
				a.getElemento(i);
				novoConjunto = novoConjunto + "(" + a.getElemento(i) + " ," + b.getElemento(j) + ")" + ",";
				elementos.add(novoConjunto);
			}
		}
		System.out.println(elementos);
		System.out.println(novoConjunto);
	}

	public static void partes(Conjunto a) {
		String linha = "P(" + a.getNome() + ") = {";
		for (int i = 0; i < (1 << a.getCardinalidade()); i++) {

			linha += " { ";

			for (int j = 0; j < a.getCardinalidade(); j++) {
				if ((i & (1 << j)) != 0) {
					linha += a.getElemento(j) + ",";

				}
			}
			linha += " } ,";
		}
		linha += " }";
		linha = linha.replace(",}", "}").replace(", }", "}");
		System.out.println(linha);
	}

	public static void conjuntoDasPartes(Conjunto A) {
		int i = 0, cont = 0;
		String linhafinal = "}";
		String linhainicio = "{ Ø";
		String linhaAux = "{";

		String linha1 = "";
		String linha2 = "";
		String linha3 = "";
		String linha4 = "";

		System.out.println();
		ArrayList<Object> t = new ArrayList<>();
		for (int y = 0; y < A.getCardinalidade(); y++) {
			t.add(A.getElemento(y));
			System.out.println(t);

		}

		linha1 += linhainicio + ",{";
		linha2 += linhaAux;
		linha3 += linhaAux;

		while (i < A.getCardinalidade()) {

			linha1 += A.getElemento(i) + "},";
			linha1 += linhaAux;

			linha2 += A.getElemento(i) + ",";
			if (i == 0) {
				linha3 += A.getElemento(i) + "," + A.getElemento(i + 1) + linhafinal;
			} else if (i == 1) {
				linha3 += linhaAux + A.getElemento(i - 1) + "," + A.getElemento(i + 1) + linhafinal + ",";
			} else if (i == 2) {
				System.out.println("VALOR DO I: " + i);
				i = i - 1;
				linha3 += linhaAux + A.getElemento(i) + "," + A.getElemento(i + 1) + linhafinal;
				i = i + 1;
			} else if (i == 3) {
			}

			i++;
		}
		int j = 0;
		while (t.size() != 1) {
			// for(int j=0; j<A.getCardinalidade(); j) {
			for (int w = 1; w < A.getCardinalidade(); w++) {
				if (t.get(j) != A.getElemento(w)) {
					linha4 += "{ " + t.get(j) + "," + A.getElemento(w) + "}";

				}

			}
			t.remove(t.get(j));
			// t.remove(t.get(j));
			System.out.println(t.get(j));
			// t.remove(t.get(j));
		}
		// cont++;
		// }

		linha1 += linhafinal;
		linha2 += linhafinal + ",";
		linha3 += linhafinal;

		System.out.println("linha1" + linha1);
		System.out.println("linha2" + linha2);
		System.out.println("linha3" + linha3);
		System.out.println("LINHA4 " + linha4);

		String Concatena = linha1 + linha2 + linha3;
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Conjunto das Partes: " + Concatena);

	}

	//-----COMPLEMENTAR CORRIGIDA: SOMENTE FAZ A DIFERENÇA SE O conjuntoB ESTIVER CONTIDO NO conjuntoA
	public static void complementa(Conjunto conjuntoA, Conjunto conjuntoB) {
		String lista0 = conjuntoA.toString().replace("{", "").replace("}", "").replace(" ", "");
		String lista1 = conjuntoB.toString().replace("{", "").replace("}", "").replace(" ", "");
		String[] recebe1 = lista0.split(",");
		String[] recebe2 = lista1.split(",");
		int cont = recebe2.length, cont1 = 0;
		for(String el: recebe1) {
			for(String ele: recebe2) {
				if(ele.equals(el)) {
					cont1++;
				}
			}
		}
		if(cont == cont1) {
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
			} else {
				System.out.println(conjuntoA.getNome() + " não é complementar de " + conjuntoB.getNome() + ".");
			}
		}

	public static void relacaoDeDivisao(Conjunto primeiro, Conjunto segundo) {
		String lista1 = primeiro.toString().replace("{", "").replace("}", "").replace(" ", "");
		String lista2 = segundo.toString().replace("{", "").replace("}", "").replace(" ", "");
		String[] recebe1 = lista1.split(",");
		String[] recebe2 = lista2.split(",");
		int[] vet1 = new int[recebe1.length];
		int[] vet2 = new int[recebe2.length];
		Set<String> concatena = new HashSet<>();
		for (int i = 0; i < recebe1.length; i++) {
			vet1[i] = Integer.parseInt(recebe1[i]);
		}
		for (int i = 0; i < recebe2.length; i++) {
			vet2[i] = Integer.parseInt(recebe2[i]);
		}
		//String concatena = "";
		for (int i = 0; i < vet1.length; i++) {
			for (int j = 0; j < vet2.length; j++) {
				if (vet2[j] % vet1[i] == 0) {
					concatena.add("(" + vet1[i] + ", " + vet2[j] + "), ");
				}

			}
		}
		System.out.println("a se relaciona com b se, e somente se, aRb = a/b: " + concatena);

	}

}
