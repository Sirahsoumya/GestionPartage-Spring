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
import ma.pfa.GestionPartage.Repository.DemandeServiceRepository;
import ma.pfa.GestionPartage.Repository.ServiceRepository;
import ma.pfa.GestionPartage.entity.DemandeService;
import ma.pfa.GestionPartage.entity.DemandeServiceKey;
import ma.pfa.GestionPartage.entity.Service;

@RestController
@RequestMapping(value = "demandeService")
@CrossOrigin(origins = "http://localhost:4200")
public class DemandeServiceController {
	@Autowired
	private DemandeServiceRepository demandeServiceRepository;
	@Autowired
	private ServiceRepository serviceRepository;

	@PostMapping("/save")
	public void Save(@RequestBody DemandeService demandeService) {
		Service serv = new Service();
		serv.setId_serv(demandeService.getService().getId_serv());
		demandeService.setService(serv);
		demandeService.setidDemServ(
				new DemandeServiceKey(demandeService.getUser().getId_user(), demandeService.getService().getId_serv()));
		demandeServiceRepository.save(demandeService);
		serviceRepository.setStatusService(false, demandeService.getService().getId_serv());
	}

	@DeleteMapping("/delete/{id_user}/{id_serv}")

	public void delete(@PathVariable(required = true) int id_user, @PathVariable(required = true) int id_serv) {
		DemandeServiceKey idDemServ = new DemandeServiceKey(id_user, id_serv);
		DemandeService d = demandeServiceRepository.findByIdDemServ(idDemServ);
		demandeServiceRepository.delete(d);
	}

	@GetMapping("/all")
	public List<DemandeService> findAll() {
		return demandeServiceRepository.findAll();
	}

	@PutMapping(value = "/update")
	public void updateDemandeService(@RequestBody DemandeService demandeService) {
		demandeServiceRepository.save(demandeService);
	}

	@GetMapping("/find/{id_user}/{id_serv}")
	public DemandeService find(@PathVariable int id_user, @PathVariable int id_serv) {
		DemandeServiceKey idDemServ = new DemandeServiceKey(id_user, id_serv);
		return demandeServiceRepository.findByIdDemServ((idDemServ));

	}

	@GetMapping("/findDemandeService/{id_serv}")
	public DemandeService findDemandeServiceByIdService(@PathVariable int id_serv) throws Exception {
		System.out.println("le id " + id_serv);
		String dateTime = "2020-10-10 05:00:00";
		// Format for input
		SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");

		// Parsing the date
		Date date7 = dateParser.parse(dateTime);

		DemandeService demandeService = demandeServiceRepository.getService(id_serv);
		return demandeService;

	}

}
