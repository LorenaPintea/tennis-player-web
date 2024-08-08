package springmvc.tennisplayerweb.controller;

import springmvc.tennisplayerweb.model.Registration;
import springmvc.tennisplayerweb.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public List<Registration> allRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @GetMapping("/{id}")
    public Registration getRegistration(@PathVariable int id){
        return registrationService.getRegistrationById(id);
    }

    @PostMapping
    public Registration addRegistration(@RequestBody Registration registration) {
        return registrationService.addRegistration(registration);
    }

    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable int id) {
        registrationService.deleteRegistration(id);
    }
}
