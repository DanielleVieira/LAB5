package comparadores;

import java.util.Comparator;

import cenarios.Cenario;

public class ComparadorPorCadastro implements Comparator<Cenario>{

	@Override
	public int compare(Cenario o1, Cenario o2) {
		if(o1.getId() < o2.getId()) {
			return -1;
		} else if(o1.getId() > o2.getId()) {
			return 1;
		} else {
			return 0;
		}
	}

}
