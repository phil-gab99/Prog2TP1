/*
* @Karim Boumghar
* @Philippe Gabriel
* @Version 1.2.2 2020-11-12
*
* The class Person
**/

public class Person {

    private String lastName;
    private String firstName;
    private String email;
    private String birth;
    private String position;


    /*
    * The Person constructor
    *
    *
    **/

    public Person(String lastName, String firstName, String birth,
        String position) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.email = generateEmail();
        this.birth = birth;
        this.position = position;
    }

    /*
    * This constructor is used for test purposes to avoid including parameters
    **/

    public Person() {

    }

    /*
    * The generateEmail method creates an email associated with the
    * corresponding account. This method ensures that no duplicate emails are
    * generated and follows a general format of : lastNamefirstName@magasin.ca
    *
    * @return validEmail String representing the email associated with a user
    **/

    public String generateEmail() {

        int count = 0;

        String validEmail = lastName + firstName + count;

        //This is a long method for generating an email in worst case scenario
        //Would recommend to instead make a search of all emails with the same
            //lastName and firstName, extract the numbers using UTF-8 encoding
            //conditions and create the email afterwards
        while(emailExist(email)) {

            count ++;
            validEmail = validEmail.substring(0,validEmail.length() - 1) + count;
        }

        return validEmail + "@magasin.ca";
    }
}