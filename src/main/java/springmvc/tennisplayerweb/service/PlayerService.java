package springmvc.tennisplayerweb.service;

import springmvc.tennisplayerweb.model.Player;
import springmvc.tennisplayerweb.model.PlayerProfile;
import springmvc.tennisplayerweb.model.Registration;
import springmvc.tennisplayerweb.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> allPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayer(int id){
        return playerRepository.findById(id).orElseThrow();
    }

    public Player getPlayerByName(String name){
        return allPlayers().stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }

    public Player addPlayer(Player player) {
        player.setId(0);
        //check if player contains nested profile
        if(player.getPlayerProfile()!=null) {
            player.getPlayerProfile().setPlayer(player);
        }
        return playerRepository.save(player);
    }

    public void deletePlayer(int id) {
        playerRepository.deleteById(id);
    }

    public Player assignProfile(int id, PlayerProfile profile) {
        Player player = playerRepository.findById(id).orElseThrow();
        player.setPlayerProfile(profile);
        //bidirectional
        player.getPlayerProfile().setPlayer(player);
        return playerRepository.save(player);
    }

    public Player assignRegistration(int id, Registration registration) {
        Player player = playerRepository.findById(id).orElseThrow();
        player.registerPlayer(registration);
        return playerRepository.save(player);
    }

    public Player removeRegistration(int id, Registration registration) {
        Player player = playerRepository.findById(id).orElseThrow();
        player.removeRegistration(registration);
        return playerRepository.save(player);
    }
}
