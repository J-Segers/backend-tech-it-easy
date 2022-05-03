package nl.novi.les.springboot.backendtechiteasy.repositories;

import nl.novi.les.springboot.backendtechiteasy.models.entities.CIModule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CIModuleRepository extends JpaRepository<CIModule, Long> {
}
