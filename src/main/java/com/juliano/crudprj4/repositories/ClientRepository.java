package com.juliano.crudprj4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juliano.crudprj4.entities.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {

}
