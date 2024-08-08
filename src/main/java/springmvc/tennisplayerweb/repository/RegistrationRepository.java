package springmvc.tennisplayerweb.repository;

import springmvc.tennisplayerweb.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
}
