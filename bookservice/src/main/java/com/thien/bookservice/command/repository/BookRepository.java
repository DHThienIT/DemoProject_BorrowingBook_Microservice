package com.thien.bookservice.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thien.bookservice.command.data.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

}
