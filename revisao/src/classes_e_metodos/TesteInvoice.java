package classes_e_metodos;

public class TesteInvoice {
	public static void main(String[] args) {
		
		Invoice item1 = new Invoice("533", "caneta preta", 30, 1.56);
		System.out.println(item1.getInvoiceAmount());
	}
}
