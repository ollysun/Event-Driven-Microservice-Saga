package com.moses.eshop.productservice.command_apis.controller;

import com.moses.eshop.productservice.command_apis.commands.CreateProductCommand;
import com.moses.eshop.productservice.command_apis.model.CreateProductRestModel;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductCommandController {
    private final CommandGateway commandGateway;

    @Autowired
    public ProductCommandController( CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }


    @PostMapping
    public String createProduct(@Valid @RequestBody CreateProductRestModel createProductRestModel) {
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .price(createProductRestModel.getPrice())
                .title(createProductRestModel.getTitle())
                .quantity(createProductRestModel.getQuantity())
                .productId(UUID.randomUUID().toString())
                .build();

        return commandGateway.sendAndWait(createProductCommand);
    }

//    @PutMapping
//    public String updateProduct(){
//        return "update handle";
//    }
//
//    @DeleteMapping
//    public String deleteProduct(){
//        return "delete handle";
//    }





}
