import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accountList = new ArrayList<>();

    public Customer() {
        idNumber = 0;
        fullName = "";
        accountList = new ArrayList<>();
    }

    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
        accountList = new ArrayList<>();
    }

    public String getCustomerInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Số CMND: ").append(idNumber);
        sb.append(" Họ và tên: ").append(fullName);
        sb.append(".");
        return sb.toString();
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void removeAccount(Account account) {
        accountList.remove(account);
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
