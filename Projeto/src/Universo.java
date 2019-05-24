import java.util.ArrayList;

public class Universo {
	//Classe para manipulacao dos conjuntos
	private ArrayList<Conjunto> universo;
	
	public Universo() {
		universo = new ArrayList<>();
	}
	
	public Universo(Conjunto conjunto) {
		universo = new ArrayList<>();
		universo.add(conjunto);
	}
	
	

}
