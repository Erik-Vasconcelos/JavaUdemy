package classes_e_metodos;

public class DateTest {
	public static void main(String[] args) {
		Date data = new Date(12,07,2022);
		System.out.println(data.displayDate());
		
		Date data2 = new Date();
		System.out.println(data2.displayDate());
	}
}
