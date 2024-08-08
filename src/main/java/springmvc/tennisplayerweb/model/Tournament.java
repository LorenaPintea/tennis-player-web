package springmvc.tennisplayerweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String location;

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="tournament_id")
    private List<Registration> registrationList = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "tournament_categories", joinColumns = @JoinColumn(name = "tournament_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    @JsonIgnoreProperties("tournamentList")
    private List<Category> categoryList = new ArrayList<>();

    public Tournament() {
    }

    public Tournament(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Tournament(String name, String location, List<Registration> registrationList, List<Category> categoryList) {
        super();
        this.name = name;
        this.location = location;
        this.registrationList = registrationList;
        this.categoryList = categoryList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Registration> getRegistrations() {
        return registrationList;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrationList = registrations;
    }

    public void addRegistration(Registration registration) {
        this.registrationList.add(registration);
    }

    public void removeRegistration(Registration registration) {
        if (registrationList != null) {
            registrationList.remove(registration);
        }
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", registrationList=" + registrationList +
                '}';
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public void addCategory(Category category) {
        this.categoryList.add(category);
        //set up bidirectional relationship
        category.getTournamentList().add(this);
    }

    public void removeCategory(Category category) {
        if (categoryList != null) {
            categoryList.remove(category);
        }
        //update bidirectional relationship
        category.getTournamentList().remove(this);
    }
}
