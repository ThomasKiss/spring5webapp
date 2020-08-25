package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

	Publisher testPublisher = new Publisher("test", "test", 12345, "test", "test");
	
	publisherRepository.save(testPublisher);
	
	
        Author test = new Author("test", "test");
        Book ddd = new Book("testname", "isbn");
        test.getBooks().add(ddd);
        ddd.getAuthors().add(test);

        testPublisher.getBooks().add(ddd);
        ddd.setPublisher(testPublisher);
        
        authorRepository.save(test);
        bookRepository.save(ddd);
        publisherRepository.save(testPublisher);

        System.out.println("Startet in Bootstrap");
        System.out.println(authorRepository.count());

    }
}
