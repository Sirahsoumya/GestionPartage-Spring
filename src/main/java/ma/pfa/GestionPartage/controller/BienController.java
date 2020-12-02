package ma.pfa.GestionPartage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.pfa.GestionPartage.Repository.BienRepository;
import ma.pfa.GestionPartage.entity.Bien;

@RestController
@RequestMapping(value="biens")
@CrossOrigin(origins = "http://localhost:4200")
public class BienController {
	@Autowired
	private BienRepository bienRepository;
	
	@PostMapping("/save")
	public void Save(@RequestBody Bien bien)
	
	{
		System.out.println("le bien est:"+ bien);
		System.out.println("le cout est:"+ bien.getCout());
		
		bienRepository.save(bien);
	}


	@DeleteMapping("/delete/{id_bien}")
	public void Delete(@PathVariable(required=true) String id_bien)
	{
	Bien b=bienRepository.findById(Integer.parseInt(id_bien));
		bienRepository.delete(b);
		}
	
	@GetMapping("/searchBien/{id_catbien}")
	public List<Bien> searchService(@PathVariable(required=true) String id_catbien)
	{
	return bienRepository.findByIdCateorieBien(Integer.parseInt(id_catbien));
	   
	}

	@GetMapping("/all")
	public List<Bien> findAll()
	{
		return bienRepository.findAll();
	}
	
	
	
	
	
	
	
	
	
}
