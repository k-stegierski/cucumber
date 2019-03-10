import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class step_definitions {
    int amount;
    int withdraw;
    @Given("^I have (\\d+) PLN on mu account$")
    public void i_have_PLN_on_mu_account(int amount) {
        this.amount = amount;
    }

    @When("^I want to withdraw (\\d+) PLN$")
    public void i_want_to_withdraw_PLN(int withdraw) {
        this.withdraw = withdraw;
    }

    @Then("^I should see error message \"([^\"]*)\"$")
    public void i_should_see_error_message(String Error_msg) {
        System.out.println(Error_msg);
        withdraw = 0;
    }

    @Then("^I should see message \"([^\"]*)\"$")
    public void i_should_see_message(String msg) {
        System.out.println(msg);
    }
    @Then("^I should see remaining ballance$")
    public void i_should_see_remaining_ballance() {
        System.out.println("You have " + (amount-withdraw) + " PLN remaining");
    }
    @Then("^I verify if (\\d+) PLN is legit$")
    public void i_verify_if_PLN_is_legit(int amount_to_verify) {
        Assert.assertTrue(amount_to_verify>=0);
    }

    @Then("^I should have (\\d+) PLN remaining on the account$")
    public void i_should_have_PLN_remaining_on_the_account(int balance) {
        Assert.assertEquals(amount-withdraw,balance);
    }
}
