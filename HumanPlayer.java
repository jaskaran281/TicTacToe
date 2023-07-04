import java.util.Scanner;

public class HumanPlayer extends Player {
    
    HumanPlayer(String letter){
        super(letter);
    }


    int getMove(){
        
        Scanner input = new Scanner(System.in);
        int position;
            while(true){
                
                System.out.print("Enter a number between 1 and 9: ");
                position = input.nextInt();
                System.out.println();

                if (1 <= position && position <= 9){
                    // input.close();
                    if (! isUsed(used, position)){
                        used[track] = position;
                        track++;
                        // input.close();
                        return position;
                    }
                    else {
                        System.out.println("The place is already used");
                    }
                    
                }
                else{
                    System.out.println("Invalid input");
                }
            }
        }
}
