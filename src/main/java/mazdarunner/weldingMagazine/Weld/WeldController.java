package mazdarunner.weldingMagazine.Weld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/weld")
public class WeldController {

    private final WeldService weldService;

    @Autowired
    public WeldController(WeldService weldService) { //зачем чел создал конструктор?
        this.weldService = weldService;
    }

    @GetMapping("/showallwelds")
    public List<Weld> showAllWelds(){
        return weldService.showAllWelds();
    }

    @PostMapping("/addweld")
    public void addWeld(@RequestBody Weld weld){
        weldService.addWeld(weld);
    }

    @DeleteMapping(path = "/delete/{weldId}")
    public void deleteWeldByID(@PathVariable("weldId") UUID weldId){
        weldService.deleteWeldByID(weldId);
    }

    @PutMapping(path = "/edit/{weldId}")
    public void editWeldByID(@PathVariable("weldId") UUID weldId,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) Integer price,
                             @RequestParam(required = false) Integer maxPower){
        weldService.updateWeldByID(weldId, name, price, maxPower);
    }

}
