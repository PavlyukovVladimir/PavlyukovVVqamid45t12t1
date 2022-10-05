package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class FilmsManagerTest {

    private FilmsManager filmsManager;

    @BeforeEach
    void setUp() {
        filmsManager = new FilmsManager();
    }

    @Test
    void exceptionNegativeSizeLast() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new FilmsManager(-1);
        });
        assertEquals("Нельзя присвоить отрицательное количество выводимых фильмов", exception.getMessage());
    }

    @Test
    void addOneNullFilmFindAll() {
        filmsManager.add(null);

        FilmsItem[] expected = new FilmsItem[0];
        FilmsItem[] actual = filmsManager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void addOneNullFilmFindLast() {
        filmsManager.add(null);

        FilmsItem[] expected = new FilmsItem[0];
        FilmsItem[] actual = filmsManager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void emptyManagerFindAllSize() {
        int expected = 0;
        int actual = filmsManager.findAll().length;

        assertEquals(expected, actual);
    }

    @Test
    void emptyManagerFindLastSize() {
        int expected = 0;
        int actual = filmsManager.findLast().length;

        assertEquals(expected, actual);
    }

    @Test
    void addOneFilmFindAll() {
        FilmsItem filmsItem = new FilmsItem("title", 1981, "imageUrl");

        filmsManager.add(filmsItem);

        FilmsItem[] expected = new FilmsItem[]{filmsItem};
        FilmsItem[] actual = filmsManager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void addOneFilmFindLast() {
        FilmsItem filmsItem = new FilmsItem("title", 1981, "imageUrl");

        filmsManager.add(filmsItem);

        FilmsItem[] expected = new FilmsItem[]{filmsItem};
        FilmsItem[] actual = filmsManager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void addOneFilmSetZeroLastFindAll() {
        FilmsItem filmsItem = new FilmsItem("title", 1981, "imageUrl");

        filmsManager = new FilmsManager(0);
        filmsManager.add(filmsItem);

        FilmsItem[] expected = new FilmsItem[]{filmsItem};
        FilmsItem[] actual = filmsManager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void addOneFilmSetZeroLastFindLast() {
        FilmsItem filmsItem = new FilmsItem("title", 1981, "imageUrl");

        filmsManager = new FilmsManager(0);
        filmsManager.add(filmsItem);

        FilmsItem[] expected = new FilmsItem[0];
        FilmsItem[] actual = filmsManager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void addThreeFilmsFindAll() {
        FilmsItem filmsItem1 = new FilmsItem("title1", 1981, "imageUrl1");
        FilmsItem filmsItem2 = new FilmsItem("title2", 1970, "imageUrl2");
        FilmsItem filmsItem3 = new FilmsItem("title3", 1990, "imageUrl3");

        filmsManager.add(filmsItem1);
        filmsManager.add(filmsItem2);
        filmsManager.add(filmsItem3);

        FilmsItem[] expected = new FilmsItem[]{filmsItem1, filmsItem2, filmsItem3};
        FilmsItem[] actual = filmsManager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void addThreeFilmsFindLast() {
        FilmsItem filmsItem1 = new FilmsItem("title1", 1981, "imageUrl1");
        FilmsItem filmsItem2 = new FilmsItem("title2", 1970, "imageUrl2");
        FilmsItem filmsItem3 = new FilmsItem("title3", 1990, "imageUrl3");

        filmsManager.add(filmsItem1);
        filmsManager.add(filmsItem2);
        filmsManager.add(filmsItem3);

        FilmsItem[] expected = new FilmsItem[]{filmsItem3, filmsItem2, filmsItem1};
        FilmsItem[] actual = filmsManager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void addThreeFilmsSetTwoLastFindAll() {
        FilmsItem filmsItem1 = new FilmsItem("title1", 1981, "imageUrl1");
        FilmsItem filmsItem2 = new FilmsItem("title2", 1970, "imageUrl2");
        FilmsItem filmsItem3 = new FilmsItem("title3", 1990, "imageUrl3");

        filmsManager = new FilmsManager(2);
        filmsManager.add(filmsItem1);
        filmsManager.add(filmsItem2);
        filmsManager.add(filmsItem3);

        FilmsItem[] expected = new FilmsItem[]{filmsItem1, filmsItem2, filmsItem3};
        FilmsItem[] actual = filmsManager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void addThreeFilmsSetTwoLastFindLast() {
        FilmsItem filmsItem1 = new FilmsItem("title1", 1981, "imageUrl1");
        FilmsItem filmsItem2 = new FilmsItem("title2", 1970, "imageUrl2");
        FilmsItem filmsItem3 = new FilmsItem("title3", 1990, "imageUrl3");

        filmsManager = new FilmsManager(2);
        filmsManager.add(filmsItem1);
        filmsManager.add(filmsItem2);
        filmsManager.add(filmsItem3);

        FilmsItem[] expected = new FilmsItem[]{filmsItem3, filmsItem2};
        FilmsItem[] actual = filmsManager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void addElevenFilmsFindAll() {
        FilmsItem filmsItem1 = new FilmsItem("title1", 1981, "imageUrl1");
        FilmsItem filmsItem2 = new FilmsItem("title2", 1970, "imageUrl2");
        FilmsItem filmsItem3 = new FilmsItem("title3", 1990, "imageUrl3");
        FilmsItem filmsItem4 = new FilmsItem("title4", 1991, "imageUrl4");
        FilmsItem filmsItem5 = new FilmsItem("title5", 1992, "imageUrl5");
        FilmsItem filmsItem6 = new FilmsItem("title6", 1993, "imageUrl6");
        FilmsItem filmsItem7 = new FilmsItem("title7", 1994, "imageUrl7");
        FilmsItem filmsItem8 = new FilmsItem("title8", 1995, "imageUrl8");
        FilmsItem filmsItem9 = new FilmsItem("title9", 1996, "imageUrl9");
        FilmsItem filmsItem10 = new FilmsItem("title10", 1997, "imageUrl10");
        FilmsItem filmsItem11 = new FilmsItem("title11", 1998, "imageUrl11");

        filmsManager.add(filmsItem1);
        filmsManager.add(filmsItem2);
        filmsManager.add(filmsItem3);
        filmsManager.add(filmsItem4);
        filmsManager.add(filmsItem5);
        filmsManager.add(filmsItem6);
        filmsManager.add(filmsItem7);
        filmsManager.add(filmsItem8);
        filmsManager.add(filmsItem9);
        filmsManager.add(filmsItem10);
        filmsManager.add(filmsItem11);

        FilmsItem[] expected = new FilmsItem[]{filmsItem1, filmsItem2, filmsItem3, filmsItem4, filmsItem5, filmsItem6,
                filmsItem7, filmsItem8, filmsItem9, filmsItem10, filmsItem11};
        FilmsItem[] actual = filmsManager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void addElevenFilmsFindLast() {
        FilmsItem filmsItem1 = new FilmsItem("title1", 1981, "imageUrl1");
        FilmsItem filmsItem2 = new FilmsItem("title2", 1970, "imageUrl2");
        FilmsItem filmsItem3 = new FilmsItem("title3", 1990, "imageUrl3");
        FilmsItem filmsItem4 = new FilmsItem("title4", 1991, "imageUrl4");
        FilmsItem filmsItem5 = new FilmsItem("title5", 1992, "imageUrl5");
        FilmsItem filmsItem6 = new FilmsItem("title6", 1993, "imageUrl6");
        FilmsItem filmsItem7 = new FilmsItem("title7", 1994, "imageUrl7");
        FilmsItem filmsItem8 = new FilmsItem("title8", 1995, "imageUrl8");
        FilmsItem filmsItem9 = new FilmsItem("title9", 1996, "imageUrl9");
        FilmsItem filmsItem10 = new FilmsItem("title10", 1997, "imageUrl10");
        FilmsItem filmsItem11 = new FilmsItem("title11", 1998, "imageUrl11");

        filmsManager.add(filmsItem1);
        filmsManager.add(filmsItem2);
        filmsManager.add(filmsItem3);
        filmsManager.add(filmsItem4);
        filmsManager.add(filmsItem5);
        filmsManager.add(filmsItem6);
        filmsManager.add(filmsItem7);
        filmsManager.add(filmsItem8);
        filmsManager.add(filmsItem9);
        filmsManager.add(filmsItem10);
        filmsManager.add(filmsItem11);

        FilmsItem[] expected = new FilmsItem[]{filmsItem11, filmsItem10, filmsItem9, filmsItem8, filmsItem7,
                filmsItem6, filmsItem5, filmsItem4, filmsItem3, filmsItem2};
        FilmsItem[] actual = filmsManager.findLast();

        assertArrayEquals(expected, actual);
    }
}
