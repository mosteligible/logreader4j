package com.example.client.clientel.atithi;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtithiRepository extends JpaRepository<Atithi, String> {

	Optional<Atithi> findAtithiById(String id);
}
