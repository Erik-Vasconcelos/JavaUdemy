package fundamentos;

import java.util.Iterator;

public class ForAninhado {
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			
			for (int j = 0; j < 10; j++) {
				System.out.printf("[%d %d] ", i, j);
			}
			System.out.println();
			
		}
		
		
		for(String i ="#";!i.equals("#####"); i+="#") {
			System.out.println(i);
		}
		
		
			

	}
}
