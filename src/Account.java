/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.1 2020-11-12
*
* The class Account
**/

//todo : Give program specification
//todo : Begin

public abstract class Account {

    private int balance; //Balance associated with the account

    // public Account() {
    // }

    public void addBalance(int amount) {
        this.balance += amount;
    }
    //
    // public void removeBalance(int amount) {
    //
    // }

    public int getBalance() {
        return balance;
    }
}