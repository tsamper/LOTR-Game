package models;

import javafx.scene.control.TextArea;

public class Orco extends Bestia{
	
	public Orco(String nombre, int vida, int armadura) {
		super(nombre, vida, armadura);
		this.tipo = "Orco";
	}
	@Override
	public void atacar(Personaje p, TextArea ta) {
		int tiradaActual = tirarDado();
		int armaduraActual = p.getArmadura()-(p.getArmadura()*10/100);
		if(tiradaActual>armaduraActual) {
			p.setVida(p.getVida()- (tiradaActual - armaduraActual));
			ta.setText(ta.getText() + "\n" + "  " + this.getNombre() + " saca " + tiradaActual + " y le quita " + (tiradaActual - p.getArmadura()) + " de vida a " + p.getNombre());
		}else {
			ta.setText(ta.getText() + "\n" + "  " + this.getNombre() + " saca " + tiradaActual + " y le quita 0 de vida a " + p.getNombre());
		}
	}

}

