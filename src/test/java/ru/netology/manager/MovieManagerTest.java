package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.verification.Times;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MovieManagerTest {
    @Mock
    private MovieRepository repository;
    @InjectMocks
    private MovieManager manager;
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
    public void shouldAdd() {
        // настройка заглушки
        Movie[] tmp = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, second};
        doReturn(tmp).when(repository).findAll();
        manager.add(second);
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{second, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).save(first);
    }

    @Test
    public void shouldGetLast(){
        // настройка заглушки
        Movie[] tmp = new Movie[]{first, second, third, fourth, fifth, sixth, seventh};
        doReturn(tmp).when(repository).findAll();
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void shouldRemoveById(){
        int idToRemove = 2;
        // настройка заглушки
        Movie[] tmp = new Movie[]{first, third, fourth, fifth, sixth, seventh};
        doReturn(tmp).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);
        manager.removeById(idToRemove);
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{seventh, sixth, fifth, fourth, third, first};
        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }

}
