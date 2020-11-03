/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.0 2020-11-12
*
* The class Main is mainly used for testing for now
**/

public class Main {

    public static void main(String[] args) {
        Client c1 = new Client("Last", "First", "123");
        c1.addBalance(3000);

        System.out.println(c1.getBalance());
    }
}