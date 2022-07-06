package com.tsi.eddie.t.hilton.springtest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SpecialCharacterStepdefs {

    @Mock
    ActorRepository actorRepository;

    @Mock
    FilmRepository filmRepository;

    Actor actor = new Actor("", "");

    @Given("I have actor special character first name, last name")
    public void iHaveActorSpecialCharacterFirstNameLastName() {
    }

    @When("Special first name equals {string}")
    public void specialFirstNameEquals(String string) {
        actor.setFirst_name(string);

    }

    @And("Special last name equals {string}")
    public void specialLastNameEquals(String string) {
        actor.setLast_name(string);

    }

    @Then("Special Actor {string} {string} will be added to database")
    public void specialActorWillBeAddedToDatabase(String string, String string2) {
        actorRepository = mock(ActorRepository.class);
        filmRepository = mock(FilmRepository.class);
        MyfirstspringtestApplication myfirstspringtestApplication = new MyfirstspringtestApplication(actorRepository, filmRepository);

        Assertions.assertEquals(actor.getFirst_name(), string, "First name does not match expected.");
        Assertions.assertEquals(actor.getLast_name(), string2, "Last name does not match expected.");


        List<Actor> actorList = new ArrayList<Actor>();
        actorList.add(actor);
        myfirstspringtestApplication.addActor(actor.getFirst_name(), actor.getLast_name());
        when(actorRepository.findAll()).thenReturn(actorList);

        System.out.println(actorRepository.findAll());
    }
}
