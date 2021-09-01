package com.management.elder.elements;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DataRepository extends JpaRepository<Data, Long> {
    Optional<Data> findAllByDataOldNoEquals(Long no);
}
