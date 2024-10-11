package br.com.SistemaDeBiblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private int yearPublication;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private AuthorModel author;

    public BookModel() {}

    @Override
    public String toString() {
        return "BookModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearPublication=" + yearPublication +
                '}';
    }
}
