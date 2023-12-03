package com.iit.deviqtracker.gatewayservice.filter;

import java.lang.reflect.Array;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.lang.Arrays;

@Component
public class RouteValidator {

	public static final List<String> openApiEndpoints = Arrays.of("/auth/register", "/auth/token", "/eureka");

	public Predicate<ServerHttpRequest> isSecured = request -> openApiEndpoints.stream()
			.noneMatch(uri -> request.getURI().getPath().contains(uri));

}
