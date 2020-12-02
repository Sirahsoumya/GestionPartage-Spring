package ma.pfa.GestionPartage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.pfa.GestionPartage.entity.Quartier;

public interface QuartierRepository extends JpaRepository<Quartier,Integer> {
	 Quartier findById(int id_quartier);

}
