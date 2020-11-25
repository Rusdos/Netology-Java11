package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.MovieManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieRepositoryTest {
    private MovieRepository repository = new MovieRepository();
    private MovieManager manager = new MovieManager(repository);
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
    public void shouldFindAll() {
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSave() {
        repository.save(first);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        int idForFind = 0;
        Movie actual = repository.findById(idForFind);
        Movie expected = first;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        int idForRemove = 1;
        repository.removeById(idForRemove);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{second, third, fourth, fifth, sixth, seventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        repository.removeAll();
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLast() {
        Movie[] actual = repository.getLast();
        Movie[] expected = new Movie[]{seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
}
