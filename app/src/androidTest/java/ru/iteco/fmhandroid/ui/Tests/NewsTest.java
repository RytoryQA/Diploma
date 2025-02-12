package ru.iteco.fmhandroid.ui.Tests;

import static ru.iteco.fmhandroid.ui.Data.Data.categorySalary;
import static ru.iteco.fmhandroid.ui.Data.Data.categoryTradeUnion;
import static ru.iteco.fmhandroid.ui.Data.Data.createdEditNewsId;
import static ru.iteco.fmhandroid.ui.Data.Data.createdEditNewsId2;
import static ru.iteco.fmhandroid.ui.Data.Data.deskriptionAddNew;
import static ru.iteco.fmhandroid.ui.Data.Data.deskriptionEditNew;
import static ru.iteco.fmhandroid.ui.Data.Data.editNewsButtonId2;
import static ru.iteco.fmhandroid.ui.Data.Data.emptyValue;
import static ru.iteco.fmhandroid.ui.Data.Data.localDateToStr;
import static ru.iteco.fmhandroid.ui.Data.Data.localDateToStrAfter;
import static ru.iteco.fmhandroid.ui.Data.Data.newCancelButtonId;
import static ru.iteco.fmhandroid.ui.Data.Data.newOkButtonId;
import static ru.iteco.fmhandroid.ui.Data.Data.timeAddNew;
import static ru.iteco.fmhandroid.ui.Data.Data.timeEditNew;
import static ru.iteco.fmhandroid.ui.Data.Data.titleAddNew;
import static ru.iteco.fmhandroid.ui.Data.Data.titleEditNew;
import static ru.iteco.fmhandroid.ui.Data.Data.toastEmptyFields;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.checkToasts;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.clickButton;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.generateScreenshotName;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.waitingForElement;

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
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.Object.AuthorizationPage;
import ru.iteco.fmhandroid.ui.Object.NewsPage;

@Epic("Тестирование страницы: создания, реадктирования и фильтрации новостей")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsTest {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    NewsPage newsPage = new NewsPage();
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE, generateScreenshotName("Failed"));


    @Before
    public void In() {
        authorizationPage.logInCheck();
    }


    @Test
    @DisplayName("Создание новости")
    public void addNews() {
        newsPage.addNew(categorySalary, localDateToStr, timeAddNew, deskriptionAddNew, titleAddNew);
        newsPage.checkTextNewsCreated(createdEditNewsId, titleAddNew);
    }
    @Test
    @DisplayName("Редактирование новости")
    public void editNews() {
        newsPage.editNew(titleAddNew, categorySalary, categoryTradeUnion,
                deskriptionEditNew, titleEditNew, localDateToStrAfter, timeEditNew);
        newsPage.checkTextNewsCreated(createdEditNewsId2, titleEditNew);
    }
    @Test
    @DisplayName("Удаление новости")
    public void deleteNews() {
        newsPage.deleteNew(titleEditNew);
        waitingForElement(R.id.news_list_recycler_view);
    }


    @Test
    @DisplayName("Поля при создании новости не заполнены")
    public void fieldsAreNotFilled() {
        newsPage.addNew(emptyValue, emptyValue, emptyValue, emptyValue, emptyValue);
        checkToasts(toastEmptyFields);
        clickButton(newCancelButtonId);
        clickButton(newOkButtonId);
    }

    @Test
    @DisplayName("Фильтруем новости по дате создания")
    public void filterByDateButton() {
        newsPage.goToTheNews();
        newsPage.filterNewsByDateButton();
    }

    @Test
    @DisplayName("Фильтруем новости по определенной дате")
    public void filterDate() {
        newsPage.goToTheNews();
        newsPage.filterDateNews(localDateToStr, localDateToStrAfter);
    }

    @Test
    @DisplayName("Фильтруем новости на контрольной панели по дате создания")
    public void filterByDateButtonControlPanel() {
        newsPage.goToTheNews();
        waitingForElement(R.id.edit_news_material_button);
        clickButton(editNewsButtonId2);
        newsPage.filterNewsByDateButton();
    }
}
