package org.siri_hate.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user_service_route", r -> r.path("/api/v?/user_service/**")
                        .filters(f -> f.addRequestHeader("X-Gateway", "true"))
                        .uri("http://localhost:8081"))
                .route("notification_service_route", r -> r.path("/api/v?/notification_service/**")
                        .filters(f -> f.addRequestHeader("X-Gateway", "true"))
                        .uri("http://localhost:8082"))
                .route("main_service_route", r -> r.path("/api/v?/main_service/**")
                        .filters(f -> f.addRequestHeader("X-Gateway", "true"))
                        .uri("http://localhost:8083"))
                .route("chat_service_route", r -> r.path("/api/v?/chat_service/**")
                        .filters(f -> f.addRequestHeader("X-Gateway", "true"))
                        .uri("http://localhost:8084"))
                .build();
    }
}