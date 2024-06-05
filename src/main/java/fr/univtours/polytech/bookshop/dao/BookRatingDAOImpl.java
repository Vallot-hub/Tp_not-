package fr.univtours.polytech.bookshop.dao;

import java.util.List;

import fr.univtours.polytech.bookshop.model.bookRating.Book;
import fr.univtours.polytech.bookshop.model.bookRating.Doc;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

@Stateless
public class BookRatingDAOImpl implements BookRatingDAO{
    
    public List<Doc> getDocs(String title, String author) {
        String url = "https://openlibrary.org/search.json";
        Client client = ClientBuilder.newClient();


        WebTarget target = client.target(url);

        String filed = "first_sentence,title,author_name,ratings_count,ratings_average,author_key";

        target = target.queryParam("q", title+"-"+author);
        target = target.queryParam("fields", filed);
        target = target.queryParam("limit", 1);
        System.out.println(target.getUri());
        Book book = target.request(MediaType.APPLICATION_JSON).get(Book.class);
        System.out.println("Dao "+ book.getDocs().get(0).getRatings_average().toString());
        return book.getDocs();
    }

    
    
    public Byte getPhoto(String authorId){
        Client client = ClientBuilder.newClient();
        String url = "https://covers.openlibrary.org/a/olid/"+authorId+".jpg";
        WebTarget target = client.target(url);

        Byte image = target.request().get(byte.class);
        return image;
    }



   
}
