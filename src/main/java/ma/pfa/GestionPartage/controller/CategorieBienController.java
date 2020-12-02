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
import ma.pfa.GestionPartage.Repository.CategorieBienRepository;
import ma.pfa.GestionPartage.entity.CategorieBien;


@RestController
@RequestMapping(value = "biencateg")
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieBienController {
	@Autowired
	private CategorieBienRepository categorieBienRepository;

	@GetMapping("/all")
	public List<CategorieBien> findAll() {
		return categorieBienRepository.findAll();
	}

	@PostMapping("/save")
	public void Save(@RequestBody CategorieBien categorieBien) {
		categorieBienRepository.save(categorieBien);
	}

	@DeleteMapping("/Delete/{id_catBien}")
	public void Delete(@PathVariable(required = true) String id_catBien) {
		CategorieBien categorieBien = categorieBienRepository.findById(Integer.parseInt(id_catBien));
		categorieBienRepository.delete(categorieBien);

	}

}
