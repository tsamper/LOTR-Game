package models;

import javafx.scene.control.TextArea;

public class Elfo extends Heroe{
	public Elfo(String nombre, int vida, int armadura) {
		super(nombre, vida, armadura);
		this.tipo = "Elfo";
	}
	
	
	@Override
	public void atacar(Personaje p, TextArea ta) {
		int tiradaActual = tirarDado();
		if(p.getTipo() == "Orco"){
			tiradaActual += 10;
		}
		if(tiradaActual>p.getArmadura()) {
			p.setVida(p.getVida()- (tiradaActual - p.getArmadura()));
			ta.setText(ta.getText() + "\n" + "  " + this.getNombre() + " saca " + tiradaActual + " y le quita " + (tiradaActual - p.getArmadura()) + " de vida a " + p.getNombre());
		}else {
			ta.setText(ta.getText() + "\n" + "  " + this.getNombre() + " saca " + tiradaActual + " y le quita 0 de vida a " + p.getNombre());
		}
		
	}
	
}
