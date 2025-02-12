package ru.iteco.fmhandroid.ui.Object;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static io.qameta.allure.kotlin.Allure.step;
import static ru.iteco.fmhandroid.ui.Data.Data.addNewsButtonId;
import static ru.iteco.fmhandroid.ui.Data.Data.categoryAutoTextFieldId;
import static ru.iteco.fmhandroid.ui.Data.Data.childAtPosition;
import static ru.iteco.fmhandroid.ui.Data.Data.descriptionFieldId;
import static ru.iteco.fmhandroid.ui.Data.Data.editNewsButtonId;
import static ru.iteco.fmhandroid.ui.Data.Data.menuButtonId;
import static ru.iteco.fmhandroid.ui.Data.Data.newsButtonId;
import static ru.iteco.fmhandroid.ui.Data.Data.newsSaveButtonId;
import static ru.iteco.fmhandroid.ui.Data.Data.textInputFieldId;
import static ru.iteco.fmhandroid.ui.Data.Data.titleFieldId;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.clickButton;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.clickScrollToButton;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.inputText;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.waitForElement;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.waitingForElement;

import androidx.test.espresso.IdlingPolicies;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;

import java.util.concurrent.TimeUnit;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Data.DataHelper;

public class NewsPage {
    public void goToTheNews() {
        step("Переход на страницу `Новости`");
        waitingForElement(R.id.main_menu_image_button);
        clickButton(menuButtonId);
        clickButton(newsButtonId);
    }

    public void goToTheAddNews() {
        step("Переход на страницу `Добавить новость`");
        waitingForElement(R.id.edit_news_material_button);
        clickButton(editNewsButtonId);
        clickButton(addNewsButtonId);
    }

    public void selectCategory(String text) {
        step("Выбираем категорию");
        waitingForElement(R.id.text_input_end_icon);
        clickButton(textInputFieldId);
        inputText(categoryAutoTextFieldId, text);
    }

    public void deleteCategory(String text) {
        step("Удаляем категорию");
        ViewInteraction materialAutoCompleteTextView2 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view), withText(text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_category_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        materialAutoCompleteTextView2.perform(replaceText(""));
    }

    public void selectDate(String date) {
        step("Выбираем дату");
        ViewInteraction dateField = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
        dateField.perform(replaceText(date));
    }

    public void selectTime(String time) {
        step("Выбираем время");
        ViewInteraction timeField = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
        timeField.perform(replaceText(time));
    }

    public void inputDescription(String text) {
        step("Вводим описание");
        inputText(descriptionFieldId, text);
    }

    public static final void inpuTitle(String text) {
        step("Вводим заголовок");
        inputText(titleFieldId, text);
    }

    public void checkTextNewsCreated(ViewInteraction id, String text) {
        step("Проверяем текст созданной новости");
        ViewInteraction textView = id;
        textView.check(matches(withText(text)));
    }

    public void addNew(String category, String date, String time, String description, String title) {
        step("Создаем новость");
        goToTheNews();
        goToTheAddNews();
        selectCategory(category);
        selectDate(date);
        selectTime(time);
        inputDescription(description);
        inpuTitle(title);
        clickScrollToButton(newsSaveButtonId);
    }

    public void openNew(String title) {
        step("Открываем новость");
        onView(withId(R.id.news_list_recycler_view))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.scrollTo(hasDescendant(allOf(withText(title)))));
        onView(withId(R.id.news_list_recycler_view))
                .check(matches(isDisplayed()))
                .perform(actionOnItem(hasDescendant(withText(title)), click()));
        onView(allOf(withId(R.id.news_item_material_card_view), hasDescendant(withText(title))))
                .perform(DataHelper.clickChildViewWithId(R.id.edit_news_item_image_view));
    }

    public void editNew(String addNewTitlle, String deletedCategory, String category, String description, String title, String date, String time) {
        step("Редактируем новость");
        goToTheNews();
        clickButton(editNewsButtonId);
        openNew(addNewTitlle);
        deleteCategory(deletedCategory);
        selectCategory(category);
        inpuTitle(title);
        selectDate(date);
        selectTime(time);
        inputDescription(description);
        clickScrollToButton(newsSaveButtonId);
    }

    public void deleteNew(String newName) {
        step("Удаляем новость");
        goToTheNews();
        clickButton(editNewsButtonId);
        waitingForElement(R.id.news_list_recycler_view);
        onView(withId(R.id.news_list_recycler_view))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.scrollTo(hasDescendant(allOf(withText(newName)))));
        waitingForElement(R.id.news_item_material_card_view);

        onView(allOf(withId(R.id.news_item_material_card_view), hasDescendant(withText(newName))))
                .perform(DataHelper.clickChildViewWithId(R.id.delete_news_item_image_view));
        waitingForElement(android.R.id.button1);
        onView(allOf(withId(android.R.id.button1))).perform(click());

    }

    public void filterNewsByDateButton() {
        step("Фильтруем новости по дате создания");
        clickButton(onView(withId(R.id.sort_news_material_button)));
    }

    public void filterDateNews(String startDate, String endDate) {
        step("Фильтруем новости по определенным датам");
        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.filter_news_material_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container_list_news_include),
                                        0),
                                2),
                        isDisplayed()));
        materialButton2.perform(click());


        inputText(onView(allOf(withId(R.id.news_item_publish_date_start_text_input_edit_text),
                childAtPosition(childAtPosition(withId(R.id.news_item_publish_date_start_text_input_layout), 0), 1))), startDate);


        inputText(onView(allOf(withId(R.id.news_item_publish_date_end_text_input_edit_text),
                childAtPosition(childAtPosition(withId(R.id.news_item_publish_date_end_text_input_layout), 0), 1))), endDate);


        ViewInteraction filterButton = onView(
                allOf(withId(R.id.filter_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                6)));

        filterButton.perform(click());
    }
}


