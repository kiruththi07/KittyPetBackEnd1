package com.kittypet.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kittypet.demo.model.PetFood;
import com.kittypet.demo.repository.PetFoodRepository;

@Service
public class PetFoodService {
	
	@Autowired
	PetFoodRepository petFoodRepository;

	public ResponseEntity <PetFood> createPetFood(PetFood petFood){
		try {
			PetFood petFoodDet= petFoodRepository.save(petFood);
			return new ResponseEntity <>(petFoodDet,HttpStatus.CREATED);
			
		}
		
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public List<PetFood> getAllFoods(){
		return petFoodRepository.findAll();
		
	}
	
	
	public PetFood updatePetFood(String id,PetFood newpetFood) {
		Optional<PetFood> oldPetFood=petFoodRepository.findById(id);
		System.out.println(oldPetFood);
		if(oldPetFood.isPresent()) {
			PetFood _petFood =oldPetFood.get();
			_petFood.setTitle(newpetFood.getTitle());
			_petFood.setPrice(newpetFood.getPrice());
			_petFood.setDescription(newpetFood.getDescription());
			_petFood.setAvatarUrl(newpetFood.getAvatarUrl());
			_petFood.setImageUrl(newpetFood.getImageUrl());
			_petFood.setAnimalType(newpetFood.getAnimalType());
			System.out.println(_petFood);
			return petFoodRepository.save(_petFood);
		}
		return null;
	}
	
	public void deletePetFoodById(String id) {
		petFoodRepository.deleteById(id);
		
	

		
	}

//	public List<PetFood> getPetFoodByAnimalType(String animalType) {
//		System.out.println(animalType);
//		System.out.println(petFoodRepository.findByAnimalType(animalType));
//		return petFoodRepository.findByAnimalType(animalType);
//		
//		
//	}
	
	public ResponseEntity<List<PetFood>> getPetFoodByAnimalType (String animalType){
		try {
			List<PetFood> PetFoodDet = petFoodRepository.findFoodByAnimalType(animalType);
			
			if(PetFoodDet.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
				
			return new ResponseEntity<>(PetFoodDet, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	public ResponseEntity<Map<String, Object>> getAllPetFoodInPage(int pageNo, int pageSize,String sortBy) {
		try {
			
			Map<String, Object> response = new HashMap<>();
	   	 	Sort sort = Sort.by(sortBy);
	   		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
	   	 	Page<PetFood> page = petFoodRepository.findAll(pageable);
	   	 	response.put("data", page.getContent());
	   	 	response.put("Total no of pages", page.getTotalPages());
	   	 	response.put("Totalnoofelements", page.getTotalElements());
	   	 	response.put("Current page no", page.getNumber());
	   		 
	   	 	return new ResponseEntity<>(response, HttpStatus.OK);
				
		}
		
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Optional<PetFood>> getFoodById(String id) {
		Optional<PetFood> food= petFoodRepository.findById(id);
		
		if(food.isPresent()) {
			return new ResponseEntity<Optional<PetFood>>(food, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Optional<PetFood>>(HttpStatus.NOT_FOUND);
		}
	}
	

	

	

	

}
