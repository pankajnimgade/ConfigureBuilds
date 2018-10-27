package configure.test.configurebuilds.ui.activities.test101;

public class User {

    public int id;
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String emailAddress;
    public String physicalAddress;
    public String zipCode;
    public String state;

    public static User getInstance() {
        User user = new User();
        user.id = 10;
        user.firstName = "John";
        user.lastName = "Smith";
        user.phoneNumber = "124578544";
        user.emailAddress = "some@gmail.com";
        user.physicalAddress = "12 st AP, new lane";
        user.zipCode = "1242";
        user.state = "TX";
        return user;
    }
}
