package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketsInformation implements Comparable {
    private int id;
    private int price;
    private String from;
    private String to;
    private int time;


    @Override
    public int compareTo(Object o) {
        TicketsInformation t = (TicketsInformation) o;
        return price - t.price;
    }
}
