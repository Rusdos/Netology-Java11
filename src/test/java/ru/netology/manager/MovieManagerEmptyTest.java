package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerEmptyTest {
    private MovieManager manager = new MovieManager();

    @Test
    public void shouldRemoveEmptyMovieManager(){
        int idToRemove = 0;
        manager.removeById(idToRemove);
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected,actual);
    }

}
