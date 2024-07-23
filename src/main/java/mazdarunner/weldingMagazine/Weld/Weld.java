package mazdarunner.weldingMagazine.Weld;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "weldings")
public class Weld {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private int price;
    private int maxPower;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }

    @Override
    public String toString() {
        return "Weld{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", maxPower=" + maxPower +
                '}';
    }
}
