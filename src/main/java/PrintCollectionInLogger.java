import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.util.*;

public class PrintCollectionInLogger {
    public static final Logger LOG = Logger.getLogger(PrintCollectionInLogger.class);

    public static void main(String[] args) {
        List<WareHouse> wareHouses1 = new ArrayList<>();
        wareHouses1.add(new WareHouse(1, new Date(System.currentTimeMillis() + 9000L)));
        wareHouses1.add(new WareHouse(2, new Date(System.currentTimeMillis() + 6000L)));
        wareHouses1.add(new WareHouse(3, new Date(System.currentTimeMillis() + 3000L)));

        List<WareHouse> wareHouses2 = new ArrayList<>();
        wareHouses2.add(new WareHouse(4, new Date(System.currentTimeMillis() + 200000L)));
        wareHouses2.add(new WareHouse(5, new Date(System.currentTimeMillis() + 15000L)));
        wareHouses2.add(new WareHouse(6, new Date(System.currentTimeMillis() + 12000L)));

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Salo", wareHouses1));
        products.add(new Product(2, "Onion", wareHouses2));

        BasicConfigurator.configure();
//        LOG.info(String.format("print log %s", products));
        System.out.println("check " + products.size());
        System.out.println("check " + products.get(0));
        System.out.println("check " + products.get(1));
        System.out.println("check " + products.get(2));

        for (Product p : products) {
            Collections.sort(p.getWareHouses(), Comparator.comparing(WareHouse::getCreateDate));
        }
        for (Product p : products) {
//    LOG.info(S);
        }
        LOG.info(String.format("print log %s", Arrays.toString(products.toArray())));

    }


}
