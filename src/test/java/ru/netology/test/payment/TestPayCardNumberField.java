package ru.netology.test.payment;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;
import ru.netology.test.TestBase;

import static ru.netology.data.DataHelper.*;

public class TestPayCardNumberField extends TestBase {
   MainPage mainPage = new MainPage();
   PaymentPage paymentPage = new PaymentPage();

   @BeforeEach
    void setUpForPayWithCard(){
       mainPage.payWithCard();
   }
   @Test
    public void shouldFailurePaymentIfEmptyCardNumber(){
       val cardData = getEmptyFieldCardNumber();
       paymentPage.fillCardData(cardData);
       paymentPage.shouldEmptyFieldNotification();
   }
   @Test
   public void shouldFailurePaymentIfCardNumberLess16Sym(){
      val cardData = getInvalidCardNumberIfLessThan16Sym();
      paymentPage.fillCardData(cardData);
      paymentPage.shouldImproperFormatNotification();
   }
   @Test
   public void shouldFailurePaymentIfCardNumberNonRegistered(){
      val cardData = getCardNumberNonRegisteredInSystem();
      paymentPage.fillCardData(cardData);
      paymentPage.shouldFailureNotification();
   }
}
