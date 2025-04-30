package kr.ac.kopo.mkj.bookmarket.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
//@Getter //공백 있으면 안됨 바로 붙어있어야 함
//@Setter
//@NoArgsConstructor
public class Book {
    private String bookId; //도서번호
    private String name; //도서명
    private BigDecimal unitPrice; //단가
    private String author; //저자
    private String description; //도서설명
    private String publisher;//출판사
    private String category;//분류
    private long unitsInStock;//재고량
    private String releaseDate;//출판일
    private String condition;//신규도서 or 중고도서 or 전자책
}

