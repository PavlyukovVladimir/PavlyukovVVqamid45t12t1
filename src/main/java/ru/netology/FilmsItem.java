package ru.netology;

import java.util.Objects;

public class FilmsItem implements Cloneable {
    private static long indexCount = 0;

    private long id;
    private String title;
    private int releaseYear;
    private String imageUrl;

    public FilmsItem(String title, int releaseYear, String imageUrl) {
        this.id =indexCount + 1L;
        this.title = title;
        this.releaseYear = releaseYear;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static long getIndexCount() {
        return indexCount;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmsItem filmsItem = (FilmsItem) o;
        return getReleaseYear() == filmsItem.getReleaseYear() &&
                Objects.equals(getTitle(), filmsItem.getTitle()) &&
                Objects.equals(getImageUrl(), filmsItem.getImageUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getReleaseYear(), getImageUrl());
    }

    @Override
    protected Object clone(){
        return new FilmsItem(this.title, this.releaseYear, this.imageUrl);
    }
}
