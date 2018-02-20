package comparadores;

import java.util.Comparator;

import cenarios.Cenario;

public class ComparadorPorApostas implements Comparator<Cenario>{

	@Override
	public int compare(Cenario cen1, Cenario cen2) {
		if(cen1.totalDeApostas() > cen2.totalDeApostas()) {
			return -1;
		} else if(cen1.totalDeApostas() < cen2.totalDeApostas()) {
			return 1;
		} else {
			return cen1.compareTo(cen2);
		}
	}

}
