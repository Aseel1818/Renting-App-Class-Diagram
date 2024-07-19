public class PayPal implements PaymentWay{
    @Override
    public void pay(float amount) {
        System.out.println("Processing payment with paypal for "+amount);
    }
}
