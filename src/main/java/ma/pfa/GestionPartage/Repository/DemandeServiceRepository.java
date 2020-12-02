package ma.pfa.GestionPartage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.pfa.GestionPartage.entity.DemandeService;
import ma.pfa.GestionPartage.entity.DemandeServiceKey;

public interface DemandeServiceRepository extends JpaRepository<DemandeService,DemandeServiceKey>{
	DemandeService findByIdDemServ(DemandeServiceKey  idDemServ);
	@Query("select demandeService from DemandeService demandeService where demandeService.service.id_serv=?1")
	DemandeService getService(int id_serv);

}
