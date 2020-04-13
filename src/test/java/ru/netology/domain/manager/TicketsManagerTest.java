package ru.netology.domain.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketsInformation;
import ru.netology.manager.TicketsManager;
import ru.netology.repository.TicketsRepository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketsManagerTest {
    private TicketsRepository repository = new TicketsRepository();
    private TicketsManager manager = new TicketsManager(repository);

    private TicketsInformation first = new TicketsInformation(1, 2000, "SVX", "BCN", 500);
    private TicketsInformation second = new TicketsInformation(2, 3000, "SVX", "BCN", 400);
    private TicketsInformation third = new TicketsInformation(3, 4000, "SVX", "CDG", 360);
    private TicketsInformation fourth = new TicketsInformation(4, 4500, "SVX", "BCN", 360);
    private TicketsInformation[] information = new TicketsInformation[]{};

    @Test
    void shouldFindAndSortByPrice(String search) {

        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);

        TicketsInformation[] expected = new TicketsInformation[]{first, second, fourth};
        TicketsInformation[] actual = manager.findAll("SVX", "BCN", Comparator.comparing(information -> information.getPrice()));
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAndSortByTime(String search) {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);

        manager.findAll("SVX", "BCN", (Comparator.comparing(information -> information.getTime())));
        TicketsInformation[] expected = new TicketsInformation[]{first, second, fourth};
        TicketsInformation[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }
}
