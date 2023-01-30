package models;

public class Humano extends Heroe {

	public Humano(String nombre, int vida, int armadura) {
		super(nombre, vida, armadura);
		this.tipo = "Humano";
	}

}
