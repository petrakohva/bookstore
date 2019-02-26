package hh.swd20.bookstoremavenproject.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity 
public class Genre {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long genreid;
	private String genreName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	private List<Book> books;
	
	public Genre() {
		
	}
	
	public Genre(String genreName) {
		super();
		this.genreName = genreName;
	}
	
	
	
	

	public void setGenreid(Long genreid) {
		this.genreid = genreid;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	

	public Long getGenreid() {
		return genreid;
	}

	public String getGenreName() {
		return genreName;
	}

	public List<Book> getBooks() {
		return books;
	}

	@Override
	public String toString() {
		return "Genre [genreid=" + genreid + ", genre=" + genreName + "]";
	}
	
	
	
	
	
	

}
