package steps.phone;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.lang.reflect.Array;
import java.util.List;

public class PracticeSteps {
    @Given("I am $name and $age years old")
    public void givenIAmAnhduongAndYearsOld(String name,int age) {
        System.out.println("Yes, I am "+name+" and "+age+" years old");
    }

    @When("I enter array $array number")
    public void whenIEnterArratNumber(List<Integer> double1) {
        int sum = 0;
        for (int i = 0; i < double1.size(); i++) {
            sum += double1.get(i);
        }
        System.out.println("Oh, I entered "+double1 +"and sum = " +sum   );
    }

    @Then("System say hello $name")
    public void thenSystemSayHelloAnhduong(String name) {
        System.out.println("Hello "+name);
    }
}
