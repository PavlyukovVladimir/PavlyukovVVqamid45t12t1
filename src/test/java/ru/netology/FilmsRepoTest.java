package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class FilmsRepoTest {

    private FilmsRepo repo;

    @BeforeEach
    void setUp() {
        repo = new FilmsRepo();
    }

    @Test
    void findAll() {
        FilmsItem[] films = new FilmsItem[]{
                new FilmsItem("title1", 1981, "imageUrl1"),
                new FilmsItem("title2", 1970, "imageUrl2"),
                new FilmsItem("title3", 1990, "imageUrl3"),
                new FilmsItem("title4", 1991, "imageUrl4"),
                new FilmsItem("title5", 1992, "imageUrl5"),
                new FilmsItem("title6", 1993, "imageUrl6"),
                new FilmsItem("title7", 1994, "imageUrl7")
        };

        for (FilmsItem item : films) {
            repo.save(item);
        }

        FilmsItem[] expected = films;
        FilmsItem[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        FilmsItem[] films = new FilmsItem[]{
                new FilmsItem("title1", 1981, "imageUrl1"),
                new FilmsItem("title2", 1970, "imageUrl2"),
                new FilmsItem("title3", 1990, "imageUrl3"),
                new FilmsItem("title4", 1991, "imageUrl4"),
                new FilmsItem("title5", 1992, "imageUrl5"),
                new FilmsItem("title6", 1993, "imageUrl6"),
                new FilmsItem("title7", 1994, "imageUrl7")
        };

        for (FilmsItem item : films) {
            repo.save(item);
        }

        FilmsItem expected = films[3];
        FilmsItem actual = repo.findById(expected.getId());

        assertEquals(expected, actual);
    }

    @Test
    void findByIllegalId() {
        FilmsItem[] films = new FilmsItem[]{
                new FilmsItem("title1", 1981, "imageUrl1"),
                new FilmsItem("title2", 1970, "imageUrl2"),
                new FilmsItem("title3", 1990, "imageUrl3"),
                new FilmsItem("title4", 1991, "imageUrl4"),
                new FilmsItem("title5", 1992, "imageUrl5"),
                new FilmsItem("title6", 1993, "imageUrl6"),
                new FilmsItem("title7", 1994, "imageUrl7")
        };

        for (FilmsItem item : films) {
            repo.save(item);
        }

        FilmsItem expected = null;
        FilmsItem actual = repo.findById(7);

        assertEquals(expected, actual);
    }

    @Test
    void removeById() {
        FilmsItem[] films = new FilmsItem[]{
                new FilmsItem("title1", 1981, "imageUrl1"),
                new FilmsItem("title2", 1970, "imageUrl2"),
                new FilmsItem("title3", 1990, "imageUrl3"),
                new FilmsItem("title4", 1991, "imageUrl4"),
                new FilmsItem("title5", 1992, "imageUrl5"),
                new FilmsItem("title6", 1993, "imageUrl6"),
                new FilmsItem("title7", 1994, "imageUrl7")
        };

        for (FilmsItem item : films) {
            repo.save(item);
        }

        FilmsItem[] expected = new FilmsItem[]{
                films[0],
                films[1],
                films[2],
                films[4],
                films[5],
                films[6],
        };
        repo.removeById(films[3].getId());

        FilmsItem[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIllegalId() {
        FilmsItem[] films = new FilmsItem[]{
                new FilmsItem("title1", 1981, "imageUrl1"),
                new FilmsItem("title2", 1970, "imageUrl2"),
                new FilmsItem("title3", 1990, "imageUrl3"),
                new FilmsItem("title4", 1991, "imageUrl4"),
                new FilmsItem("title5", 1992, "imageUrl5"),
                new FilmsItem("title6", 1993, "imageUrl6"),
                new FilmsItem("title7", 1994, "imageUrl7")
        };

        for (FilmsItem item : films) {
            repo.save(item);
        }

        FilmsItem[] expected = new FilmsItem[]{
                films[0],
                films[1],
                films[2],
                films[4],
                films[5],
                films[6],
        };
        Exception exception = assertThrows(NullPointerException.class, () -> {
            repo.removeById(7);
        });
        assertEquals("Объекта с id: 7 нет", exception.getMessage());
    }

    @Test
    void removeAll() {
        FilmsItem[] films = new FilmsItem[]{
                new FilmsItem("title1", 1981, "imageUrl1"),
                new FilmsItem("title2", 1970, "imageUrl2"),
                new FilmsItem("title3", 1990, "imageUrl3"),
                new FilmsItem("title4", 1991, "imageUrl4"),
                new FilmsItem("title5", 1992, "imageUrl5"),
                new FilmsItem("title6", 1993, "imageUrl6"),
                new FilmsItem("title7", 1994, "imageUrl7")
        };

        for (FilmsItem item : films) {
            repo.save(item);
        }

        FilmsItem[] expected = new FilmsItem[0];
        repo.removeAll();
        FilmsItem[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }
}