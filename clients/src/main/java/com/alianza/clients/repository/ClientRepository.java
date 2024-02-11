package com.alianza.clients.repository;

import com.alianza.clients.models.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findBySharedKey(String sharedKey);
}
