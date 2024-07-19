public class VisaCard  implements  PaymentWay{
    @Override
    public void pay(float amount){
        System.out.println("Processing payment with visa card for "+amount);
    }
}
