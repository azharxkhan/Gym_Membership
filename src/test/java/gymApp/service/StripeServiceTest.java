package gymApp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StripeServiceTest {

    @Test
    public void testSimulatedPaymentIntent() throws Exception {
        StripeService stripeService = new StripeService();
        String clientSecret = stripeService.createPaymentIntent(50);
        assertEquals("simulated_client_secret_50", clientSecret, "Client secret should be correctly simulated.");
    }
}
