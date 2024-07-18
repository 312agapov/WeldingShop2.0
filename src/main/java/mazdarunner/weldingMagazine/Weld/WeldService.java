package mazdarunner.weldingMagazine.Weld;

import org.springframework.stereotype.Service;

@Service
public class WeldService {

    public Weld showInfo(){
        return new Weld("ТОРУС", 12000, 200);
    }
}
