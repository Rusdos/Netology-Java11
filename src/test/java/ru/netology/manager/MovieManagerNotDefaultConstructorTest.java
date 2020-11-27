package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerNotDefaultConstructorTest {
    MovieManager managerLess = new MovieManager(5);
    MovieManager managerEqual = new MovieManager(7);
    MovieManager managerMore = new MovieManager(11);
    private Movie first = new Movie(1, "Бладшот", "Боевик", "", false);
    private Movie second = new Movie(2, "Вперёд", "Мультфильм", "", false);
    private Movie third = new Movie(3, "Отель 'Белград'", "Комедия", "", false);
    private Movie fourth = new Movie(4, "Джентельмены", "Боевик", "", false);
    private Movie fifth = new Movie(5, "Человек-невидимка", "Ужасы", "", false);
    private Movie sixth = new Movie(6, "Тролли. Мировой тур", "Мультфильм", "", true);
    private Movie seventh = new Movie(7, "Номер один", "Комедия", "", true);

    @BeforeEach
    public void setUp() {
        managerLess.add(first);
        managerLess.add(second);
        managerLess.add(third);
        managerLess.add(fourth);
        managerLess.add(fifth);
        managerLess.add(sixth);
        managerLess.add(seventh);
        managerEqual.add(first);
        managerEqual.add(second);
        managerEqual.add(third);
        managerEqual.add(fourth);
        managerEqual.add(fifth);
        managerEqual.add(sixth);
        managerEqual.add(seventh);
        managerMore.add(first);
        managerMore.add(second);
        managerMore.add(third);
        managerMore.add(fourth);
        managerMore.add(fifth);
        managerMore.add(sixth);
        managerMore.add(seventh);
    }

    @Test
    public void shouldGetLessThanNumberMovies() {
        Movie[] actual = managerLess.getLast();
        Movie[] expected = new Movie[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetEqualNumberMovies() {
        Movie[] actual = managerEqual.getLast();
        Movie[] expected = new Movie[]{seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMoreNumberMovies() {
        Movie[] actual = managerMore.getLast();
        Movie[] expected = new Movie[]{seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

}

