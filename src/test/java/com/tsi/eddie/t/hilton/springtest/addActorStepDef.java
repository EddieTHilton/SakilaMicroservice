package com.tsi.eddie.t.hilton.springtest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class addActorStepDef {

    @Mock
    ActorRepository actorRepository;


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
        actorRepository = mock(ActorRepository.class);
        MyfirstspringtestApplication myfirstspringtestApplication = new MyfirstspringtestApplication(actorRepository);

        Assertions.assertEquals(actor.getFirst_name(), string, "First name does not match expected.");
        Assertions.assertEquals(actor.getLast_name(), string2, "Last name does not match expected.");
        //Above checks that user case story names are assigned correctly

        List<Actor> actorList = new ArrayList<Actor>();
        actorList.add(actor);
        myfirstspringtestApplication.addActor(actor.getFirst_name(), actor.getLast_name());
        when(actorRepository.findAll()).thenReturn(actorList);

        System.out.println(actorRepository.findAll());
       // Assertions.assertEquals(actor.getLast_name(), actorRepository.findAll()., "Last name does not match expected.");
        //Assertions.assertEquals(actor.getLast_name(), string2, "Last name does not match expected.");


    }

}