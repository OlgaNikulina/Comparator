package ru.netology.domain.corparator;

import ru.netology.domain.TicketsInformation;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<TicketsInformation> {


    @Override
    public int compare(TicketsInformation information, TicketsInformation t1) {
        return t1.getTime() - information.getTime();
    }
}
