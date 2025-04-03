import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    /**
     * .
     */
    public void readCustomerList(InputStream inputStream) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            Customer customer = new Customer();
            Account account;
            if (line != null) {
                String name;
                String id;
                name = line.substring(0, line.length() - 10);
                id = line.substring(name.length() + 1, line.length());
                long idnumber = Long.parseLong(id);
                customer = new Customer(idnumber, name);
            }
            while ((line = bufferedReader.readLine()) != null) {
                if (!(line.charAt(0) <= '9' && line.charAt(0) >= '0')) {
                    if (customer.getIdNumber() != 0) {
                        customerList.add(customer);
                    }
                    String name;
                    String id;
                    name = line.substring(0, line.length() - 10);
                    id = line.substring(name.length() + 1, line.length());
                    long idnumber = Long.parseLong(id);
                    customer = new Customer(idnumber, name);
                } else {
                    String[] accountInfo = line.split(" ");
                    long number = Long.parseLong(accountInfo[0]);
                    double balance = Double.parseDouble(accountInfo[2]);
                    String type = accountInfo[1];
                    if (type.equals(Account.CHECKING)) {
                        account = new CheckingAccount(number, balance);
                    } else {
                        account = new SavingsAccount(number, balance);
                    }
                    customer.addAccount(account);
                }
            }
            if (customer.getIdNumber() != 0) {
                customerList.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
    
    /**
     * .
     */
    public String getCustomersInfoByIdOrder() {
        StringBuilder result = new StringBuilder();
        customerList.sort(Comparator.comparingLong(Customer::getIdNumber));
        for (Customer customer : customerList) {
           result.append(customer.getCustomerInfo()).append("\n"); 
        }
        return result.toString();
    }

    /**
     * .
     */
    public String getCustomersInfoByNameOrder() {
        StringBuilder result = new StringBuilder();
        customerList.sort(Comparator.comparing(Customer::getFullName));
        for (Customer customer : customerList) {
            result.append(customer.getCustomerInfo()).append("\n"); 
        }
        return result.toString();
    }
}
