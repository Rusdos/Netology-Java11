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
        Movie[] tmp = new Movie[]{first, second, third, fourth, fifth, sixth, seventh};
        doReturn(tmp).when(repository).findAll();
        doReturn(tmp).when(repository).getLast();
        manager.add(first);
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh};
        assertArrayEquals(expected, actual);
        verify(repository, new Times(2)).save(first);
    }

    @Test
    public void shouldGetLast(){
        // настройка заглушки
        Movie[] tmp = new Movie[]{first, second, third, fourth, fifth, sixth, seventh};
        doReturn(tmp).when(repository).findAll();
        doReturn(tmp).when(repository).getLast();
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh};
        assertArrayEquals(expected, actual);
        // удостоверяемся, что заглушка была вызвана с нужным значением
        // но это уже проверка "внутренней" реализации
        verify(repository).getLast();
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
        Movie[] expected = new Movie[]{first, third, fourth, fifth, sixth, seventh};
        assertArrayEquals(expected, actual);
        // удостоверяемся, что заглушка была вызвана с нужным значением
        // но это уже проверка "внутренней" реализации
        verify(repository).removeById(idToRemove);
    }

}
