public class showDiagram {

    public static void show(String[][]playground, boolean bomb, int[][]mineSpot){

        if(bomb == true){
            for(int i  = 0; i < 12; i++){
                for(int j = 0; j < 12; j++){
                    if(mineSpot[i][j] == 1){
                        playground[i][j] = "* ";
                    }
                    System.out.print(playground[i][j]);
                }
                System.out.println();
            }
        } else{
            for(int i  = 0; i < 12; i++){
                for(int j = 0; j < 12; j++){
                    System.out.print(playground[i][j]);
                }
                System.out.println();
            }
        }
    }
}
