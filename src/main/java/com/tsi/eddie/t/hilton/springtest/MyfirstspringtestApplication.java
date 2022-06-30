package com.tsi.eddie.t.hilton.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

@SpringBootApplication

@RestController
@RequestMapping("/Home")  // localhost:8080/Home/All_Actors
@CrossOrigin
public class MyfirstspringtestApplication {

	@Autowired
	private ActorRepository actorRepository;

	@Autowired
	private FilmRepository filmRepository;



	//@Autowired
	//private String save = "save";
	public static void main(String[] args) {

		SpringApplication.run(MyfirstspringtestApplication.class, args);


	}

	public MyfirstspringtestApplication(ActorRepository actorRepository, FilmRepository filmRepository){

		this.actorRepository = actorRepository;
		this.filmRepository = filmRepository;

	}

	@GetMapping("/All_Actors") //
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	@GetMapping("/All_Films") //
	public @ResponseBody
	Iterable<Film>getAllFilms(){
		return filmRepository.findAll();
	}

	@GetMapping("/Actor_ByID")
	public ResponseEntity<Actor> getActorById(@RequestParam int actor_id){
		Actor actor = actorRepository.findById(actor_id)
				.orElseThrow(); //() -> ResourceNotFoundException("Actor with id " + actor_id + " not found."));
		return  ResponseEntity.ok(actor);
	}

	@GetMapping("/Film_ByID")
	public ResponseEntity<Film> getFilmById(@RequestParam int film_id){
		Film film = filmRepository.findById(film_id)
				.orElseThrow(); //() -> ResourceNotFoundException("Actor with id " + actor_id + " not found."));
		return  ResponseEntity.ok(film);
	}

	@PostMapping("/Add_Actor")
	public @ResponseBody String addActor(@RequestParam String first_name, String last_name) {
		Actor addActor = new Actor(first_name, last_name);
		actorRepository.save(addActor);
		return "Added actor, saved."; //save;
	}

	@PostMapping("/Add_Film")
	public @ResponseBody String addFilm(@RequestParam String title, String description, int release_year, double rental_rate, int length, double replacement_cost, String rating, String special_features) {
		Film addFilm = new Film(title, description, release_year, rental_rate, length, replacement_cost, rating, special_features);
		filmRepository.save(addFilm);
		return "Added film, saved."; //save;
	}

	@PutMapping("/Update_Actor")
	public @ResponseBody String addActor(@RequestParam int id, String first_name, String last_name){
 		String results = "Id does not exist.";
 		if (actorRepository.existsById(id)){
			Actor newActor = actorRepository.findById(id).get(); //.setFirst_name(first_name);
			//actorRepository.findById(id).get().setLast_name(last_name);
			newActor.setLast_name(last_name);
			newActor.setFirst_name(first_name);
			actorRepository.save(newActor);
			results = "Actor successfully updated.";
		}
		return results;
		//actorRepository.findAll();
	}

	@DeleteMapping("/Delete_Actor")
	public @ResponseBody String deleteActor(@RequestParam int id){
		actorRepository.deleteById(id);
		return "Actor deleted.";
	}

	@DeleteMapping("/Delete_Film")
	public @ResponseBody String deleteFilm(@RequestParam int id){
		filmRepository.deleteById(id);
		return "Film deleted.";
	}
}

