package com.moses.userservice.eventhandler;

import com.moses.core.model.PaymentDetails;
import com.moses.core.model.User;
import com.moses.core.query.FetchUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserEventsHandler {

    @QueryHandler
    public User findUserPaymentDetails(FetchUserPaymentDetailsQuery query) {
        
        PaymentDetails paymentDetails = PaymentDetails.builder()
                .cardNumber("123Card")
                .cvv("123")
                .name("moses ")
                .validUntilMonth(12)
                .validUntilYear(2030)
                .build();

        return User.builder()
                .firstName("moses")
                .lastName("olalere")
                .userId(query.getUserId())
                .paymentDetails(paymentDetails)
                .build();
    }
    
    
}