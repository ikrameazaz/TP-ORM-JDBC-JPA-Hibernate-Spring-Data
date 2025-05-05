package enset.ma.repositories;

import enset.ma.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Long> {
   public List<Patient> findByMalade(boolean m);

   public List<Patient> findByMaladeIsTrueAndScoreLessThanEqual(int score);

   @Query("select p from Patient p where p.DateNaissance between :x and :y or p.Nom like :z ")
   public List<Patient> chercherPatient1(@Param("x") Date d1, @Param("y") Date d2, @Param("z") String nom);

   @Query("select p from Patient p where p.Nom LIKE :x and  p.score <:y ")
   public List<Patient> chercherPatient2(@Param("x") String nom, @Param("y") int ScoreMin);
}