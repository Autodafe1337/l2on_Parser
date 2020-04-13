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
    String lowestQuantity;
    int enchant;
    String lowestTime;
    int highestPrice;
    String highestQuantity;
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

            name = doc.select("h1").textNodes().get(0).text();
            if(!doc.select("h1").select("span").isEmpty()){
                name +=doc.select("h1").select("span").eq(0).text();
            }


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
        String newName = name;
        for(int i = 0; i<len; i++){

            if(items[i].price<=lowestPrice){
                if(enchant == 1){
                    newName = name + " +" + items[i].quantityOrEnchant;
                }
               lowestPrice = items[i].price;
               lowestQuantity = items[i].quantityOrEnchantStr;
               lowestTime = items[i].time;
            }
        }

        if(lowestPrice != 2147000000) {

            System.out.println(String.format("Продажа: %s - %s Аден%s - %s", newName, myFormat.format(lowestPrice), lowestQuantity, lowestTime));
            return (String.format("Продажа: %s - %s Аден%s - %s", name, myFormat.format(lowestPrice), lowestQuantity, lowestTime));
        } else return("");

    }

    public String getHighestPrice(){

        clearItems();
        addItems("#group_buy");
        highestPrice = 0;
        String newName = name;
        for(int i = 0; i<len; i++){
            if(items[i].price>=highestPrice){
                if(enchant == 1){
                    newName = name + " +" + items[i].quantityOrEnchant;
                }
                highestPrice = items[i].price;
                highestQuantity = items[i].quantityOrEnchantStr;
                highestTime = items[i].time;
            }
        }

        if(highestPrice != 0) {
            System.out.println(String.format("Покупка: %s - %s Аден%s - %s", newName , myFormat.format(highestPrice), highestQuantity, highestTime));
            return (String.format("Покупка: %s - %s Аден%s - %s", newName , myFormat.format(highestPrice), highestQuantity, highestTime));
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

        if(sell.select("thead").select("th").eq(2).text().equals("Мод.")){
            enchant = 0;
        }

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

            int n = enchant;

            if(enchant!=-1 && !tr.eq(i).select(".right").eq(1).attr("order").equals("0")){
                enchant = 1;
            }



            String l = tr.eq(i).select("td").eq(m).text();                                           //дата


            items[i] = new Item(j, k, l, n);
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
        String newName = name;
        for(int i = 0; i<len; i++){

            if(items[i].price<maxPrice){
                if(enchant == 1){
                    newName = name + " +" + items[i].quantityOrEnchant;
                }

                System.out.println(String.format("Демпинг: %s - %s Аден%s - %s", newName , myFormat.format(items[i].price), items[i].quantityOrEnchantStr, items[i].time));
                res.add(String.format("Демпинг: %s - %s Аден%s - %s", newName, myFormat.format(items[i].price), items[i].quantityOrEnchantStr, items[i].time));


            }
        }
      return(res);
    }

    public class Item{
        public int price;
        public int quantityOrEnchant;
        public String time;
        public int enchant;
        public String quantityOrEnchantStr;


        public Item(int priceIn, int quantityIn, String timeIn, int enchantIn){
            price = priceIn;
            quantityOrEnchant = quantityIn;
            time = timeIn;
            enchant = enchantIn;

            if(enchant==-1){
                quantityOrEnchantStr = String.format(" - %d штук", quantityOrEnchant);
                if (quantityOrEnchant==1){
                    quantityOrEnchantStr = "";
                }
            } else if(enchant==0){
                quantityOrEnchantStr = "";
            } else if(enchant==1){
                quantityOrEnchantStr = "";
            }




        }


    }

}


