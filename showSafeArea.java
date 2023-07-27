import java.util.Scanner;

public class showSafeArea {

    public static String showSafe(int[][]mineSpot, int spot1, int spot2, String[][] playground, String flag, boolean bomb,Scanner scanner){

        if(playground[spot1][spot2] == "★ "){
            if(flag == "yes"){
                expandBlock.expand(mineSpot, spot1, spot2, playground,bomb);
            }else{
                System.out.println("此处为标记，是否要点击?(输入yes或no)");
                String YorN = scanner.nextLine();
                return YorN;
            }
        } else{
            //System.out.println("我来过 showsafe");
            String boomORnot = expandBlock.expand(mineSpot, spot1, spot2, playground,bomb);
            return boomORnot;
        }
        return "OK";
    }
}
