package gymApp.service;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import java.util.HashMap;
import java.util.Map;

public class StripeService {
    public StripeService() {
        Stripe.apiKey = "your-stripe-secret-key";  // Replace with your Stripe secret key
    }

    public String createPaymentIntent(int amount) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("amount", amount * 100); // Amount in cents
        params.put("currency", "usd");
        params.put("payment_method_types", "card");

        PaymentIntent paymentIntent = PaymentIntent.create(params);
        return paymentIntent.getClientSecret();
    }
}
