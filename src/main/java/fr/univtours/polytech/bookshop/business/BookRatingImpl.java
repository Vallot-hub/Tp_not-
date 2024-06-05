package fr.univtours.polytech.bookshop.business;

import java.util.List;

import fr.univtours.polytech.bookshop.dao.BookRatingDAO;
import fr.univtours.polytech.bookshop.dao.BookRatingDAOImpl;
import fr.univtours.polytech.bookshop.model.bookRating.Doc;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class BookRatingImpl implements BookRating {
    
    @Inject
    private BookRatingDAO bookRaking = new BookRatingDAOImpl();
    
    @Override
    public List<Doc> getDocs(String title, String author) {
        return this.bookRaking.getDocs(title, author);
    }
}
