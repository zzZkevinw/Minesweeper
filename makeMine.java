public class makeMine {
    public static int[][] make(String[][] playground){
        int[][] mineSpot = new int[20][20];
        for(int i  = 2; i < 11; i++){
            for(int j = 2; j < 11; j++){
                playground[i][j] = "● ";
            }
        }
        
        int n = 0;
        while(n < 10){
            double randomNumber1 = Math.random()*10;          
            double randomNumber2 = Math.random()*10;
            int r1 = (int) Math.round(randomNumber1);
            int r2 = (int) Math.round(randomNumber2);

            if(mineSpot[r1][r2] == 1){
                continue;
            }
            if(r2 >= 2 && r1 >= 2 && r1 <= 10 && r2 <= 10){
                //System.out.println("n: " + n);
                //playground[r1][r2] = "* ";
                mineSpot[r1][r2] = 1;
                //System.out.println(r1 + " " + r2);
                n++;
            }
        }
        return mineSpot;
    }
}
