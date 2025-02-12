package ru.iteco.fmhandroid.ui.Object;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static io.qameta.allure.kotlin.Allure.step;
import static ru.iteco.fmhandroid.ui.Data.Data.enterButtonId;
import static ru.iteco.fmhandroid.ui.Data.Data.logOutButtonId1;
import static ru.iteco.fmhandroid.ui.Data.Data.logOutButtonId2;
import static ru.iteco.fmhandroid.ui.Data.Data.loginId;
import static ru.iteco.fmhandroid.ui.Data.Data.passwordId;
import static ru.iteco.fmhandroid.ui.Data.Data.validLogin;
import static ru.iteco.fmhandroid.ui.Data.Data.validPassword;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.clickButton;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.inputText;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.waitForElement;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.waitingForElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class AuthorizationPage {
    public void LogIn() {
        step("Вход в аккаунт");
        waitingForElement(R.id.login_text_input_layout);
        inputText(loginId, validLogin);
        inputText(passwordId, validPassword);
        clickButton(enterButtonId);

    }

    public void LogOut() {
        step("Выход из аккаунта]");
        clickButton(logOutButtonId1);
        clickButton(logOutButtonId2);
    }

    public void logInCheck() {
        Allure.step("Загрузка приложения");
        onView(isRoot()).perform(waitForElement(withId(R.id.splashscreen_image_view), 5000));
        try {
            Allure.step("Загрузка страницы");
            onView(isRoot()).perform(waitForElement(withText("News"), 5000));
        } catch (Exception e) {
            LogIn();
        } finally {
            Allure.step("Загрузка страницы");
            onView(isRoot()).perform(waitForElement(withText("News"), 5000));
        }
    }
    public void logOutCheck() {
        try {
            Allure.step("Загрузка страницы");
            onView(isRoot()).perform(waitForElement(withId(R.id.login_text_input_layout), 5000));
        } catch (Exception e) {
            LogOut();
        }
    }
}
