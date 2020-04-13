package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketsInformation;
import ru.netology.manager.TicketsManager;

import static org.junit.jupiter.api.Assertions.*;

class TicketsRepositoryTest {
    private TicketsRepository repository = new TicketsRepository();

    private TicketsInformation first = new TicketsInformation(1, 2000, "SVX", "BCN", 500);
    private TicketsInformation second = new TicketsInformation(2, 3000, "LED", "BCN", 400);
    private TicketsInformation third = new TicketsInformation(3, 4000, "SVX", "DME", 360);
    private TicketsInformation fourth = new TicketsInformation(4, 4500, "SVX", "BCN", 360);

    @BeforeEach
    public void shouldSetUp() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);
    }

    @Test
    void shouldGetFour() {

        TicketsInformation[] expected = new TicketsInformation[]{first, second, third, fourth};
        TicketsInformation[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        int id = 3;
        TicketsInformation[] expected = new TicketsInformation[]{first, second, fourth};
        TicketsInformation[] actual = repository.removeById(id);
        assertArrayEquals(expected, actual);
    }
}
