public class makeDiagram {

    public static String[][] make() {

        String[][] playground = new String[12][12];
        
         for(int i  = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
                playground[i][j] = "  ";
                //System.out.print(playground[i][j]);
            }
            //System.out.println();
        }
        
        for(int i = 2; i < 11; i++){
            playground[1][i] = "--";
            playground[11][i] = "--";
        }
        for(int j = 2; j < 11; j++){
            playground[j][1] = "| ";
            playground[j][11] = "|";
        }

        playground[1][10] = "- ";
        playground[11][10] = "- ";

        String[] letter = {"1 ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8 ", "9 "};
        String[] num = {"1 ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8 ", "9 "};
        for(int i = 2,k = 0; i < 11; i++){
            playground[i][0] = num[k];
            playground[0][i] = letter[k];
            k++;
            //System.out.print(playground[0][i]);
        }

        playground[1][1] = "★ ";
        playground[11][1] = "★ ";
        playground[1][11] = "★";
        playground[11][11] = "★";

        // for(int i  = 0; i < 12; i++){
        //     for(int j = 0; j < 12; j++){
        //         System.out.print(playground[i][j]);
        //     }
        //     System.out.println();
        // }

        return playground;
    }
}
