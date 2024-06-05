package fr.univtours.polytech.bookshop.rest;

import java.util.ArrayList;
import java.util.List;

import fr.univtours.polytech.bookshop.business.BookBusiness;
import fr.univtours.polytech.bookshop.model.BookBean;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Stateless
@Path("v1")
public class BookRest {

    @EJB
    BookBusiness bookBusiness;

    @Path("books")
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<BookBean> getBooks(@QueryParam("auteur") String auteur, @QueryParam("titre") String titre) {
        List<BookBean> ListeBooksFiltré = new ArrayList<>();
        for (BookBean bookBean : bookBusiness.getBooks()) {
            Boolean EstDansLeFiltreAuteur = true;
            Boolean EstDansLeFiltreTitre = true;
            if (auteur != null) {
                EstDansLeFiltreAuteur = bookBean.getAuthor().toLowerCase().contains(auteur.toLowerCase());
            }
            if (titre != null) {
                EstDansLeFiltreTitre = bookBean.getTitle().toLowerCase().contains(titre.toLowerCase());
            }
            if (EstDansLeFiltreAuteur && EstDansLeFiltreTitre) {
                ListeBooksFiltré.add(bookBean);
            }
        }
        return ListeBooksFiltré;
    }

    @Path("books/{id}")
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public BookBean getBooksbyId(@PathParam("id") Integer id) {
        return bookBusiness.getBook(id);
    }

    @PATCH
    @Path("books/{id}")
    public Response partialUpdateBook(@PathParam("id") Integer id, BookBean bookBean,
            @HeaderParam(HttpHeaders.AUTHORIZATION) String auth) {

        if (!"42".equals(auth)) {
            return Response.status(Status.UNAUTHORIZED).build();
        }
        BookBean oldBook = bookBusiness.getBook(id);
        if (null == oldBook) {
            return Response.status(Status.NOT_FOUND).build();
        }

        if (null != bookBean.getAuthor() && !"".equals(bookBean.getAuthor())) {
            oldBook.setAuthor(bookBean.getAuthor());
        }
        if (null != bookBean.getTitle() && !"".equals(bookBean.getTitle())) {
            oldBook.setTitle(bookBean.getTitle());
        }
        if (null != bookBean.getPrice()) {
            oldBook.setPrice(bookBean.getPrice());
        }
        // A tester si la currency est valide.(Enfaite ça marche pas)
        if (null != bookBean.getCurrency()) {
            oldBook.setCurrency(bookBean.getCurrency());
        }
        bookBusiness.updateBook(oldBook);
        return Response.status(Status.ACCEPTED).build();

    }

    @PUT
    @Path("books/{id}")
    public Response fullUpdateBook(@PathParam("id") Integer idLocation, BookBean bookBean,
            @HeaderParam(HttpHeaders.AUTHORIZATION) String auth) {
        if (!"42".equals(auth)) {
            return Response.status(Status.UNAUTHORIZED).build();
        }

        BookBean oldBook = bookBusiness.getBook(idLocation);
        if (null == oldBook) {
            return Response.status(Status.NOT_FOUND).build();
        }

        oldBook.setAuthor(bookBean.getAuthor());
        // A tester si la currency est valide.(Enfaite ça marche pas)
        oldBook.setCurrency(bookBean.getCurrency());
        oldBook.setPrice(bookBean.getPrice());
        oldBook.setTitle(bookBean.getTitle());
        bookBusiness.updateBook(oldBook);
        return Response.status(Status.ACCEPTED).build();
    }

    @DELETE
    @Path("books/{id}")
    public Response deleteBook(@PathParam("id") Integer id,
            @HeaderParam(HttpHeaders.AUTHORIZATION) String auth) {
        System.out.println(auth);
        if (!"42".equals(auth)) {
            return Response.status(Status.UNAUTHORIZED).build();
        } else {
            BookBean book = bookBusiness.getBook(id);
            if (null == book) {
                return Response.status(Status.NOT_FOUND).build();
            } else {
                bookBusiness.removeBook(id);
                return Response.status(Status.NO_CONTENT).build();
            }
        }
    }

    @POST
    @Path("books")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response createLocation(BookBean bookBean, @HeaderParam(HttpHeaders.AUTHORIZATION) String auth) {
        if (!"42".equals(auth)) {
            return Response.status(Status.UNAUTHORIZED).build();
        } else {
            bookBusiness.createBook(bookBean);
            return Response.status(Status.ACCEPTED).build();
        }
    }

}
