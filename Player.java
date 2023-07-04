public abstract class Player {
    protected static int[] used = new int[9];
    static int track = 0;
    public String symbol;
    
    Player(String letter){
        this.symbol = letter;
    }

    @Override
    public String toString(){
        return this.symbol;
    }
    protected boolean isUsed(int[] used, int element){
        for(int i = 0; i < used.length; i++ ){
            if (element == used[i]){
                return true;
            }
        }
        return false;
    }

    abstract int getMove();

}

