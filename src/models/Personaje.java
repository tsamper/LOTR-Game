package models;


import javafx.scene.control.TextArea;

public abstract class Personaje {
	private String nombre;
	private int vida;
	private int armadura;
	protected String tipo;

	
	

	public Personaje(String nombre, int vida, int armadura) {
		super();
		this.nombre = nombre;
		this.vida = vida;
		this.armadura = armadura;
	}
	
	public abstract int tirarDado();

	public void atacar(Personaje p, TextArea ta) {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getArmadura() {
		return armadura;
	}

	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return nombre + " - " + tipo + " (" + vida + ", " + armadura + ")";
	}
	
	/*@Override
	public String toString() {
		return nombre + " (Vida=" + vida + " Armadura=" + armadura + ")";
	}*/
	
	
	
}
