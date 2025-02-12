package ru.iteco.fmhandroid.ui.Tests;

import static ru.iteco.fmhandroid.ui.Data.Data.devMark;
import static ru.iteco.fmhandroid.ui.Data.Data.privacyPolicyLink;
import static ru.iteco.fmhandroid.ui.Data.Data.termsOfUseLink;
import static ru.iteco.fmhandroid.ui.Data.Data.textLinkPrivacyPolicy;
import static ru.iteco.fmhandroid.ui.Data.Data.textLinkTermsOfUse;
import static ru.iteco.fmhandroid.ui.Data.Data.textNumVersion;
import static ru.iteco.fmhandroid.ui.Data.Data.textPrivacyPolicy;
import static ru.iteco.fmhandroid.ui.Data.Data.textTermsOfUse;
import static ru.iteco.fmhandroid.ui.Data.Data.textVersion;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.checkIsDisplayed;
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
import ru.iteco.fmhandroid.ui.Object.AboutPage;
import ru.iteco.fmhandroid.ui.Object.AuthorizationPage;

@Epic("Тестирование страницы `О приложении`")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AboutTest {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    AboutPage aboutPage = new AboutPage();
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE, generateScreenshotName("Failed"));

    @Before
    public void In() {
        authorizationPage.logInCheck();
        aboutPage.OpenAboutPage();
    }

    @Test
    @DisplayName("Отображение сведений о версии приложения")
    public void checkTexts() {
        checkIsDisplayed(devMark);
        checkText(textVersion);
        checkText(textNumVersion);
        checkText(textPrivacyPolicy);
        checkText(textTermsOfUse);
    }

    @Test
    @DisplayName("Отображение ссылок")
    public void checkLinks() {
        checkIsDisplayed(privacyPolicyLink);
        checkText(textLinkPrivacyPolicy);
        checkIsDisplayed(termsOfUseLink);
        checkText(textLinkTermsOfUse);
    }
}
