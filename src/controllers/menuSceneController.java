package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import exceptions.ExceptionCreacionPersonaje;
import exceptions.ExceptionInterfaz;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Bestia;
import models.Orco;
import models.Heroe;
import models.Humano;
import models.Elfo;
import models.Hobbit;
import models.Trasgo;
import models.Batalla;

public class menuSceneController implements Initializable{
	ArrayList<Bestia> bestias = new ArrayList<Bestia>();
	ArrayList<Heroe> heroes = new ArrayList<Heroe>();
	ObservableList<Heroe> heroesOb =FXCollections.observableArrayList(heroes);
	ObservableList<Bestia> bestiasOb =FXCollections.observableArrayList(bestias);

	
    @FXML
    private TextField armaduraBestia;

    @FXML
    private TextField armaduraHeroe;

    @FXML
    private Button b1Bestia;

    @FXML
    private Button b1Heroe;

    @FXML
    private Button b2Bestia;

    @FXML
    private Button b2Heroe;

    @FXML
    private Button b3Bestia;

    @FXML
    private Button b3Heroe;

    @FXML
    private Button botonBestia;

    @FXML
    private Button botonHeroe;
   
    @FXML
    private Button bBatalla;
    
    @FXML
    private ListView<Bestia> listaBestia;

    @FXML
    private ListView<Heroe> listaHeroe;

    @FXML
    private TextField nombreBestia;

    @FXML
    private TextField nombreHeroe;

    @FXML
    public TextArea textoBatalla;

    @FXML
    private ChoiceBox<String> tipoBestia;
    
    private String[] tBestias = {"Orco", "Trasgo"};

    @FXML
    private ChoiceBox<String> tipoHeroe;
    
    private String[] tHeroes = {"Humano", "Elfo", "Hobbit"};

    @FXML
    private TextField vidaBestia;

    @FXML
    private TextField vidaHeroe;
    
///////////////A�adir bestia a la lista/////////////////////
    @FXML
    void anyadirBestia(ActionEvent event) {
    	String nombreB = "";
    	String tipoB = "";
    	int vidaB = 0;
    	int armaduraB = 0;
    	Pattern patNombre = Pattern.compile("^[a-zA-Z�-�\\u00f1\\u00d1]+");
    	Matcher matNombre = patNombre.matcher(nombreBestia.getText());
    	try {
    		if(!matNombre.matches()) {
    			throw new ExceptionCreacionPersonaje("Nombre incorrecto");
    		}
    		nombreB = nombreBestia.getText();
    	}catch(ExceptionCreacionPersonaje e) {
    		textoBatalla.setText(e.getMessage());
    	}
    	try {
    		if(tipoBestia.getValue() == null) {
    			throw new ExceptionCreacionPersonaje("Introduce un tipo");
    		}
    		tipoB = tipoBestia.getValue();
    	}catch(ExceptionCreacionPersonaje e) {
    		textoBatalla.setText(e.getMessage());
    	}
    	Pattern patVida = Pattern.compile("^[0-9]+");
    	Matcher matVida = patVida.matcher(vidaBestia.getText());
    	try {
    		if(!matVida.matches()) {
    			throw new ExceptionCreacionPersonaje("Introduce un número correcto para la vida");
    		}
    		vidaB = Integer.parseInt(vidaBestia.getText());
    	}catch(ExceptionCreacionPersonaje e){
    		textoBatalla.setText(e.getMessage());
    	}
    	Matcher matArmadura = patVida.matcher(armaduraBestia.getText());
    	try {
    		if(!matArmadura.matches()) {
    			throw new ExceptionCreacionPersonaje("Introduce un número correcto parra la armadura");
    		}
    		armaduraB = Integer.parseInt(armaduraBestia.getText());
    	}catch(ExceptionCreacionPersonaje e) {
    		textoBatalla.setText(e.getMessage());
    	}
    	try {
    		if(!matNombre.matches() || tipoBestia.getValue() == null || !matVida.matches() || !matArmadura.matches()) {
    			throw new ExceptionCreacionPersonaje("Error al añadir la bestia");
    		}
    		textoBatalla.setText(nombreB + " añadido");
    		switch (tipoB) {
    		case "Orco":
    			Orco o = new Orco(nombreB, vidaB, armaduraB);
    			bestias.add(o);
    			bestiasOb.add(o);
    			break;
    		case "Trasgo":
    			Trasgo t = new Trasgo(nombreB, vidaB, armaduraB);
    			bestias.add(t);
    			bestiasOb.add(t);
    			break;
    		}
    		listaBestia.setItems(bestiasOb);
    	}catch(ExceptionCreacionPersonaje e){
    		System.out.println(e.getMessage());
    	}
    }
    
///////////////A�adir heroe a la lista/////////////////////
    @FXML
    void anyadirHeroe(ActionEvent event) {
    	String nombreH = "";
    	String tipoH = "";
    	int vidaH = 0;
    	int armaduraH = 0;
    	Pattern patNombre = Pattern.compile("^[a-zA-Z�-�\\u00f1\\u00d1]+");
    	Matcher matNombre = patNombre.matcher(nombreHeroe.getText());
    	try {
    		if(!matNombre.matches()) {
    			throw new ExceptionCreacionPersonaje("Nombre incorrecto");
    		}
    		nombreH = nombreHeroe.getText();
    	}catch(ExceptionCreacionPersonaje e) {
    		textoBatalla.setText(e.getMessage());
    	}
    	try {
    		if(tipoHeroe.getValue() == null) {
    			throw new ExceptionCreacionPersonaje("Introduce un tipo");
    		}
    		tipoH = tipoHeroe.getValue();
    	}catch(ExceptionCreacionPersonaje e) {
    		textoBatalla.setText(e.getMessage());
    	}
    	Pattern patVida = Pattern.compile("^[0-9]+");
    	Matcher matVida = patVida.matcher(vidaHeroe.getText());
    	try {
    		if(!matVida.matches()) {
    			throw new ExceptionCreacionPersonaje("Introduce un número correcto para la vida");
    		}
    		vidaH = Integer.parseInt(vidaHeroe.getText());
    	}catch(ExceptionCreacionPersonaje e){
    		textoBatalla.setText(e.getMessage());
    	}
    	Matcher matArmadura = patVida.matcher(armaduraHeroe.getText());
    	try {
    		if(!matArmadura.matches()) {
    			throw new ExceptionCreacionPersonaje("Introduce un número correcto parra la armadura");
    		}
    		armaduraH = Integer.parseInt(armaduraHeroe.getText());
    	}catch(ExceptionCreacionPersonaje e) {
    		textoBatalla.setText(e.getMessage());
    	}
    	try {
    		if(!matNombre.matches() || tipoHeroe.getValue() == null || !matVida.matches() || !matArmadura.matches()) {
    			throw new ExceptionCreacionPersonaje("Error al añadir el heroe");
    		}
    		textoBatalla.setText(nombreH + " añadido");
    		switch (tipoH) {
    		case "Humano":
    			Humano h = new Humano(nombreH, vidaH, armaduraH);
    			heroes.add(h);
    			heroesOb.add(h);
    			break;
    		case "Elfo":
    			Elfo e = new Elfo(nombreH, vidaH, armaduraH);
    			heroes.add(e);
    			heroesOb.add(e);
    			break;
    		case "Hobbit":
    			Hobbit ht = new Hobbit(nombreH, vidaH, armaduraH);
    			heroes.add(ht);
    			heroesOb.add(ht);
    			break;
    		}
			listaHeroe.setItems(heroesOb);
    	}catch(ExceptionCreacionPersonaje e){
    		System.out.println(e.getMessage());
    	}
    }
    
///////////////Bajar posici�n de una bestia en la lista/////////////////////
    @FXML
    void bajarBestia(ActionEvent event) {
    	try {
    		if(bestiasOb.size()==0) {
    			throw new ExceptionInterfaz("No hay ningún personaje para bajar");
    		}else if((listaBestia.getSelectionModel().getSelectedIndex()+1)<bestiasOb.size()) {
    			Bestia bTemp = bestiasOb.get(listaBestia.getSelectionModel().getSelectedIndex()+1);
        		bestiasOb.set(listaBestia.getSelectionModel().getSelectedIndex()+1, listaBestia.getSelectionModel().getSelectedItem());
        		bestiasOb.set(listaBestia.getSelectionModel().getSelectedIndex(), bTemp);
    		}else {
    			throw new ExceptionInterfaz("No hay más posiciones por abajo");
    		}
    	}catch(ExceptionInterfaz e) {
    		textoBatalla.setText(e.getMessage());
    	}
    }
    
///////////////Bajar posici�n de un heroe en la lista/////////////////////
    @FXML
    void bajarHeroe(ActionEvent event) {
    	try {
    		if(heroesOb.size()==0) {
    			throw new ExceptionInterfaz("No hay ningún personaje para bajar");
    		}else if((listaHeroe.getSelectionModel().getSelectedIndex()+1)<heroesOb.size()) {
    			Heroe hTemp = heroesOb.get(listaHeroe.getSelectionModel().getSelectedIndex()+1);
    			heroesOb.set(listaHeroe.getSelectionModel().getSelectedIndex()+1, listaHeroe.getSelectionModel().getSelectedItem());
    			heroesOb.set(listaHeroe.getSelectionModel().getSelectedIndex(), hTemp);	
    		}else {
    			throw new ExceptionInterfaz("No hay más posiciones por abajo");
    		}
    	}catch(ExceptionInterfaz e) {
    		textoBatalla.setText(e.getMessage());
    	}
    }
    
///////////////Eliminar una bestia de la lista/////////////////////
    @FXML
    void eliminarBestia(ActionEvent event) {
    	try{
    		bestiasOb.remove(listaBestia.getSelectionModel().getSelectedIndex());
    	}catch(Exception e) {
    		textoBatalla.setText("Debe haber algún elemento para poder eliminar");
    	}
    }
    
///////////////Eliminar un heroe de la lista/////////////////////
    @FXML
    void eliminarHeroe(ActionEvent event) {
    	try{
    		heroesOb.remove(listaHeroe.getSelectionModel().getSelectedIndex());
    	}catch(Exception e) {
    		textoBatalla.setText("Debe haber algún elemento para poder eliminar");
    	}
    	
    }

///////////////Subir posici�n de una bestia en la lista/////////////////////
    @FXML
    void subirBestia(ActionEvent event) {
    	try {
    		if(bestiasOb.size()==0) {
    			throw new ExceptionInterfaz("No hay ningún personaje para subir");
    		}else if((listaBestia.getSelectionModel().getSelectedIndex())>0) {
        		Bestia bTemp = bestiasOb.get(listaBestia.getSelectionModel().getSelectedIndex()-1);
        		bestiasOb.set(listaBestia.getSelectionModel().getSelectedIndex()-1, listaBestia.getSelectionModel().getSelectedItem());
        		bestiasOb.set(listaBestia.getSelectionModel().getSelectedIndex(), bTemp);
    		}else {
    			throw new ExceptionInterfaz("El personaje ya se encuentra en la primera posición");
    		}
    	}catch(ExceptionInterfaz e) {
    		textoBatalla.setText(e.getMessage());
    	}
    }

///////////////Subir posici�n de un heroe en la lista/////////////////////
    @FXML
    void subirHeroe(ActionEvent event) {
    	try {
    		if(heroesOb.size()==0) {
    			throw new ExceptionInterfaz("No hay ningún personaje para subir");
    		}else if((listaHeroe.getSelectionModel().getSelectedIndex())>0) {
    			Heroe hTemp = heroesOb.get(listaHeroe.getSelectionModel().getSelectedIndex()-1);
    			heroesOb.set(listaHeroe.getSelectionModel().getSelectedIndex()-1, listaHeroe.getSelectionModel().getSelectedItem());
    			heroesOb.set(listaHeroe.getSelectionModel().getSelectedIndex(), hTemp);
    		}else {
    			throw new ExceptionInterfaz("El personaje ya se encuentra en la primera posición");
    		}
    	}catch(ExceptionInterfaz e) {
    		textoBatalla.setText(e.getMessage());
    	}
    }
///////////////Iniciar el juego/////////////////////
    @FXML
    void Batalla(ActionEvent event) {
    	Batalla.batalla(heroesOb, bestiasOb, textoBatalla);
    }

    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
///////////////A�adir los tipos de personaje a las ChoiceBox/////////////////////
		tipoBestia.getItems().addAll(tBestias);
		tipoHeroe.getItems().addAll(tHeroes);
		
		
		
	}

}
