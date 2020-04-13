package ru.netology.domain.comparator;

import ru.netology.domain.TicketsInformation;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<TicketsInformation> {


    @Override
    public int compare(TicketsInformation t1, TicketsInformation t2) {
        return t2.getTime() - t1.getTime();
    }
}
