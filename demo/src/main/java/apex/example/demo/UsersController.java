package apex.example.demo;
import apex.example.demo.Users;
import apex.example.demo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class UsersController {
    private UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }
    @PostMapping(path="/add/{username}/{password}/{email}/{zipcode}/{type}") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@PathVariable String username, @PathVariable String password
            , @PathVariable String email, @PathVariable String zipcode, @PathVariable String type) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Users n = new Users();
        n.setUsername(username);
        n.setEmail(email);
        n.setPassword(password);
        n.setZipcode(zipcode);
        n.setType(type);
        usersRepository.save(n);
        return "Saved";
    }
   /* @GetMapping(value="/all")
    public @ResponseBody
    Iterable<Users> getAllUsers() {
        return usersRepository.findAll();
    }*/
   @RequestMapping("/")
   public ModelAndView welcome(){
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName("/index.html");
       return modelAndView;
   }
    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login.html");
        return modelAndView;
    }
}
