import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Teste {

	public static void main(String[] args) {
		
		

		int a[] = {1, 2, 3};
		
		
		String s = "A = {1,2, 3,{1, 2},4}";
		String w = "B = {1,2,3}";
		
		Conjunto B = new Conjunto(w);
		Conjunto A = new Conjunto(s);
		
		System.out.println("A soma:      " + somaConjunto(A,B, 8));
		
		

		
		/*
		String U = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,{1,2}}";
		String s = "A = {1,2, 3,{1, 2},4}";
		String w = "B = {1,2,3}";
		Conjunto B = new Conjunto(w);
		Conjunto A = new Conjunto(s);
		
		
		ArrayList<String> d = new ArrayList<String>();
		d.add("A");
		d.add("B");
		
//		System.out.println(s);
//		System.out.println(new Conjunto(s));
		
		Universo u = new Universo(U);
		partes(B);
		
		*/
		
		
		
		
		
		
		
	}
	
	//sandro.j@pucminas.br
	
	
	
	//METODO DO CONJUNTO DAS PARTES
	public static Conjunto partes(Conjunto a) {
		
		 String linha="P(" + a.getNome() + ") = {";
		 
		 for(int i=0;i<(1<<a.getCardinalidade());i++) {

		  linha+=" { ";
		  
		  for(int j=0; j<a.getCardinalidade();j++) {
		   if((i & (1<<j))!=0) {
		    linha+=a.getElemento(j)+ ",";
		    
		   }
		  }
		  linha+=" } ,";
		 }
		 linha+=" }";
		 linha = linha.replace(",}", "}").replace(", }", "}");
		 Conjunto C = new Conjunto(linha);
		 return C; 
		}
	
	


	
	
	
	
	
	

	
	
	
	
	
	
	// MÉTODO DE SOMA
	public static Conjunto  somaConjunto(Conjunto A, Conjunto B, int parametro) {
		int somaAB = 0;
		String concatena = "";
		String vetA[];
		String vetB[];
		
		for(int i = 0; i< A.getCardinalidade(); i++){
			for(int j=0; j< B.getCardinalidade(); j++) {
				
				if(A.getElemento(i).contains("{") && B.getElemento(j).contains("{")) {
					vetA = A.getElemento(i).split(",");
					vetB = B.getElemento(j).split(",");
					for(int w=0; w< vetA.length && w < vetB.length; w++){
						somaAB = Integer.parseInt(A.getElemento(w).replaceAll("{", "").replaceAll("}", "") + Integer.parseInt(B.getElemento(w).replaceAll("{", "").replaceAll("}", "")));
						if(somaAB == parametro)
							concatena += A.getNome() + "{ " + A.getElemento(w) + "+" + B.getElemento(w) + " }" + " = " + somaAB;
					}
				}else if(A.getElemento(i).contains("{")) {
					vetA = A.getElemento(i).split(",");
					for(int w=0; i< vetA.length; i++) {
						somaAB= Integer.parseInt(Integer.parseInt(A.getElemento(w).replaceAll("{", "").replaceAll("}", "")) + B.getElemento(j));
						if(somaAB == parametro)
							concatena += A.getNome() + "{ " + A.getElemento(w) + " + " + B.getElemento(j) + " }" + " = " + somaAB;
					}
				}else if(B.getElemento(j).contains("{")) {
					vetB = B.getElemento(j).split(",");
					for(int w=0; i < vetB.length; i++) {
						somaAB = Integer.parseInt(A.getElemento(i) + Integer.parseInt(B.getElemento(w).replaceAll("{", "").replaceAll("}", "")));		
						if(somaAB == parametro)
							concatena += A.getNome() + "{ " + A.getElemento(i) + " + " + B.getElemento(w) + " }" + " = " + somaAB;
					}
				}else{
					somaAB = Integer.parseInt(A.getElemento(i)) + Integer.parseInt(B.getElemento(j));
					if(somaAB == parametro) 
						concatena += "{ " + A.getElemento(i) + " + " + B.getElemento(j) + " }" + " = " + somaAB;	
				}	
				
				
				
				
			}
		}
		if(concatena == "") {
			System.out.println("Não é possível calcular com esse parâmetro");
		} else {
			Conjunto C = new Conjunto(concatena);
			C.setNome("C");
			return C;
		}
		return null;
	}
	
	
	
	
	
}
	

