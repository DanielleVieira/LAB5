package comparadores;

import java.util.Comparator;

import cenarios.Cenario;

public class ComparadorPorNome implements Comparator<Cenario>{

	@Override
	public int compare(Cenario cen1, Cenario cen2) {
		if(cen1.getDescricao().compareTo(cen2.getDescricao()) != 0) {
			return cen1.getDescricao().compareTo(cen2.getDescricao());
		} else {
			return cen1.compareTo(cen2);
		}
	}

}
