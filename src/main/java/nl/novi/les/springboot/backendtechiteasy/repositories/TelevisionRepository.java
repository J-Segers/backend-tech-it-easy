package nl.novi.les.springboot.backendtechiteasy.repositories;

import nl.novi.les.springboot.backendtechiteasy.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
}
