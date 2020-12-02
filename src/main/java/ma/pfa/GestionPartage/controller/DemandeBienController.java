package ma.pfa.GestionPartage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ma.pfa.GestionPartage.Repository.BienRepository;
import ma.pfa.GestionPartage.Repository.DemandeBienRepository;
import ma.pfa.GestionPartage.entity.Bien;
import ma.pfa.GestionPartage.entity.DemandeBien;
import ma.pfa.GestionPartage.entity.DemandeBienKey;

@RestController
@RequestMapping(value = "demandeBien")
@CrossOrigin(origins = "http://localhost:4200")
public class DemandeBienController {

	@Autowired
	private DemandeBienRepository demandeBienRepository;

	@Autowired
	private BienRepository bienRepository;

	@PostMapping("/save")
	public void Save(@RequestBody DemandeBien demandeBien) {
		Bien b = new Bien();
		b.setId_bien(demandeBien.getBienB().getId_bien());
		demandeBien.setBienB(b);
		demandeBien.setIdDemandeBien(
				new DemandeBienKey(demandeBien.getUserB().getId_user(), demandeBien.getBienB().getId_bien()));
		System.out.println("demandeBien : " + demandeBien);
		System.out.println("le id_bien :" + demandeBien.getBienB().getId_bien());
		demandeBienRepository.save(demandeBien);
		// changement de status
		bienRepository.setStatusBien(false, demandeBien.getBienB().getId_bien());

	}

	@DeleteMapping("/delete/{id_user}/{id_bien}")

	public void delete(@PathVariable(required = true) int id_user, @PathVariable(required = true) int id_bien) {
		DemandeBienKey idDemandeBien = new DemandeBienKey(id_user, id_bien);
		DemandeBien d = demandeBienRepository.findByIdDemandeBien(idDemandeBien);
		demandeBienRepository.delete(d);
	}

	@GetMapping("/all")
	public List<DemandeBien> findAll() {
		return demandeBienRepository.findAll();
	}

	@PutMapping(value = "/update")
	public void updateDemandeBien(@RequestBody DemandeBien demandeBien) {
		demandeBienRepository.save(demandeBien);
	}

	@GetMapping("/find/{id_user}/{id_bien}")
	public DemandeBien find(@PathVariable int id_user, @PathVariable int id_bien) {
		DemandeBienKey idDemandeBien = new DemandeBienKey(id_user, id_bien);
		return demandeBienRepository.findByIdDemandeBien(idDemandeBien);

	}

	@GetMapping("/findDemandeBien/{id_bien}")
	public DemandeBien findDemandeBienByIdBien(@PathVariable int id_bien) throws Exception {
		System.out.println("le id " + id_bien);
		String dateTime = "2020-10-10 05:00:00";
		// Format for input
		SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");

		// Parsing the date
		Date date7 = dateParser.parse(dateTime);

		DemandeBien demandeBien = demandeBienRepository.getBien(id_bien);
		return demandeBien;
	}
}
