/**
 * Name: Daniel Nguyen
 * ID: A16129027
 * Email: d7nguyen@ucsd.edu
 * Sources used: tutor help(Angela Liu), javadoc https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
 * 
 * This file contains a program to compute the risk of contracting Covid. It uses primitive data types, variables, input, output, and if-else statements.
 */
 
import java.util.Scanner;

/**
 * This class will prompt the user to enter the needed data and calculate and display the time each person spent together in minutes. It will then display the associated risk level.
 */
public class Main   /**change the name to CovidTransmission*/
{   
    public static void main(String[] args) 
    {
        
        /** constants */
        final int hrsPerDay = 24;
        final int minPerHr = 60;
        final int lowCutoff = 60;
        final int medCutoff = 180;
        final int highCutoff = 360;
    
        /** instance variables */
        int D1; /**day*/
        int H1; /**hour*/
        int M1; /**minute*/
    
        int D2; /**end day*/
        int H2; /**end hour*/
        int M2; /**end minute*/

        int minOfTheMonthStart; /**this assigns a minute for the start time. goes up to 43800 as long as the input is valid*/
        int minOfTheMonthEnd;   /**and a minute for the end time*/
    
        int contactTime=0;    /**in minutes. It will be difference between minMonthEnd and minMonthStart*/
    
        Scanner scnr = new Scanner(System.in);
        D1 = scnr.nextInt();
        H1 = scnr.nextInt();
        M1 = scnr.nextInt();
        D2 = scnr.nextInt();
        H2 = scnr.nextInt();
        M2 = scnr.nextInt();
    
        if(D1>=1 && D1<=31 && D2>=1 && D2<=31 && H1>=0 && H1<=23 && H2>=0 && H2<=23 && M1>=0 && M1<=59 && M2>=0 && M2<=59)         //check validity
        {
            minOfTheMonthStart = (D1*hrsPerDay*minPerHr) + (H1*minPerHr) + M1;   /**add up all the minutes there are using conversion factors*/
            minOfTheMonthEnd = (D2*hrsPerDay*minPerHr) + (H2*minPerHr) + M2;     /**do it for the end as well. */
        
            contactTime = minOfTheMonthEnd - minOfTheMonthStart;      /**calculate it by subtracting*/
        
            if (contactTime >= 0)
            {
            
                if(contactTime>=0 && contactTime<=lowCutoff)
                {
                    System.out.println(contactTime + "low");
                }
                else if(contactTime>lowCutoff && contactTime<=medCutoff)
                {
                    System.out.println(contactTime + "medium");
                }
                else if(contactTime>=medCutoff && contactTime<=highCutoff)
                {
                    System.out.println(contactTime + "high");
                }
                else if(contactTime>highCutoff)
                {
                    System.out.println(contactTime + "HIGH");
                }
            }
            else    /**invalid because contactTime can't be negative.*/
            {
                System.out.println("-1 -1");
            }
        }
        else        /**invalid because data must be within range.*/
        {
            System.out.println("-1 -1");
        }
    }
}
