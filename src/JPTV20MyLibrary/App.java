/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPTV20MyLibrary;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import myclasses.Author;
import myclasses.Author;
import myclasses.Book;
import myclasses.Book;
import myclasses.History;
import myclasses.History;
import myclasses.Reader;
import myclasses.Reader;



/**
 *
 * @author JPTV20MyLibrary
 */
public class  App{
    private Scanner scanner = new Scanner(System.in);
    private Book[] books = new Book[10];
    private Reader[] readers = new Reader[10];
    private History[] histories = new History[10];
    public void run(){
        String repeat = "r";
        do{
            System.out.println("Выберите номер задачи: ");
            System.out.println("0: Выход из программы");
            System.out.println("1: Добавить книгу");
            System.out.println("2: Список книг");
            System.out.println("3: Добавить читателя");
            System.out.println("4: Список читателей");
            System.out.println("5: Выдать книгу");
            System.out.println("6: Список выданных книг");
            int task = scanner.nextInt(); scanner.nextLine();
            switch (task) {
                case 0:
                    repeat="q";
                    System.out.println("Пока! :)");
                    break;
                case 1:
                    System.out.println("---- Добавление книги ----");
                    for (int i = 0; i < books.length; i++) {
                        if(books[i] == null){
                            books[i] = addBook();
                            break;
                        }
                    }
                    System.out.println("-----------------------");
                    break;
                case 2:
                    System.out.println("---- Список книг -----");
                    for (int i = 0; i < books.length; i++) {
                        if(books[i] != null){
                            System.out.println(books[i].toString());
                        }
                    }
                    System.out.println("-----------------------");
                    break;
                case 3:
                    System.out.println("---- Добавление читателя ----");
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i] == null){
                            readers[i] = addReader();
                            break;
                        }
                    }
                    System.out.println("-----------------------");
                    break;
                case 4:
                    System.out.println("---- Список читателей -----");
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i] != null){
                            System.out.println(readers[i].toString());
                        }
                    }
                    System.out.println("-----------------------");
                    break;
                case 5:
                    System.out.println("---- Выдать книгу -----");
                    for (int i = 0; i < histories.length; i++) {
                        if(histories[i] == null){
                            histories[i] = addHistory();
                            break;
                        }
                    }
                    System.out.println("-----------------------");
                    break;
                case 6:
                    System.out.println("---- Список выданных книг -----");
                    int n = 0;
                    for (int i = 0; i < histories.length; i++) {
                        if(histories[i] != null && histories[i].getReturnedDate() == null){
                            System.out.println(histories[i].toString());
                            n++;
                        }
                    }
                    if(n < 1){
                        System.out.println("Нет выданных книг");
                    }
                    System.out.println("-----------------------");
                    break;
                default:
                    System.out.println("Введите номер из списка!");;
            }
            
        }while("r".equals(repeat));
    }
    private Book addBook(){
        Book book = new Book();
        System.out.print("Введите название книги: ");
        book.setBookName(scanner.nextLine());
        System.out.print("Введите год публикации книги: ");
        book.setPublishedYear(scanner.nextInt()); scanner.nextLine();
        System.out.println("Автор книги: ");
        System.out.print("Введите количество авторов: ");
        int countAutors = scanner.nextInt(); scanner.nextLine();
        Author[] authors = new Author[countAutors];
        for (int i = 0; i < authors.length; i++) {
            Author author = new Author();
            System.out.print("Введите имя автора "+(i+1)+": ");
            author.setFirstname(scanner.nextLine());
            System.out.print("Введите фамилию автора: ");
            author.setLastname(scanner.nextLine());
            System.out.print("Введите год рождения автора: ");
            author.setBirthYear(scanner.nextInt());scanner.nextLine();
            authors[i] = author;
        }
        book.setAuthor(authors);
        
        return book;
    }
    private Reader addReader(){
        Reader reader = new Reader();
        System.out.print("Введите имя читателя: ");
        reader.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию читателя: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Введите телефон читателя: ");
        reader.setPhone(scanner.nextLine());
        return reader;
    }

    private History addHistory() {
        History history = new History();
        /**
         * 1. Вывести пронумерованный список книг библиотеки
         * 2. Попросить пользователя выбрать номер книги
         * 3. Вывести пронумерованный список читателей
         * 4. Попрость пользователя выбрать номер читателя
         * 5. Генерироват текущую дату
         * 6. инициировать (задать состояние) объект history
         */
        System.out.println("Список книг: ");
        for (int i = 0; i < books.length; i++) {
            if(books[i] != null){
                System.out.println(i+1+". "+books[i].toString());
            }
        }
        System.out.print("Введите номерк книги: ");
        int numberBook = scanner.nextInt(); scanner.nextLine();
        System.out.println("Список читателей: ");
        for (int i = 0; i < readers.length; i++) {
            if(readers[i] != null){
                System.out.println(i+1+". "+readers[i].toString());
            }
        }
        System.out.print("Введите номерк читателя: ");
        int numberReader = scanner.nextInt(); scanner.nextLine();
        history.setBook(books[numberBook-1]);
        history.setReader(readers[numberReader-1]);
        Calendar c = new GregorianCalendar();
        history.setGivenDate(c.getTime());
        return history;
    }
        
}