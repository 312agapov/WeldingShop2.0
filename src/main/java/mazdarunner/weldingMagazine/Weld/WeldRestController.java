package mazdarunner.weldingMagazine.Weld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/weld")
public class WeldRestController {

    private final WeldService weldService;

    @Autowired
    public WeldRestController(WeldService weldService) { //зачем чел создал конструктор?
        this.weldService = weldService;
    }


    @GetMapping
    public List<Weld> showAllWelds(){
        return weldService.showAllWelds();
    }

    @GetMapping(path = "/{id}")
    public Weld showWeld(@PathVariable("id") UUID id){
        return weldService.showWeld(id);
    }

    @PostMapping
    public void addWeld(@RequestBody Weld weld){
        weldService.addWeld(weld);
    }

    @DeleteMapping(path = "/{weldId}")
    public void deleteWeldByID(@PathVariable("weldId") UUID weldId){
        weldService.deleteWeldByID(weldId);
    }

    @PutMapping
    public void editWeldByID(@RequestBody Weld weld){
        weldService.addWeld(weld);
    }

}
