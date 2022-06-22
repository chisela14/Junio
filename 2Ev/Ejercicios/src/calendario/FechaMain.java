package calendario;

public class FechaMain {

	public static void main(String[] args) throws FechaException {
		Fecha f = new Fecha(22,06,2022);
		System.out.println(f.getDiaSemana());
		f.annadirDias(8);
		System.out.println(f);
		f.restarDias(15);
		System.out.println(f);
		f.annadirMeses(15);
		System.out.println(f);
		f.restarDias(16);
		System.out.println(f);
		f.restarMeses(5);
		System.out.println(f);
	}

}
