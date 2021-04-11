package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    private MovieManager manager = new MovieManager(10);
    private Movie first = new Movie(1, "боевик", "Бладшот");
    private Movie second = new Movie(2, "мультфильм", "Вперёд");
    private Movie third = new Movie(3, "комедия", "Отель Белград");
    private Movie fourth = new Movie(4, "боевик", "Джентельмены");
    private Movie fifth = new Movie(5, "ужасы", "Человек невидимка");
    private Movie sixth = new Movie(6, "мультфильм", "Тролии. Мировой тур");
    private Movie seventh = new Movie(7, "комедия", "Номер один");

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
    public void addFilmFromArray() {
        MovieManager manager = new MovieManager();
        manager.add(first);
        Movie[] actual = manager.getMovie();
        Movie[] expected = new Movie[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void addFilmIfArraySizeZero() {
        MovieManager manager = new MovieManager(0);
        manager.add(first);
        Movie[] actual = manager.getMovie();
        Movie[] expected = new Movie[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getIfNotFilm() {
        MovieManager manager = new MovieManager();

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllMovie() {

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLastFiveMovie() {
        MovieManager manager = new MovieManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        Movie[] actual = manager.getMovie();
        Movie[] expected = new Movie[]{sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, actual);

    }

}