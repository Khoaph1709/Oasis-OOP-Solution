public class DVD extends LibraryItem {
    private int duration;

    public DVD() {
        super();
        duration = 0;
    }

    public DVD(String title, String director, int year, boolean isAvailable, int duration) {
        super(title, director, year);
        setAvailable(isAvailable);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String getInfo() {
        return String.format("DVD(%s by %s, %d) - %s minutes", title, author, year, duration);
    }

    @Override
    public String toString() {
        return String.format("DVD[title=%s,author=%s,year=%d,available=%b,duration=%d]", title, author, year, isAvailable, duration);
    }

    @Override
    public double calculateLateFee(int daysLate) {
        double fee = 2000;
        if (duration > 120) {
            fee = fee * 1.3;
        } else if (duration < 90) {
            fee = fee * 0.9;
        }
        return fee * daysLate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DVD) {
            DVD other = (DVD) obj;
            return title.equals(other.title) && author.equals(other.author) && year == other.year && isAvailable == other.isAvailable && duration == other.duration;
        }
        return false;
    }
}
