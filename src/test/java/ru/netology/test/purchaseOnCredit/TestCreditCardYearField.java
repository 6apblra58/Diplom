package ru.netology.test.purchaseOnCredit;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;
import ru.netology.test.TestBase;

import static ru.netology.data.DataHelper.*;

public class TestCreditCardYearField extends TestBase {
    MainPage mainPage = new MainPage();
    PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    void setUpForPayWithCard(){
        mainPage.payWithCredit();
    }

    @Test
    public void shouldEmptyFieldYear(){
        val cardData = getEmptyFieldYear();
        paymentPage.fillCardData(cardData);
        paymentPage.shouldEmptyFieldNotification();
    }

    @Test
    public void shouldDateIfLessPresent(){
        val cardData = getDateIfLessPresent();
        paymentPage.fillCardData(cardData);
        paymentPage.shouldExpiredDatePassNotification();
    }
    @Test
    public void shouldDateIfDistantFuture(){
        val cardData = getDateIfDistantFuture();
        paymentPage.fillCardData(cardData);
        paymentPage.shouldInvalidExpiredDateNotification();
    }
    @Test
    public void shouldInvalidFieldYearIfOneDigit(){
        val cardData = getInvalidFieldYearIfOneDigit();
        paymentPage.fillCardData(cardData);
        paymentPage.shouldImproperFormatNotification();
    }
}