package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;

import static com.codeborne.selenide.Selenide.open;

public class PaymentTest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
    @BeforeEach
    void start() {
        open("http://localhost:8080");
    }

    @Test
    public void shouldFillFormWithApprovedCard() {
        MainPage.getPaymentPage();
        var cardInfo = DataHelper.getApprovedNumberOfCard();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldSuccessMessage();
    }
   @Test
   public void shouldFillFormWithDeclinedCard() {
       MainPage.getPaymentPage();
       var cardInfo = DataHelper.getDeclinedNumberOfCard();
       PaymentPage.fillOutAllFields(cardInfo);
       PaymentPage.shouldErrorMessage();
    }
   @Test
   public void shouldFillFormWithIncompleteNumberOfCard() {
       MainPage.getPaymentPage();
       var cardInfo = DataHelper.getIncompleteNumberOfCard();
       PaymentPage.fillOutAllFields(cardInfo);
       PaymentPage.shouldWrongFormatMessage();
   }
   @Test
   public void shouldFillFormWithNextMonth() {
       MainPage.getPaymentPage();
       var cardInfo = DataHelper.getNextMonth();
       PaymentPage.fillOutAllFields(cardInfo);
       PaymentPage.shouldSuccessMessage();
   }
    @Test
    public void shouldFillFormWithPastMonth() {
        MainPage.getPaymentPage();
        var cardInfo = DataHelper.getPastMonth();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldInvalidExpirationDateMessage();
    }
   @Test
   public void shouldFillFormWithThirteenthMonth() {
       MainPage.getPaymentPage();
       var cardInfo = DataHelper.getThirteenthMonth();
       PaymentPage.fillOutAllFields(cardInfo);
       PaymentPage.shouldInvalidExpirationDateMessage();
   }
    @Test
    public void shouldFillFormWithZeroMonth() {
        MainPage.getPaymentPage();
        var cardInfo = DataHelper.getZeroMonth();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldInvalidExpirationDateMessage();
    }
    @Test
    public void shouldFillFormWithNextYear() {
        MainPage.getPaymentPage();
        var cardInfo = DataHelper.getNextYear();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldSuccessMessage();
    }
    @Test
    public void shouldFillFormWithPastYear() {
        MainPage.getPaymentPage();
        var cardInfo = DataHelper.getPastYear();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldExpiredCardMessage();
    }
    @Test
    public void shouldFillFormWithMoreThanFiveYear() {
        MainPage.getPaymentPage();
        var cardInfo = DataHelper.getMoreThanFiveYear();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldInvalidExpirationDateMessage();
    }
    @Test
    public void shouldFillFormWithRussianNameOfTheCardholder() {
        MainPage.getPaymentPage();
        var cardInfo = DataHelper.getRussianNameOfTheCardholder();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
    }
    @Test
    public void shouldFillFormWithNumbersInTheCardholderField() {
        MainPage.getPaymentPage();
        var cardInfo = DataHelper.getNumbersInTheCardholderField();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
    }
    @Test
    public void shouldFillFormWithSymbolsInTheCardholderField() {
        MainPage.getPaymentPage();
        var cardInfo = DataHelper.getSymbolsInTheCardholderField();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
    }
    @Test
    public void shouldFillFormWithIncompleteCvc() {
        MainPage.getPaymentPage();
        var cardInfo = DataHelper.getIncompleteCvc();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
    }
    @Test
    public void shouldFillFormWithZeroCvc() {
        MainPage.getPaymentPage();
        var cardInfo = DataHelper.getZeroCvc();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
    }
    @Test
    public void shouldFillFormWithEmptyNumberOfCardField() {
        MainPage.getPaymentPage();
        var cardInfo = DataHelper.getEmptyNumberOfCard();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
    }
    @Test
    public void shouldFillFormWithEmptyMonthField() {
        MainPage.getPaymentPage();
        var cardInfo = DataHelper.getEmptyMonth();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
    }
    @Test
    public void shouldFillFormWithEmptyYearField() {
        MainPage.getPaymentPage();
        var cardInfo = DataHelper.getEmptyYear();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
    }
    @Test
    public void shouldFillFormWithEmptyCardholderField() {
        MainPage.getPaymentPage();
        var cardInfo = DataHelper.getEmptyCardholder();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldEmptyFieldMessage();
    }
    @Test
    public void shouldFillFormWithEmptyCvcField() {
        MainPage.getPaymentPage();
        var cardInfo = DataHelper.getEmptyCvc();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
    }
    @Test
    public void shouldFillFormWithEmptyAllFields() {
        MainPage.getPaymentPage();
        var cardInfo = DataHelper.getEmptyAllFields();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
        PaymentPage.shouldWrongFormatMessage();
        PaymentPage.shouldWrongFormatMessage();
        PaymentPage.shouldEmptyFieldMessage();
        PaymentPage.shouldWrongFormatMessage();
    }
}
