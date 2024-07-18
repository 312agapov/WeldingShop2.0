package mazdarunner.weldingMagazine.Weld;

public class Weld {
    private String name;
    private int price;
    private int maxPower;

    public Weld() {

    }

    public Weld(String name, int price, int maxPower) {
        this.name = name;
        this.price = price;
        this.maxPower = maxPower;
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
                "name='" + name + '\'' +
                ", price=" + price +
                ", maxPower=" + maxPower +
                '}';
    }
}
