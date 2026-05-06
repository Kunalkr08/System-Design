package fooddelivery.strategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Amount of" + amount + "has been successfully proceed");
    }
}
