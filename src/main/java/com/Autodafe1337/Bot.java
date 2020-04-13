package com.Autodafe1337;


import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Bot extends TelegramLongPollingBot {

    public static void main(String[] args){
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try{
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }


    }



    public void onUpdateReceived(Update update) {

    }


    public String getBotUsername() {
        return "L2on Parser";
    }


    public String getBotToken() {
        return "1117171939:AAHulxqortz4JMbT824XaE_a3tO5l4hYH0U";
    }
}
