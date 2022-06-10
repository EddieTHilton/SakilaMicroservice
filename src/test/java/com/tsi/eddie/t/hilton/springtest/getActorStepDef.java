package com.tsi.eddie.t.hilton.springtest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Test;


public class getActorStepDef {

    //@Test
    int actor_id;

    @Given("I have actor id")
    public void i_have_actor_id() {
        // Write code here that turns the phrase above into concrete actions
        actor_id = 1;
        throw new io.cucumber.java.PendingException();
    }

    @When("I use get url using correct id")
    public void i_use_get_url_using_correct_id() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I get the correct actor information")
    public void i_get_the_correct_actor_information() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
