package ma.pfa.GestionPartage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ma.pfa.GestionPartage.entity.DemandeBien;
import ma.pfa.GestionPartage.entity.DemandeBienKey;

public interface DemandeBienRepository extends JpaRepository<DemandeBien, DemandeBienKey> {
	DemandeBien findByIdDemandeBien(DemandeBienKey idDemandeBien);

	@Query("select db from DemandeBien db where db.bienB.id_bien=?1")
	DemandeBien getBien(int id_bien);
	

}
