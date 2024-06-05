package fr.univtours.polytech.bookshop.business;

import java.util.List;

import fr.univtours.polytech.bookshop.dao.BookRatingDAO;
import fr.univtours.polytech.bookshop.dao.BookRatingDAOImpl;
import fr.univtours.polytech.bookshop.model.bookRating.Doc;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class BookRatingBusinessImpl implements BookRatingBusiness {
    
    @Inject
    private BookRatingDAO bookRating = new BookRatingDAOImpl();
    
    @Override
    public List<Doc> getDocs(String title, String author) {
        return this.bookRating.getDocs(title, author);
    }

    @Override
    public Doc getDoc(String title, String author) {
        return this.bookRating.getDoc(title, author);
    }

    @Override
    public Byte getPhoto(String authorId) {
        return this.bookRating.getPhoto(authorId);
    }
    @Override
    public List<Double> getRatingCountAndAVG(String title, String author){
        return this.bookRating.getRatingCountAndAVG(title, author);
    }
}
