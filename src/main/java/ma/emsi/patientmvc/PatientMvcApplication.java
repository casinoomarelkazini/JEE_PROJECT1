package ma.emsi.patientmvc;

import ma.emsi.patientmvc.entities.Patient;
import ma.emsi.patientmvc.repositories.PatientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication //est une annotation Spring Boot utilisée pour indiquer qu'une classe est une application Spring Boot.
// Il s'agit d'une annotation de commodité qui combine
public class PatientMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientMvcApplication.class, args);
    }

    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(new Patient(null, "amine", new Date(), false, 12));
            patientRepository.save(new Patient(null, "hassan", new Date(), true, 20));
            patientRepository.save(new Patient(null, "mehdi", new Date(), false, 51));
            patientRepository.save(new Patient(null, "yassine", new Date(), true, 190));
            patientRepository.findAll().forEach(
                    p -> {
                        System.out.println(p.getNom());
                    }
            );

        };
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
