package fr.univtours.polytech.bookshop.business;

import java.util.List;

import fr.univtours.polytech.bookshop.model.bookRating.Doc;

public interface BookRatingBusiness {
    public List<Doc> getDocs(String title, String author);
    public Byte getPhoto(String authorId);
    public Doc getDoc(String title, String author);
    public List<Double> getRatingCountAndAVG(String title, String author);
}
