package comparadores;

import java.util.Comparator;

import cenarios.Cenario;

public class ComparadorPorApostas implements Comparator<Cenario>{

	@Override
	public int compare(Cenario o1, Cenario o2) {
		if(o1.totalDeApostas() > o2.totalDeApostas()) {
			return -1;
		} else if(o1.totalDeApostas() < o2.totalDeApostas()) {
			return 1;
		} else {
			return o1.compareTo(o2);
		}
	}

}
