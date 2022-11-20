package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Usuario {
	
	private SimpleStringProperty nombre;
    private SimpleIntegerProperty edad;
    private SimpleStringProperty nacionalidad;
    
    //	CONSTRUCTOR DE LA CLASE USUARIO
    public Usuario(String nombre, int edad, String nacionalidad) {
        this.nombre = new SimpleStringProperty(nombre);
        this.edad = new SimpleIntegerProperty(edad);
        this.nacionalidad = new SimpleStringProperty(nacionalidad);
    }
        
    public String getNombre() {
		return nombre.get();
	}

	public void setNombre(String nombre) {
		this.nombre = new SimpleStringProperty(nombre); 
	}

	public int getEdad() {
		return edad.get();
	}

	public void setEdad(int edad) {
		this.edad = new SimpleIntegerProperty(edad);
	}
	
	public String getNacionalidad() {
		return nacionalidad.get();
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = new SimpleStringProperty(nacionalidad); 
	}

}