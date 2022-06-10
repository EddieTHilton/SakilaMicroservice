package com.tsi.eddie.t.hilton.springtest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addActorStepDef {

    @Given("I have actor information, and an actor table exists")
    public void i_have_actor_information_and_an_actor_table_exists() {
        // Write code here that turns the phrase above into concrete actions
        Actor actor = new Actor("test", "testerson");
        //throw new io.cucumber.java.PendingException();
    }
    @When("I post actor information")
    public void i_post_actor_information() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I get the success return string")
    public void i_get_the_success_return_string() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}