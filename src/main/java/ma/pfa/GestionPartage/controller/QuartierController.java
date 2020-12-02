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
import ma.pfa.GestionPartage.Repository.QuartierRepository;
import ma.pfa.GestionPartage.entity.Quartier;

@RestController
@RequestMapping(value = "quartiers")
@CrossOrigin(origins = "http://localhost:4200")
public class QuartierController {
	@Autowired
	private QuartierRepository quartierRepository;

	@GetMapping("/all")
	public List<Quartier> findAll() {
		System.out.println("ok");
		return quartierRepository.findAll();
	}

	@PostMapping("/save")
	public void Save(@RequestBody Quartier quartier) {
		quartierRepository.save(quartier);
	}

	@DeleteMapping("/Delete/{id_quartier}")
	public void Delete(@PathVariable(required = true) String id_quartier) {
		Quartier quartier = quartierRepository.findById(Integer.parseInt(id_quartier));
		quartierRepository.delete(quartier);

	}

}
