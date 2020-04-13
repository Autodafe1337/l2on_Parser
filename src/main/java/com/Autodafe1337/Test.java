package com.Autodafe1337;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Test extends Items {

    public Test(int itemID) {
        super(itemID);
    }

    public void addItems(String query){
        Elements sell = doc.select(query);
        Elements tr = sell.select(".fresh");
        len = tr.size();
        items = new Item[len];

        for(int i = 0; i<len; i++){
            int j = Integer.parseInt(tr.eq(i).select(".right").eq(0).attr("order"));      //цена
            int k;
            int m = 3;
            if(tr.eq(i).select(".right").eq(1).isEmpty()){
                k = 1;
                m = 2;
            }else{
                k = Integer.parseInt(tr.eq(i).select(".right").eq(1).attr("order"));      //количество
            }

            if(sell.select("thead").select("th").eq(3).text().equals("Мод.")){
                System.out.println("mod found");
            }


            String l = tr.eq(i).select("td").eq(m).text();                                           //дата

            items[i] = new Item(j, k, l);
        }
        System.out.println(sell.select("thead").select("th").eq(2).text());
    }


    public static void main(String[] args){


        Test braslet = new Test(5784);
        braslet.getLowestPrice();



    }

}
