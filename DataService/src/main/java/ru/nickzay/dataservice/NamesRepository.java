package ru.nickzay.dataservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NamesRepository extends JpaRepository<Name, Long> {
    Optional<Name> findByName(String name);
}
