package ma.pfa.GestionPartage.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import ma.pfa.GestionPartage.entity.Bien;

public interface BienRepository extends JpaRepository<Bien,Integer> {
	Bien findById(int id_bien);
	@Query("select bien from Bien bien where bien.categorieBien.id_catBien=?1 and bien.status= true")
	List<Bien> findByIdCateorieBien(int id_catbien);
	
	//changer le status du bien 
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Bien bien set bien.status=?1 where bien.id_bien=?2")
	void setStatusBien(boolean status, int id_bien);
			
	

}
