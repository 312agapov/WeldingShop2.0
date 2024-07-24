package mazdarunner.weldingMagazine.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "weldings")
@Getter
@Setter
@ToString
public class Weld {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private int price;
    private int maxPower;

}
