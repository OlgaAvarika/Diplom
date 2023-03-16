package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.*;

import java.time.LocalDate;
import java.util.Locale;

public class DataHelper {
    private static Faker faker = new Faker(new Locale("en"));

    @Value
    public static class cardInfo {
        private String numberOfCard;
        private String month;
        private String year;
        private String cardholder;
        private String cvc;
    }
    public static String approvedNumberOfCard() {
        return "4444444444444441";
    }
    public static String declinedNumberOfCard() {
        return "4444444444444442";
    }
    public static String currentMonth() {
        LocalDate currentMonth = LocalDate.now();
        int month = currentMonth.getMonthValue();
        return String.format("%02d", month);
    }
    public static String thirteenthMonth() {
        LocalDate currentMonth = LocalDate.now();
        int between = (12 - currentMonth.getMonthValue()) + 1;
        int month = currentMonth.getMonthValue() + between;
        return String.format("%02d", month);
    }
    public static String zeroMonth() {
        LocalDate currentMonth = LocalDate.now();
        int month = currentMonth.getMonthValue()-currentMonth.getMonthValue();
        return String.format("%02d", month);
    }
    public static String pastMonth() {
        LocalDate currentMonth = LocalDate.now();
        int month = currentMonth.getMonthValue() - 1;
        return String.format("%02d", month);
    }
    public static String nextMonth() {
        LocalDate currentMonth = LocalDate.now();
        int month = currentMonth.getMonthValue() + 1;
        return String.format("%02d", month);
    }
    public static String currentYear() {
        LocalDate currentYear = LocalDate.now();
        int year = currentYear.getYear() - 2000;
        return Integer.toString(year);
    }
    public static String pastYear() {
        LocalDate currentYear = LocalDate.now();
        int year = currentYear.getYear() - 2001;
        return Integer.toString(year);
    }
    public static String nextYear() {
        LocalDate currentYear = LocalDate.now();
        int year = currentYear.getYear() - 1999;
        return Integer.toString(year);
    }
    public static String moreThanFiveYear() {
        LocalDate currentYear = LocalDate.now();
        int year = currentYear.getYear() - 1994;
        return Integer.toString(year);
    }
    public static String cardholder() {
        return faker.name().fullName();
    }
    public static String cvc() {
        return faker.number().digits(3);
    }
    public static String incompleteCvc() {
        return faker.number().digits(2);
    }

    public static cardInfo getApprovedNumberOfCard() {
        return new cardInfo(approvedNumberOfCard(), currentMonth(), currentYear(), cardholder(), cvc());
    }
    public static cardInfo getDeclinedNumberOfCard() {
        return new cardInfo(declinedNumberOfCard(), currentMonth(), currentYear(), cardholder(), cvc());
    }
    public static cardInfo getIncompleteNumberOfCard() {
        return new cardInfo("444444444444", currentMonth(), currentYear(), cardholder(), cvc());
    }
    public static cardInfo getNextMonth() {
        return new cardInfo(approvedNumberOfCard(), nextMonth(), currentYear(), cardholder(), cvc());
    }
    public static cardInfo getPastMonth() {
        return new cardInfo(approvedNumberOfCard(), pastMonth(), currentYear(), cardholder(), cvc());
    }
    public static cardInfo getZeroMonth() {
        return new cardInfo(approvedNumberOfCard(), zeroMonth(), currentYear(), cardholder(), cvc());
    }
    public static cardInfo getThirteenthMonth() {
        return new cardInfo(approvedNumberOfCard(), thirteenthMonth(), currentYear(), cardholder(), cvc());
    }
    public static cardInfo getNextYear() {
        return new cardInfo(approvedNumberOfCard(), currentMonth(), nextYear(), cardholder(), cvc());
    }
    public static cardInfo getPastYear() {
        return new cardInfo(approvedNumberOfCard(), currentMonth(), pastYear(), cardholder(), cvc());
    }
    public static cardInfo getIncompleteCvc() {
        return new cardInfo(approvedNumberOfCard(), currentMonth(), currentYear(), cardholder(), incompleteCvc());
    }
    public static cardInfo getRussianNameOfTheCardholder() {
        return new cardInfo(approvedNumberOfCard(), currentMonth(), currentYear(), "Иванов Иван", cvc());
    }
    public static cardInfo getNumbersInTheCardholderField() {
        return new cardInfo(approvedNumberOfCard(), currentMonth(), currentYear(), "12345", cvc());
    }
    public static cardInfo getSymbolsInTheCardholderField() {
        return new cardInfo(approvedNumberOfCard(), currentMonth(), currentYear(), "$%@#&*", cvc());
    }
    public static cardInfo getMoreThanFiveYear() {
        return new cardInfo(approvedNumberOfCard(), currentMonth(), moreThanFiveYear(), cardholder(), cvc());
    }
    public static cardInfo getZeroCvc() {
        return new cardInfo(approvedNumberOfCard(), currentMonth(), currentYear(), cardholder(), "000");
    }
    public static cardInfo getEmptyAllFields() {
        return new cardInfo("", "", "", "", "");
    }
    public static cardInfo getEmptyNumberOfCard()  {
        return new cardInfo("", currentMonth(), currentYear(), cardholder(), cvc());
    }
    public static cardInfo getEmptyMonth() {
        return new cardInfo(approvedNumberOfCard(), "", currentYear(), cardholder(), cvc());
    }
    public static cardInfo getEmptyYear() {
        return new cardInfo(approvedNumberOfCard(), currentMonth(), "", cardholder(), cvc());
    }
    public static cardInfo getEmptyCardholder() {
        return new cardInfo(approvedNumberOfCard(), currentMonth(), currentYear(), "", cvc());
    }
    public static cardInfo getEmptyCvc() {
        return new cardInfo(approvedNumberOfCard(), currentMonth(), currentYear(), cardholder(), "");
    }
}
