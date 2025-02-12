package ru.iteco.fmhandroid.ui.Object;

import static io.qameta.allure.kotlin.Allure.step;
import static ru.iteco.fmhandroid.ui.Data.Data.goAboutButtonId;
import static ru.iteco.fmhandroid.ui.Data.Data.menuButtonId;
import static ru.iteco.fmhandroid.ui.Data.Data.outAboutButtonId;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.clickButton;
import static ru.iteco.fmhandroid.ui.Data.DataHelper.waitingForElement;

import ru.iteco.fmhandroid.R;

public class AboutPage {
    public void OpenAboutPage() {
        step("Переход на страницу `О приложении`");
        waitingForElement(R.id.main_menu_image_button);
        clickButton(menuButtonId);
        clickButton(goAboutButtonId);
        waitingForElement(R.id.about_version_title_text_view);

    }

    public void clickOutButton() {
        step("Выход со страницы `О приложении`");
        waitingForElement(R.id.about_company_info_label_text_view);
        clickButton(outAboutButtonId);
    }
}
