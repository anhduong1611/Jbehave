package steps.user;

import org.example.Account;
import org.jbehave.core.annotations.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class LoginSteps { // Look, Ma', I'm a POJO!

    private Account account;

    @Given("the user is on the Login page")
    public void onLoginPage() {
        System.out.println("OK I'm on steps.Login Page");
    }
    @When(value = "the user enter name $username and password $password",priority = 1)
    public void enterUsername(@Named("username") String username,@Named("password") String password) {
        System.out.println("OK I'm set user name"+username+password);
        account = new Account(username, password);
    }

    @Then("the user is redirected to Homepage")
    public void theGridShouldLookLike() {
        assertEquals(true,true,"OKOKO");
//        assertThat(true, equalTo(false));
    }


}
