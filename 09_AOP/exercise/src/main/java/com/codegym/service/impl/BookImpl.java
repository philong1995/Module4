package com.codegym.service.impl;

import com.codegym.entity.Book;
import com.codegym.entity.LibraryCard;
import com.codegym.repository.BookRepository;
import com.codegym.repository.LibraryCardRepository;
import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LibraryCardRepository libraryCardRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void borrowBook(String id_card, int id_book) {
        Book book = findById(id_book);
        LibraryCard libraryCard = this.libraryCardRepository.findById(Integer.parseInt(id_card)).orElse(null);

        int amount = book.getAmount();
        book.getCardList().add(libraryCard);
        libraryCard.getBookList().add(book);

        --amount;
        book.setAmount(amount);
        save(book);
    }

    @Override
    public void payBook(int idCard, int idBook) throws Exception {
        Book book = findById(idBook);
        LibraryCard libraryCard = this.libraryCardRepository.findById(idCard).orElse(null);

        if (book.getCardList().remove(libraryCard) && libraryCard.getBookList().remove(book)) {
            int amount = book.getAmount();
            ++amount;
            book.setAmount(amount);
            save(book);
        } else {
            throw new Exception();
        }
    }

    @Override
    public int getAmount(int id) {
        return findById(id).getAmount();
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public Page<Book> searchBookByName(String keyword, Pageable pageable) {
        return this.bookRepository.findAllByNameContaining(keyword, pageable);
    }
}
