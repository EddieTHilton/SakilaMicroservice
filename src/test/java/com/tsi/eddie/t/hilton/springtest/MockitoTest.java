package com.tsi.eddie.t.hilton.springtest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {


    MyfirstspringtestApplication myfirstspringtestApplication;

    @Mock
    private ActorRepository actorRepository;
    @Mock
    private FilmRepository filmRepository;

    @BeforeEach
    public void Setup(){

        actorRepository = mock(ActorRepository.class);
        filmRepository = mock(FilmRepository.class);

        myfirstspringtestApplication = new MyfirstspringtestApplication(actorRepository, filmRepository);

    }

    @Test
    public void testGetAllActors(){
        myfirstspringtestApplication.getAllActors();
        verify(actorRepository).findAll(); //verify takes mock object and checks that specified changes are made

    }

    @Test
    public void testGetAllFilms(){
        myfirstspringtestApplication.getAllFilms();
        verify(filmRepository).findAll(); //verify takes mock object and checks that specified changes are made

    }

    @Test
    public void testGetActorById(){
        Actor testActor = new Actor("Test","Testerson");
        testActor.setFirst_name("Test");
        testActor.setLast_name("Testrson");

        testActor.setActor_id(1);
        when(actorRepository.findById(1)).thenReturn(Optional.of(testActor));

        Actor actual = myfirstspringtestApplication.getActorById(testActor.getActor_id()).getBody();
        Actor expected = testActor;

        Assertions.assertEquals(expected, actual, "Actor with ID not found.");

    }

    @Test
    public void testGetFilmById(){
        Film testFilm = new Film("Test Movie", "Descriptive description.", 9099, 01.01, 1, 01.01, "?", "Features");
        testFilm.setFilm_id(1);
        testFilm.setTitle("Test Movie");
        testFilm.setDescription("Descriptive description.");
        testFilm.setRelease_year(9099);
        testFilm.setRental_rate(01.01);
        testFilm.setLength(1);
        testFilm.setReplacement_cost(01.01);
        testFilm.setRating("?");
        testFilm.setSpecial_features("Features");

        when(filmRepository.findById(1)).thenReturn(Optional.of(testFilm));

        Film actual = myfirstspringtestApplication.getFilmById(testFilm.getFilm_id()).getBody();
        Film expected = testFilm;

        Assertions.assertEquals(expected, actual, "Film with ID not found.");

    }


    @Test
    public void testAddActor(){
        Actor testActor = new Actor("Test", "Testerson");
        String expected = "Added actor, saved.";
        String actual = myfirstspringtestApplication.addActor(testActor.getFirst_name(), testActor.getLast_name());

        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class); //catches actor going into mock repository

        verify(actorRepository).save(actorArgumentCaptor.capture());
        //actorArgumentCaptor.getValue();

        Assertions.assertEquals(expected, actual, "Actor not added.");

    }

    @Test
    public void testAddFilm(){
        Film testFilm = new Film("Test Movie", "Descriptive description.", 9099, 01.01, 1, 01.01, "?", "Features");
        String expected = "Added film, saved.";
        String actual = myfirstspringtestApplication.addFilm(testFilm.getTitle(), testFilm.getDescription(), testFilm.getRelease_year(), testFilm.getRental_rate(), testFilm.getLength(), testFilm.getReplacement_cost(), testFilm.getRating(), testFilm.getSpecial_features());

        ArgumentCaptor<Film> filmArgumentCaptor = ArgumentCaptor.forClass(Film.class); //catches actor going into mock repository

        verify(filmRepository).save(filmArgumentCaptor.capture());
        //actorArgumentCaptor.getValue();

        Assertions.assertEquals(expected, actual, "Film not added.");

    }




}
