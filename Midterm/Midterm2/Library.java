import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<LibraryItem> items;
    
    public Library() {
        items = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void removeItem(LibraryItem item) {
        items.remove(item);
    }

    public List<LibraryItem> getItemsByAuthor(String author) {
        List<LibraryItem> itemsByAuthor = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getAuthor().equalsIgnoreCase(author)) {
                itemsByAuthor.add(item);
            }
        }
        return itemsByAuthor;
    }

    public double getTotalLateFee(int days) {
        double totalLateFee = 0.0;
        for (LibraryItem item : items) {
            totalLateFee += item.calculateLateFee(days);
        }
        return totalLateFee;
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Library Inventory:\n");
        for (LibraryItem item : items) {
            info.append(item.getInfo()).append("\n");
        }
        return info.toString();
    }
}
