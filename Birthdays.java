//Nina Ervin
//this code compairs two birthdays
//1/16/2023
import java.util.*;
public class Birthdays {
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);
        //the value the controls if the while loop ends or not
        boolean end = false;
        //this is just for fun to add a little more vriety into the birthday facts
        int count = 0;
        while (end != true){
            count++;
            //prints the intro to what the code does and takes the users input in a string and saves it the the var todayS
           String todayS = Introduction(console);
            //takes the sring of user input and puts it into the number of days
           int numToday = calcToNum(todayS,1);
           //this method sends in the number of the user (wethere the 1st or the 2nd and the number of what the user said today was converted into how many days into the year)
            //it returns the number valuse of each birthday
           int person1 = PersonsBirthday(console,1, numToday);
           int person2 = PersonsBirthday(console,2, numToday); 
           //this method takes how far away the birthdays are and tells the user whos birthday is closer
           SoonerBirthday(person1, person2,count);
           //asks the user if they want to continue
           end = Continue(console);
            //I added a next line since it was having issues with the next line for the second loop causing the error.
           console.nextLine();
           
        }
        System.out.println("thanks for using the program. Have a good day!");
    }


    public static String Introduction(Scanner console){
        //intro writing
        System.out.println("This program compares two birthdays");
        System.out.println("and displays which one is sooner.");
        System.out.println("What is today's month and day?");
        String today = console.nextLine();
        //sents the user input back to the main method
        return today;
    }


    public static int calcToNum(String todayS,int changeString){
        //takes the string of the month and day to turn it into an in of just the month
            //Integer.parseInt = convers a string to an intager
            //String.substring isolates the just the first number by starting the index at 0
            //String.indexOf finds the numarical valuse of where the space is in the string
        int month = Integer.parseInt(todayS.substring(0,todayS.indexOf(" ")));
        //this is the same thing but its just the day
        int day = Integer.parseInt(todayS.substring(todayS.indexOf(" ")+1));
        int numDay = 0;
        int addition = 0;
        //this for statment runs for the anount of full months that you have and calculation how many days that is
        for (int i = 1; i < month; i++){
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12){
                addition = 31;
            }else if (i == 2){
                addition = 29;
            }else {
                addition = 30;
            }
            numDay = (numDay+addition);
        }
        //after that then the days gets added to the total outside the for loop to get the number of days before the date
        numDay = (numDay + day);
        //this if statment filtertes through wether or not it is the first date of a birthday and then print the correct statement
            //it uses the var input at the top called changeString
        if (changeString == 1){
            System.out.println("Today is " + month + "/" + day + "/2020, day #" + numDay + " of this year");
        }else {
            System.out.println(month + "/" + day + "/2020 falls on day #" + numDay + " of 366");
        }
        //this sends back the # of the day out of the year
        return numDay;
    }


    public static int PersonsBirthday(Scanner console,int personNum,int currentDate){
        //this prints out which user is going
        System.out.println("person " + personNum + ":");
        System.out.println("What month and day were you born?");
        //this takes the user input of what day their birthday is in a String
        String birthday = console.nextLine();
        //this sends that user string off to the other method to calculate the number valuse of their birthday
        int birthdayNum = calcToNum(birthday,2);
        int tillNextB = 0;
        //this if else loop calculates how many days till their next birthday bepending on wether or not its still in this year or happended last year
        if (birthdayNum > currentDate){
             tillNextB = (birthdayNum - currentDate);
        }else if (birthdayNum < currentDate){
            tillNextB = (366 - (currentDate-birthdayNum));
        }
        //this if statemnt decides if their birthday is today (which just prints happy birthday) or not (then it prints how many days away and what precent of the year is left)
        if (tillNextB == 0){
            System.out.println("Happy Birthday");
        }else{
        System.out.println("Your next birthday is in " + tillNextB + " day(s).");
        //convert tillNextB to a double to make sure that im doing divison with dec.
        double precentOfYear = ((double)tillNextB)/366*100;
        //this printf statment is used to round the double to the 1st dec
        System.out.printf("That is %.1f precent of the year away.\n",precentOfYear);
        }
        return tillNextB;
    }


    public static void SoonerBirthday(int person1, int person2, int count){
        System.out.println();
        //prints different statements based on who has the sooner birthday
        if(person1 < person2){
            System.out.println("Person 1's birthday is sooner. ");
        }else if (person1 > person2){
            System.out.println("Person 2's birthday is sooner ");
        }else {
            System.out.println("Wow, you share the same birthday! ");
        }
        System.out.println();
        //changed up the birthday fact cause I thought it would be more fun
        if(count %2 == 0){
            System.out.println("Did yopu know that at least 15 million people share a birthday with each of you!! ");
        }else{
            System.out.println("The most popular day to be born is on a tuesday ");
        }
        System.out.println();
    }


    public static boolean Continue(Scanner console){
        boolean end = false;
        //prints out question and how to respont to continue the program
        System.out.println("Would you like to compare two more birthdays?");
        System.out.println("Type 1 and then <enter/return> to compare two more birthdays");
        System.out.println("Type 2<enter/return> to end the program");
        int answer = console.nextInt();
        if(answer == 2)
            end = true;
        return end;
    }
}
