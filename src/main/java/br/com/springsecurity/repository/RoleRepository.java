package br.com.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springsecurity.entities.Role;


@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {
    
    Role findByName(String name);
    
}

