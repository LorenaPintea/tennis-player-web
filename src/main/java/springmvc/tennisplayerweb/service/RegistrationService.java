package springmvc.tennisplayerweb.service;


import springmvc.tennisplayerweb.model.Registration;
import springmvc.tennisplayerweb.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
    private final RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public Registration getRegistrationById(int id) {
        return registrationRepository.findById(id).orElse(null);
    }

    public Registration addRegistration(Registration registration) {
        registration.setId(0);
        return registrationRepository.save(registration);
    }

    public void deleteRegistration(int id) {
        registrationRepository.deleteById(id);
    }
}
