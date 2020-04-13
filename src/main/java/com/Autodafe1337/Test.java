package com.Autodafe1337;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Test extends Items {

    public Test(int itemID) {
        super(itemID);
    }




    public static void main(String[] args){


        Test braslet = new Test(5784);
        braslet.getLowestPrice();



    }

}
