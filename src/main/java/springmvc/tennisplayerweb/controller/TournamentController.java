package springmvc.tennisplayerweb.controller;

import springmvc.tennisplayerweb.model.Category;
import springmvc.tennisplayerweb.model.Registration;
import springmvc.tennisplayerweb.model.Tournament;
import springmvc.tennisplayerweb.service.CategoryService;
import springmvc.tennisplayerweb.service.RegistrationService;
import springmvc.tennisplayerweb.service.TournamentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {
    private final TournamentService tournamentService;
    private final RegistrationService registrationService;
    private final CategoryService categoryService;

    public TournamentController(TournamentService tournamentService, RegistrationService registrationService, CategoryService categoryService) {
        this.tournamentService = tournamentService;
        this.registrationService = registrationService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Tournament> allTournaments() {
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/{id}")
    public Tournament getTournament(@PathVariable Long id) {
        return tournamentService.getTournamentById(id);
    }

    @PostMapping
    public Tournament addTournament(@RequestBody Tournament tournament) {
        return tournamentService.addTournament(tournament);
    }

    @PutMapping("/{id}/add_registrations/{registration_id}")
    public Tournament addRegistration(@PathVariable Long id, @PathVariable int registration_id) {
        Registration registration = registrationService.getRegistrationById(registration_id);
        System.out.println(registration);
        return tournamentService.addRegistration(id, registration);
    }

    @PutMapping("/{id}/remove_registrations/{registration_id}")
    public Tournament removeRegistration(@PathVariable Long id, @PathVariable int registration_id) {
        Registration registration = registrationService.getRegistrationById(registration_id);
        System.out.println(registration);
        return tournamentService.removeRegistration(id, registration);
    }

    @PutMapping("/{id}/categories/{category_id}")
    public Tournament addCategory(@PathVariable Long id, @PathVariable Long category_id) {
        Category category = categoryService.getCategoryById(category_id);
        return tournamentService.addCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void removeTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
    }
}