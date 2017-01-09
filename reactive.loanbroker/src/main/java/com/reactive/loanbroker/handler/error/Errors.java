package com.reactive.loanbroker.handler.error;

import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Created by husainbasrawala on 1/9/17.
 */
public class Errors {

    public static Mono<ServerResponse> unknownException(Throwable ex) {
        return ServerResponse.status(INTERNAL_SERVER_ERROR).body(Mono.just(Error.unknownError(ex)), Error.class);
    }

    public static Mono<ServerResponse> loanAmountRequired() {
        return ServerResponse.badRequest().body(Mono.just(Error.loanAmountRequired()), Error.class);
    }

    public static Mono<ServerResponse> mapException(Exception ex) {
        return ServerResponse.status(INTERNAL_SERVER_ERROR).body(Mono.just(Error.mapException(ex)), Error.class);
    }

}