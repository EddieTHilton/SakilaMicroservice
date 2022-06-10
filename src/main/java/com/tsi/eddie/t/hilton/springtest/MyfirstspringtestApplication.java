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

// Funny joke here

	//@Autowired
	//private String save = "save";
	public static void main(String[] args) {

		SpringApplication.run(MyfirstspringtestApplication.class, args);


	}

	public MyfirstspringtestApplication(ActorRepository actorRepository){

		this.actorRepository = actorRepository;

	}

	@GetMapping("/All_Actors") //
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	@GetMapping("/Actor_ByID")
	public ResponseEntity<Actor> getActorById(@RequestParam int actor_id){
		Actor actor = actorRepository.findById(actor_id)
				.orElseThrow(); //() -> ResourceNotFoundException("Actor with id " + actor_id + " not found."));
		return  ResponseEntity.ok(actor);
	}

	@PostMapping("/Add_Actor")
	public @ResponseBody String addActor(@RequestParam String first_name, String last_name) {
		Actor addActor = new Actor(first_name, last_name);
		actorRepository.save(addActor);
		return "Added actor, saved."; //save;
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
}

