public class makeFlag {

    public static void make(String[][] playground, int[] flagSpots){

        int spot1 = flagSpots[0] + 1;
        int spot2 = flagSpots[1] + 1;

        if(playground[spot1][spot2] == "● "){
            playground[spot1][spot2] = "★ ";
        }
        else System.out.println("------此处不可标记!------");
    }
}
