package ru.netology.repository;

import ru.netology.domain.TicketsInformation;

public class TicketsRepository {
    private TicketsInformation[] items = new TicketsInformation[]{};

    public void add(TicketsInformation item) {
        int length = items.length + 1;
        TicketsInformation[] tmp = new TicketsInformation[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public TicketsInformation[] getAll() {
        TicketsInformation[] result = new TicketsInformation[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i;
            result[i] = items[index];
        }
        return result;
    }

    public TicketsInformation[] removeById(int id) {
        int length = items.length - 1;
        TicketsInformation[] tmp = new TicketsInformation[length];
        int index = 0;
        for (TicketsInformation item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return tmp;
    }
}

