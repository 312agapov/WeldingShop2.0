package mazdarunner.weldingMagazine.repository;

import mazdarunner.weldingMagazine.entity.Weld;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WeldRepository extends JpaRepository<Weld, UUID> {


}
