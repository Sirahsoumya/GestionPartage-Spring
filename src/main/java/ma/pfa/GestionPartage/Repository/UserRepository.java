package ma.pfa.GestionPartage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import ma.pfa.GestionPartage.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
 User findById(int id_user);
 

  @Query("select u from User u where u.email = ?1 and u.password = ?2")
  User findByEmailAndPassword(String email,String password);
  
  // cette requete nous permet de changer la note d'un utilisateur
    @Transactional
	@Modifying(clearAutomatically = true)
	@Query("update User user1 set user1.note=?1 where user1.id_user=?2")
	void setNoteUser(String note, int id_user);
  
  
}
