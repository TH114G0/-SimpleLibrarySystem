package br.com.SistemaDeBiblioteca;

import br.com.SistemaDeBiblioteca.service.AuthorService;
import br.com.SistemaDeBiblioteca.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>MENÚ PRINCIPAL<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("0. Salir");
            System.out.println("1. Autor");
            System.out.println("2. Libro");
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
                    authorService.menu(scanner);
                    break;
                case 2:
                    bookService.menu(scanner);
                    break;
                default:
                    System.out.println("¡La opción no es válida!");
            }
        }
    }
}