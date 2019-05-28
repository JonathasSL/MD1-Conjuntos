
public class Teste {

	public static void main(String[] args) {
		Universo u = new Universo("Universo = {100,150,200}");
		Conjunto a = new Conjunto("A = {1,2,  3,{1, 2},4}");
		Conjunto b = new Conjunto("B = {4,5,6,7,{9,10},8}");
		Conjunto texto = new Conjunto("Texto = {Daniel, Alex,{Claudia, Joao},Fernando}");
		u.addConjunto(a);
		u.addConjunto(b);
		u.addConjunto(texto);
		System.out.println(u.getUniverso());
		
		
		
		
	}

}
