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
import ma.pfa.GestionPartage.Repository.CategorieServiceRepository;
import ma.pfa.GestionPartage.entity.Categorie;

@RestController
@RequestMapping(value="serviceCat")
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieServiceController {
	@Autowired
	private CategorieServiceRepository categorieServiceRepository;
	
	@GetMapping("/all")
	public List<Categorie> findAll()
	{
		return categorieServiceRepository.findAll();
	}
	@PostMapping("/save")
	public void Save(@RequestBody Categorie categorieService)
	{
		categorieServiceRepository.save(categorieService);
	}

	@DeleteMapping("/Delete/{id_catServ}")
	public void Delete(@PathVariable(required = true) String id_catServ) {
		Categorie categorieService= categorieServiceRepository.findById(Integer.parseInt(id_catServ));
		categorieServiceRepository.delete(categorieService);
		
	}


}

