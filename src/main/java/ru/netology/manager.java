package ru.netology;

import ru.netology.domain.TicketsInformation;

import java.util.Arrays;
import java.util.Comparator;

public class manager {
    public static class TicketsManager {
        private ru.netology.repository.TicketsRepository repository;

        public TicketsManager(ru.netology.repository.TicketsRepository repository) {
            this.repository = repository;
        }

        public TicketsInformation[] findAll(String from, String to, Comparator<TicketsInformation> comparator) {
            TicketsInformation[] result = new TicketsInformation[0];

            for (TicketsInformation items : repository.getAll()) {
                if (matches(items, from)&& matches(items, to)) {
                    TicketsInformation[] tmp = new TicketsInformation[result.length + 1];
                    System.arraycopy(items, 0, tmp, 0, result.length);
                    tmp[tmp.length - 1] = items;
                    result = tmp;
                }
            }
            Arrays.sort(result, comparator);
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
}
