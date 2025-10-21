package com.springboot.book.Errorhandling;

import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Controller
@ControllerAdvice
public class GraphqlErrorHandler {

@GraphQlExceptionHandler(IllegalArgumentException.class)
    public GraphQLError handle(IllegalArgumentException error) {
        return  GraphQLError.newError()
                .message(error.getMessage())
                .build();
    }
}
