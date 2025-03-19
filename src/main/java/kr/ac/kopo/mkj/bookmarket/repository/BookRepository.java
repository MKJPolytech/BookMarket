package kr.ac.kopo.mkj.bookmarket.repository;

import java.util.List;
import kr.ac.kopo.mkj.bookmarket.domain.Book;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository {
    List<Book> getAllBookList();
}
