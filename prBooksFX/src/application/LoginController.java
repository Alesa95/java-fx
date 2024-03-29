package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import application.models.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.PasswordField;

public class LoginController {
	@FXML
	private TextField txtNombre;
	@FXML
	private PasswordField txtContrasena;
	@FXML
	private Button btnEntrar;
	@FXML
	private ImageView img;
	
	private String correctUser = "Alejandra";
	private String correctPassword = "123";
	
	//	Creamos una variable para poder llamar a los m�todos del Main de la aplicaci�n
	Main main;
	BorderPane rootLayout;

	// Event Listener on Button[#btnEntrar].onAction
	@FXML
	public void login(ActionEvent event) throws IOException {
		// TODO Autogenerated
		if (txtNombre.getText().equals(correctUser) && txtContrasena.getText().equals(correctPassword)) {
			
			/**
			 * 	Los pasos que seguimos a continuaci�n nos permiten tener un layout base
			 * 	que podemos usar como "plantilla" para cada p�gina. Es decir, inicializaremos
			 * 	la p�gina que queramos mostrar sobre el layout, de forma que se muestre al 
			 * 	mismo tiempo la p�gina que queremos ver y el contenido del layout.
			 * 	
			 * 	De esta forma podemos usar "plantillas" reutilizables con los elementos que
			 * 	tengan en com�n varias p�ginas. En este caso, podemos querer que la barra 
			 * 	de men� se encuentre en varias p�ginas, por lo que no ser�a muy eficiente
			 * 	crearla en cada p�gina.
			 * 	
			 * 	En su lugar, la creamos en el layout y aplicamos dicho layout a todas las 
			 *	p�ginas donde queramos que aparezca el men�.
			 */
			
			// Cargamos RootLayout (el layout que usaremos de plantilla)
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Mostramos el RootLayout
            Scene scene = new Scene(rootLayout);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
            // Cargamos BooksIndex y lo mostramos sobre RootLayout
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(Main.class.getResource("views/BooksIndex.fxml"));
            BorderPane booksIndex = (BorderPane) loader2.load();
            
            //	Cargamos los libros
            BooksIndexController controller = loader2.getController();
	        controller.setLoginController(this);
            
            //	Colocamos BooksIndex en el centro de RootLayout
            rootLayout.setCenter(booksIndex);
            
            
        //	En este IF entraremos si no se introduce el nombre o la contrase�a
		} else if (txtNombre.getText().isEmpty() || txtContrasena.getText().isEmpty()) {
			
			/*
			 *	Alert nos permite crear cuadros de di�logo emergentes. Consulta
			 *	https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Alert.html
			 *	para m�s informaci�n sobre los cuadros de di�logo
			 */
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Aviso");
			alert.setHeaderText("No has introducido todos tus datos");
			alert.setContentText("Por favor, introduce tanto tu usuario como tu contrase�a.");

			alert.showAndWait();
			
			
		//	En este IF entraremos si el nombre o la contrase�a se introducen mal
		} else {
			/*
			 *	Los tipos de Alertas son: CONFIRMATION, INFORMATION, ERROR, WARNING
			 *	
			 *	Cada tipo muestra un icono diferente que da una pista al usuario
			 *	del motivo de la alerta
			 */
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Aviso");
			alert.setHeaderText("La contrase�a o el usuario son incorrectos");
			alert.setContentText("Si no recuerdas tu contrase�a contacta con el soporte.");

			alert.showAndWait();
		}
	}
	
	/*
	 *	Creamos la ObservableList que contendr� los libros que mostraremos.
	 *	
	 *	En este caso la creamos en el login puesto que esta ser� la p�gina 
	 *	desde la que accedamos al contenido de la aplicaci�n. Si no hubiera
	 *	un login, la crear�amos en el main. 
	 */
	private ObservableList<Book> books = FXCollections.observableArrayList();
    
    public LoginController () {
    	books.add(new Book(1, "Juego de Tronos","George R.R. Martin"));
    	books.add(new Book(2, "El Se�or de los Anillos", "J.R.R. Tolkien"));
	}
    
	public ObservableList<Book> getBooks () {
		return books;
	}
}
