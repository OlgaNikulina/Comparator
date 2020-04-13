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
        return items;
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
