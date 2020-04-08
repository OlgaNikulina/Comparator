package ru.netology.domain.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketsInformation;
import ru.netology.domain.repository.TicketsRepository;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketsManagerTest {
    private TicketsRepository repository;
    private TicketsManager manager;

    private TicketsInformation first = new TicketsInformation(1, 2000, "SVX", "BCN", 500);
    private TicketsInformation second = new TicketsInformation(2, 3000, "SVX", "BCN", 400);
    private TicketsInformation third = new TicketsInformation(3, 4000, "SVX", "BCN", 360);
    private TicketsInformation fourth = new TicketsInformation(3, 4500, "SVX", "BCN", 360);

    @BeforeEach
    @Test
    public void shouldSortByPrice() {
        int[] expected = new int[]{2000, 3000, 4000, 4500};
        int[] actual = new int[]{3000, 2000, 4000, 4500};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldFindIfMatchesQuery(String search) {
        TicketsInformation[] result = new TicketsInformation[]{first, second, fourth, third};
        manager.findAll("SVX", "BCN", (information, t1) -> (information.getPrice()));
        manager.findAll("SVX", "BCN", (information, t1) -> (information.getTime()));
       // manager.findAll("SVX", "BCN", (Comparator.comparing(information -> information.getPrice())));
      //  manager.findAll("SVX", "BCN", (Comparator.comparing(information -> information.getTime())));
        TicketsInformation[] expected = TicketsInformation[]{first, second, third, fourth};
        TicketsInformation[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }
}