package models;

import javafx.scene.control.TextArea;

public class Heroe extends Personaje{
	private boolean haceDanyo = false;
	public Heroe(String nombre, int vida, int armadura) {
		super(nombre, vida, armadura);
	}

	@Override
	public int tirarDado() {
		int tirada1= (int) (Math.random()*100);
		int tirada2= (int) (Math.random()*100);
		int tiradaMayor;
		
		if(tirada1>tirada2) {
			tiradaMayor = tirada1;
		}else {
			tiradaMayor = tirada2;
		}
		return tiradaMayor;
	}

	@Override
	public void atacar(Personaje p, TextArea ta) {
		int tiradaActual = tirarDado();
		if(tiradaActual>p.getArmadura()) {
			p.setVida(p.getVida()- (tiradaActual - p.getArmadura()));
			ta.setText(ta.getText() + "\n" + "  " + this.getNombre() + " saca " + tiradaActual + " y le quita " + (tiradaActual - p.getArmadura()) + " de vida a " + p.getNombre());
		}else {
			ta.setText(ta.getText() + "\n" + "  " + this.getNombre() + " saca " + tiradaActual + " y le quita 0 de vida a " + p.getNombre());
		}
		
	}

	public boolean isHaceDanyo() {
		return haceDanyo;
	}

	public void setHaceDanyo(boolean haceDanyo) {
		this.haceDanyo = haceDanyo;
	}
	

	

}