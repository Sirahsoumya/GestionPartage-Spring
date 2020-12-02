package ma.pfa.GestionPartage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.pfa.GestionPartage.entity.Categorie;

public interface CategorieServiceRepository extends JpaRepository<Categorie,Integer>{
	Categorie findById(int id_catServ);
}
