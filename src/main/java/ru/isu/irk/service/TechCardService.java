
package ru.isu.irk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isu.irk.model.TechCard;
import ru.isu.irk.repository.TechCardRepository;

@Service
public class TechCardService {
    
    private TechCardRepository techCardRepository;

    @Autowired
    public TechCardService(TechCardRepository techCardRepository) {
        this.techCardRepository = techCardRepository;
    }

    public TechCard getById(int id){
        return techCardRepository.findById(id);
    }


    @Transactional
    public void save(TechCard techCard) {
        techCardRepository.save(techCard);
    }

}




/*public class TechCardService {
    
    //@Autowired
    private BookRepository repo;
    
    @Autowired
    public TechCardService(BookRepository repo) {
        this.repo = repo;
    }    
    
    public Book getById(Integer bookId){
        if(bookId<10){
            throw new BookNotFoundException(
                    "Book with id "+bookId +" no found");
        }
        Book b = new Book();
        b.setId(bookId);
        b.setTitle("Sample book");
        return b;
    }
    
    @Transactional
    public void save(Book book){
        repo.save(book);
    }
    
    public Book findById(Integer id){
        return repo.findById(id)
            .orElseThrow(
            () -> new BookNotFoundException(
                    "Book with id "+id +" no found"));
    } 
}*/
