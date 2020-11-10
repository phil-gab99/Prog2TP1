package actions;

/**
* @author Philippe Gabriel
* @version 1.0.1 2020-11-12
*
* The interface ManageBalance offers the necessary methods for managing a
* user's balance
***/

public interface ManageBalance {

    /**
    * The methods addBalance and deductBalance add or deduct a given amount
    * to or from the user's balance
    *
    * @param amount Integer indicating the amount to add/deduct to/from the
    * user's balance
    ***/

    void addBalance(int amount);
    void deductBalance(int amount);
}