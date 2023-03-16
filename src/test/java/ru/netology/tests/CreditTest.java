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

public class CreditTest {
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
    public void shouldFillFormWithApprovedCardForCreditCard() {
        MainPage.getCreditPage();
        var cardInfo = DataHelper.getApprovedNumberOfCard();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldSuccessMessage();
    }
  @Test
  public void shouldFillFormWithDeclinedCardForCreditCard() {
      MainPage.getCreditPage();
      var cardInfo = DataHelper.getDeclinedNumberOfCard();
      PaymentPage.fillOutAllFields(cardInfo);
      PaymentPage.shouldErrorMessage();
    }
  @Test
  public void shouldFillFormWithIncompleteNumberOfCardForCreditCard() {
      MainPage.getCreditPage();
      var cardInfo = DataHelper.getIncompleteNumberOfCard();
      PaymentPage.fillOutAllFields(cardInfo);
      PaymentPage.shouldWrongFormatMessage();
  }
  @Test
  public void shouldFillFormWithNextMonthForCreditCard() {
      MainPage.getCreditPage();
      var cardInfo = DataHelper.getNextMonth();
      PaymentPage.fillOutAllFields(cardInfo);
      PaymentPage.shouldSuccessMessage();
  }
    @Test
    public void shouldFillFormWithPastMonthForCreditCard() {
        MainPage.getCreditPage();
        var cardInfo = DataHelper.getPastMonth();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldInvalidExpirationDateMessage();
    }
  @Test
  public void shouldFillFormWithThirteenthMonthForCreditCard() {
      MainPage.getCreditPage();
      var cardInfo = DataHelper.getThirteenthMonth();
      PaymentPage.fillOutAllFields(cardInfo);
      PaymentPage.shouldInvalidExpirationDateMessage();
  }
    @Test
    public void shouldFillFormWithZeroMonthForCreditCard() {
        MainPage.getCreditPage();
        var cardInfo = DataHelper.getZeroMonth();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldInvalidExpirationDateMessage();
    }
    @Test
    public void shouldFillFormWithNextYearForCreditCard() {
        MainPage.getCreditPage();
        var cardInfo = DataHelper.getNextYear();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldSuccessMessage();
    }
    @Test
    public void shouldFillFormWithPastYearForCreditCard() {
        MainPage.getCreditPage();
        var cardInfo = DataHelper.getPastYear();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldExpiredCardMessage();
    }
    @Test
    public void shouldFillFormWithMoreThanFiveYearForCreditCard() {
        MainPage.getCreditPage();
        var cardInfo = DataHelper.getMoreThanFiveYear();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldInvalidExpirationDateMessage();
    }
    @Test
    public void shouldFillFormWithRussianNameOfTheCardholderForCreditCard() {
        MainPage.getCreditPage();
        var cardInfo = DataHelper.getRussianNameOfTheCardholder();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
    }
    @Test
    public void shouldFillFormWithNumbersInTheCardholderFieldForCreditCard() {
        MainPage.getCreditPage();
        var cardInfo = DataHelper.getNumbersInTheCardholderField();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
    }
    @Test
    public void shouldFillFormWithSymbolsInTheCardholderFieldForCreditCard() {
        MainPage.getCreditPage();
        var cardInfo = DataHelper.getSymbolsInTheCardholderField();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
    }
    @Test
    public void shouldFillFormWithIncompleteCvcForCreditCard() {
        MainPage.getCreditPage();
        var cardInfo = DataHelper.getIncompleteCvc();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
    }
    @Test
    public void shouldFillFormWithZeroCvcForCreditCard() {
        MainPage.getCreditPage();
        var cardInfo = DataHelper.getZeroCvc();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
    }
    @Test
    public void shouldFillFormWithEmptyNumberOfCardFieldForCreditCard() {
        MainPage.getCreditPage();
        var cardInfo = DataHelper.getEmptyNumberOfCard();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
    }
    @Test
    public void shouldFillFormWithEmptyMonthFieldForCreditCard() {
        MainPage.getCreditPage();
        var cardInfo = DataHelper.getEmptyMonth();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
    }
    @Test
    public void shouldFillFormWithEmptyYearFieldForCreditCard() {
        MainPage.getCreditPage();
        var cardInfo = DataHelper.getEmptyYear();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
    }
    @Test
    public void shouldFillFormWithEmptyCardholderFieldForCreditCard() {
        MainPage.getCreditPage();
        var cardInfo = DataHelper.getEmptyCardholder();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldEmptyFieldMessage();
    }
    @Test
    public void shouldFillFormWithEmptyCvcFieldForCreditCard() {
        MainPage.getCreditPage();
        var cardInfo = DataHelper.getEmptyCvc();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
    }
    @Test
    public void shouldFillFormWithEmptyAllFieldsForCreditCard() {
        MainPage.getCreditPage();
        var cardInfo = DataHelper.getEmptyAllFields();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldWrongFormatMessage();
        PaymentPage.shouldWrongFormatMessage();
        PaymentPage.shouldWrongFormatMessage();
        PaymentPage.shouldEmptyFieldMessage();
        PaymentPage.shouldWrongFormatMessage();
    }
}
