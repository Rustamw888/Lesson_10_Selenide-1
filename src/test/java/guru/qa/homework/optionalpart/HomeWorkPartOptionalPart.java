package guru.qa.homework.optionalpart;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class HomeWorkPartOptionalPart extends SelectorsAndVariablesDnD {

    @BeforeAll
    public static void setUp() {
        baseUrl = "https://the-internet.herokuapp.com/";
    }

    @Test
    @DisplayName("Selenide dragAndDrop method using")
    public void dragAndDropTestWithSelenideMethod() {
        step("Current page opening", () -> {
            open("drag_and_drop");
        });
        step("Checking the positions of elements BEFORE the transfer", () -> {
            blockA.shouldHave(text(textA)).shouldBe(visible);
            blockB.shouldHave(text(textB)).shouldBe(visible);
        });
        step("Item transfer", () -> {
            blockA.dragAndDropTo(blockB);
        });
        step("Checking the positions of elements AFTER the transfer", () -> {
            blockA.shouldHave(text(textB)).shouldBe(visible);
            blockB.shouldHave(text(textA)).shouldBe(visible);
        });
    }


    // Пробовал различные комбинации, в том числе через offset, не проходит перемещение.
    @Test
    public void dragAndDropTestWithActionMethodFirst() {
        step("Current page opening", () -> {
            open("drag_and_drop");
        });
        step("Checking the positions of elements BEFORE the transfer", () -> {
            blockA.shouldHave(text(textA)).shouldBe(visible);
            blockB.shouldHave(text(textB)).shouldBe(visible);
        });
        step("Item transfer", () -> {
            actions()
                    .moveToElement(blockA)
                    .clickAndHold()
                    .release()
                    .moveToElement(blockB)
                    .release()
                    .perform();
        });
        step("Checking the positions of elements AFTER the transfer", () -> {
            blockA.shouldHave(text(textB)).shouldBe(visible);
            blockB.shouldHave(text(textA)).shouldBe(visible);
        });
    }

    @Test
    public void dragAndDropTestWithActionMethodSecond() {
        step("Current page opening", () -> {
            open("drag_and_drop");
        });
        step("Checking the positions of elements BEFORE the transfer", () -> {
            blockA.shouldHave(text(textA)).shouldBe(visible);
            blockB.shouldHave(text(textB)).shouldBe(visible);
        });
        step("Item transfer", () -> {
            actions().moveToElement(blockB).clickAndHold().moveByOffset(543, 0).release().perform();
        });
        step("Checking the positions of elements AFTER the transfer", () -> {
            blockA.shouldHave(text(textB)).shouldBe(visible);
            blockB.shouldHave(text(textA)).shouldBe(visible);
        });
    }
}
