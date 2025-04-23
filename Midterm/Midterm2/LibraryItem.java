public abstract class LibraryItem {
    protected String title;
    protected String author;
    protected int year;
    protected boolean isAvailable;

    public LibraryItem() {
        title = "Unknown";
        author = "Unknown";
        year = 0;
        isAvailable = false;
    }

    public LibraryItem(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        isAvailable = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public abstract String getInfo();

    public abstract double calculateLateFee(int days);

    @Override
    public String toString() {
        return String.format("LibraryItem[title=%s,author=%s,year=%d,available=%b]", title, author, year, isAvailable);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LibraryItem) {
            LibraryItem other = (LibraryItem) obj;
            return title.equals(other.title) && author.equals(other.author) && year == other.year;
        }
        return false;
    }
}