// User-defined exception class
class InvalidAgeException extends Exception {
public InvalidAgeException(String message) {
super(message);
}
}
public class UserDefinedException {
// Method that throws a user-defined exception
public static void checkAge(int age) throws InvalidAgeException {
if (age < 18) {
throw new InvalidAgeException("Age must be 18 or above to vote.");
} else {
System.out.println("You are eligible to vote.");
}
}
public static void main(String[] args) {
try {
// Example 1: age below 18
checkAge(15);
// Example 2: valid age
checkAge(20);
} catch (InvalidAgeException e) {
System.out.println("Exception caught: " + e.getMessage());
} finally {
System.out.println("Program finished.");
}
}
}