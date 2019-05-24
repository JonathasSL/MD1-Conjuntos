
public class Teste {

	public static void main(String[] args) {
		String s = "A = {1,2,  3,{1, 2},4}";
		System.out.println(s+"\n");
		Conjunto c = new Conjunto(s);
		System.out.println(c+"\n");
		System.out.println(c.getElemento(3));
	}

}
