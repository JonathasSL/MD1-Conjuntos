import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) {
//		Universo u = new Universo("Universo = {100,150,200}");
//		Conjunto a = new Conjunto("A = {1,2,  3,{1, 2},4}");
//		Conjunto b = new Conjunto("B = {4,5,6,7,{9,10},8}");
		Conjunto texto = new Conjunto("Texto = {Daniel, Alex,{Claudia, Joao},Fernando}");
//		u.addConjunto(a);
//		u.addConjunto(b);
//		u.addConjunto(texto);
//		ArrayList<String> noms = new ArrayList<>();
//		noms.add("A");
//		noms.add("texto");
//		noms.add("B");
//		System.out.println(u.uniao(noms));
//		u.uniao(noms);
//		
//		ArrayList<Conjunto> respostas = new ArrayList<>();
 		
		String PAPartes = "PAPartes = { { } , { 1} , { 2} , {1,2} , { 3} , {1,3} , { 1,2,3} }";
		System.out.println(new Conjunto(PAPartes));
		System.out.println(texto);
		
		
	}

}