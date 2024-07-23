package mazdarunner.weldingMagazine.Weld;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class WeldService {

    private final WeldRepository weldRepository;

    @Autowired
    public WeldService(WeldRepository weldRepository) {
        this.weldRepository = weldRepository;
    }

    public List<Weld> showAllWelds(){
        return weldRepository.findAll();
    }

    public void addWeld(Weld weld){
        weldRepository.save(weld);
    }

    public void deleteWeldByID(UUID weldId){
        boolean exists = weldRepository.existsById(weldId);
        if (exists){
            weldRepository.deleteById(weldId);
        } else {
            System.out.println("No such welding in database!");
        }
    }

    @Transactional
    public void updateWeldByID(UUID weldId, String name, Integer price, Integer maxPower){
        Weld weld = weldRepository.findById(weldId).orElseThrow(() -> new IllegalStateException("Сварочный аппарат с ID " + weldId + " не найден"));

        if (name != null && !Objects.equals(weld.getName(),name)){
            weld.setName(name);
        }
        if (price != null && price != weld.getPrice()){
            weld.setPrice(price);
        }
        if (maxPower != null && maxPower != weld.getMaxPower()){
            weld.setMaxPower(maxPower);
        }
    }

}
