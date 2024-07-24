package mazdarunner.weldingMagazine.service;

import mazdarunner.weldingMagazine.entity.Weld;
import mazdarunner.weldingMagazine.repository.WeldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WeldService {

    @Autowired
    private WeldRepository weldRepository;

    public List<Weld> showAllWelds(){
        return weldRepository.findAll();
    }

    public Weld showWeld(UUID id){
        return weldRepository.findById(id).orElseThrow(() -> new IllegalStateException("Сварочный аппарат с ID " + id + " не найден"));
    }

    public void addWeld(Weld weld){
        if(weld.getName().isEmpty() || weld.getPrice() == 0 || weld.getMaxPower() == 0){
            throw new IllegalStateException("Одно из введенных полей пустое!");
        } else {
            weldRepository.save(weld);
        }
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
