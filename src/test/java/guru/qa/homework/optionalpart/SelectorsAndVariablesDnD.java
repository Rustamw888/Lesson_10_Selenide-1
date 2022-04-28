package guru.qa.homework.optionalpart;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class SelectorsAndVariablesDnD {

    // Variables
    public String textA = "A";
    public String textB = "B";

    // Selectors
    SelenideElement blockA = $("#column-a");
    SelenideElement blockB = $("#column-b");

}
