package com.king.service;

import com.king.dto.BookRequestDTO;
import com.king.entity.Book;
import com.king.repository.BookRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class BookService {
    @Inject
    BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.listAll();
    }

    public Book getBookById(Long id) {
        Book existingBook = bookRepository.findById(id);

        if (existingBook == null) {
            throw new IllegalArgumentException("Book  with id : " + id + " not found");
        }

        return existingBook;
    }

    @Transactional
    public Book addBook(BookRequestDTO bookRequestDTO) {
        Book book = new Book();
        book.setTitle(bookRequestDTO.getTitle());
        book.setPageCount(bookRequestDTO.getPageCount());
        bookRepository.persist(book);
        return book;
    }

    @Transactional
    public Book updateBook(Long id, BookRequestDTO bookRequestDTO) {
        Book existingBook = getBookById(id);

        existingBook.setTitle(bookRequestDTO.getTitle());
        existingBook.setPageCount(bookRequestDTO.getPageCount());
        return existingBook;
    }

    @Transactional
    public String deleteBook(Long id) {
        Book existingBook = getBookById(id);
        bookRepository.delete(existingBook);

        return "Successfully delete book with id : " + id;
    }
}
