package guru.qa.homework.mainpart;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class HomeWorkMainPart extends SelectorsAndVariablesGit {

    /**
     * 1. Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт
     * разные элементы?
     * Если может - приведите пример, когда.
     *
     * Ответ:
     * 1. $("h1 div"); быстрее, чем $("h1").$("div");
     * 2. Методом проб и ошибок выяснил, что может быть разница в поиске, кстати я ломал голову над этим не только
     * на курсе, не мог понять, почему не находит элемент. Оказалось, что в случае $("h1 div"); происходит поиск
     * всей связки целиком, т.е. найдет div у которого родитель h1.
     * В случае же использования $("h1").$("div"); происходит поиск сначала первого элемента, в нашем случае h1, но
     * найдется самый первый h1 в дереве, у которого в потомках, может не оказаться div-ов, тогда элемент
     * не будет найден. Но меня смущает формулировка вопроса: "может ли привести к тому что, поиск НАЙДЕТ
     * разные элементы?", возможно я что-то упустил. Во втором случае, просто возникнет исключение NoSuchElementException,
     * а это значит, что он не нашел. Поэтому, если четко ответить на данный вопрос нет, не может найти, только попытаться)
     *
     * В качестве примера:
     *
     *     @Test
     *     public void test() {
     *         open("https://www.tutu.ru/");
     *         $("a div").hover(); --> находит
     *         $("a").$("div").hover(); --> падает с исключением NoSuchElementException
     *     }
     */

    @BeforeAll
    public static void setUp() {
        baseUrl = "https://github.com/";
    }

    @Test
    public void selenideTest() {
        open("selenide/selenide");

        wikiTab.click();
        wikiTitle.shouldHave(text(wikiTitleValue));
        filterInput.val(pageName);
        resultList.find(text(pageName)).click();
        assertionTitle.shouldHave(text(pageName)).shouldBe(visible);
        exampleBlock
                .find(text(exampleTitle))
                .sibling(0)
                .$("pre")
                .shouldHave(text(CODEEXAMPLE))
                .shouldBe(visible);
    }
}
