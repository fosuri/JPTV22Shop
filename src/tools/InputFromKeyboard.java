
package tools;

import java.util.Scanner;

public class InputFromKeyboard {
    private static final Scanner scanner = new Scanner(System.in);

    public static Integer inputNumberFromRange(Integer min, Integer max){
        
        
        Integer number;
        while (true) {
            
            if (scanner.hasNextInt()){
                number = scanner.nextInt();
                if((min==null || number >= min) && (max == null || number <=max)){
                    break;
                }else{
                    System.out.println("Please enter a number in the range from " + min + " to " + max);
                }
            }else{
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }
        return number;
    }
    public static String inputSympolYesOrNO(){;
        String sybmol = "n";
        do{
            sybmol = scanner.nextLine();
            if(sybmol.equals("n") || sybmol.equals("y")){
                return sybmol;
            }
            System.out.println("Only \"y\" or \"n\": ");
        }while(true);
    }
    
}
