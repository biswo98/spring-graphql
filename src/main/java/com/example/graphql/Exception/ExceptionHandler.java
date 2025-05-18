package com.example.graphql.Exception;


import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

@Component
public class ExceptionHandler extends DataFetcherExceptionResolverAdapter {
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        ErrorType errorType;

        if (ex instanceof DataIntegrityViolationException) {
            errorType = ErrorType.BAD_REQUEST;
        } else {
            errorType = ErrorType.INTERNAL_ERROR;
        }

        return GraphqlErrorBuilder.newError(env).message("Received Message" + ex.getMessage()).errorType(errorType).build();
    }
}
