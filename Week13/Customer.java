import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accountList;

    /**
     * .
     */
    public Customer() {
        accountList = new ArrayList<>();
        idNumber = 0;
        fullName = "";
    }

    /**
     * .
     */
    public Customer(long idNumber, String fullName) {
        accountList = new ArrayList<>();
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    public String getCustomerInfo() {
        return "Số CMND: " + idNumber + ". Họ tên: " + fullName + ".";
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

    public List<Account> getAccounts() {
        return accountList;
    }
    
    public List<Account> getAccountList() {
        return accountList;
    }
}
