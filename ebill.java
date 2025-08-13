import java.util.Scanner;
public class ebill 
{
  private int consumerNo;
  private String consumerName;
  private double previousReading;
  private double currentReading;
  private String connectionType;

  public ebill(int consumerNo, String consumerName, double previousReading, double currentReading, String connectionType) 
  {
    this.consumerNo = consumerNo;
    this.consumerName = consumerName;
    this.previousReading = previousReading;
    this.currentReading = currentReading;
    this.connectionType = connectionType;
  }

  public double calculateBill() 
  {
    double unitsConsumed = currentReading - previousReading;
    double amount = 0;
    if (unitsConsumed <= 0) 
    {
      System.out.println("Invalid readings. Current reading must be greater than previous reading.");
      return 0;
    }
  
    if (connectionType.equalsIgnoreCase("domestic")) 
    {
      if (unitsConsumed <= 100) 
      {
        amount = unitsConsumed * 1;
      } 
      else if (unitsConsumed <= 200) 
      {
        amount = 100 * 1 + (unitsConsumed - 100) * 2.50;
      } 
      else if (unitsConsumed <= 500)  
      {
        amount = 100 * 1 + 100 * 2.50 + (unitsConsumed - 200) * 4;
      } 
      else 
      {
        amount = 100 * 1 + 100 * 2.50 + 300 * 4 + (unitsConsumed - 500) * 6;
      }
    } 
    else if (connectionType.equalsIgnoreCase("commercial")) 
    {
      if (unitsConsumed <= 100) 
      {
        amount = unitsConsumed * 2;
      } 
      else if (unitsConsumed <= 200) 
      {
        amount = 100 * 2 + (unitsConsumed - 100) * 4.50;
      } 
      else if (unitsConsumed <= 500) 
      {
        amount = 100 * 2 + 100 * 4.50 + (unitsConsumed - 200) * 6;
      }  
      else 
      {
        amount = 100 * 2 + 100 * 4.50 + 300 * 6 + (unitsConsumed - 500) * 7;
      }
      System.out.println("Invalid connection type.");
      return 0;
    }
    return amount;
  }

  public void displayBill() 
  {
    System.out.println("\nElectricity Bill");
    System.out.println("Consumer Number:"+ consumerNo);
    System.out.println("Consumer Name:"+ consumerName);
    System.out.println("Connection Type:"+ connectionType);
    System.out.printf("Units Consumed: %.2f%n", (currentReading - previousReading));
    System.out.printf("Total Amount : Rs. %.2f%n", calculateBill());
  }
}
class ElectricityBillGenerator 
{
  public static void main(String [] args) 
  {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter Consumer Number: ");
    int consumerNo = scanner.nextInt();
    System.out.println("Enter Consumer Name: ");
    scanner.nextLine(); 
    String consumerName = scanner.nextLine();
    System.out.println("Enter Previous Month Reading: ");
    double previousReading = scanner.nextDouble();
    System.out.println("Enter Current Month Reading: ");
    double currentReading = scanner.nextDouble();
    System.out.println("Enter Connection Type (domestic/commercial): ");
    scanner.nextLine(); 
    String connectionType = scanner.nextLine();

    ebill bill = new ebill(consumerNo, consumerName, previousReading,currentReading, connectionType);

    bill.displayBill();
    scanner.close();
  }
}