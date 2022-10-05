package application.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
	
	private SimpleIntegerProperty id;
	private SimpleStringProperty title;
    private SimpleStringProperty author;
    
    
    //	Constructor de la clase libro
    
    public Book(int id, String title, String author) {
    	this.id = new SimpleIntegerProperty(id);
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
    }
       
    //	Getters y setters
    
    public int getId() {
		return id.get();
	}

	public void setTitle(int id) {
		this.id = new SimpleIntegerProperty(id); 
	}
    
    public String getTitle() {
		return title.get();
	}

	public void setTitle(String title) {
		this.title = new SimpleStringProperty(title); 
	}

	public String getAuthor() {
		return author.get();
	}

	public void setAuthor(String author) {
		this.author = new SimpleStringProperty(author);
	}

}
