import inventory.Food;
import inventory.Furniture;
import inventory.Product;
import store.*;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.0 2020-11-12
*
* The class Main is mainly used for testing for now
**/

public class Main {

    public static void main(String[] args) {
        Client c1 = new Client("Zelric", "Jayajay", "01/23/1999");
        Client c2 = new Client("Zelric", "Jayajay", "12/34/5222");
        Manager m1 = new Manager("Boumghar", "Karim", "22/03/2020");
        Manager m2 = new Manager("Boumghar", "Karim", "22/03/2020");
        Furniture f1 = new Furniture("BoumgharKarim", "Bombe", 10, 152);
        Product p1 = new Product("Boumghar Karim");
        Food f2 = new Food("BoumgharKarim", "pomme", "rouge", 152);
        Base.products.add(f1);
        Base.products.add(p1);
        Base.products.add(f2);
        Base.products.remove(f2);
        System.out.println(Base.products.get(2).toString());
        /*
        System.out.println(c1.getEmail());
        System.out.println(c2.getEmail());
        System.out.println(m1.getEmail());
        System.out.println(m2.getEmail());
        System.out.println(Base.accounts.get(0).getBalance());
        c1.addBalance(3000);
        System.out.println(Base.accounts.get(0).getBalance());
        */

    }
}