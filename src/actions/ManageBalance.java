package actions;

/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.0 2020-11-12
*
* The interface ManageBalance
**/

public interface ManageBalance {

    /*
    * The methods addBalance and deductBalance adds or deducts a given amount
    * to the user's balance
    *
    * @param amount Integer indicating the amount to add/deduct to the user's
    * balance
    **/

    void addBalance(int amount);
    void deductBalance(int amount);
}