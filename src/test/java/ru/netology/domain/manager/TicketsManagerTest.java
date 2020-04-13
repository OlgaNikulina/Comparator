package ru.netology.domain.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketsInformation;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketsManagerTest {
    private ru.netology.repository.TicketsRepository repository;
    private ru.netology.manager.TicketsManager manager;

    private TicketsInformation first = new TicketsInformation(1, 2000, "SVX", "BCN", 500);
    private TicketsInformation second = new TicketsInformation(2, 3000, "SVX", "BCN", 400);
    private TicketsInformation third = new TicketsInformation(3, 4000, "SVX", "CDG", 360);
    private TicketsInformation fourth = new TicketsInformation(4, 4500, "SVX", "BCN", 360);
    private TicketsInformation[] information = new TicketsInformation[]{};

    @Test
    void shouldFindIfMatchesQuery(String search) {
        TicketsInformation[] result = new TicketsInformation[]{first, second, fourth, third};
        manager.findAll("SVX", "BCN", (information, t1) -> (information.getPrice()));
        manager.findAll("SVX", "BCN", (information, t1) -> (information.getTime()));
       // manager.findAll("SVX", "BCN", (Comparator.comparing(information -> information.getPrice())));
      //  manager.findAll("SVX", "BCN", (Comparator.comparing(information -> information.getTime())));
        TicketsInformation[] expected = new TicketsInformation[]{first, second, fourth};
        TicketsInformation[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }
}