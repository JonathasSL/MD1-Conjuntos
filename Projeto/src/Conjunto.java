import java.util.ArrayList;
import java.util.StringTokenizer;

public class Conjunto {
	private String strConjunto;
	private ArrayList<String> elementos;
	
	public Conjunto(String conjunto) {
		setStrConjunto(conjunto);
		setElementos(conjunto);
		System.out.println("strConjunto = "+strConjunto);
		System.out.println("elementos = "+elementos);
	}

	/**
	 * @return the strConjunto
	 */
	public String getStrConjunto() {
		return strConjunto;
	}

	/**
	 * @param strConjunto the strConjunto to set
	 */
	public void setStrConjunto(String strConjunto) {
		this.strConjunto = strConjunto;
	}

	/**
	 * @return o array
	 */
	public ArrayList<String> getElementos() {
		return elementos;
	}

	/**
	 * @param metodo privado que transforma a string recebida num Array que armazena os elementos
	 */
	private void setElementos(String conjunto) {
		//separa a string pela igualdade
		StringTokenizer st = new StringTokenizer(conjunto,"=");
		String token;
		//itera pelos lados da(s) igualdade(s)
		for(int i=0 ; i< st.countTokens() ; i++) {
			token = st.nextToken();
			//verifica se esse lado da igualdade é a representacao de um conjunto
			if(token.contains("{")) {
				//elimina os espacos
				token.replaceAll(" ", "");
				//percorre cada caracter da string
				for(int t=0 ; t<token.length() ; i++) {
					
				}
			}
		}
		this.elementos =null;
	}

	
}
