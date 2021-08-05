package ru.netology.test.purchaseOnCredit;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;
import ru.netology.test.TestBase;

import static com.codeborne.selenide.Selenide.$$;
import static ru.netology.data.DataHelper.*;


public class TestCreditCardCodeCVCField extends TestBase {
    MainPage mainPage = new MainPage();
    PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    void setUpForPayWithCard() {
        mainPage.payWithCredit();
    }
    @Test
    public void shouldEmptyCodeCVC(){
        val cardData = getEmptyFieldCodeCVC();
        paymentPage.fillCardData(cardData);
        final ElementsCollection fieldSub = $$(".input__sub");
        final SelenideElement cvvFieldSub = fieldSub.get(2);
        cvvFieldSub.shouldHave(Condition.text("Поле обязательно для заполнения"));

    }

    @Test
    public void shouldInvalidCodeCVCIfOneDigit() {
        val cardData = getInvalidCodeCVCIfOneDigit();
        paymentPage.fillCardData(cardData);
        paymentPage.shouldImproperFormatNotification();

    }

    @Test
    public void shouldInvalidCodeCVCIfTwoDigit() {
        val cardData = getInvalidCodeCVCIfTwoDigit();
        paymentPage.fillCardData(cardData);
        paymentPage.shouldImproperFormatNotification();

    }
}