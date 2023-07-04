import java.util.Random;

public class RandomPlayer extends Player {
    RandomPlayer(String letter){
        super(letter);
    }

    int getMove(){
        Random random = new Random();
        boolean run = true;
        int position = 0;    
        
        while (run){
            
            position = random.nextInt(0, 9) + 1;
            if (! isUsed(used, position)){
                used[track] = position;
                track++;
                System.out.println("Computer Choosed " + position );
                break;
            }
           
        }
        return position;
    }
}
