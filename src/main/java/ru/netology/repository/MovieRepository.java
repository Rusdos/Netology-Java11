package ru.netology.repository;

import ru.netology.domain.Movie;

public class MovieRepository {
    private Movie[] items = new Movie[0];

    public Movie[] findAll() {
        return items;
    }

    public void save(Movie item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie findById(int id) {
        for (int i = 0; i < items.length; i++) {
            if (i == id) {
                return items[i];
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (items.length >= id) {
            int length = items.length - 1;
            if (length >= 0) {
                Movie[] tmp = new Movie[length];
                int index = 0;
                for (Movie item : items) {
                    if (item.getId() != id) {
                        tmp[index] = item;
                        index++;
                    }
                }
                // меняем наши элементы
                items = tmp;
            }
        }
        return;
    }

    public void removeAll() {
        Movie[] empty = new Movie[0];
        items = empty;
    }

}
