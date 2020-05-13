package android.example.booklist;

public class Book {
    private String title;
    private String author;
    private String thumbnail;
    private String description;
    private String language;
    private int rating;
    private String price;
    private int pages;


    /***
     *
     * @param title -(String) name of the book
     * @param author -(String) name of the author
     * @param thumbnail -(String) url for the image/cover
     * @param rating - (int) star rating for the book
     * @param price -(String) price of the book
     * @param pages -(int) number of pages in the book
     * @param description -(String) description of the book
     * @param language -(String) language book is available in
     */
    public Book(String title, String author, String thumbnail, int rating, String price, int pages, String description, String language) {
        this.title = title;
        this.author = author;
        this.thumbnail = thumbnail;
        this.rating = rating;
        this.price = price;
        this.pages = pages;
        this.description = description;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
