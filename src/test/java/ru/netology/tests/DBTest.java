package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.codeborne.selenide.Selenide.open;

public class DBTest {
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
    @SneakyThrows
    public void shouldFillFormWithApprovedCardForPayment() {
        MainPage.getPaymentPage();
        var cardInfo = DataHelper.getApprovedNumberOfCard();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldSuccessMessage();
        var expectedStatus = "APPROVED";
        var actualStatus = SQLHelper.getApprovedStatusWhenPayment();
        assertEquals(expectedStatus, actualStatus);
    }
    @Test
    @SneakyThrows
    public void shouldFillFormWithDeclinedCardForPayment() {
        MainPage.getPaymentPage();
        var cardInfo = DataHelper.getDeclinedNumberOfCard();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldErrorMessage();
        var expectedStatus = "DECLINED";
        var actualStatus = SQLHelper.getDeclinedStatusWhenPayment();
        assertEquals(expectedStatus, actualStatus);
    }
    @Test
    @SneakyThrows
    public void shouldFillFormWithApprovedCardForCredit() {
        MainPage.getCreditPage();
        var cardInfo = DataHelper.getApprovedNumberOfCard();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldSuccessMessage();
        var expectedStatus = "APPROVED";
        var actualStatus = SQLHelper.getApprovedStatusWhenCredit();
        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    @SneakyThrows
    public void shouldFillFormWithDeclinedCardForCredit() {
        MainPage.getCreditPage();
        var cardInfo = DataHelper.getDeclinedNumberOfCard();
        PaymentPage.fillOutAllFields(cardInfo);
        PaymentPage.shouldErrorMessage();
        var expectedStatus = "DECLINED";
        var actualStatus = SQLHelper.getDeclinedStatusWhenCredit();
        assertEquals(expectedStatus, actualStatus);
    }
}