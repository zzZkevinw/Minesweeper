public class judgeMine {
    
    public static boolean judge(int[][] mineSpot, int[] inputArray){
        int spot1 = inputArray[0] + 1;
        int spot2 = inputArray[1] + 1;

        if(mineSpot[spot1][spot2] == 1){
            return true;
        } else return false;
    }
}
