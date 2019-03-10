package hh.swd20.bookstoremavenproject.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.bookstoremavenproject.domain.Book;
import hh.swd20.bookstoremavenproject.domain.BookRepository;
import hh.swd20.bookstoremavenproject.domain.GenreRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository brepository;
	
	@Autowired
	private GenreRepository grepository;
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/booklist", method=RequestMethod.GET)
	public String bookList(Model model) {
		model.addAttribute("books", brepository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest(){
		return (List<Book>) brepository.findAll();
	}
	
	@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId){
		return brepository.findById(bookId);
	}
	
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("genre", grepository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveBook(Book book) {
		brepository.save(book);
		return "redirect:booklist";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		brepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", brepository.findById(bookId));
		model.addAttribute("genre", grepository.findAll());
		return "editbook";
	}
}
