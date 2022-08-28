package com.sena.learnspringboot.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolRepository  extends JpaRepository<Rol, Integer> {
    
}
