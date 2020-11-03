/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.0 2020-11-12
*
* The interface AddBalance
**/

public interface AddBalance {

    default void addBalance(int amount) {
        this.balance += amount;
    }
}