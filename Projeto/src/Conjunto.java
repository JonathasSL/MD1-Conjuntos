import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Conjunto {
	//Nome do conjunto
	private String nome;
	//String recebida como conjunto
	private String strConjunto;
	//Conjunto separado em lista
	private Set<String> elementos;

	//Cria um conjunto com nome e elementos ja determinados Ex: "A = {1,2,  3,{1, 2},4}"
	public Conjunto(String conjunto) {
		elementos = new HashSet<>();
		setStrConjunto(conjunto);
		setElementos(conjunto.replaceAll(" ", ""));
	}
	
	//Cria um conjunto sem elementos e sem nome
	public Conjunto() {
		elementos = new HashSet<>();
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
		//itera pelos lados da(s) igualdade(s)
		for(int i=0 ; i<= st.countTokens() ; i++) {
			token = st.nextToken();
			//verifica se esse lado da igualdade e a representacao de um conjunto
			if(token.contains("{")) {
				//elimina os espacos da string
				token = token.replaceAll(" ", "");
				String add,sub;
				//percorre cada caracter da string
				for(int p=1 ; p<token.length() ; p++) {
					add = token.substring(p);
					if(!"{".equals(String.valueOf(token.charAt(p))) 
							&& !",".equals(String.valueOf(token.charAt(p))) 
							&& !"}".equals(String.valueOf(token.charAt(p)))) {
						int euristica = Integer.MAX_VALUE;
						sub = token.substring(p);
						int virg = sub.indexOf(",")<0?euristica:sub.indexOf(",");
						int chav = sub.indexOf("}")<0?euristica:sub.indexOf("}");
						add = virg<chav? sub.substring(0, virg):sub.substring(0, chav);
						elementos.add(add);
						p+=add.length()-1;
					}else {
						//Checa se elemento na posicao t e um subconjunto
						if("{".equals(String.valueOf(token.charAt(p)))) {
							//adiciona o subConjunto inteiro como um elementos
							int chave = add.indexOf("}")+p;
							add = token.substring(p, chave)+"}";
							elementos.add(add);
							//Pula o subconjunto
							p += add.length();
						}
					}
				}
			}else //se o lado da igualdade for o nome do conjunto
				setNome(token);
		}
	}
	
	//Retorna o elemento na posicao i do conjunto
	public String getElemento(int i) {
		Iterator<String> it = elementos.iterator();
		int aux = 0;
		String elemento = null;
		while(it.hasNext() && aux <= i) {
			elemento = it.next();
			aux++;
		}
		return elemento;
	}
	
	//Retorna a cardinalidade do conjunto
	public int getCardinalidade() {
		return elementos.size();
	}

	//Adiciona um unico elemento ao conjunto
	public void addElemento(String elemento) {
		elementos.add(elemento);
	}
	
	//Retorna uma String com o nome do conjunto
	public String getStringCardinalidade() {
		return "|"+nome+"| = "+ getCardinalidade();
	}

	//Testa se um elemento existe no conjunto
	public boolean contains(String elemento) {
		boolean achou = false;
		for(int i=0 ; i<getCardinalidade() && !achou; i++)
			achou = getElemento(i).equalsIgnoreCase(elemento)?true:false;
		return achou;
	}

	//Retorna uma string com o nome e a representacao do conjunto
	@Override
	public String toString() {
		return  nome + " = " + elementos.toString().replace("[", "{").replace("]", "}") ;
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
