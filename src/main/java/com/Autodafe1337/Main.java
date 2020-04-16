package com.Autodafe1337;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Main {

    

    public static void main(String[] args){

        LocalTime time;
        CheckerGUI gui = new CheckerGUI("L2on Parser");
        Items moon = new Items("92236", "Лунный");
        Items korall = new Items("92196", "Коралл");
        Items onyx = new Items("92206", "Оникс");
        Items opal = new Items("92186", "Опал");
        Items circon = new Items("92226", "Циркон");
        Items ember = new Items("92176", "Янтарь");
        Items shpinel = new Items("92216", "Шпинель");
        Items L1000 = new Items("93628", "1000");
        Items L8000 = new Items("93629", "8000");
        int[] IDlist = {2626, 205, 5780, 49703, 90555, 90556, 90557, 90558, 90559, 90560, 90561, 90562, 90563, 93633, 49996,  91168, 91169,
                91170, 91167, 91166, 91166, 91167, 91168, 45481};



//        gui.addText(korall.checkForLess(3900000));
        while(true) {

//            gui.addText(moon.getLowestPrice());
//            gui.addText(moon.getHighestPrice());
//        gui.addText(korall.getLowestPrice());
//        gui.addText(korall.getHighestPrice());
//        gui.addText(circon.getLowestPrice());
//        gui.addText(circon.getHighestPrice());
//        gui.addText(shpinel.getLowestPrice());
//        gui.addText(shpinel.getHighestPrice());
//        gui.addText(opal.getLowestPrice());
//        gui.addText(opal.getHighestPrice());
//        gui.addText(onyx.getLowestPrice());
//        gui.addText(onyx.getHighestPrice());
//        gui.addText(ember.getLowestPrice());
//        gui.addText(ember.getHighestPrice());             // buy-sell all gems


            gui.addText(onyx.checkForLess(12000000));
            gui.addText(shpinel.checkForLess(10000000));
            gui.addText(korall.checkForLess(8600000));
            gui.addText(circon.checkForLess(8100000));
            gui.addText(opal.checkForLess(3000000));
//            gui.addText(moon.checkForLess(3500000));
//            gui.addText(ember.checkForLess(1000000));


            gui.addText(" ");
            System.out.println("");
            gui.addText(checkList(IDlist));
//        System.out.println("");
        System.out.println("");
        gui.addText(L1000.getLowestPrice());
        gui.addText(L8000.getLowestPrice());
//
            gui.addText(" ");
            System.out.println("");
            time = LocalTime.now();
            gui.addText("Data Updated - " + time.getHour() + ":" + time.getMinute());

            try {
                Thread.sleep(300000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            gui.clearText();
        }
    }

    public static String[] checkList(int[] IDlist){

        String[] res = new String[IDlist.length];
        Items[] list = new Items[IDlist.length];

        for(int i = 0; i<IDlist.length; i++){
            
            list[i] = new Items(IDlist[i]);
            try{
                res[i]=list[i].getLowestPrice();
            } catch (NumberFormatException ignored){}
        }
        return res;
    }

}

