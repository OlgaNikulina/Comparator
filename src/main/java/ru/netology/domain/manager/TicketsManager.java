package ru.netology.domain.manager;

import ru.netology.domain.TicketsInformation;
import ru.netology.domain.repository.TicketsRepository;

import java.util.Arrays;

public class TicketsManager {
    private TicketsRepository repository;

    public TicketsManager(TicketsRepository repository) {
        this.repository = repository;
    }

    public TicketsInformation[] findAll(String from, String to) {
        TicketsInformation[] result = new TicketsInformation[0];

        for (TicketsInformation items : repository.getAll()) {
            if (matches(items, from)) {
                TicketsInformation[] tmp = new TicketsInformation[result.length + 1];
                System.arraycopy(items, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = items;
                result = tmp;
            }
            if (matches(items, to)) {
                TicketsInformation[] tmp = new TicketsInformation[result.length + 1];
                System.arraycopy(items, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = items;
                result = tmp;
                Arrays.sort(result);
            }
        }
        return result;
    }

    private boolean matches(TicketsInformation information, String search) {
        TicketsInformation ticketsInformation = new TicketsInformation();
        if (ticketsInformation.getFrom().equalsIgnoreCase(search)) {
            return true;
        }
        if (ticketsInformation.getTo().equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }
}
