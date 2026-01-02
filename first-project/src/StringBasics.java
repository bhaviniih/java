public class StringBasics{
    public static void main(String[] args) {

        String name = "Dev";
        String role = "Developer";

        System.out.println("Name: " + name);
        System.out.println("Role: " + role);

        System.out.println("Name length: " + name.length());
        System.out.println("Uppercase: " + name.toUpperCase());

        if (role.equals("Developer")){
            System.out.println("Access granted");
        }

        if (role == "Developer"){
            System.out.println("Access granted for ==");
        }

    }
}