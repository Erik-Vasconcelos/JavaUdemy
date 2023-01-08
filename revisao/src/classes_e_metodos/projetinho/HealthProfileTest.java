package classes_e_metodos.projetinho;

import classes_e_metodos.Date;

public class HealthProfileTest {
	public static void main(String[] args) {
		
		HealthProfile healthProfile = new HealthProfile("Riam", "Lucas", "M", new Date(25, 04, 2008), 1.79, 55.98);
		System.out.println(healthProfile.toString());
	}
}
