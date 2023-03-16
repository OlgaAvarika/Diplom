package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private static SelenideElement paymentButton = $$(".button").find(exactText("Купить"));
    private static SelenideElement paymentButtonInCredit = $$(".button").find(exactText("Купить в кредит"));

    public static PaymentPage getPaymentPage() {
        paymentButton.click();
        return new PaymentPage();
    }
    public static PaymentPage getCreditPage() {
        paymentButtonInCredit.click();
        return new PaymentPage();
    }

}
