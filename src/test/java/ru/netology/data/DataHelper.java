package ru.netology.data;

import lombok.Value;


public class DataHelper {
    @Value
    public static class CardData{
        String cardNumber;
        String month;
        String year;
        String cardOwner;
        String codeCVC;
    }

    public static CardData getApprovedCard(){
        return new CardData("4444 4444 4444 4441","11","23","Ivan Ivanov", "123");
    }

    public static CardData getDeclinedCard(){
        return new CardData("4444 4444 4444 4442","11","23","Ivan Ivanov", "123");
    }

    public static CardData getInvalidCardNumberIfLessThan16Sym(){
        return new CardData("4444 4444 4444 44","11","23","Ivan Ivanov", "123");
    }

    public static CardData getCardNumberNonRegisteredInSystem(){
        return new CardData("1234 5678 8765 4321","11","23","Ivan Ivanov", "123");
    }

    public static CardData getEmptyFields(){
        return new CardData("","","","", "");
    }

    public static CardData getEmptyFieldCardNumber(){
        return new CardData("","11","23","Ivan Ivanov", "123");
    }

    public static CardData getEmptyFieldMonth(){
        return new CardData("4444 4444 4444 4441","","23","Ivan Ivanov", "123");
    }

    public static CardData getEmptyFieldYear(){
        return new CardData("4444 4444 4444 4441","11","","Ivan Ivanov", "123");
    }

    public static CardData getEmptyFieldCardOwner(){
        return new CardData("4444 4444 4444 4441","11","23","", "123");
    }

    public static CardData getEmptyFieldCodeCVC(){
        return new CardData("4444 4444 4444 4441","11","23","Ivan Ivanov", "");
    }

    public static CardData getInvalidFieldMonthIfMore12(){
        return new CardData("4444 4444 4444 4441","15","23","Ivan Ivanov", "123");
    }

    public static CardData getInvalidFieldMonthIfZero(){
        return new CardData("4444 4444 4444 4441","0","23","Ivan Ivanov", "123");
    }
    public static CardData getInvalidFieldMonthIfOneDigit(){
        return new CardData("4444 4444 4444 4441","7","23","Ivan Ivanov", "123");
    }

    public static CardData getDateIfDistantFuture(){
        return new CardData("4444 4444 4444 4441","11","99","Ivan Ivanov", "123");
    }

    public static CardData getDateIfLessPresent(){
        return new CardData("4444 4444 4444 4441","11","12","Ivan Ivanov", "123");
    }

    public static CardData getInvalidFieldYearIfOneDigit(){
        return new CardData("4444 4444 4444 4441","11","7","Ivan Ivanov", "123");
    }

    public static CardData getCardOwnerWithCyrillic(){
        return new CardData("4444 4444 4444 4441","11","23","Иван Иванов", "123");
    }

    public static CardData getCardOwnerWithSpecialSymbolsAndDigits(){
        return new CardData("4444 4444 4444 4441","11","23","<#135!* :%$", "123");
    }

    public static CardData getInvalidCodeCVCIfOneDigit(){
        return new CardData("4444 4444 4444 4441","11","23","Ivan Ivanov", "1");
    }

    public static CardData getInvalidCodeCVCIfTwoDigit(){
        return new CardData("4444 4444 4444 4441","11","23","Ivan Ivanov", "1");
    }
}
