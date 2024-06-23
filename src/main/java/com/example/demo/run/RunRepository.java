package com.example.demo.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }

    void update(Run run, Integer id) {
        Optional<Run> result = findById(id);
        result.ifPresent(value -> runs.set(runs.indexOf(value), run));
    }

    void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }

    void create(Run run) {
        runs.add(run);
    }

    @PostConstruct
    private void init(){
        runs.add(new Run(1,
                "Monday",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                3,
                Location.INDOOR));

        runs.add(new Run(2,
                "Tuesday",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(120),
                5,
                Location.OUTDOOR));
    }
}
