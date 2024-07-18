package mazdarunner.weldingMagazine.Weld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/weld")
public class WeldController {

    private WeldService weldService = new WeldService();

    @Autowired
    public WeldController(WeldService weldService) { //зачем чел создал конструктор?
        this.weldService = weldService;
    }

    @GetMapping("/showinfo")
    public Weld showInfo(){
        return weldService.showInfo();
    }
}
