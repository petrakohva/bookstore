package hh.swd20.bookstoremavenproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstoremavenproject.domain.Book;

@Controller
public class BookController {

	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String addBook(Model model) {
		
		Book book = new Book();
		model.addAttribute("books", book);
		return "showbooks";
	}
}
