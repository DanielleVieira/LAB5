package facade;

import easyaccept.EasyAccept;

public class Main {

	public static void main(String[] args) {
		args = new String [] {"facade.Facade", "testes_de_aceitacao/us1_test.txt", "testes_de_aceitacao/us2_test.txt", "testes_de_aceitacao/us3_test.txt",
				"testes_de_aceitacao/us4_test.txt", "testes_de_aceitacao/us5_test.txt", "testes_de_aceitacao/us6_test.txt", "testes_de_aceitacao/us7_test.txt"};
		EasyAccept.main(args);
	}

}
