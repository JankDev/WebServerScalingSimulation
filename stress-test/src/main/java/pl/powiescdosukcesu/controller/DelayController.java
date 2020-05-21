package pl.powiescdosukcesu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/api/users")
public class DelayController {

    @GetMapping
    public Mono<String> getUserWithDelay(@RequestParam long delay) {
        final var sampleUser = String.format("Harry Potter with delay %d", delay);

        return Mono.just(sampleUser).delayElement(Duration.of(delay, ChronoUnit.MILLIS));
    }
}
