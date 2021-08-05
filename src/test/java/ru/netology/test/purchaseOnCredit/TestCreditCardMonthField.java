package ru.netology.test.purchaseOnCredit;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;
import ru.netology.test.TestBase;

import static ru.netology.data.DataHelper.*;


public class TestCreditCardMonthField extends TestBase {
    MainPage mainPage = new MainPage();
    PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    void setUpForPayWithCreditCard() {
        mainPage.payWithCredit();
    }

    @Test
    public void shouldEmptyMonthField() {
        val cardData = getEmptyFieldMonth();
        paymentPage.fillCardData(cardData);
        paymentPage.shouldEmptyFieldNotification();
    }

    @Test
    public void shouldInvalidFieldMonthIfMore12() {
        val cardData = getInvalidFieldMonthIfMore12();
        paymentPage.fillCardData(cardData);
        paymentPage.shouldInvalidExpiredDateNotification();
    }

    @Test
    public void shouldInvalidFieldMonthIfZero() {
        val cardData = getInvalidFieldMonthIfZero();
        paymentPage.fillCardData(cardData);
        paymentPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldInvalidFieldMonthIfOneDigit() {
        val cardData = getInvalidFieldMonthIfOneDigit();
        paymentPage.fillCardData(cardData);
        paymentPage.shouldImproperFormatNotification();
    }
}