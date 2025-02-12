package ru.iteco.fmhandroid.ui.Tests;

import static ru.iteco.fmhandroid.ui.Data.Data.quotes2Text;
import static ru.iteco.fmhandroid.ui.Data.Data.quotes2Title;
import static ru.iteco.fmhandroid.ui.Data.Data.quotes3Text;
import static ru.iteco.fmhandroid.ui.Data.Data.quotes3Title;
import static ru.iteco.fmhandroid.ui.Data.Data.quotes4Text;
import static ru.iteco.fmhandroid.ui.Data.Data.quotes4Title;
import static ru.iteco.fmhandroid.ui.Data.Data.quotes5Text;
import static ru.iteco.fmhandroid.ui.Data.Data.quotes5Title;
import static ru.iteco.fmhandroid.ui.Data.Data.quotes6Text;
import static ru.iteco.fmhandroid.ui.Data.Data.quotes6Title;
import static ru.iteco.fmhandroid.ui.Data.Data.quotes7Text;
import static ru.iteco.fmhandroid.ui.Data.Data.quotes7Title;
import static ru.iteco.fmhandroid.ui.Data.Data.quotes8Text;
import static ru.iteco.fmhandroid.ui.Data.Data.quotes8Title;
import static ru.iteco.fmhandroid.ui.Data.Data.titleQuotesPage;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.checkText;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.generateScreenshotName;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.Data.Data;
import ru.iteco.fmhandroid.ui.Object.AuthorizationPage;
import ru.iteco.fmhandroid.ui.Object.QuotesPage;

@Epic("Тестирование страницы `Тематические цитаты`")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ThematicQuotesTest {
    QuotesPage quotesPage = new QuotesPage();
    Data data = new Data();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE, generateScreenshotName("Failed"));


    @Before
    public void In() {
        authorizationPage.logInCheck();
        quotesPage.goToQuotes();
    }

    @Test
    @DisplayName("Проверяем заголовок страницы")
    public void QuotesTitle() {
        checkText(titleQuotesPage);
    }

    @Test
    @DisplayName("Проверяем текст и заголовок цитаты")
    public void quotation1() {
        quotesPage.selectQuoteByPosition(0);
        quotesPage.checkQuotesText(data.quotes1Title, data.quotes1Text);
    }

    @Test
    @DisplayName("Проверяем текст и заголовок цитаты")
    public void quotation2() {
        quotesPage.selectQuoteByPosition(1);
        quotesPage.checkQuotesText(quotes2Title, quotes2Text);
    }

    @Test
    @DisplayName("Проверяем текст и заголовок цитаты")
    public void quotation3() {
        quotesPage.selectQuoteByPosition(2);
        quotesPage.checkQuotesText(quotes3Title, quotes3Text);
    }

    @Test
    @DisplayName("Проверяем текст и заголовок цитаты")
    public void quotation4() {
        quotesPage.selectQuoteByPosition(3);
        quotesPage.checkQuotesText(quotes4Title, quotes4Text);
    }

    @Test
    @DisplayName("Проверяем текст и заголовок цитаты")
    public void quotation5() {
        quotesPage.selectQuoteByPosition(4);
        quotesPage.checkQuotesText(quotes5Title, quotes5Text);
    }

    @Test
    @DisplayName("Проверяем текст и заголовок цитаты")
    public void quotation6() {
        quotesPage.selectQuoteByPosition(5);
        quotesPage.checkQuotesText(quotes6Title, quotes6Text);
    }

    @Test
    @DisplayName("Проверяем текст и заголовок цитаты")
    public void quotation7() {
        quotesPage.selectQuoteByPosition(6);
        quotesPage.checkQuotesText(quotes7Title, quotes7Text);
    }

    @Test
    @DisplayName("Проверяем текст и заголовок цитаты")
    public void quotation8() {
        quotesPage.selectQuoteByPosition(7);
        quotesPage.checkQuotesText(quotes8Title, quotes8Text);
    }
}
