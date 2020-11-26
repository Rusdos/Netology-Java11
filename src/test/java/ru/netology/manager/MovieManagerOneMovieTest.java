package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerOneMovieTest {
   // private MovieManager manager = new MovieManager();
    private Movie first = new Movie(1, "Бладшот", "Боевик", "", false);

 /*   @BeforeEach
    public void setUp() {
        manager.add(first);
    }*/

    @Test
    public void shouldRemoveOneMovie() {
        MovieManager manager = new MovieManager();
        manager.add(first);
        int idToRemove = 1;
        manager.removeById(idToRemove);
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLast(){
        MovieManager managerGet = new MovieManager();
        managerGet.add(first);
        Movie[] actual = managerGet.getLast();
        Movie[] expected = new Movie[]{first};
        assertArrayEquals(expected, actual);
    }
}
