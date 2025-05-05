package enset.ma;

import enset.ma.entities.Patient;
import enset.ma.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp_OrmJdbcJpaHibernateSpringDataApplication implements CommandLineRunner {

    private PatientRepository patientRepository;

    public Tp_OrmJdbcJpaHibernateSpringDataApplication(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public static void main(String[] args) {

        SpringApplication.run(Tp_OrmJdbcJpaHibernateSpringDataApplication.class, args);
    }

    // C'est ici qu'on place le code à exécuter juste après le démarrage (insertion de données, tests, etc.)
    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(
                new Patient(null,"ikrame",new Date(),false,50));
        patientRepository.save
                (new Patient(null,"azaz",new Date(),false,60));
        patientRepository.save
                (new Patient(null,"zak",new Date(),true,90));

        List<Patient> patients = patientRepository.findAll();
        patients.forEach(patient -> {
            System.out.println("====INFORMATIONS-PATIENT=====");
            System.out.println(patient.getId());
            System.out.println(patient.getNom());
            System.out.println(patient.getDateNaissance());
            System.out.println(patient.isMalade());
            System.out.println(patient.getScore());
        }) ;

        System.out.println("====END-OF-PATIENT=====");
        Patient patient = patientRepository.findById(1L).orElse(null);
        if (patient != null) {
            System.out.println(patient.getNom());
            System.out.println(patient.isMalade());
        }
        patient.setScore(27);
        patientRepository.save(patient); // save ici joue le role d'un update au lieu d'insert (insert si l'id est null)


        List<Patient> patient2 = patientRepository.chercherPatient2("%k%",40);
        System.out.println(patient2);


    }
}
 