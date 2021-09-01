package com.management.elder.elements;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> findAllByStatusOldNoEquals(Long no);
}
