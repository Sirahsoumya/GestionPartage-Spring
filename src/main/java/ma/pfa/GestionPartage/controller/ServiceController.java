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
import ma.pfa.GestionPartage.Repository.ServiceRepository;
import ma.pfa.GestionPartage.entity.Service;


@RestController
@RequestMapping(value="services")
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceController {

		
	@Autowired
	private ServiceRepository serviceRepository;
	
	@PostMapping("/save")
	public void Save(@RequestBody Service service)
	{
		serviceRepository.save(service);}

	@DeleteMapping("/Delete/{id_serv}")
	public void Delete(@PathVariable(required=true) String id_serv)
	{
	Service s=serviceRepository.findById(Integer.parseInt(id_serv));
		serviceRepository.delete(s);
		}
	

	@GetMapping("/searchService/{id_cat}")
	public List<Service> searchService(@PathVariable(required=true) String id_cat)
	{
	return serviceRepository.findByIdCategorie(Integer.parseInt(id_cat));
		}
	
	
	
	@GetMapping("/all")
	public List<Service> findAll()
	{return serviceRepository.findAll();
	}
	}