package com.kittypet.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kittypet.demo.model.PetFood;
import com.kittypet.demo.service.PetFoodService;

@CrossOrigin("*")
@RestController
@RequestMapping("/petFoods")
public class PetFoodController {
	
	
	@Autowired
	PetFoodService petFoodService;

	
	@PostMapping
	public ResponseEntity<PetFood> createPetFoods(@RequestBody PetFood petfood ){
		return petFoodService.createPetFood(petfood);
	}
	
	@GetMapping
	
	public  List<PetFood>getAllFoods() {
		return petFoodService.getAllFoods();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<PetFood>>getFoodById(@PathVariable String id){
		return petFoodService.getFoodById(id);
	}
	
	@PutMapping("/{id}")
	public PetFood updatePetFood(@RequestBody PetFood petFood,@PathVariable String id) {
		return petFoodService.updatePetFood(id,petFood);
		
	}
	
	@DeleteMapping("/{id}")
	public void deletePetFood(@PathVariable String id) {
		petFoodService.deletePetFoodById(id);	
		
	}
	
	@GetMapping(params= {"animalType"})
	public ResponseEntity<List<PetFood>> getPetFoodByAnimalType(@RequestParam String animalType){
		return petFoodService.getPetFoodByAnimalType(animalType);
	}
	
	
	@GetMapping("/page")
	public ResponseEntity<Map<String, Object>> getAllPetFoodInPage(
			@RequestParam (name = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam (name = "pageSize", defaultValue = "3") int pageSize,
			@RequestParam (name = "sortBy", defaultValue = "Id") String sortBy)
	{
		return petFoodService.getAllPetFoodInPage (pageNo,pageSize,sortBy);
	}	

}
