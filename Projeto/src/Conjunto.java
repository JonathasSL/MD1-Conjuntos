import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Conjunto {
	//Nome do conjunto
	private String nome;
	//String recebida como conjunto
	private String strConjunto;
	
	//Conjunto separado em lista
	private ArrayList<String> el;
	private Set<String> elementos;
	
	public Conjunto(String conjunto) {
		setStrConjunto(conjunto);
		setElementos(conjunto.replaceAll(" ", ""));
		//Testes
//		System.out.println("strConjunto: "+strConjunto);
//		System.out.println("elementos: "+elementos);
	}
	
	/**
	 * @param metodo privado que transforma a string recebida numa lista que armazena os elementos
	 */
	private void setElementos(String conjunto) {
		//Inicializa o array
		elementos = new HashSet<>();
		//separa a string pela igualdade
		StringTokenizer st = new StringTokenizer(conjunto,"=");
		String token;
		// 
		boolean chave;
		//itera pelos lados da(s) igualdade(s)
		for(int i=0 ; i<= st.countTokens() ; i++) {
			token = st.nextToken();
			//verifica se esse lado da igualdade é a representacao de um conjunto
			if(token.contains("{")) {
				//elimina os espacos da string
				token = token.replaceAll(" ", "");
				String add,sub = null;
				//percorre cada caracter da string
				for(int t=1 ; t<token.length() ; t++) {
					add = null;
					if(!"{".equals(String.valueOf(token.charAt(t))) && !",".equals(String.valueOf(token.charAt(t))) && !"}".equals(String.valueOf(token.charAt(t)))) {
						
						int euristica = Integer.MAX_VALUE;
						sub = token.substring(t);
						int virg = sub.indexOf(",")<0?euristica:sub.indexOf(",");
						int chav = sub.indexOf("}")<0?euristica:sub.indexOf("}");
						add = virg<chav? sub.substring(0, virg):sub.substring(0, chav);

						System.out.println(add);
						elementos.add(add);
					}else
						//Checa se elemento na posicao t e um subconjunto
						if("{".equals(token.charAt(t))) {
							add = token.substring(t-1, token.substring(t).indexOf("}"));
							elementos.add(add);
							

							System.out.println(add);
							
							//Pula o subconjunto
//							System.out.println(t);
							t += token.substring(t).indexOf("}") - t;
//							System.out.println(t);
						}
				}
			}else
				setNome(token);
		}
		this.elementos =null;
	}

	
	

	@Override
	public String toString() {
		return "Conjunto: " + nome + " = " + elementos ;
	}
	

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
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
	public Set<String> getElementos() {
		return elementos;
	}
}
