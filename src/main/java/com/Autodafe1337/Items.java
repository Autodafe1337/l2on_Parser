package com.Autodafe1337;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Items {




    NumberFormat myFormat;
    Document doc;
    String name;
    Item[] items;
    String result;
    int lowestPrice;
    int lowestQuantity;
    int enchant;
    String lowestTime;
    int highestPrice;
    int highestQuantity;
    String highestTime;
    int len;

    public Items(String itemID){
        result = "";
        connect(itemID);
        myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);
    }

    public Items(int itemID){
        result = "";
        connect(Integer.toString(itemID));
        myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);
    }

    public Items(String itemID, String nameIn){
        result = "";
        connect(itemID);
        name = nameIn;
        myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);
    }

    public Items(int itemID, String nameIn){
        result = "";
        connect(Integer.toString(itemID));
        name = nameIn;
        myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);
    }

    public void connect(String itemID){
        try {
            doc = Jsoup.connect("http://l2on.net/?c=market&a=item&id=" + itemID + "&setworld=3502")
                    .data("query", "Java")
                    .userAgent("Mozilla")
                    .cookie("auth", "token")
                    .timeout(5000)
                    .post();
            name = doc.select("h1").text();
            enchant = -1;
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public String getLowestPrice(){

        clearItems();
        addItems("#group_sell");
        lowestPrice = 2147000000;
        for(int i = 0; i<len; i++){
            if(items[i].price<=lowestPrice){
               lowestPrice = items[i].price;
               lowestQuantity = items[i].quantity;
               lowestTime = items[i].time;
            }
        }

        if(lowestPrice != 2147000000) {
            System.out.println(String.format("Продажа: %s - %s Аден - %d штук - %s", name, myFormat.format(lowestPrice), lowestQuantity, lowestTime));
            return (String.format("Продажа: %s - %s Аден - %d штук - %s", name, myFormat.format(lowestPrice), lowestQuantity, lowestTime));
        } else return("");

    }

    public String getHighestPrice(){

        clearItems();
        addItems("#group_buy");
        highestPrice = 0;
        for(int i = 0; i<len; i++){
            if(items[i].price>=highestPrice){
                highestPrice = items[i].price;
                highestQuantity = items[i].quantity;
                highestTime = items[i].time;
            }
        }

        if(highestPrice != 0) {
            System.out.println(String.format("Покупка: %s - %s Аден - %d штук - %s", name , myFormat.format(highestPrice), highestQuantity, highestTime));
            return (String.format("Покупка: %s - %s Аден - %d штук - %s", name , myFormat.format(highestPrice), highestQuantity, highestTime));
        } else return("");

    }

    public void changeName(String nameIn){
        name = nameIn;
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
    }

    public void clearItems(){
        for(int i = 0; i<len; i++){
            items[i] = null;
            result = "";
        }
    }

    public ArrayList<String> checkForLess(int maxPrice){                        //проверяет есть ли товар дешевле

        clearItems();
        addItems("#group_sell");

        ArrayList<String> res = new ArrayList<String>();

        for(int i = 0; i<len; i++){
            if(items[i].price<maxPrice){
                System.out.println(String.format("Демпинг: %s - %s Аден - %d штук - %s", name , myFormat.format(items[i].price), items[i].quantity, items[i].time));
                res.add(String.format("Демпинг: %s - %s Аден - %d штук - %s", name, myFormat.format(items[i].price), items[i].quantity, items[i].time));


            }
        }
      return(res);
    }

    public class Item{
        public int price;
        public int quantity;
        public String time;

        public Item(int i, int j, String k){
            price = i;
            quantity = j;
            time = k;
        }


    }

}


