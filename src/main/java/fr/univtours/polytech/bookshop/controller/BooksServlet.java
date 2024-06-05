package fr.univtours.polytech.bookshop.controller;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.bookshop.business.BookBusiness;
import fr.univtours.polytech.bookshop.business.BookRatingBusiness;
import fr.univtours.polytech.bookshop.model.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("books")
public class BooksServlet extends HttpServlet {

    @Inject
    private BookBusiness bookBusiness;

    @Inject
    private BookRatingBusiness bookRatingBusiness;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<BookBean> books = this.bookBusiness.getBooks();
        for (BookBean book : books) {
            List<Double> listeRating = bookRatingBusiness.getRatingCountAndAVG(book.getTitle(), book.getAuthor());
            System.out.print(listeRating != null);
            if (listeRating != null) {
                System.out.print(listeRating.get(0));
                System.out.print(listeRating.get(1));
                book.setRatingAverage(listeRating.get(1));
                Integer count = (Integer) (int) (double) listeRating.get(0);
                book.setRatingCount(count);
            }

        }

        request.setAttribute("BOOKS", books);

        request.getRequestDispatcher("books.jsp").forward(request, response);
    }
}
