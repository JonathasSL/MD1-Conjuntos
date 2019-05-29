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
		
		
//		combina(a, 0, new ArrayList<>());
		
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
//	public static void print(ArrayList<Integer> solucao) {
//		for(int i=0;i<solucao.size();i++) {
//			
//			System.out.print(solucao.get(i) + " - ");
//		}
//		System.out.print("\n");
//	}
//	
//	public static void combina(int []conjunto, int atual, ArrayList<Integer> solucao) {
//		
//		print(solucao);
//		for(int i=0;i<conjunto.length;i++) {
//			if (atual != i) {
//				solucao.add(conjunto[i]);
//				combina(conjunto, i, solucao);
//				solucao.remove(solucao.size()-1)
//;			}
//		}
//		
//	}
//	
//	public static void partes(Conjunto a) {
//		
//		 String linha="P(" + a.getNome() + ") = {";
//		 
//		 for(int i=0;i<(1<<a.getCardinalidade());i++) {
//
//		  linha+=" { ";
//		  
//		  for(int j=0; j<a.getCardinalidade();j++) {
//		   if((i & (1<<j))!=0) {
//		    linha+=a.getElemento(j)+ ",";
//		    
//		   }
//		  }
//		  linha+=" } ,";
//		 }
//		 linha+=" }";
//		 linha = linha.replace(",}", "}").replace(", }", "}");
//		 System.out.println(linha); 
//		}
	
	
//	public static void partes(Conjunto a){
//		
//		 String linha = "P(" + a.getNome() + ") = {";
//		 
//		 for(int i=0; i< a.getCardinalidade(); i++) {
//			 
//			 linha+=" { ";
//			 
//			 for(int j=0; j< a.getCardinalidade(); j++) {
//				 if( j  +  1/ j+1 != 0 ) {
//					 System.out.println("Entrei aqui dentro");
//				 }
//			 }
//		 }
//	}

	
	
	
	
	
	
//	public static void conjuntoDasPartes(Conjunto A) {
//		System.out.println();
//		int i=0;
//		String linhafinal = "}";
//		String linhainicio = "{ Ø"; 
//		String linhaAux = "{";
//		
//		String linha1  = "";
//		String linha2  ="";
//		String linha3  = "";
//		
//
//		
//			
//		linha1 += linhainicio + ",{";
//		linha2 += linhaAux;
//		linha3 += linhaAux; 
//		
//	
//			while(i < A.getCardinalidade()) {
//				
//				
//				linha1 += A.getElemento(i) + "},";
//				linha1 += linhaAux;
//				
//				linha2 += A.getElemento(i) + ",";
//				if(i == 0) {
//					linha3 +=  A.getElemento(i) + "," + A.getElemento(i + 1) + linhafinal;
//				}
//				else if(i == 1) {
//					linha3 += linhaAux + A.getElemento(i-1) + "," + A.getElemento(i+1) + linhafinal +",";
//				}else if(i == 2) {
//					System.out.println("VALOR DO I: " + i);
//					i=i-1;
//					linha3 += linhaAux + A.getElemento(i) + "," + A.getElemento(i+1) + linhafinal;	
//					i=i+1;
//				}else if(i == 3) { }
//				
//				i++;
//			}
//			linha1 += linhafinal;
//			linha2 += linhafinal + ",";
//			linha3 += linhafinal;
//			
//			System.out.println("linha1" + linha1);
//			System.out.println("linha2" + linha2);
//			System.out.println("linha3" + linha3);
//			
//			String Concatena = linha1 + linha2 + linha3;
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println("Conjunto das Partes: "+ Concatena);
//
//		}
	
	
	
	
	
	
	
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
	

