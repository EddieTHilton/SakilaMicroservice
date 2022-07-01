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

public class addFilmStepDef {

    @Mock
    ActorRepository actorRepository;

    @Mock
    FilmRepository filmRepository;

    Film film = new Film();

    @Given("I have film title, description, release year, rental rate, length, replacement cost, rating and special features.")
    public void i_have_film_title_description_release_year_rental_rate_length_replacement_cost_rating_and_special_features() {

    }
    @When("Title equals {string}")
    public void title_equals(String string) {
        film.setTitle(string);
    }
    @When("Description equals {string}")
    public void description_equals(String string) {
        film.setDescription(string);
    }
    @When("Release year equals {int}")
    public void release_year_equals(Integer int1) {
        film.setRelease_year(int1);
    }
    @When("Rental rate equals {double}")
    public void rental_rate_equals(Double double1) {
        film.setRental_rate(double1);
    }
    @When("Length equals {int}")
    public void length_equals(Integer int1) {
        film.setLength(int1);
    }
    @When("Replacement cost equals {double}")
    public void replacement_cost_equals(Double double1) {
        film.setReplacement_cost(double1);
    }
    @When("Rating cost equals {string}")
    public void rating_cost_equals(String string) {
        film.setRating(string);
    }
    @When("Special features cost equals {string}")
    public void special_features_cost_equals(String string) {
        film.setSpecial_features(string);
    }
    @Then("Film {string} will be added to database")
    public void film_will_be_added_to_database(String string) {
        actorRepository = mock(ActorRepository.class);
        filmRepository = mock(FilmRepository.class);
        MyfirstspringtestApplication myfirstspringtestApplication = new MyfirstspringtestApplication(actorRepository, filmRepository);

        Assertions.assertEquals(film.getTitle(), string, "Title does not match expected.");
        //Assertions.assertEquals(actor.getLast_name(), string2, "Last name does not match expected.");
        //Above checks that user case story names are assigned correctly

        List<Film> filmList = new ArrayList<Film>();
        filmList.add(film);
        myfirstspringtestApplication.addFilm(film.getTitle(), film.getDescription(), film.getRelease_year(), film.getRental_rate(), film.getLength(), film.getReplacement_cost(), film.getRating(), film.getSpecial_features());
        when(filmRepository.findAll()).thenReturn(filmList);

        System.out.println(filmRepository.findAll());
        // Assertions.assertEquals(actor.getLast_name(), actorRepository.findAll()., "Last name does not match expected.");
        //Assertions.assertEquals(actor.getLast_name(), string2, "Last name does not match expected.");
    }


}
