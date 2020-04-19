package com.Autodafe1337;


import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Main {

    

    public static void main(String[] args){


        NumberFormat myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);

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
        int[] IDlist = {93633, 49996, 91169, 205,
                91170, 91166, 91167, 91168};



//        gui.addText(korall.checkForLess(3900000));
        while(true) {

//
//        gui.addText(onyx.getLowestPrice());
//        gui.addText(onyx.getHighestPrice());
//        gui.addText(shpinel.getLowestPrice());
//        gui.addText(shpinel.getHighestPrice());
//        gui.addText(korall.getLowestPrice());
//        gui.addText(korall.getHighestPrice());
//        gui.addText(circon.getLowestPrice());
//        gui.addText(circon.getHighestPrice());
//        gui.addText(opal.getLowestPrice());
//        gui.addText(opal.getHighestPrice());
//        gui.addText(moon.getLowestPrice());
//        gui.addText(moon.getHighestPrice());
//        gui.addText(ember.getLowestPrice());
//        gui.addText(ember.getHighestPrice());
            System.out.print("");         //buy sell all gems



            gui.addText(onyx.checkForLess(10350000));
            gui.addText(shpinel.checkForLess(8870000));
            gui.addText(korall.checkForLess(6380000));
            gui.addText(circon.checkForLess(6350000));
//            gui.addText(opal.checkForLess(2450000));
//            gui.addText(moon.checkForLess(2880000));
//            gui.addText(ember.checkForLess(690000));


            gui.addText(" ");
            System.out.println("");
            gui.addText(checkList(IDlist));
//        System.out.println("");
        System.out.println("");
        gui.addText(" ");
        gui.addText(L1000.getLowestPrice());
        gui.addText(L8000.getLowestPrice());
        gui.addText("8 x L1000 = " + myFormat.format(L1000.lowestPrice*8) + " Аден");
//
            gui.addText(" ");
            System.out.println("");
            time = LocalTime.now();
            String minute = "";
            if(time.getMinute()<=9){
                minute = "0";
            }
            minute += time.getMinute();

            gui.addText(String.format("Data Updated - %d:%s", time.getHour(), minute ));

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
                if(!res[i].isEmpty()){
                    res[i] += "      ID" + IDlist[i];
                }
            } catch (NumberFormatException ignored){}
        }
        return res;
    }

}

