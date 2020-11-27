package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    private MovieManager manager = new MovieManager();
    private Movie first = new Movie(1, "Бладшот", "Боевик", "", false);
    private Movie second = new Movie(2, "Вперёд", "Мультфильм", "", false);
    private Movie third = new Movie(3, "Отель 'Белград'", "Комедия", "", false);
    private Movie fourth = new Movie(4, "Джентельмены", "Боевик", "", false);
    private Movie fifth = new Movie(5, "Человек-невидимка", "Ужасы", "", false);
    private Movie sixth = new Movie(6, "Тролли. Мировой тур", "Мультфильм", "", true);
    private Movie seventh = new Movie(7, "Номер один", "Комедия", "", true);


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        manager.removeById(idToRemove);

        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{seventh, sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 8;
        manager.removeById(idToRemove);
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldGetWhenOneMovie(){
        MovieManager managerGet = new MovieManager();
        managerGet.add(first);
        Movie[] actual = managerGet.getLast();
        Movie[] expected = new Movie[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetWhenManyMovies(){
        MovieManager managerGet = new MovieManager();
        managerGet.add(first);
        managerGet.add(second);
        managerGet.add(third);
        managerGet.add(fourth);
        managerGet.add(fifth);
        managerGet.add(sixth);
        managerGet.add(seventh);
        Movie[] actual = managerGet.getLast();
        Movie[] expected = new Movie[]{seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetWhenNoMovies(){
        MovieManager managerGet = new MovieManager();
        Movie[] actual = managerGet.getLast();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }




}