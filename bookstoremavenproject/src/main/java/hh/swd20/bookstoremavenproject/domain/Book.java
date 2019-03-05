package hh.swd20.bookstoremavenproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String author;
	private int year;
	private String isbn;
	private double price;
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "genreid")
	private Genre genre;
		
	
	public Book() {
	
		
	}
	
	public Book(String title, String author, int year, String isbn, double price, Genre genre) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.genre = genre;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	
	
	
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return year;
	}

	public String getIsbn() {
		return isbn;
	}

	public double getPrice() {
		return price;
	}
	
	public Genre getGenre() {
		return genre;
	}

	
	
	@Override
	public String toString() {
		if(this.genre != null)
			return "Book [title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price + " genre =" + this.getGenre() + "]";
		else
			return "Book [title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price + "]";
	}
	
	
	
	
}
