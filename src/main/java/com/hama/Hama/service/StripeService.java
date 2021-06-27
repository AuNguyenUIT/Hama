package com.hama.Hama.service;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.model.Coupon;
import com.stripe.model.Customer;
import com.stripe.model.Subscription;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

public interface StripeService {

    String createCustomer(String email, String token);

    String createSubscription(String customerId, String plan, String coupon);

    boolean cancelSubscription(String subscriptionId);

    String createCharge(String email, String token, int amount);

}