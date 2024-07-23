package mazdarunner.weldingMagazine.Weld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WeldController {
    @GetMapping("/")
    public String weldings(){
        return "index";
    }
}
