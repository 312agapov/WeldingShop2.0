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

    public Weld showWeld(UUID id){
        return weldRepository.findById(id).orElseThrow(() -> new IllegalStateException("Сварочный аппарат с ID " + id + " не найден"));
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

}
