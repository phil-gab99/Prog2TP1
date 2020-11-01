/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.0 2020-11-12
*
* The class Main is mainly used for testing for now
**/

public class Main {

    public static void main(String[] args) {
        Client c1 = new Client();
        Employee e1 = new Employee();

        System.out.println(c1.getBalance());
        System.out.println(e1.getBalance());

        c1.addBalance(30);

        System.out.println(c1.getBalance());
        System.out.println(e1.getBalance());
    }
}