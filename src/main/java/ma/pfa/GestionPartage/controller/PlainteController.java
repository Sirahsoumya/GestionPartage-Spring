package ma.pfa.GestionPartage.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ma.pfa.GestionPartage.Repository.PlainteRepository;
import ma.pfa.GestionPartage.Repository.UserRepository;
import ma.pfa.GestionPartage.entity.Plainte;

@RestController
@RequestMapping(value = "plainte")
@CrossOrigin(origins = "http://localhost:4200")
public class PlainteController {
	@Autowired
	private PlainteRepository plainteRepository;
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/save")
	public void Save(@RequestBody Plainte plainte)

	{
		System.out.println("la plainte : " + plainte);
		plainteRepository.save(plainte);
		// changement de la note du user
		userRepository.setNoteUser(plainte.getUser1().getNote(), plainte.getUser1().getId_user());
	}

	@GetMapping("/all")
	public List<Plainte> findAll() {
		return plainteRepository.findAll();
	}

}