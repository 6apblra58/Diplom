package ru.netology.test.purchaseOnCredit;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;
import ru.netology.test.TestBase;


import static ru.netology.data.DataHelper.*;

public class TestCreditValidCards extends TestBase {
    MainPage mainPage = new MainPage();
    PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    void setUpForPayWithCard(){
        mainPage.payWithCredit();
    }
    @Test
    public void shouldSuccessPayIfValidApprovedCards() {
        val cardData = getApprovedCard();
        paymentPage.fillCardData(cardData);
        paymentPage.shouldSuccessNotification();

    }

    @Test
    public void shouldFailurePayIfValidDeclinedCards() {
        val cardData = getDeclinedCard();
        paymentPage.fillCardData(cardData);
        paymentPage.shouldFailureNotification();

    }
}