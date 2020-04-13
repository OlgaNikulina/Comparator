package ru.netology.domain.comparator;

import ru.netology.domain.TicketsInformation;

import java.util.Comparator;

public class TicketByPriceAscComparator  implements Comparator<TicketsInformation>{
    @Override
    public int compare(TicketsInformation t1, TicketsInformation t2) {
        return t1.getPrice() - t2.getPrice();
    }
}
