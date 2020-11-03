/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.1 2020-11-12
*
* The class Manager
**/

public class Manager extends Account implements AddBalance, DeductBalance,
    ManageProducts {

    public Manager(String lastName, String firstName, String birth) {
        super(lastName, firstName, birth, 2);
    }

    public void addBalance(int amount) {
        this.setBalance(this.getBalance() + amount);
    }

    public void deductBalance(int amount) {
        this.setBalance(this.getBalance() - amount);
    }
}