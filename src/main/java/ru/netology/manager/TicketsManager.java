package ru.netology.manager;

import ru.netology.domain.TicketsInformation;
import ru.netology.repository.TicketsRepository;

import java.util.Arrays;

public class TicketsManager {
    private TicketsRepository repository;

    public TicketsManager(TicketsRepository repository) {
        this.repository = repository;
    }

    public TicketsInformation[] findAll(String from, String to) {
        TicketsInformation[] result = new TicketsInformation[]{};

        for (TicketsInformation items : repository.getAll()) {
            if (matches(items, from) && (matches(items, to))
            ) {
                TicketsInformation[] tmp = new TicketsInformation[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = items;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    private boolean matches(TicketsInformation information, String search) {
        if (information.getFrom().equalsIgnoreCase(search)) {
            return true;
        }
        if (information.getTo().equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }
}
