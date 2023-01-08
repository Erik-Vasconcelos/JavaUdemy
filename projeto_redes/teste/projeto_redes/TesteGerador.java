package projeto_redes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import br.edu.ifrn.portal.pr.model.Gerador;

class TesteGerador {

	@Test
	void testGerar() {
		int[] bits = Gerador.fabricarBits(8);
		
		System.out.println(Arrays.toString(bits));
	}

}
