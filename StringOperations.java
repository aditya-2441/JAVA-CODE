import java.util.ArrayList;
import java.util.Scanner;
public class StringOperations {
private ArrayList<String> stringList;
public StringOperations() {
stringList = new ArrayList<>();
}
// a. Append - add at end
public void append(String str) {
stringList.add(str);
System.out.println(str + " appended successfully.");
}
// b. Insert – add at particular index
public void insert(int index, String str) {
if (index >= 0 && index <= stringList.size()) {
stringList.add(index, str);
System.out.println(str + " inserted at index " + index);
} else {
System.out.println("Invalid index!");
}
}
// c. Search
public void search(String str) {
if (stringList.contains(str)) {
System.out.println(str + " found at index " + stringList.indexOf(str));
} else {
System.out.println(str + " not found in list.");
}
}
// d. List all strings starting with given letter
public void listStartsWith(char letter) {
System.out.println("Strings starting with '" + letter + "':");
boolean found = false;
for (String s : stringList) {
if (s.toLowerCase().startsWith(String.valueOf(letter).toLowerCase())) {
System.out.println(s);
found = true;
}
if (!found) {
    System.out.println("No strings found starting with '" + letter + "'");
}}
}
// Display all elements
public void display() {
System.out.println("Current List: " + stringList);
}
// Main method with menu
public static void main(String[] args) {
StringOperations ops = new StringOperations();
Scanner sc = new Scanner(System.in);
while (true) {
System.out.println("\n--- String Operations Menu ---");
System.out.println("1. Append");
System.out.println("2. Insert at index");
System.out.println("3. Search");
System.out.println("4. List strings starting with letter");
System.out.println("5. Display all");
System.out.println("6. Exit");
System.out.print("Enter your choice: ");
int choice = sc.nextInt();
sc.nextLine(); // consume newline
switch (choice) {
case 1:
System.out.print("Enter string to append: ");
ops.append(sc.nextLine());
break;
case 2:
System.out.print("Enter index: ");
int index = sc.nextInt();
sc.nextLine();
System.out.print("Enter string to insert: ");
ops.insert(index, sc.nextLine());
break;
case 3:
System.out.print("Enter string to search: ");
ops.search(sc.nextLine());
break;
case 4:
System.out.print("Enter starting letter: ");
char letter = sc.next().charAt(0);
ops.listStartsWith(letter);
break;
case 5:
ops.display();
break;
case 6:
System.out.println("Exiting program...");
sc.close();
System.exit(0);
default:
System.out.println("Invalid choice! Try again.");
}
}
}}