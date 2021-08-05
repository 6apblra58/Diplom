package ru.netology.test.purchaseOnCredit;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;
import ru.netology.test.TestBase;

import static ru.netology.data.DataHelper.*;

public class TestCreditCardOwner extends TestBase {
    MainPage mainPage = new MainPage();
    PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    void setUpForPayWithCard(){
        mainPage.payWithCredit();
    }
    @Test
    public void shouldEmptyFieldCardOwner(){
        val cardData = getEmptyFieldCardOwner();
        paymentPage.fillCardData(cardData);
        paymentPage.shouldEmptyFieldNotification();
    }
    @Test
    public void shouldFieldCardOwnerWithCyrillic(){
        val cardData = getCardOwnerWithCyrillic();
        paymentPage.fillCardData(cardData);
        paymentPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldFieldCardOwnerWithSpecialSymbolsAndDigits(){
        val cardData = getCardOwnerWithSpecialSymbolsAndDigits();
        paymentPage.fillCardData(cardData);
        paymentPage.shouldImproperFormatNotification();
    }

}
