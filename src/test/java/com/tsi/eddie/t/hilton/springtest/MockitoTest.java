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
        testActor.setActor_id(1);
        when(actorRepository.findById(1)).thenReturn(Optional.of(testActor));

        Actor actual = myfirstspringtestApplication.getActorById(testActor.getActor_id()).getBody();
        Actor expected = testActor;

        Assertions.assertEquals(expected, actual, "Actor with ID not found.");

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




}
