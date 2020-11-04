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
        System.out.println(c1.getEmail());
        System.out.println(c2.getEmail());
        System.out.println(Base.accounts.get(0).getBalance());
        c1.addBalance(3000);
        System.out.println(Base.accounts.get(0).getBalance());
    }
}