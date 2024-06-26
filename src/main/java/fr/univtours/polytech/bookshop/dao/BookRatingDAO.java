package fr.univtours.polytech.bookshop.dao;

import java.util.List;

import fr.univtours.polytech.bookshop.model.bookRating.Doc;

public interface BookRatingDAO {
    public List<Doc> getDocs(String title, String author);
    public Byte getPhoto(String authorId);
    public Doc getDoc(String title, String author);
    public List<Double> getRatingCountAndAVG(String title, String author);
}
