import java.util.Scanner;

public class AirlineSeat
{
  public static void main(String[]args)
  {
    int seatClass;
    boolean [] seatAssignment = new boolean[10];
    Scanner input = new Scanner(System.in);
    int index=0;
    int economySeatIndex = 0;
    int firstClassSeatIndex = 5;
    String switchClass;
    String lowerSwitchClass;
    
    for(int i = 0; i < 10; i++)
    {
      seatAssignment[i] = false;
    }
    
    System.out.println("Please type 1 for First Class or 2 for Economy: ");
    seatClass = input.nextInt();
    
    switch(seatClass)
    {
      case 1:
        if(firstClassSeatIndex < 10)
        {
          seatAssignment[firstClassSeatIndex] = true;
          System.out.println("BOARDING PASS: \n\n Your Class: First Class \n Your seatNumber: " + (firstClassSeatIndex+1) + "\n");
          firstClassSeatIndex++;

        }
        else
        {
          System.out.println("First Class is full. Would you like to be placed in economy?");
          switchClass = input.nextLine();
          lowerSwitchClass = switchClass.toLowerCase();
          switch(switchClass)
          {
            case "yes":
              if(economySeatIndex < 5)
              {
                seatAssignment[economySeatIndex] = true;
                System.out.println("BOARDING PASS: \n\n Your Class: Economy \n Your seatNumber: " + (economySeatIndex+1) + "\n");
                economySeatIndex++;

              }
              else
              {
                System.out.println("Economy is also full. Next flight leaves in three hours.");
              }
            case "no":
              System.out.println("Next flight leaves in three hours.");
          }
        }
        break;
      case 2:
        if(economySeatIndex < 5)
        {
          seatAssignment[economySeatIndex] = true;
          System.out.println("BOARDING PASS: \n\n Your Class: economy \n Your seatNumber: " + (economySeatIndex+1) + "\n");
          economySeatIndex++;

        }
        else
        {
          System.out.println("Economy is full. Would you like to be placed in First Class?");
          switchClass = input.nextLine();
          lowerSwitchClass = switchClass.toLowerCase();
          switch(switchClass)
          {
            case "yes":
              if(firstClassSeatIndex < 10)
              {
                seatAssignment[firstClassSeatIndex] = true;
                System.out.println("BOARDING PASS: \n\n Your Class: First Class \n Your seatNumber: " + (firstClassSeatIndex+1) + "\n");
                firstClassSeatIndex++;
              }
              else
              {
                System.out.println("First Class is also full. Next flight leaves in three hours.");
              }
            case "no":
              System.out.println("Next flight leaves in three hours.");
          }
        }
        break;
      }
      
      
    }
  }
