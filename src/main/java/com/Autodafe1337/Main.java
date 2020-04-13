package com.Autodafe1337;


public class Main {

    

    public static void main(String[] args){
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
        int[] IDlist = {91303, 49703, 90555, 90556, 90557, 90558, 90559, 90560, 90561, 90562, 90563, 93633, 49996,  91168, 91169,
                91170, 91167, 91166, 91303, 91166, 91167, 91168, 5784, 45481};



//        gui.addText(korall.checkForLess(3900000));

        gui.addText(moon.getLowestPrice());
        gui.addText(moon.getHighestPrice());



//        gui.addText(korall.getLowestPrice());
//        gui.addText(circon.getLowestPrice());
//
//        gui.addText(ember.getLowestPrice());

        gui.addText(" ");
        System.out.println("");
        gui.addText(checkList(IDlist));
//        System.out.println("");
//        shpinel.getLowestPrice();
//        korall.getLowestPrice();
//        circon.getLowestPrice();
//        moon.getLowestPrice();
//        System.out.println("");
//        L1000.getLowestPrice();
//        L8000.getLowestPrice();
//
        gui.addText(" ");
        System.out.println("");
//        gui.addText(circon.checkForLess(7400000));
//        gui.addText(ember.checkForLess(500000));

//        gui.addText(shpinel.getLowestPrice());
//        gui.addText(opal.getLowestPrice());
//        gui.addText(onyx.getLowestPrice());
//        gui.addText(onyx.getHighestPrice());

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

