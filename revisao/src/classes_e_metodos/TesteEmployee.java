package classes_e_metodos;

import java.time.LocalDate;

public class TesteEmployee {
	public static void main(String[] args) {
		
		Employee employee1 = new Employee("João", "Nascimento", 2589.96);
		
		
		Employee employee2 = new Employee("Paulo", "Coelho", 3465.47);
		System.out.println(employee1.getSalarioAnual());
		System.out.println(employee2.getSalarioAnual());
		
		employee1.setBonus(0.1);
		employee2.setBonus(0.1);
		System.out.println();
		
		System.out.println(employee1.getSalarioAnual());
		System.out.println(employee2.getSalarioAnual());
		
		System.out.println(LocalDate.now());
	}
}
