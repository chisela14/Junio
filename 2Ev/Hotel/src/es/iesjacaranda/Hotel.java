package es.iesjacaranda;

import java.time.LocalDate;
import java.util.Arrays;

public class Hotel {
	
	private final int MAX_CLIENTES = 100;
	private Cliente[] clientes = new Cliente[MAX_CLIENTES];
	private int numClientes;
	private final int MAX_SALAS = 5;
	private Sala[] salas = new Sala[MAX_SALAS];
	private int numSalas;
	private final int MAX_RESERVAS = 75;
	private Reserva[] reservas = new Reserva[MAX_RESERVAS];
	private int numReservas;
	
	public Hotel(){
		inicializarHotel();
	}
	
	public void inicializarHotel() {
		this.numReservas = 0;
		this.numClientes = 0;
		this.numSalas = 0;
		//para no complicar mucho las pruebas pongo una sala de cada
		Sala s1 = new Sala(TiposSala.SIMPLE);
		salas[0] = s1;
		this.numSalas++;
		Sala s2 = new Sala(TiposSala.DOBLE);
		salas[1] = s2;
		this.numSalas++;
		Sala s3 = new Sala(TiposSala.CELEBRACION);
		salas[2] = s3;
		this.numSalas++;
		Sala s4 = new Sala(TiposSala.REUNION);
		salas[3] = s4;
		this.numSalas++;
		Sala s5 = new Sala(TiposSala.SUITE);
		salas[4] = s5;
		this.numSalas++;
	}
	
	public String listarInstalaciones() {
		StringBuilder salida = new StringBuilder();
		for(int i=0; i<this.numSalas;i++) {
			salida.append(salas[i].toString()+"\n");
		}
		salida.append("...............................................");
		return salida.toString();
	}
	
	public boolean encuentraCliente (String dni) {
		boolean encontrado = false;
		for(int i=0; i<clientes.length;i++) {
			if(dni.equals(clientes[i].getDni())) {
				encontrado = true;
			}
		}
		return encontrado;
	}
	
	public void nuevoCliente(String dni,String nombre, String apellido) {
		Cliente c = new Cliente(dni, nombre, apellido);
		clientes[0] = c;
		this.numClientes ++;
	}
	
	public int addReserva(TiposSala sala, LocalDate inicio, int dias, int personas) throws HotelException {
		//buscar si hay sala libre
		Sala salaDisponible = buscarSala(sala,inicio,dias);
		if (salaLibre(salaDisponible,inicio,dias)==true){
			LocalDate acaba = inicio.plusDays(dias);
			Reserva nueva = new Reserva(inicio,acaba,salaDisponible);
			reservas[0] = nueva;
			this.numReservas ++;
			return personas;
		}else {
			throw new HotelException("No hay ninguna sala disponible de ese tipo");
		}
	}
	
	public void addClienteUltimaReserva(String dni) throws HotelException {
		Reserva ultima = reservas[numReservas-1];
		//encontrar cliente
		if(encuentraCliente(dni)==false) {
			throw new HotelException("No se ha registrado ningún cliente con ese DNI en el hotel");
		}else {
			for(int i=0; i<clientes.length;i++) {
				if(dni.equals(clientes[i].getDni())) {
					Cliente c1 = clientes[i];
					//añadirlo a la ultima reserva
					ultima.addCliente(c1);
					//añadirle al cliente la reserva
					c1.addReserva(ultima);
				}
			}
		}
	}
	
	//borra la reserva del cliente segun la posicion -1, si no existe debera lanzar exception (se lanza en el metodo del cliente)
	public void delReserva(String dni, int posicion) throws HotelException, ClienteException {
		if(encuentraCliente(dni)==false) {
			throw new HotelException("El cliente no existe");
		}else {
			//buscar el cliente y borrar la reserva
			for(int i=0; i<clientes.length;i++) {
				if(dni.equals(clientes[i].getDni())) {
					clientes[i].delReserva(posicion-1);
				}
			}
			this.numReservas --;
		}
	}
	
	//buscar en las reservas de la sala si solapa o no
	private boolean salaLibre(Sala sala, LocalDate inicio, int dias) {
		boolean libre= false;
		LocalDate acaba = inicio.plusDays(dias);
		//en el uml no aparece ningun get reservas de sala pero entiendo que hace falta (si no es asi, no se como hacer este metodo)
		Reserva[] reservasSala = sala.getReservas();
		int numReservasSala = sala.getNumReservas();
		while(libre = false) {
			for(int i=0; i<numReservasSala; i++) {
				if(reservasSala[i].solapa(inicio, dias)==false) {
					libre = true;
				}
			}
		}
		return libre;
	}
	//buscar una sala libre para esas fechas, si no existe se lanza una excepcion
	private Sala buscarSala(TiposSala tipo, LocalDate inicio, int dias) throws HotelException {
		Sala salida = null;
		for(int i=0; i<this.numSalas; i++) {
			if(salas[i].getTipo()==tipo) {
				//buscar si esta libre
				if(salaLibre(salas[i],inicio,dias)==true) {
					salida = salas[i];
				}
			}
		}
		
		if(salida == null) {
			throw new HotelException("No se ha encontrado una sala libre para esas fechas");
		}else {
			return salida;
		}
	}

	public String getClientes() throws HotelException {
		if(this.numClientes==0) {
			throw new HotelException("No hay clientes");
		}else {
			StringBuilder salida = new StringBuilder();
			for(int i=0; i<clientes.length;i++) {
				salida.append(clientes[i].toString() +"\n");
			}
			salida.append("........................");
			return salida.toString();
		}
	}
	
	public String getReservasFechas() throws HotelException {
		if(this.numReservas==0) {
			throw new HotelException("No hay reservas");
		}else {
			Arrays.sort(reservas);
			StringBuilder salida = new StringBuilder();
			for(int i=0; i<this.numReservas;i++) {
				salida.append(i+1+".- Fecha Inicial: " + reservas[i].getFechaI() + " Fecha Final: " + reservas[i].getFechaF());
			}
			salida.append("........................");
			return salida.toString();
		}
	}
	
	public String getReservasClientes(String dni) {
		StringBuilder salida = new StringBuilder();
		//encontrar al cliente con ese dni(asumo que lo encontrara)
		for(int i=0; i<clientes.length;i++) {
			if(dni.equals(clientes[i].getDni())) {
				salida.append(clientes[i].getReservas());
			}
		}
		salida.append("........................");
		return salida.toString();
	}
	
	public String getReservasPosteriores(LocalDate fecha) {
		//crear un nuevo array a partir de la reserva con fecha posterior(a la fecha inicial)
		Reserva[] posteriores = null;
		int numPosteriores = 0;
		for (int i=0; i<this.numReservas; i++) {
			if(reservas[i].getFechaI().isAfter(fecha)) {
				posteriores[0] = reservas[i];
				numPosteriores ++;
			}
		}
		//ordenar para mostrar por orden
		Arrays.sort(posteriores);
		StringBuilder salida = new StringBuilder();
		for(int i=0;i<numPosteriores;i++) {
			salida.append(i+1+".- "+posteriores[i].toString()+"\n");
		}
		salida.append("........................");
		return salida.toString();
	}
}
