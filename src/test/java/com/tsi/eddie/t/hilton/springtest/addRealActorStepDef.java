package com.tsi.eddie.t.hilton.springtest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.Mock;

public class addRealActorStepDef {



    ActorRepository actorRepository;


    FilmRepository filmRepository;


    Actor actor = new Actor("", "");


    @Given("I have actor first name, last name")
    public void i_have_actor_first_name_last_name() {






    }
    @When("First name equals {string}")
    public void first_name_equals(String string) {
        actor.setFirst_name(string);

    }
    @When("Last name equals {string}")
    public void last_name_equals(String string) {
        actor.setLast_name(string);


    }
    @Then("Actor {string} {string} will be added to database")
    public void actor_will_be_added_to_database(String string, String string2) {




    }


}
