package nl.novi.les.springboot.backendtechiteasy.repositories;

import nl.novi.les.springboot.backendtechiteasy.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Television, Long> {

    List<Television> findTelevisionsByTypeEqualsIgnoreCase(String type);

    List<Television> findTelevisionsByBrandEqualsIgnoreCase(String brand);

    List<Television> findTelevisionsByNameEqualsIgnoreCase(String name);

    List<Television> findTelevisionsByPriceIs(double price);

}
