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

	
	

	public Conjunto Intersecao(Conjunto a, Conjunto b) {
		
		String teste = null;
		String novoConjunto = "Interseção de " + a.getNome() + " e " + b.getNome() +  "= {";
		for(int i=0;i<a.getSize();i++) {
			for(int j=0;j<b.getSize();j++) {
				if(a.getElemento(i).contains(b.getElemento(j))) {
					teste=a.getElemento(i);
					novoConjunto = novoConjunto + teste+ " ," ;
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
