package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketsInformation;
import ru.netology.manager.TicketsManager;
import ru.netology.repository.TicketsRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketsManagerTest {
    private TicketsRepository repository = new TicketsRepository();
    private TicketsManager[] ticket = new TicketsManager[]{};

    private TicketsInformation first = new TicketsInformation(1, 2000, "SVX", "BCN", 500);
    private TicketsInformation second = new TicketsInformation(2, 3000, "LED", "BCN", 400);
    private TicketsInformation third = new TicketsInformation(3, 4000, "SVX", "DME", 360);
    private TicketsInformation fourth = new TicketsInformation(4, 4500, "SVX", "BCN", 360);

    @Test
    void shouldFindIfMatchesQuery() {
        TicketsManager manager = new TicketsManager(repository);
        String from = "SVX";
        String to = "BCN";

        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);

        TicketsInformation[] expected = new TicketsInformation[]{first, fourth};
        TicketsInformation[] actual = manager.findAll(from, to);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNorFindIfMotMatchesQuery() {
        TicketsManager manager = new TicketsManager(repository);
        String from = "FCO";
        String to = "BCN";

        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);

        TicketsInformation[] expected = new TicketsInformation[]{};
        TicketsInformation[] actual = manager.findAll(from, to);

        assertArrayEquals(expected, actual);
    }
}
