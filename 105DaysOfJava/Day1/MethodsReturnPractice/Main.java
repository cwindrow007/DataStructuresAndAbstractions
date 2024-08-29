//Basic program to practice calling other classes and  methods within Java. User Class is a "blueprint"

public class Main {

    public static void main(String[] args) {
        User user = new User(); //Creates object named user pulling from user class
        user.firstName = "John"; //sets user first name variable to John in User class
        user.lastName = "Doe";

        String message = user.output(); //Calls Output Method which is named string
        System.out.println(message); //outputs String

        /*
        OUTPUT:

        Hi my name is John Doe.


         */

    }
}
