package ma.pfa.GestionPartage.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import ma.pfa.GestionPartage.entity.Service;




public interface ServiceRepository extends JpaRepository<Service, Integer>{
	
	Service findById(int id_serv);
	@Query("select ser from Service ser where ser.categorie.id_catServ = ?1 ")
	List<Service> findByIdCategorie(int id_categorie);
	
	//changer le status du service 
		@Transactional
		@Modifying(clearAutomatically = true)
		@Query("update Service service set service.status=?1 where service.id_serv=?2")
		void setStatusService(boolean status, int id_serv);
}
