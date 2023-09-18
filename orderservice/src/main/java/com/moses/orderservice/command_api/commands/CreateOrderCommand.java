package com.moses.orderservice.command_api.commands;


import com.moses.orderservice.data.model.OrderStatus;
import lombok.Builder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
public record CreateOrderCommand(@TargetAggregateIdentifier String orderId, String userId, String productId,
                                 int quantity, String addressId, OrderStatus orderStatus) {
}
