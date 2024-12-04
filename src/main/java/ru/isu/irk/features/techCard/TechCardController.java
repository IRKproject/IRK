
package ru.isu.irk.features.techCard;

// import jakarta.validation.Valid;
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.isu.irk.features.instrument.*;
// import ru.isu.irk.model.TechCard;
// import ru.isu.irk.service.TechCardService;

@Controller
@RequestMapping("/techcard")
public class TechCardController {
    
    private TechCardService techCardService;

    @Autowired
    public TechCardController(TechCardService techCardService) {
        this.techCardService = techCardService;
    } 

    @GetMapping("/get/{id}")
    @ResponseBody
    public TechCard getTechCard(@PathVariable("id") int id){
        return techCardService.getById(id);
    }

    @PostMapping("/add")
    public String addTechCard(@RequestBody TechCard techCard){
        techCardService.save(techCard);
        return "TechCard added successfully";
    }

    @PostMapping("/addInstrument/{techCardId}")
    public String addInstrumentToTechCard(@PathVariable("techCardId") int techCardId, @RequestBody Instrument instrument){
        TechCard techCard = techCardService.getById(techCardId);
        //techCard.addInstrument(instrument);
        techCardService.save(techCard);
        return "Instrument added to TechCard successfully";
    }

    @PostMapping("/save")
    public String saveTechCard(
            @Validated @ModelAttribute("techCard") TechCard techCard,
            Errors errors, Model model){
        if(errors.hasErrors()){
            System.out.println(errors.getFieldErrors());
            return "techCard/addTechCard";
        }
        techCardService.save(techCard);
        System.out.println(techCard);
        return "redirect:/";        
    }

}

/*public class TechCardController {
    
    private BookService bookService;

    @Autowired
    public TechCardController(BookService bookService) {
        this.bookService = bookService;
    } 
    
    
    @ModelAttribute("coverTypes")
    public Map<String, String> getCoverTypes(){
        Map<String, String> res = new HashMap<>();
        res.put("hard", "Hard cover");
        res.put("soft", "Soft cover");
        res.put("ebook", "Ebook version");
        return res;
    }
    
    @ModelAttribute("bookGenres")
    public List<String> getBookGenres(){
        return Arrays.asList("Adventure", "Tech", "SciFi");        
    }
    
    @GetMapping("/add")
    public String addBook(Model model){
        Book b = new Book();
        b.setTitle("new book");
        b.setPages(123);
        model.addAttribute("book", b);
        return "addBook";
    }
    
    @PostMapping("/save")
    public String saveBook(
            @Valid @ModelAttribute("book") Book b,
            Errors errors, Model model){
        if(errors.hasErrors()){
            System.out.println(errors.getFieldErrors());
            return "addBook";
        }
        bookService.save(b);
        System.out.println(b);
        return "redirect:/";        
    }
    
    @GetMapping("/get/{bookId}")
    @ResponseBody
    public Book getBook(@PathVariable("bookId") Book b){
        return b;
    }    
}*/
