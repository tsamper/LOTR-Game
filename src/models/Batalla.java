package models;

import java.util.ArrayList;

import exceptions.ExceptionTamanyoEjercito;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;

public class Batalla {
	public static void batalla(ObservableList<Heroe> eh, ObservableList<Bestia> eb, TextArea ta) {
		int cont = 1; //Contador para saber el turno actual
		ArrayList<Integer> muertosHeroes = new ArrayList<Integer>();  //ArrayList que guarda la posici�n de los heroes muertos durante el turno
		ArrayList<Integer> muertosBestias = new ArrayList<Integer>();  //ArrayList que guarda la posici�n de las bestias muertas durante el turno
		try {
			if (eh.size() == 0 || eb.size() == 0) {
				throw new ExceptionTamanyoEjercito("Introduce al menos un personaje de cada tipo");
			} 
			while ((eh.size() != 0) && (eb.size() != 0)) {
				if (cont == 1) {
					ta.setText("Turno " + cont++ + ":");
				} else {
					ta.setText(ta.getText() + "\n" + "Turno " + cont++ + ":");
				}
			////Turno si el ejercito de heroes es mayor que el de bestias o igual
				if (eh.size() > eb.size() || eh.size() == eb.size()) {
					for (int i = 0; i < eb.size(); i++) {
						ta.setText(ta.getText() + "\n" + " Lucha entre " + eh.get(i).getNombre() + " (Vida="
								+ eh.get(i).getVida() + " Armadura=" + eh.get(i).getArmadura() + ") y "
								+ eb.get(i).getNombre() + " (Vida=" + eb.get(i).getVida() + " Armadura="
								+ eb.get(i).getArmadura() + ")");
						eh.get(i).atacar(eb.get(i), ta);
						eb.get(i).atacar(eh.get(i), ta);
						if (eh.get(i).getVida() < 1) {
							ta.setText(ta.getText() + "\n" + "  ¡Muere " + eh.get(i).getTipo() + " "
									+ eh.get(i).getNombre() + "!");
							muertosHeroes.add(i);
						}
						if (eb.get(i).getVida() < 1) {
							ta.setText(ta.getText() + "\n" + " ¡Muere " + eb.get(i).getTipo() + " "
									+ eb.get(i).getNombre() + "!");
							muertosBestias.add(i);						
						}

					}
					
				////Turno si el ejercito de bestias es mayor que el de heroes
				} else {
					for (int i = 0; i < eh.size(); i++) {
						ta.setText(ta.getText() + "\n" + " Lucha entre " + eh.get(i).getNombre() + " (Vida="
								+ eh.get(i).getVida() + " Armadura=" + eh.get(i).getArmadura() + ") y "
								+ eb.get(i).getNombre() + " (Vida=" + eb.get(i).getVida() + " Armadura="
								+ eb.get(i).getArmadura() + ")");
						eh.get(i).atacar(eb.get(i), ta);
						eb.get(i).atacar(eh.get(i), ta);
						if (eh.get(i).getVida() < 1) {
							ta.setText(ta.getText() + "\n" + " ¡Muere " + eh.get(i).getTipo() + " "
									+ eh.get(i).getNombre() + "!");
							muertosHeroes.add(i);
						}
						if (eb.get(i).getVida() < 1) {
							ta.setText(ta.getText() + "\n" + " ¡Muere " + eb.get(i).getTipo() + " "
									+ eb.get(i).getNombre() + "!");
							muertosBestias.add(i);
						}
					}
					
				}
				int contHeroes = 0; //Contador para recalcular la posici�n de un heroe al haber eliminado a otro antes que �l
				int contBestias = 0;
				////Eliminar todos los personajes muertos en ese turno
				for (int i = 0; i < muertosHeroes.size(); i++) {
					int eliminarH = muertosHeroes.get(i-contHeroes);
					eh.remove(eliminarH);
					contHeroes++;
				}
				muertosHeroes.clear();
				for (int i = 0; i < muertosBestias.size(); i++) {
					int eliminarB = muertosBestias.get(i-contBestias);
					eb.remove(eliminarB);
					contBestias++;
				}
				muertosBestias.clear();
			}

			if (eh.size() > eb.size()) {
				ta.setText(ta.getText() + "\n" + "¡¡VICTORIA DE LOS HEROES!!");
			} else if (eh.size() < eb.size()) {
				ta.setText(ta.getText() + "\n" + "¡¡VICTORIA DE LAS BESTIAS!!");
			}
		
		}catch(ExceptionTamanyoEjercito e) {
			ta.setText(e.getMessage());
		}
	}
}
