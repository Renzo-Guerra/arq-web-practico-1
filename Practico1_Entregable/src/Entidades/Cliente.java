package Entidades;

public class Cliente {
	private int idCliente;
	private String nombre;
	private String mail;
	
	public Cliente(int idCliente, String nombre, String mail) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.mail = mail;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMail() {
		return mail;
	}
		
}
