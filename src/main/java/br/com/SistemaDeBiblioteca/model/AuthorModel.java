package br.com.SistemaDeBiblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@Data
public class AuthorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre no puede estar nulo.")
    @NotEmpty(message = "El nombre no puede estar vacío.")
    private String name;

    @NotNull(message = "La nacionalidad no puede estar nulo.")
    @NotEmpty(message = "La nacionalidad no puede estar vacío.")
    private String nationality;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<BookModel> bookModelList = new ArrayList<>();

    public AuthorModel() {}

    @Override
    public String toString() {
        return "AuthorModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
