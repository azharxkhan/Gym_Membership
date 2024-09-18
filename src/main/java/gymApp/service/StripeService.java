package gymApp.service;

public class StripeService {

    /**
     * Constructor for the StripeService.
     * Simulates the API key setup (though it won't be used in this version).
     */
    public StripeService() {
    }

    /**
     * Simulates the creation of a payment intent.
     *
     * @param amount the payment amount in dollars
     * @return a simulated client secret for the payment
     * @throws Exception if any error occurs during the process
     */
    public String createPaymentIntent(int amount) throws Exception {
        System.out.println("Simulating payment intent creation for amount: $" + amount);
        return "simulated_client_secret_" + amount;
    }
}
