package comparadores;

import java.util.Comparator;

import cenarios.Cenario;

public class ComparadorPorNome implements Comparator<Cenario>{

	@Override
	public int compare(Cenario o1, Cenario o2) {
		if(o1.getDescricao().compareTo(o2.getDescricao()) != 0) {
			return o1.getDescricao().compareTo(o2.getDescricao());
		} else {
			return o1.compareTo(o2);
		}
	}

}
