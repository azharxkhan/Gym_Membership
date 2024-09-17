package gymApp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class StripeServiceTest {

    @Test
    public void testCreatePaymentIntent() throws Exception {
        StripeService stripeService = new StripeService();

        String clientSecret = stripeService.createPaymentIntent(250); 

        assertNotNull(clientSecret, "Client secret should be returned for valid payment intent.");
    }
}
