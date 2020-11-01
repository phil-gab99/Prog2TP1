public class Person {
    String lastName;
    String firstName;
    String email;
    String birth;
    String position;


    public Person(String lastName, String firstName, String email, String birth, String position) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.birth = birth;
        this.position = position;
    }

    //Creating email for each person. It is composed of lastName + firstName + a digit (until
    //a unique email is created).
    public String emailCreater(String lastName, String firstName) {
        int counter = 0;


        email = lastName + firstName + counter + "@magasin.ca";

        while(emailExist(email)) {
            counter++;

            //If the email already exists, we increase the counter
            //and remove the digit + @magasin.ca part to replace the digit
            email = email.substring(0,email.length()-12);
            email += counter + "@magasin.ca";
        }
    }



}
