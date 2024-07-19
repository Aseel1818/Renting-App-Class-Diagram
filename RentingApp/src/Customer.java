import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;

    //////Aggregation//////////////
    private List<Contract> contractList;


    public Customer(String name) {
        contractList = new ArrayList<>();
        this.name = name;
    }

    public void addContract(Contract contract ) {
        contractList.add(contract);
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public List<Contract> getContractList() {
        return contractList;
    }


    public void printData(){
        System.out.println("\n\nCustomer Name: " + getName());
        System.out.println("**************************************");
        for (Contract contract : contractList) {
            contract.printInformation();
        }
    }


    public void pay() {
        for (Contract contract : contractList){
            contract.getPaymentMethod().pay(contract.getPrice());
        }
    }
}
