package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

public class MovieManager {
    private MovieRepository repository;
    private Movie[] items;
    private int count;

    public MovieManager(int count) {
        this.count = count;
        this.items = new Movie[0];
    }

    public MovieManager() {
        this.count = 10;
        this.items = new Movie[0];
    }

    public void add(Movie item) {
        repository.save(item);
    }

    public Movie[] getLast() {
        if (this.count == 10) {
            Movie[] result = repository.findAll();
            // Movie[] result = new Movie[items.length];
            // перебираем массив в прямом порядке
            // но кладём в результаты в обратном
            for (int i = 0; i < items.length; i++) {
                int index = items.length - i - 1;
                result[i] = items[index];
            }
            return result;
        } else {
            Movie[] result = new Movie[this.count];
            for (int i = 0; i < this.count; i++) {
                int index = items.length - i - 1;
                result[i] = items[index];
            }
            return result;
        }
    }

    // наивная реализация
    public void removeById(int id) {
        repository.removeById(id);
    }
}
