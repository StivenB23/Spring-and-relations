package com.sena.learnspringboot.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository  extends JpaRepository<Usuario, Integer> {
    
}
