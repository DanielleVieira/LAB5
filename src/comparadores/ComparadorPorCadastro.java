package comparadores;

import java.util.Comparator;

import cenarios.Cenario;

public class ComparadorPorCadastro implements Comparator<Cenario>{

	@Override
	public int compare(Cenario cen1, Cenario cen2) {
		if(cen1.getId() < cen2.getId()) {
			return -1;
		} else if(cen1.getId() > cen2.getId()) {
			return 1;
		} else {
			return 0;
		}
	}

}
