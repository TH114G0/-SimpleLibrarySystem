package br.com.SistemaDeBiblioteca.repository;

import br.com.SistemaDeBiblioteca.model.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorModel, Long> { }