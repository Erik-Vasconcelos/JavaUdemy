package orientacao_obj.interface2;

public class Teste {
	public static void main(String[] args) {
		J2Prime j2 = new J2Prime();
		
		j2.desbloquear();
		j2.tirarFoto();
		
		System.out.println();
		S21Plus s21 = new S21Plus();
		s21.desbloquear();
		s21.tirarFoto();
		s21.foto4K();
		s21.tirarFoto();
		
		
	}
}
