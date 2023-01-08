package orientacao_obj.animal;

public class Gato extends Mamifero implements AnimalDomesticado, AnimalEstimacao{
	String raca;
	@Override
	public void brincar() {
		System.out.println("Brincando");
	}

	@Override
	public void levarPassear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alimentar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void levarAoVeterinario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chamarVeterinario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	String amamentar() {
		
		return "com leite materno";
	}

}
