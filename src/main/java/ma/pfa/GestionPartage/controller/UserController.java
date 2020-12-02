package ma.pfa.GestionPartage.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.pfa.GestionPartage.Repository.UserRepository;
import ma.pfa.GestionPartage.entity.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/users")
	public void Save(@RequestBody User user) {
		System.out.println("user est:" + user);
		userRepository.save(user);

	}

	@PostMapping("/checkUser")
	public User getUser(@RequestBody User user) {
		User u = userRepository.findByEmailAndPassword(user.getemail(), user.getPassword());
		System.out.println("email" + u.getemail());
		System.out.println("email" + u.getPassword());
		System.out.println("email" + u.getNom());
		return (u);

	}

	@DeleteMapping("/Delete/{id_user}")
	public void Delete(@PathVariable(required = true) String id_user) {
		User u = userRepository.findById(Integer.parseInt(id_user));
		userRepository.delete(u);

	}

	@GetMapping("/users")
	public List<User> findAll() {
		return userRepository.findAll();
	}

}