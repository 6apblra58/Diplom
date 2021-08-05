package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement heading = $$(".heading").find(exactText("Путешествие дня"));
    private static final SelenideElement payWithCardButton = $$("button").find(exactText("Купить"));
    private static final SelenideElement payWithCreditButton = $$("button").find(exactText("Купить в кредит"));

    public void payWithCard(){
        payWithCardButton.click();
    }

    public void payWithCredit(){
        payWithCreditButton.click();
    }
}
