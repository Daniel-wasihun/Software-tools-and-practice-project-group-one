
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieRecordApp {
    private List<MovieRecord> movieList;
    private Scanner scanner;

    public MovieRecordApp() {
        movieList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        MovieRecordApp app = new MovieRecordApp();
        app.run();
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a movie");
            System.out.println("2. Find a movie");
            System.out.println("3. Update a movie");
            System.out.println("4. Delete a movie");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    findMovie();
                    break;
                case 3:
                    updateMovie();
                    break;
                case 4:
                    deleteMovie();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
        scanner.close();
    }

    public void addMovie() {
        System.out.println("Enter title:");
        String title = scanner.nextLine();
        System.out.println("Enter director:");
        String director = scanner.nextLine();
        System.out.println("Enter year:");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        MovieRecord movie = new MovieRecord(title, director, year);
        movieList.add(movie);
        System.out.println("Movie added successfully.");
    }

    public void findMovie() {
        System.out.println("Enter title to search:");
        String title = scanner.nextLine();

        for (MovieRecord movie : movieList) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Movie found:");
                System.out.println(movie);
                return;
            }
        }
        System.out.println("Movie not found.");
    }

    public void updateMovie() {
        System.out.println("Enter title to update:");
        String title = scanner.nextLine();

        for (MovieRecord movie : movieList) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Enter new title:");
                String newTitle = scanner.nextLine();
                System.out.println("Enter new director:");
                String newDirector = scanner.nextLine();
                System.out.println("Enter new year:");
                int newYear = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                movie.setTitle(newTitle);
                movie.setDirector(newDirector);
                movie.setYear(newYear);
                System.out.println("Movie updated successfully.");
                return;
            }
        }
        System.out.println("Movie not found.");
    }

    public void deleteMovie() {
        System.out.println("Enter title to delete:");
        String title = scanner.nextLine();

        for (MovieRecord movie : movieList) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                movieList.remove(movie);
                System.out.println("Movie deleted successfully.");
                return;
            }
        }
        System.out.println("Movie not found.");
    }
}

class MovieRecord {
    private String title;
    private String director;
    private int year;

    public MovieRecord(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Director: " + director + ", Year: " + year;
    }
}
