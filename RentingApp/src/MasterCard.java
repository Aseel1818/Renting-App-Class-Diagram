public class MasterCard implements PaymentWay {
    @Override
    public void pay(float amount) {
        System.out.println("Processing payment with master card "+amount);
    }
}
