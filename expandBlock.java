public class expandBlock {
    public static String expand(int[][]mineSpot, int spot1, int spot2, String[][] playground, boolean bomb){
        int mineNumber = calMineNumber.calNumber(mineSpot, spot1, spot2);
        int check = 0;
        if(playground[spot1][spot2] == "● "){
                    check = 1;
                }
        //System.out.println("雷数量:"+mineNumber);
            if(mineNumber == 0){
                if(playground[spot1+1][spot2] == "● "){
                    playground[spot1+1][spot2] = "  ";
                    expandBlock.expand(mineSpot, spot1+1, spot2, playground, bomb);
                }
                if(playground[spot1-1][spot2] == "● "){
                    playground[spot1-1][spot2] = "  ";
                    expandBlock.expand(mineSpot, spot1-1, spot2, playground, bomb);
                }
                if(playground[spot1][spot2+1] == "● "){
                    playground[spot1][spot2+1] = "  ";
                    expandBlock.expand(mineSpot, spot1, spot2+1, playground, bomb);
                }
                if(playground[spot1][spot2-1] == "● "){
                    playground[spot1][spot2-1] = "  ";
                    expandBlock.expand(mineSpot, spot1, spot2-1, playground, bomb);
                }
                if(playground[spot1+1][spot2-1] == "● "){
                    playground[spot1+1][spot2-1] = "  ";
                    expandBlock.expand(mineSpot, spot1+1, spot2-1, playground, bomb);
                }
                if(playground[spot1-1][spot2+1] == "● "){
                    playground[spot1-1][spot2+1] = "  ";
                    expandBlock.expand(mineSpot, spot1-1, spot2+1, playground, bomb);
                }
                if(playground[spot1+1][spot2+1] == "● "){
                    playground[spot1+1][spot2+1] = "  ";
                    expandBlock.expand(mineSpot, spot1+1, spot2+1, playground, bomb);
                }
                if(playground[spot1-1][spot2-1] == "● "){
                    playground[spot1-1][spot2-1] = "  ";
                    expandBlock.expand(mineSpot, spot1-1, spot2-1, playground, bomb);
                }
                playground[spot1][spot2] = "  ";
                return "OK";
            } else {
                playground[spot1][spot2] = String.valueOf(mineNumber) + " ";
            }
            
            //if(playground[spot1][spot2] == "● "){
            //     playground[spot1][spot2] = String.valueOf(mineNumber) + " ";
            //     return;
            // }
            
            int correspond = 0;
            //System.out.println("corre????:"+correspond);
            if(playground[spot1][spot2] != "● " && playground[spot1][spot2] != "  "){
                int count = 0;
                if(playground[spot1+1][spot2] == "★ "){
                    count++;
                    if(mineSpot[spot1+1][spot2] == 1){
                        correspond++;
                        //System.out.println("我为啥在这1");
                    }
                }
                if(playground[spot1-1][spot2+1] == "★ "){
                    count++;
                    if(mineSpot[spot1-1][spot2+1] == 1){
                        correspond++;
                        //System.out.println("我为啥在这2");
                    }
                }
                if(playground[spot1-1][spot2] == "★ "){
                    count++;
                    if(mineSpot[spot1-1][spot2] == 1){
                        correspond++;
                        //System.out.println("我为啥在这3");
                    }
                }
                if(playground[spot1][spot2+1] == "★ "){
                    count++;
                    if(mineSpot[spot1][spot2+1] == 1){
                        correspond++;
                        //System.out.println("我为啥在这4");
                    }
                }
                if(playground[spot1][spot2-1] == "★ "){
                    count++;
                    if(mineSpot[spot1][spot2-1] == 1){
                        correspond++;
                        //System.out.println("我为啥在这5");
                    }
                }
                if(playground[spot1+1][spot2+1] == "★ "){
                    count++;
                    if(mineSpot[spot1+1][spot2+1] == 1){
                        correspond++;
                        //System.out.println("我为啥在这6");
                    }
                }
                if(playground[spot1-1][spot2-1] == "★ "){
                    count++;
                    if(mineSpot[spot1-1][spot2-1] == 1){
                        correspond++;
                        //System.out.println("我为啥在这7");
                    }
                }
                if(playground[spot1+1][spot2-1] == "★ "){
                    count++;
                    if(mineSpot[spot1+1][spot2-1] == 1){
                        correspond++;
                        //System.out.println("我为啥在这8");
                    }
                }
                // System.out.println("correspond: "+correspond);
                // System.out.println("mineNumber: "+mineNumber);
                // System.out.println("count: "+count);
                // System.out.println("check: "+check);

                if(mineNumber == correspond && mineNumber >= count && check == 0){
                    //System.out.println("进去过 count");
                    int mineNumber2 = 0;
                    if(playground[spot1+1][spot2] == "● "){
                        mineNumber2 = calMineNumber.calNumber(mineSpot, spot1+1, spot2);
                        if(mineNumber2 != 0){
                            playground[spot1+1][spot2] = String.valueOf(mineNumber2) + " ";
                        }
                        else expandBlock.expand(mineSpot, spot1+1, spot2, playground, bomb);
                        //System.out.println("我来过1");
                    }
                    if(playground[spot1-1][spot2] == "● "){
                        mineNumber2 = calMineNumber.calNumber(mineSpot, spot1-1, spot2);
                        if(mineNumber2 != 0){
                            playground[spot1-1][spot2] = String.valueOf(mineNumber2) + " ";
                        }
                        else expandBlock.expand(mineSpot, spot1-1, spot2, playground, bomb);
                        //System.out.println("我来过2");
                    }
                    if(playground[spot1][spot2+1] == "● "){
                        mineNumber2 = calMineNumber.calNumber(mineSpot, spot1, spot2+1);
                        if(mineNumber2 != 0){
                            playground[spot1][spot2+1] = String.valueOf(mineNumber2) + " ";
                        }
                        else expandBlock.expand(mineSpot, spot1, spot2+1, playground, bomb);
                        //System.out.println("我来过3");
                    }
                    if(playground[spot1][spot2-1] == "● "){
                        mineNumber2 = calMineNumber.calNumber(mineSpot, spot1, spot2-1);
                        if(mineNumber2 != 0){
                            playground[spot1][spot2-1] = String.valueOf(mineNumber2) + " ";
                        }
                        else expandBlock.expand(mineSpot, spot1, spot2-1, playground, bomb);
                        //System.out.println("我来过4");
                    }
                    if(playground[spot1+1][spot2-1] == "● "){
                        mineNumber2 = calMineNumber.calNumber(mineSpot, spot1+1, spot2-1);
                        if(mineNumber2 != 0){
                            playground[spot1+1][spot2-1] = String.valueOf(mineNumber2) + " ";
                        }
                        else expandBlock.expand(mineSpot, spot1+1, spot2-1, playground, bomb);
                        //System.out.println("我来过5");
                    }
                    if(playground[spot1-1][spot2+1] == "● "){
                        mineNumber2 = calMineNumber.calNumber(mineSpot, spot1-1, spot2+1);
                        if(mineNumber2 != 0){
                            playground[spot1-1][spot2+1] = String.valueOf(mineNumber2) + " ";
                        }
                        else expandBlock.expand(mineSpot, spot1-1, spot2+1, playground, bomb);
                        //System.out.println("我来过6");
                    }
                    if(playground[spot1+1][spot2+1] == "● "){
                        mineNumber2 = calMineNumber.calNumber(mineSpot, spot1+1, spot2+1);
                        if(mineNumber2 != 0){
                            playground[spot1+1][spot2+1] = String.valueOf(mineNumber2) + " ";
                        }
                        else expandBlock.expand(mineSpot, spot1+1, spot2+1, playground, bomb);
                        //System.out.println("我来过7");
                    }
                    if(playground[spot1-1][spot2-1] == "● "){
                        mineNumber2 = calMineNumber.calNumber(mineSpot, spot1-1, spot2-1);
                        if(mineNumber2 != 0){
                            playground[spot1-1][spot2-1] = String.valueOf(mineNumber2) + " ";
                        }
                        else expandBlock.expand(mineSpot, spot1-1, spot2-1, playground, bomb);
                        //System.out.println("我来过8");
                    }
                } else if(count !=0 && check == 0){
                    //System.out.println("炸了！");
                    return "boom";
                }
            }
        return "OK";
     }
}
