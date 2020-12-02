package ma.pfa.GestionPartage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.pfa.GestionPartage.entity.CategorieBien;

public interface CategorieBienRepository extends JpaRepository<CategorieBien,Integer> {
	CategorieBien findById(int id_catBien);
}
