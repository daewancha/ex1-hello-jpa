package hellojpa.shop.domain;

import javax.persistence.Entity;

@Entity
public class Book extends InItem {

    private String author;
    private String isbn;
}
