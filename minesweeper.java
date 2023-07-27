import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class minesweeper{
    public static void main(String[] args) {

        //建立游戏盘
        String[][] playground = makeDiagram.make();
        //随机生成雷，并拿到雷坐标
        int[][] mineSpot = makeMine.make(playground);

        String fileName = "minesPosition.txt";
        // 使用try-with-resources确保资源正确关闭
        try (FileWriter writer = new FileWriter(fileName)) {
            // 将int类型的数字转换为String，并逐行写入文件
            for(int i  = 0; i < 12; i++){
                for(int j = 0; j < 12; j++){
                if(mineSpot[i][j] == 1){
                    writer.write(String.valueOf(i-1)+ " " + String.valueOf(j-1) + "\n");
                }
            }
        }
            //System.out.println("雷坐标已成功写入到文件 " + fileName);
        } catch (IOException e) {
            System.out.println("写入文件时发生错误：" + e.getMessage());
        }

        //生成游戏盘
        boolean bomb = false;
        int[] inputArray = new int[2];
        showDiagram.show(playground,bomb,mineSpot);

         //读取用户输入
        Scanner scanner = new Scanner(System.in);
        //游戏开始
        while(bomb == false){

            System.out.print("请输入你想点击的坐标,或者输入make以标记地雷:");
            String isMake = scanner.nextLine();
            
            if(isMake.equals("make")){
                System.out.print("请输入你要标记的坐标:");
                String[] numbers = scanner.nextLine().split(" ");
                if (numbers.length == 2) {
                    try {
                        int fnumber1 = Integer.parseInt(numbers[0]);
                        int fnumber2 = Integer.parseInt(numbers[1]);
                        int[] flagSpots = new int[2];
                        flagSpots[0] = fnumber1;
                        flagSpots[1] = fnumber2;
                        makeFlag.make(playground, flagSpots);
                        showDiagram.show(playground,bomb,mineSpot);

                        if(judgeWin.judge(playground, mineSpot) == true){
                            System.out.println("芜湖~你赢了");
                            return;
                        }
                        //System.out.println("你输入的两个整数分别是：" + fnumber1 + " 和 " + fnumber2);
                        // 在这里处理两个整数的逻辑
                    } catch (NumberFormatException e) {
                        System.out.println("输入格式不正确，请输入两个整数（以空格分隔)");
                        continue;
                    }
                } else {
                    System.out.println("输入格式不正确，请输入两个整数（以空格分隔");
                    continue;
                }
            }else{
                //System.out.println("我是不是都没进来啊");
                String[] numbers = isMake.split(" ");
                if (numbers.length == 2) {
                    try {
                        int number1 = Integer.parseInt(numbers[0]);
                        int number2 = Integer.parseInt(numbers[1]);
                        inputArray[0] = number1;
                        inputArray[1] = number2;
                        // 对intArray数组进行进一步操作
                    } catch (NumberFormatException e) {
                        System.out.println("输入格式不正确，需要输入两个整数");
                        continue;
                    }
                } else {
                    System.out.println("输入格式不正确，请输入'make'或者两个整数（以空格分隔)");
                    continue;
                }

                String flag = "no";
                int spot1 = inputArray[0] + 1;
                int spot2 = inputArray[1] + 1;
                bomb = judgeMine.judge(mineSpot,inputArray);
                if(bomb == false || (bomb == true && playground[spot1][spot2] == "★ ")){
                    String judgeFlag = showSafeArea.showSafe(mineSpot, spot1, spot2, playground,flag,bomb,scanner);
                    //System.out.println("judgeFlag:"+ judgeFlag);
                    if(judgeFlag.equals("yes")){
                        flag = "yes";
                        judgeFlag = showSafeArea.showSafe(mineSpot, spot1, spot2, playground,flag,bomb,scanner);
                    } else if(judgeFlag.equals("no")){
                        bomb = false;
                        continue;
                    } else if(judgeFlag.equals("boom")){
                        bomb = true;
                        showDiagram.show(playground,bomb,mineSpot);
                        continue;
                    } else if(judgeFlag.equals("no") == false && judgeFlag.equals("yes") == false && judgeFlag.equals("OK") == false){
                        System.out.println("输入格式错误，请重新操作!");
                        bomb = false;
                        continue;
                    }
                }
                showDiagram.show(playground,bomb,mineSpot);
                if(judgeWin.judge(playground, mineSpot) == true){
                    System.out.println("芜湖~你赢了");
                    return;
                }
            }
        }
        scanner.close();
        //showDiagram.show(playground,bomb,mineSpot);
        System.out.println("Bomb!游戏结束，你输了");
    }
}