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
        Client c2 = new Client("Last", "First", "12345");
        System.out.println(c1.getEmail());
        System.out.println(c2.getEmail());
    }
}