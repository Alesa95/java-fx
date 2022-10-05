package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.models.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class BooksIndexController {
	@FXML
	private TableView <Book> tableBooks;
	@FXML
	private TableColumn <Book, Integer> id;
	@FXML
	private TableColumn <Book, String> title;
	@FXML
	private TableColumn <Book, String> author;
	
	LoginController loginController;
	
	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
		//tableBooks.setItems(loginController.getBooks());
	}
		
	@FXML
    private void initialize() {
		
		DatabaseConnection dbConnection = new DatabaseConnection();
		Connection connection = dbConnection.getConnection();
		
		ObservableList<Book> bookList = FXCollections.observableArrayList();
	
		String query = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			query = "select * from books";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				bookList.add(new Book(
						resultSet.getInt("id"),
						resultSet.getString("title"),
						resultSet.getString("author")
				));
			}
			tableBooks.setItems(bookList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		title.setCellValueFactory(new PropertyValueFactory<>("title"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
    }

}
