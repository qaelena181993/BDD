package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private static final ElementsCollection cardList = $$(".list__item div");
    private static SelenideElement firstCardButton = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] .button");
    private static SelenideElement secondCardButton = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] .button");

    private static final String balanceStart = "баланс: ";
    private static final String balanceFinish = " р.";


    public DashboardPage() {
    }

    public static TransferPage firstButtonAction() {
        firstCardButton.click();
        return new TransferPage();
    }

    public static TransferPage secondButtonAction() {
        secondCardButton.click();
        return new TransferPage();
    }

    public static int getFirstCardBalance() {
        val text = cardList.first().text();
        return extractBalance(text);
    }

    public static int getSecondCardBalance() {
        val text = cardList.last().text();
        return extractBalance(text);
    }
    private static int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

}
