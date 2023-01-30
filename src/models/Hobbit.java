package models;

import javafx.scene.control.TextArea;

public class Hobbit extends Heroe{

	public Hobbit(String nombre, int vida, int armadura) {
		super(nombre, vida, armadura);
		this.tipo = "Hobbit";
		}
	
	@Override
	public void atacar(Personaje p, TextArea ta) {
		if(p.getTipo() == "Trasgo") {
			int tiradaActual = tirarDado()-5;
			if(tiradaActual>p.getArmadura()) {
				p.setVida(p.getVida()- (tiradaActual - p.getArmadura()));
			}
		}else {
			super.atacar(p, ta);
		}
	}
}