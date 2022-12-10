package ru.nickzay.dataservice.count;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CountsRepository extends JpaRepository<CountEntity, Long> {
    Optional<CountEntity> findByName(String name);
}
