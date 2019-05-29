import java.util.ArrayList;

public class Universo {
	private int size;
	private int[] elementos;
	public int[] getElementos() {
		return elementos;
	}

	public void setElementos(int[] elementos) {
		this.elementos = elementos;
	}

	//Classe para manipulacao dos conjuntos
	private ArrayList<Conjunto> universo;
	
	public Universo() {
		universo = new ArrayList<>();
	}
	
	public Universo(Conjunto conjunto) {
		universo = new ArrayList<>();
		universo.add(conjunto);
		setSize(universo.size());
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ArrayList<Conjunto> getUniverso() {
		return universo;
	}

	public void setUniverso(ArrayList<Conjunto> universo) {
		this.universo = universo;
	}

	
	


	
	public static boolean contem(Conjunto a, Conjunto b) {
		int cont=0;
		
		for(int i=0;i<b.getCardinalidade();i++) {
				if(a.getElemento(i).contains(b.getElemento(i))) {
					cont++;
				}
			
		}
		if(cont==a.getCardinalidade()) {
			return true;
		}
		return false;
		
		
	}
	
	public static void multiplicacao(Conjunto a, Conjunto b) {
		HashSet elementos = new HashSet<>();
		
		String novoConjunto = a.getNome() + " x " + b.getNome() +  "= {";
		for(int i=0;i<a.getCardinalidade();i++) {
			for(int j=0;j<b.getCardinalidade();j++) {
				novoConjunto = novoConjunto + "(" +  a.getElemento(i) + " ," + b.getElemento(j) + ")" + "," ;
				elementos.add(novoConjunto);
			}
		}
		System.out.println(novoConjunto);
	}
	
	
	public static boolean maior(Conjunto a, Conjunto b) {
		String d = a.toString();
		d= d.replace("{", "").replace("}", "").replace(":", "").replace("Conjunto", "").replace("=", "").replace(",", "").replace(" ", "");
		 try {
		Integer.valueOf(d);
		int total1=0;
		int total2=0;
		for(int i=0;i<a.getCardinalidade();i++) {
			if(a.getElemento(i).contains("{")) {
					String[] texto = a.getElemento(i).split(",");
					for(int w=0; w<texto.length;w++) {
						texto[w] = texto[w].replace("{", "").replace("}", "");
						total1 += Integer.parseInt(texto[w]);
					}
			}
			else
			total1 +=  Integer.parseInt(a.getElemento(i));
		}
		for(int j=0;j<b.getCardinalidade();j++) {
			if(a.getElemento(j).contains("{")) {
				String[] texto = a.getElemento(j).split(",");
				System.out.println("TESTE: " + texto[0].replace("{", "") + "outro " + texto[1].replace("}", ""));
				for(int w=0; w<texto.length;w++) {
					texto[w] = texto[w].replace("{", "").replace("}", "");
					total2 += Integer.parseInt(texto[w]);
				}		
			
		}
		else
			total2 = total2 + Integer.parseInt(b.getElemento(j));	
		}
		if(total1>total2) {
			System.out.println(a.getNome() + " é maior que " + b.getNome());
			return true;
		}
		else {
			System.out.println(a.getNome() + " é menor que " + b.getNome());
			return false;}
		 } catch (Exception e) {
		        System.out.println("Este conjunto é composto por elementos textos, tente outro conjunto.");
		    }

		return false;
	}
	
	
	public static Conjunto Intersecao(Conjunto a, Conjunto b) {
		
		String intersecao = null;
		String novoConjunto = "Interseção = {";
		for(int i=0;i<a.getCardinalidade();i++) {
			for(int j=0;j<b.getCardinalidade();j++) {
				if(a.getElemento(i).contains(b.getElemento(j))) {
					intersecao=a.getElemento(i);
					if(novoConjunto.contains(intersecao)) {
						
					}
					else
					novoConjunto = novoConjunto + intersecao + " ," ;
				}
			}
		}
		
		novoConjunto=novoConjunto + "}";
		novoConjunto=novoConjunto.replace(",}", "}");
		Conjunto c = new Conjunto(novoConjunto);
		System.out.println(c);
		return c;
		}

}
