package application;
	
import java.io.IOException;

import application.models.Book;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private Stage primaryStage;
    private BorderPane rootLayout;
    
    /**
     *	Este método es el que se ejecuta en primer lugar cuando le damos al 
     *	"play" y lanzamos la aplicación
     */
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("My Books");
	        
	        /*
	         *	Para simplificar el programa, se ha creado un método showLogin
	         *	que carga la pantalla del login, en lugar de hacerlo todo en 
	         *	este mismo método, de forma que el código quede más claro
	         */
	        showLogin();
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Inicializa la pantalla de login
	 */
	public void showLogin() {
		try {
			//	Cargamos el fichero Login.fxml
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("views/Login.fxml"));
	        rootLayout = (BorderPane) loader.load();
	        
	        //	Creamos la escena que contiene Login.fxml y la mostramos
	        Scene scene = new Scene(rootLayout);
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
	    
	public static void main(String[] args) {
		launch(args);
	}
}
