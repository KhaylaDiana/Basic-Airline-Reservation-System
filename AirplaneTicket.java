import java.util.Hashtable;
import java.util.Scanner;

public class AirplaneTicket
{
  public int NUMOFCITIES;
  public int [][] map;
  public static int [][] dist;
  
  public AirplaneTicket(int _n, int [][] _A) {
		NUMOFCITIES = _n;
		map = _A;
  }
  
  public void floyd_warshall(){
		dist = new int[NUMOFCITIES][NUMOFCITIES];
		for(int i = 0; i < NUMOFCITIES; i++) {
			for(int j = 0; j < NUMOFCITIES; j++) {
				dist[i][j] = map[i][j];
			}
		}
		
		for(int k = 0; k < NUMOFCITIES; k++) {
			for(int i = 0; i < NUMOFCITIES; i++) {
				for(int j = 0; j < NUMOFCITIES; j++) {
					if((dist[i][k]+dist[k][j]) < dist[i][j]) {
						dist[i][j] = (dist[i][k]+dist[k][j]);
					}
				}
			}
		}
      
	}
   
   
   
   public static void main(String[]args)
   {
     int seatClass;
     boolean [] seatAssignment = new boolean[10];
     int index=0;
     int economySeatIndex = 0;
     int firstClassSeatIndex = 5;
     String switchClass;
     String lowerSwitchClass;
     final int NUMOFCITIES = 24;
     final int INF = 99999;
     int distance = 0;
     int milePriceDollars = 0;
     int milePriceCents = 0;
     int totalPrice = 0;
     String departureLocation;
     String destination;
     int [][] map = {
     {0, 109, INF, INF, 370, INF, INF, INF, INF, INF, 308, INF, INF, INF, 862, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     {109, 0, INF, INF, 304, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     {INF, INF, 0, 740, INF, INF, INF, INF, INF, INF, INF, INF, 129, INF, INF, INF, INF, INF, 177, 693, INF, 234, INF, INF},
     {INF, INF, 740, 0, INF, INF, 187, INF, INF, 94, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     {370, 304, INF, INF, 0, INF, INF, INF, 343, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     {INF, INF, INF, INF, INF, 0, INF, INF, 191, INF, INF, 140, INF, INF, INF, 224, INF, 817, INF, INF, 689, INF, INF, INF},
     {INF, INF, INF, 94, INF, INF, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 632, INF, INF},
     {INF, INF, INF, INF, INF, INF, INF, 0, INF, INF, 30, INF, INF, INF, 967, INF, 1846, INF, INF, INF, INF, INF, INF, INF},
     {INF, INF, INF, INF, 343, 191, INF, INF, 0, INF, INF, 66, INF, INF, 794, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     {INF, INF, INF, 94, INF, INF, INF, INF, INF, 0, INF, INF, INF, 406, INF, INF, INF, INF, INF, INF, INF, INF, INF, 90},
     {308, INF, INF, INF, INF, INF, INF, 30, INF, INF, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     {INF, INF, INF, INF, INF, 140, INF, INF, 66, INF, INF, 0, INF, INF, INF, 190, INF, INF, INF, INF, INF, INF, INF, INF},
     {INF, 1721, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, INF, INF, INF, 129, INF, INF, INF, INF, INF, INF, INF},
     {INF, INF, INF, INF, INF, INF, INF, INF, INF, 406, INF, INF, INF, 0, INF, INF, INF, INF, 182, INF, INF, INF, INF, INF},
     {862, INF, INF, INF, INF, INF, INF, 967, 794, INF, INF, INF, INF, INF, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF},
     {INF, INF, INF, INF, INF, 224, INF, INF, INF, INF, INF, 190, INF, INF, INF, 0, INF, INF, INF, 175, INF, INF, 936, 1217},
     {INF, INF, INF, INF, INF, INF, INF, 1846, INF, INF, INF, INF, 129, INF, INF, INF, 0, INF, INF, INF, INF, INF, INF, INF},
     {INF, INF, INF, INF, INF, 817, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, INF, INF, 270, INF, INF, INF},
     {INF, INF, 177, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 182, INF, INF, INF, INF, 0, INF, INF, INF, INF, INF},
     {INF, INF, 693, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 175, INF, INF, INF, 0, INF, INF, INF, INF},
     {INF, INF, INF, INF, INF, 689, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 270, INF, INF, 0, INF, 277, INF},
     {INF, INF, 234, INF, INF, INF, 632, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, INF, INF},
     {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 936, INF, INF, INF, INF, 277, INF, 0, 361},
     {INF, INF, INF, INF, INF, INF, INF, INF, INF, 90, INF, INF, INF, INF, INF, 1217, INF, INF, INF, INF, INF, INF, 361, 0}};        
     Hashtable<String, Integer> cities = new Hashtable<String, Integer>();
     Scanner input = new Scanner(System.in);
     AirplaneTicket graph = new AirplaneTicket(NUMOFCITIES, map);
     graph.floyd_warshall();
     
     for(int i = 0; i < 10; i++)
     {
       seatAssignment[i] = false;
     }

     cities.put("Los Angeles", 0);
     cities.put("San Diego", 1);
     cities.put("Chicago", 2);
     cities.put("New York City", 3);
     cities.put("Phoenix", 4);
     cities.put("Houston", 5);
     cities.put("Boston", 6);
     cities.put("San Francisco", 7);
     cities.put("San Antonio", 8);
     cities.put("Philadelpia", 9);
     cities.put("San Jose", 10);
     cities.put("Austin", 11);
     cities.put("Seattle", 12);
     cities.put("Columbus", 13);
     cities.put("Denver", 14);
     cities.put("Dallas", 15);
     cities.put("Portland", 16);
     cities.put("Jacksonville", 17);
     cities.put("Indianapolis", 18);
     cities.put("Oklahoma City", 19);
     cities.put("Atlanta", 20);
     cities.put("Detroit", 21);
     cities.put("Charlotte", 22);
     cities.put("Baltimore", 23);

     System.out.println("What city are you traveling from?");
     departureLocation = input.nextLine();
     System.out.println("What city are you traveling to?");
     destination = input.nextLine();
     System.out.println("Please type 1 for First Class or 2 for Economy: ");
     seatClass = input.nextInt();

     switch(seatClass)
    {
      case 1:
        if(firstClassSeatIndex < 10)
        {
          seatAssignment[firstClassSeatIndex] = true;
          System.out.println("BOARDING PASS: \n\n Your Class: First Class \n Your Seat Number: " + (firstClassSeatIndex+1) + "\n");
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
                System.out.println("BOARDING PASS: \n\n Your Class: Economy \n Your Seat Number: " + (economySeatIndex+1) + "\n");
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
          System.out.println("BOARDING PASS: \n\n Your Class: economy \n Your Seat Number: " + (economySeatIndex+1) + "\n");
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
                System.out.println("BOARDING PASS: \n\n Your Class: First Class \n Your Seat Number: " + (firstClassSeatIndex+1) + "\n");
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
      
     
     if(cities.containsKey(departureLocation) && cities.containsKey(destination))
     {
       distance = dist[cities.get(departureLocation)][cities.get(destination)];
       milePriceDollars = (11 * distance) / 100;
       milePriceCents = (11 * distance) % 100;
       totalPrice = 50 + milePriceDollars;
     
       System.out.println("The price of your ticket from " + departureLocation + " to " + destination + " is $" + totalPrice + "." + milePriceCents);
     }
     else
     {
       System.out.println("Im sorry, we do not fly to one of your locations");
     }
   }
}