import java.util.LinkedList;
import java.util.Scanner;


public class Counter {

    private static int ProcessTime;
    private static int MaxCashiers;
    private static int NumberOfCars;
    private static int EntranceTime;
    static int minCashierIndexAvgTime = 0;
    static int averageTime;
    static int minAvgTime;


    public static void main(String[]args){

        input();

        int [] cashierTime= new int[MaxCashiers];
        LinkedList<Integer> list = new LinkedList();
        
        for (int cashiers = 1; cashiers <= MaxCashiers; cashiers++) {
            int totalTime = 0;

            for (int i = 0; i < NumberOfCars; i++) {
                CarLine carLine = new CarLine((i+1)*EntranceTime);
            	
                int entryTime = EntranceTime + (i/cashiers)*ProcessTime+ (i%cashiers)*EntranceTime;
            	
                if ((cashiers*EntranceTime)>ProcessTime) {
            		entryTime += (i/cashiers)*EntranceTime;
            	}
            	
            	carLine.setDepartureTime(entryTime+ProcessTime);
            	
            	totalTime+= carLine.totalTime();
        	}
        	averageTime=totalTime/NumberOfCars;
        	list.add(averageTime);

        }
        for (int i = 0; i < list.size(); i++) {
        	System.out.print("Number of cashiers: "+(i+1)+" ");
        	System.out.print("Average time: "+ list.get(i));
        	System.out.println();
        	cashierTime[i] = list.get(i);
        }
        

        minAvgTime = cashierTime[0];
        for (int i = 0; i < cashierTime.length; i++) {
            if (cashierTime[i] < minAvgTime) {
            	minCashierIndexAvgTime = i+1;
            	minAvgTime = cashierTime[i];
            }
        }
        print();
    }
    public static void input(){
        Scanner input= new Scanner((System.in));
        System.out.println("Enter the process time per car in seconds:");
        ProcessTime=input.nextInt();
        System.out.println("Enter the maximum number of cashiers:");
        MaxCashiers=input.nextInt();
        System.out.println("Enter the number of cars: ");
        NumberOfCars=input.nextInt();
        System.out.println("Enter the entrance time in seconds (after how many seconds new car arrives): ");
        EntranceTime=input.nextInt();
    }
    public static void print(){
        System.out.print("Optimum number of cashiers: "+minCashierIndexAvgTime);
        System.out.println();
        System.out.print("Minimum processing time: "+ minAvgTime);
        System.out.println();

    }
}

