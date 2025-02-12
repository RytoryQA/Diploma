package ru.iteco.fmhandroid.ui.Object;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static io.qameta.allure.kotlin.Allure.step;
import static ru.iteco.fmhandroid.ui.Data.Data.quotesButtonId;
import static ru.iteco.fmhandroid.ui.Data.Data.selectQuoteByPositionId;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.checkText;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.clickButton;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.waitingForElement;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class QuotesPage {
    public void goToQuotes() {
        step("Переход на страницу `Тематические цитаты`");
        waitingForElement(R.id.our_mission_image_button);
        clickButton(quotesButtonId);

    }

    public void checkQuotesText(String tittle, String text) {
        step("Проверка текста и заголовка цитаты");
        checkText(tittle);
        checkText(text);

    }

    public void selectQuoteByPosition(int position) {
        step("Выбор цитаты по позиции");
        ViewInteraction recyclerView = selectQuoteByPositionId;
        recyclerView.perform(actionOnItemAtPosition(position, click()));

    }
}
