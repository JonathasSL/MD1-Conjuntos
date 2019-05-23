import java.util.ArrayList;
import java.util.StringTokenizer;

public class Conjunto {
	//String recebida como conjunto
	private String strConjunto;
	//Conjunto separado em lista
	private ArrayList<String> elementos;
	
	public Conjunto(String conjunto) {
		setStrConjunto(conjunto);
		setElementos(conjunto);
		//Testes
		System.out.println("strConjunto: "+strConjunto);
		System.out.println("elementos: "+elementos);
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
		// 
		boolean chave;
		//itera pelos lados da(s) igualdade(s)
		for(int i=0 ; i<= st.countTokens() ; i++) {
			token = st.nextToken();
			//elimina os espacos da string
			token.replaceAll(" ", "");
			System.out.println("token: "+token);
			//verifica se esse lado da igualdade é a representacao de um conjunto
			if(token.contains("{")) {
				String add = null;
				//percorre cada caracter da string
				for(int t=0 ; t<=token.length() ; t++) {
					if(!"{".equals(token.charAt(i)) && !",".equals(token.charAt(i))) {
						int euristica = Integer.MAX_VALUE;
						String sub = token.substring(i);
						add = sub.
						
						
						
						
//						elementos.add();
					}else
						if("{".equals(token.charAt(i))) {
							add = token.substring(i, token.substring(i).indexOf("}"));
//							elementos.add(token.substring(i, token.substring(i).indexOf("}")));
						}
					System.out.println(add);
				}
			}
		}
		this.elementos =null;
	}

	
}
