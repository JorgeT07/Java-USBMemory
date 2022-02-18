import com.sun.javaws.IconUtil;

import java.util.Scanner;

import static java.lang.String.format;

public class driver {

    static StringBuilder actualMemorySize(String ms){ // returns a stringbuilder type
        String clean = ms.replaceAll("([A-Z])", ""); //here we separate the numbers from the letters
        String back =  ms.replaceAll("([0-9])", ""); //seperate gb and mb from the numbers
        double usb = Double.valueOf(clean); //turn the numbers from the string into double
        double actual; // will use this to store the result of the memory
        StringBuilder ans = new StringBuilder(); //create a stringbuilder to keep adding to the result

        if(back.equals("GB") ){ //if the end of the string was gb or mb it will be doing an action accordingly
            if(usb < 1){
                actual = (usb * 100) * .93;
                ans = ans.append(format("%.2f", actual) + " MB");
            }
            actual = usb * .93; //here we multiply the 7% to be reduced in the next function
            ans = ans.append(format("%.2f", actual) + " GB"); //we convert the answer into a stringbuilder object and ad gb to the end of it
        }else if(back.equals("MB")){ //if the end if mb we take this action
            actual = usb * .93;
            int reduced = (int)Math.round(actual); //we convert the double into int and round it down
            ans = ans.append(reduced + " MB");
        }
        return ans; //we return the stringbuilder object
    }

    public static void main(String[] args) {

        System.out.println("Please input the memory of the usb: ");

        System.out.println(actualMemorySize("32GB")); // --> "29.76GB"

        System.out.println(actualMemorySize("2GB")); // --> "1.86GB"

        System.out.println(actualMemorySize("512MB")); // --> "476MB"
    }
}
