public class calMineNumber {
    public static int calNumber(int[][]mineSpot, int spot1, int spot2){

        int mineNumber = 0;

        if(mineSpot[spot1+1][spot2] == 1){
            mineNumber ++;
        }
        if(mineSpot[spot1-1][spot2] == 1){
            mineNumber ++;
        }
        if(mineSpot[spot1][spot2+1] == 1){
            mineNumber ++;
        }
        if(mineSpot[spot1][spot2-1] == 1){
            mineNumber ++;
        }
        if(mineSpot[spot1+1][spot2-1] == 1){
            mineNumber ++;
        }
        if(mineSpot[spot1-1][spot2+1] == 1){
            mineNumber ++;
        }
        if(mineSpot[spot1+1][spot2+1] == 1){
            mineNumber ++;
        }
        if(mineSpot[spot1-1][spot2-1] == 1){
            mineNumber ++;
        }

        return mineNumber;
    }
}
