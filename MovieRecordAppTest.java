import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MovieRecordAppTest {
    private final InputStream systemIn = System.in;
    private final MovieRecordApp app = new MovieRecordApp();
    private final List<MovieRecord> movieList = app.getMovieList();

    @BeforeEach
    public void setUp() {
        // Set up mock input for testing
        String mockInput = "1\nTitle1\nDirector1\n2000\n5\n";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));
    }

    @AfterEach
    public void tearDown() {
        // Restore original System.in
        System.setIn(systemIn);
    }

    @Test
    public void testAddMovie() {
        app.run();
        assertEquals(1, movieList.size());
        assertEquals("Title1", movieList.get(0).getTitle());
        assertEquals("Director1", movieList.get(0).getDirector());
        assertEquals(2000, movieList.get(0).getYear());
    }

    @Test
    public void testFindMovie() {
        // Add a movie to the list
        movieList.add(new MovieRecord("Title2", "Director2", 2005));

        // Mock user input for finding a movie
        String mockInput = "2\nTitle2\n5\n";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        app.run();

        // Verify that the movie is found
        assertEquals(1, movieList.size());
        assertEquals("Title2", movieList.get(0).getTitle());
        assertEquals("Director2", movieList.get(0).getDirector());
        assertEquals(2005, movieList.get(0).getYear());
    }

    @Test
    public void testUpdateMovie() {
        // Add a movie to the list
        movieList.add(new MovieRecord("Title3", "Director3", 2010));

        // Mock user input for updating a movie
        String mockInput = "3\nTitle3\nNewTitle\nNewDirector\n2020\n5\n";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        app.run();

        // Verify that the movie is updated
        assertEquals(1, movieList.size());
        assertEquals("NewTitle", movieList.get(0).getTitle());
        assertEquals("NewDirector", movieList.get(0).getDirector());
        assertEquals(2020, movieList.get(0).getYear());
    }

    @Test
    public void testDeleteMovie() {
        // Add a movie to the list
        movieList.add(new MovieRecord("Title4", "Director4", 2015));

        // Mock user input for deleting a movie
        String mockInput = "4\nTitle4\n5\n";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        app.run();

        // Verify that the movie is deleted
        assertEquals(0, movieList.size());
    }
}

