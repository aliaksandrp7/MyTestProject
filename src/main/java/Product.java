import java.util.Date;
import java.util.List;

public class Product {
    int id;
    String name;
    List<WareHouse> wareHouses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WareHouse> getWareHouses() {
        return wareHouses;
    }

    public void setWareHouses(List<WareHouse> wareHouses) {
        this.wareHouses = wareHouses;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wareHouses=" + wareHouses +
                '}';
    }

    public Product(int id, String name, List<WareHouse> wareHouses) {
        this.id = id;
        this.name = name;
        this.wareHouses = wareHouses;
    }
}
