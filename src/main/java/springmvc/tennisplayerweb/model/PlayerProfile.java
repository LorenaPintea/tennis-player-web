package springmvc.tennisplayerweb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class PlayerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;

    @OneToOne(mappedBy = "playerProfile", cascade = CascadeType.ALL)
    @JsonBackReference
    private Player player;

    public PlayerProfile() {
    }

    public PlayerProfile(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "PlayerProfile{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", player=" + player +
                '}';
    }
}
