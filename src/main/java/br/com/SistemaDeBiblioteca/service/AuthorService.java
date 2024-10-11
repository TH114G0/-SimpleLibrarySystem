package br.com.SistemaDeBiblioteca.service;

import br.com.SistemaDeBiblioteca.model.AuthorModel;
import br.com.SistemaDeBiblioteca.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>MENÚ AUTOR<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("0. Salir");
            System.out.println("1. Crear autor");
            System.out.println("2. Editar autor");
            System.out.println("3. Ver autor");
            System.out.println("4. Eliminar autor");
            int resp = 0;
            try {
                resp = scanner.nextInt();
                scanner.nextLine();
            } catch (ArithmeticException e) {
                System.err.println("¡Opción equivocada! Solo numeros.");
                scanner.nextLine();
                continue;
            }
            switch (resp) {
                case 0:
                    return;
                case 1:
                    createAuthor(scanner);
                    break;
                case 2:
                    editAuthor(scanner);
                    break;
                case 3:
                    viewAuthor(scanner);
                    break;
                case 4:
                    deleteAuthor(scanner);
                    break;
                default:
                    System.out.println("¡La opción no es válida!");
            }
        }
    }

    public void createAuthor(Scanner scanner) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>CREAR AUTOR<<<<<<<<<<<<<<<<<<<<<<");
        AuthorModel authorModel = new AuthorModel();
        BookService bookService = new BookService();


        System.out.print("Introduzca el nombre del autor: ");
        authorModel.setName(scanner.nextLine());
        System.out.print("Ingrese la nacionalidad del autor: ");
        authorModel.setNationality(scanner.nextLine());


        authorModel.setBookModelList(bookService.createBook(scanner, authorModel));
        try {
            authorRepository.save(authorModel);
            System.out.println("Autor guardado exitosamente");
        } catch (Exception e) {
            System.err.println("¡Error! inesperado al guardar autor");
        }
    }

    public void editAuthor(Scanner scanner) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>EDITAR AUTOR<<<<<<<<<<<<<<<<<<<<<<");
        AuthorModel authorModel = new AuthorModel();
        while (true) {
            System.out.print("Introduzca el ID del autor: ");
            authorModel.setId(scanner.nextLong());
            scanner.nextLine();

            Optional<AuthorModel> optionalAuthorModel = authorRepository.findById(authorModel.getId());
            if (optionalAuthorModel.isPresent()) {
                authorModel = optionalAuthorModel.get();

                System.out.print("Introduzca el nombre del autor: ");
                authorModel.setName(scanner.nextLine());

                System.out.print("Ingrese la nacionalidad del autor: ");
                authorModel.setNationality(scanner.nextLine());

                authorRepository.save(authorModel);
                System.out.println("Autor editado exitosamente");
                break;
            } else {
                System.out.println("ID del autor no fue encontrado");
            }
        }
    }

    public void viewAuthor(Scanner scanner) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>VER AUTOR<<<<<<<<<<<<<<<<<<<<<<");
        AuthorModel authorModel = new AuthorModel();
        while (true) {
            System.out.print("Introduzca el ID del autor: ");
            authorModel.setId(scanner.nextLong());
            scanner.nextLine();

            Optional<AuthorModel> optionalAuthorModel = authorRepository.findById(authorModel.getId());
            if (optionalAuthorModel.isPresent()) {
                System.out.println(optionalAuthorModel);
                break;
            } else {
                System.out.println("ID del autor no fue encontrado");
            }
        }
    }

    public void deleteAuthor(Scanner scanner) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>ELIMINAR AUTOR<<<<<<<<<<<<<<<<<<<<<<");
        AuthorModel authorModel = new AuthorModel();
        while (true) {
            System.out.print("Introduzca el ID del autor: ");
            authorModel.setId(scanner.nextLong());
            scanner.nextLine();

            Optional<AuthorModel> optionalAuthorModel = authorRepository.findById(authorModel.getId());
            if (optionalAuthorModel.isPresent()) {
                try {
                    authorRepository.deleteById(authorModel.getId());
                    System.out.println("Autor eliminado exitosamente");
                    break;
                } catch (Exception e) {
                    System.out.println("Se produjo un error inesperado al intentar eliminar el autor: " + e.getMessage());
                }
            } else {
                System.out.println("ID del autor no fue encontrado. Intente nuevamente.");
            }
        }
    }
}
