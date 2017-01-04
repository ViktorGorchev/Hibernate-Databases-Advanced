package app.terminal;

import app.domain.Author;
import app.domain.Book;
import app.domain.Category;
import app.domain.enums.AgeRestriction;
import app.domain.enums.EditionType;
import app.sevice.AuthorService;
import app.sevice.BookService;
import app.sevice.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.StreamSupport;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public void run(String... strings) throws Exception {
        if(this.dataBaseIsEmpty()){
            this.seedDatabase();
        }

        //8 - 1.	Get all books after the year 2000. Print only their titles.
        Iterable<Book> books = this.bookService.findBooks();
        for (Book book : books) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(book.getReleaseDate());
            int year = cal.get(Calendar.YEAR);

            if (year <= 2000) {
                continue;
            }

            System.out.println(book.getTitle());
        }


        //8 - 2.	Get all authors with at least one book with release date before 1990.
        // Print their first name and last name.
        Iterable<Author> authors = this.authorService.findAuthors();

        for (Author author : authors) {
            if (author.getBooksByAuthor().size() == 0){
                continue;
            }

            boolean authorHasBook = false;
            for (Book book : author.getBooksByAuthor()) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(book.getReleaseDate());
                int year = cal.get(Calendar.YEAR);

                if(year >= 1990){
                    continue;
                }

                authorHasBook = true;
                break;
            }

            if (authorHasBook){
                System.out.println(author.getFirstName() + " " + author.getLastName());
            }
        }


        //8 - 3.	Get all authors, ordered by the number of their books (descending).
        // Print their first name, last name and book count.
        Iterable<Author> authors2 = this.authorService.findAuthors();
        StreamSupport.stream(authors2.spliterator(), false)
                .sorted((b1, b2) -> Integer.compare(b2.getBooksByAuthor().size(), b1.getBooksByAuthor().size()))
                .forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName() + " " + a.getBooksByAuthor().size()));


        //8 - 4.	Get all books from author George Powell, ordered by their release date (descending),
        // then by book title (ascending). Print the book's title, release date and copies.
        Iterable<Book> booksByAuthor =
                this.bookService.allBooksFromAuthor(this.authorService.findAuthor("George Powell"));

        for (Book book : booksByAuthor) {
            System.out.println(book.getTitle() + "- " + book.getReleaseDate() + " - " + book.getCopies());
        }


        //9 - Related Books
        List<Book> booksAll = (List<Book>) bookService.findBooks();
        List<Book> threeBooks = booksAll.subList(0, 3);

        threeBooks.get(0).getRelatedBooks().add(threeBooks.get(1));
        threeBooks.get(1).getRelatedBooks().add(threeBooks.get(0));
        threeBooks.get(2).getRelatedBooks().add(threeBooks.get(0));

        for (Book book : threeBooks) {
            bookService.save(book);
        }

        for (Book book : threeBooks) {
            System.out.printf("--%s\n", book.getTitle());
            for (Book relatedBook : book.getRelatedBooks()) {
                System.out.println(relatedBook.getTitle());
            }
        }
    }

    private void seedDatabase() throws IOException, ParseException, java.text.ParseException {
        List<Author> authors = this.seedAuthors();
        List<Category> categories = this.seedCategories();

        this.seedBooks(authors, categories);
    }

    private void seedBooks(List<Author> authors, List<Category> categories) throws IOException, java.text.ParseException {
        BufferedReader booksReader = new BufferedReader(new FileReader("res/books.txt"));
        String line = booksReader.readLine();
        while ((line = booksReader.readLine()) != null) {
            String[] data = line.split("\\s+");

            Random random = new Random();
            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);

            Random randomCategory = new Random();
            int categoryIndex = randomCategory.nextInt(categories.size());
            Category category = categories.get(categoryIndex);

            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            book.getBooksByCategory().add(category);

            this.bookService.save(book);
        }
    }

    private List<Category> seedCategories() throws IOException {
        List<Category> categories = new ArrayList<>();

        BufferedReader categoriesReader = new BufferedReader(new FileReader("res/categories.txt"));
        String line = categoriesReader.readLine();
        while ((line = categoriesReader.readLine()) != null) {
            String[] data = line.split("\\s+");

            String categoryName = data[0].trim();

            Category category = new Category(categoryName);
            categories.add(category);

            this.categoryService.save(category);
        }

        return categories;
    }

    private List<Author> seedAuthors() throws IOException {
        List<Author> authors = new ArrayList<>();

        BufferedReader autorsReader = new BufferedReader(new FileReader("res/authors.txt"));
        String line = autorsReader.readLine();
        while ((line = autorsReader.readLine()) != null) {
            String[] data = line.split("\\s+");

            String firstName = data[0];
            String lastName = data[1];

            Author author = new Author(firstName, lastName);
            authors.add(author);

            this.authorService.save(author);
        }

        return authors;
    }

    private boolean dataBaseIsEmpty() {
        boolean authorsIsEmpty = this.authorService.authorsCount() == 0;
        boolean booksIsEmpty = this.bookService.booksCount() == 0;
        boolean categoriesIsEmpty = this.categoryService.categoriesCount() == 0;

        if(authorsIsEmpty || booksIsEmpty || categoriesIsEmpty){
            return true;
        }

        return false;
    }
}