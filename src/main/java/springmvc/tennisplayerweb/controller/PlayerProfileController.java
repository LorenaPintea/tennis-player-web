package springmvc.tennisplayerweb.controller;

import springmvc.tennisplayerweb.model.PlayerProfile;
import springmvc.tennisplayerweb.service.PlayerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class PlayerProfileController {
    private final PlayerProfileService playerProfileService;

    public PlayerProfileController(PlayerProfileService playerProfileService) {
        this.playerProfileService = playerProfileService;
    }

    @GetMapping
    public List<PlayerProfile> allPlayerProfiles() {
        return playerProfileService.getAllPlayerProfiles();
    }

    @GetMapping("/{id}")
    public PlayerProfile getPlayerProfile(@PathVariable int id){
        return playerProfileService.getAllPlayerProfiles().get(id);
    }

    @PostMapping
    public PlayerProfile addPlayerProfile(@RequestBody PlayerProfile playerProfile) {
        return playerProfileService.addPlayerProfile(playerProfile);
    }

    @DeleteMapping("/{id}")
    public void deletePlayerProfile(@PathVariable int id) {
        playerProfileService.deletePlayerProfile(id);
    }
}
