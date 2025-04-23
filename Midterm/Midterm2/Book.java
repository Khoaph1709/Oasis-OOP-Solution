public class Book extends LibraryItem {
    private int pages;

    public Book() {
        super();
        pages = 0;
    }

    public Book(String title, String author, int year, boolean isAvailable, int pages) {
        super(title, author, year);
        setAvailable(isAvailable);
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String getInfo() {
        return String.format("Book(%s by %s, %s) - %d pages", title, author, year, pages);
    }

    @Override
    public String toString() {
        return String.format("Book[title=%s,author=%s,year=%s,available=%s,pages=%s]", title, author, year, isAvailable, pages);
    }

    @Override
    public double calculateLateFee(int daysLate) {
        double fee = 1000;
        if (pages > 500) {
            fee = fee * 1.5;
        } else if (pages < 200) {
            fee = fee * 0.8;
        }
        return fee * daysLate; 
    }

    @Override 
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book other = (Book) obj;
            return title.equals(other.title) && author.equals(other.author) && year == other.year && isAvailable == other.isAvailable && pages == other.pages;
        }
        return false;
    }
}