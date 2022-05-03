package nl.novi.les.springboot.backendtechiteasy.repositories;

import nl.novi.les.springboot.backendtechiteasy.models.entities.RemoteControl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemoteControlRepository extends JpaRepository<RemoteControl, Long> {
}
