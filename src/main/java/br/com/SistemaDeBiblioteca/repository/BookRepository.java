package br.com.SistemaDeBiblioteca.repository;

import br.com.SistemaDeBiblioteca.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel, Long> { }