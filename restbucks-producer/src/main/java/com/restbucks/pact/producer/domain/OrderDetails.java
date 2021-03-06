package com.restbucks.pact.producer.domain;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Embeddable
public class OrderDetails {

    private String location;

    @OneToMany(mappedBy = "order", fetch = EAGER, cascade = ALL)
    private List<Item> items;

    protected OrderDetails() {
    }

    public OrderDetails(String location, List<Item> items) {
        this.location = location;
        this.items = items;
    }

    public String getLocation() {
        return location;
    }

    public List<Item> getItems() {
        return items;
    }

    public void updateOrder(Order order) {
        items.forEach(i -> i.setOrder(order));
    }
}
