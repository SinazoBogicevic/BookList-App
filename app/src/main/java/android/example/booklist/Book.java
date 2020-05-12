package android.example.booklist;

public class Book {
    private String name;
    private String author;
    private String thumbnail;
    private int rating;
    private int price;
    private int pages;
    private String description;

    /***
     *
     * @param name -(String) name of the book
     * @param author -(String) name of the author
     * @param thumbnail -(String) url for the image/cover
     * @param rating - (int) star rating for the book
     * @param price -(int) price of the book
     * @param pages -(int) number of pages in the book
     * @param description -(String) description of the book
     */
    public Book(String name, String author, String thumbnail, int rating, int price, int pages, String description) {
        this.name = name;
        this.author = author;
        this.thumbnail = thumbnail;
        this.rating = rating;
        this.price = price;
        this.pages = pages;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
}
