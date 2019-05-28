
public class Teste {

	public static void main(String[] args) {
		String s = "A = {1,2,  3,{1, 2},4}";
//		System.out.println(s+"\n");
//		Conjunto c = new Conjunto(s);
//		System.out.println(c+"\n");
//		Universo u = new Universo("Universo = {100,150,200}");
//		u.addConjunto(c);
//		System.out.println(u.getUniverso());
		
		
		String a = "Texto = {Daniel, Alex,{Claudia, Joao},Fernando}";
		System.out.println(new Conjunto(a));
	}

}
