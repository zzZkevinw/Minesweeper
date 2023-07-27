public class judgeWin {

    public static boolean judge(String[][] playground, int[][] mineSpot){
        
        int solvedMine = 0;
        int nonExploit = 0;
        for(int i  = 2; i < 11; i++){
            for(int j = 2; j < 11; j++){
                if(playground[i][j] == "● "){
                    nonExploit++;
                }
                if(mineSpot[i][j] == 1){
                    if(playground[i][j] == "★ "){
                        solvedMine++;
                    }
                }
            }
        }
        //System.out.println("solvedmine数量:"+solvedMine);
        if(solvedMine == 10 && nonExploit == 0){
            return true;
        }
        return false;
    }
}
