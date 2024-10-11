package br.com.SistemaDeBiblioteca.service;

import br.com.SistemaDeBiblioteca.model.AuthorModel;
import br.com.SistemaDeBiblioteca.model.BookModel;
import br.com.SistemaDeBiblioteca.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>MENU BOOK<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("0. Salir");
            System.out.println("1. Editar libro");
            System.out.println("2. Ver libro");
            System.out.println("3. Eliminar libro");
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
                    editBook(scanner);
                    break;
                case 2:
                    viewBook(scanner);
                    break;
                case 3:
                    deleteBook(scanner);
                    break;
                default:
                    System.out.println("¡La opción no es válida!");
            }
        }

    }

    public List<BookModel> createBook(Scanner scanner, AuthorModel authorModel) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>CREAR BOOK<<<<<<<<<<<<<<<<<<<<<<");
        List<BookModel> bookModelList = new ArrayList<>();

        while (true) {
            BookModel bookModel = new BookModel();
            System.out.print("Introduce el título del libro: ");
            bookModel.setTitle(scanner.nextLine());
            System.out.print("Introduzca el año de publicación del libro: ");
            bookModel.setYearPublication(scanner.nextInt());
            scanner.nextLine();

            bookModel.setAuthor(authorModel);
            bookModelList.add(bookModel);

            System.out.print("¿Quieres añadir otro libro? (s/n) ?");
            String resp = scanner.nextLine().trim().toUpperCase();
            if (resp.equals("N")) {
                break;
            } else if (!resp.equals("S")) {
                System.out.println("respuesta equivocada! Simplemente escriba S para continuar y N para salir.");
            }
        }
        return bookModelList;
    }

    public void editBook(Scanner scanner) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>EDITAR LIBRO<<<<<<<<<<<<<<<<<<<<<<");
        BookModel bookModel = new BookModel();
        while (true) {
            System.out.print("introduce el ID del libro: ");
            bookModel.setId(scanner.nextLong());
            scanner.nextLine();

            Optional<BookModel> bookModelOptional = bookRepository.findById(bookModel.getId());
            if (bookModelOptional.isPresent()) {
                bookModel = bookModelOptional.get();

                System.out.print("Introduce el título del libro: ");
                bookModel.setTitle(scanner.nextLine());

                System.out.print("Introduzca el año de publicación del libro: ");
                bookModel.setYearPublication(scanner.nextInt());
                scanner.nextLine();

                bookRepository.save(bookModel);
                System.out.println("Libro editado exitosamente");
                break;
            } else {
                System.out.println("ID del libro no fue encontrado");
            }
        }
    }

    private void viewBook(Scanner scanner) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>VER LIBRO<<<<<<<<<<<<<<<<<<<<<<");
        BookModel bookModel = new BookModel();
        while (true) {
            System.out.print("introduce el ID del libro: ");
            bookModel.setId(scanner.nextLong());
            scanner.nextLine();

            Optional<BookModel> bookModelOptional = bookRepository.findById(bookModel.getId());
            if (bookModelOptional.isPresent()) {
                bookModel = bookModelOptional.get();
                System.out.println(bookModel);
                break;
            } else {
                System.out.println("ID del libro no fue encontrado");
            }
        }
    }

    private void deleteBook(Scanner scanner) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>ELIMINAR LIBRO<<<<<<<<<<<<<<<<<<<<<<");
        BookModel bookModel = new BookModel();
        while (true) {
            System.out.print("introduce el ID del libro: ");
            bookModel.setId(scanner.nextLong());
            scanner.nextLine();

            Optional<BookModel> bookModelOptional = bookRepository.findById(bookModel.getId());
            if (bookModelOptional.isPresent()) {
                try {
                    bookRepository.deleteById(bookModel.getId());
                    System.out.println("Autor eliminado exitosamente");
                    break;
                } catch (Exception e) {
                    System.out.println("Se produjo un error inesperado al intentar eliminar el libro: " + e.getMessage());
                }
            } else {
                System.out.println("ID del libro no fue encontrado");
            }
        }
    }
}
