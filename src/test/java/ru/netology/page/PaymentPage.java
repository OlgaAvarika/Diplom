package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage {
    private static SelenideElement continueButton = $(byText("Продолжить"));

    //Поля
    private static SelenideElement numberOfCardField = $("input[placeholder='0000 0000 0000 0000']");
    private static SelenideElement monthField = $("input[placeholder='08']");
    private static SelenideElement yearField = $("input[placeholder='22']");
    private static SelenideElement cardholderField = $(byXpath("//span[text()='Владелец']/parent::span//input[@class='input__control']"));
    private static SelenideElement cvcField = $("input[placeholder='999']");

    //Уведомления
    private static SelenideElement successMessage = $(byText("Операция одобрена Банком."));
    private static SelenideElement errorMessage = $(byText("Ошибка! Банк отказал в проведении операции."));
    private static SelenideElement wrongFormat = $(byText("Неверный формат"));
    private static SelenideElement emptyField = $(byText("Поле обязательно для заполнения"));
    private static SelenideElement invalidExpirationDate = $(byText("Неверно указан срок действия карты"));
    private static SelenideElement expiredCard = $(byText("Истёк срок действия карты"));

    public static void fillOutAllFields(DataHelper.cardInfo info) {
        numberOfCardField.setValue(info.getNumberOfCard());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        cardholderField.setValue(info.getCardholder());
        cvcField.setValue(info.getCvc());
        continueButton.click();
    }
    public void clickContinueButton() {
        continueButton.click();
    }
    public static void shouldSuccessMessage() {
        successMessage.shouldBe(Condition.visible, Duration.ofSeconds(20));
    }
    public static void shouldErrorMessage() {
        errorMessage.shouldBe(Condition.visible, Duration.ofSeconds(20));
    }
    public static void shouldWrongFormatMessage() {
        wrongFormat.shouldBe(Condition.visible);
    }
    public static void shouldEmptyFieldMessage() {
        emptyField.shouldBe(Condition.visible);
    }
    public static void shouldInvalidExpirationDateMessage() {
        invalidExpirationDate.shouldBe(Condition.visible);
    }
    public static void shouldExpiredCardMessage() {
        expiredCard.shouldBe(Condition.visible);
    }

}
