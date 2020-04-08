package ru.netology.domain.corparator;

import ru.netology.domain.TicketsInformation;

import java.util.Comparator;

public class TicketByPriceAscComparator  implements Comparator<TicketsInformation>{
    @Override
    public int compare(TicketsInformation information, TicketsInformation t1) {
        return information.getPrice() - t1.getPrice();
    }
}
