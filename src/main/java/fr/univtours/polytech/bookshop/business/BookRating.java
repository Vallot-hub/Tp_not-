package fr.univtours.polytech.bookshop.business;

import java.util.List;

import fr.univtours.polytech.bookshop.model.bookRating.Doc;

public interface BookRating {
    public List<Doc> getDocs(String title, String author);
}
