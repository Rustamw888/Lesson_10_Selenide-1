package guru.qa.homework.mainpart;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelectorsAndVariablesGit {

    // Variables
    public final String CODEEXAMPLE = "@ExtendWith({SoftAssertsExtension.class})\n" +
            "class Tests {\n" +
            "  @Test\n" +
            "  void test() {\n" +
            "    Configuration.assertionMode = SOFT;\n" +
            "    open(\"page.html\");\n" +
            "\n" +
            "    $(\"#first\").should(visible).click();\n" +
            "    $(\"#second\").should(visible).click();\n" +
            "  }\n" +
            "}";
    public String wikiTitleValue = "Welcome to the selenide wiki!";
    public String pageName = "SoftAssertions";
    public String exampleTitle = "3. Using JUnit5 extend test class:";

    // Selectors
    SelenideElement wikiTab = $("#wiki-tab");
    SelenideElement wikiTitle = $(".markdown-body h1");
    SelenideElement filterInput = $("#wiki-pages-filter");
    ElementsCollection resultList = $$("summary a");
    SelenideElement assertionTitle = $("div>h1");
    ElementsCollection exampleBlock = $$(".markdown-body h4");
}
