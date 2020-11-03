/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.5.0 2020-11-12
*
* The class Account
**/

//todo : Give program specification
//todo : Begin

public abstract class Account implements FavoriteProducts {

    private int balance;  //Balance associated with the account
    private String email; //Email to be generated for the different accounts

    private String lastName;
    private String firstName;
    private String birth;
    private int position;

    /*
    * The Account constructor serves to assign the common existing traits
    * with regards to the different account types
    *
    * @param lastName String indicating individual's last name
    * @param firstName String indicating individual's first name
    * @param birth String indicating individual's date of birth following the
    * format: dd/mm/yyyy
    * @param position Integer indicating individual's position within the store
    * 0 indicates client type, 1 employee type, 2 manager type
    **/

    public Account(String lastName, String firstName, String birth,
    int position) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.birth = birth;
        this.position = position;

        this.email = generateEmail();

        Base.addAccount(this);
    }

    /*
    * The generateEmail method creates an email associated with the
    * corresponding account. This method ensures that no duplicate emails are
    * generated and follows a general format of : lastNamefirstName@magasin.ca
    *
    * @return validEmail String representing the email associated with a user
    **/

    public String generateEmail() {

        int count = Base.emailExist(lastName, firstName);

        String validEmail = lastName + firstName + count + "@magasin.ca";

        return validEmail;
    }

    /*
    * The getter method getBalance gives access to a user's balance
    **/

    public int getBalance() {
        return balance;
    }

    /*
    * The getter method getEmail gives access to a user's email
    **/

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    /*
    * The setter method setBalance allows modifying of a user's balance
    **/

    public void setBalance(int balance) {

        this.balance = balance;
    }
}