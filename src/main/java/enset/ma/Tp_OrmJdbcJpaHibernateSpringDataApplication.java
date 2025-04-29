package enset.ma;

import enset.ma.entities.Patient;
import enset.ma.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp_OrmJdbcJpaHibernateSpringDataApplication implements CommandLineRunner {

    private final PatientRepository patientRepository;

    public Tp_OrmJdbcJpaHibernateSpringDataApplication(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Tp_OrmJdbcJpaHibernateSpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(
                new Patient(null,"ikrame",new Date(),false,50));
        patientRepository.save
                (new Patient(null,"azaz",new Date(),false,60));
        patientRepository.save
                (new Patient(null,"zak",new Date(),true,90));

        List<Patient> Patients = patientRepository.findAll();
        Patients.forEach(patient -> {
            System.out.println("====INFORMATIONS-PATIENT=====");
            System.out.println(patient.getId());
            System.out.println(patient.getNom());
            System.out.println(patient.getDateNaissance());
            System.out.println(patient.isMalade());
            System.out.println(patient.getScore());
        }) ;


    }
}
