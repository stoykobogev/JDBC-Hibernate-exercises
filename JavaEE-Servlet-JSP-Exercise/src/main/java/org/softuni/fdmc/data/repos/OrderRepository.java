package org.softuni.fdmc.data.repos;

import org.softuni.fdmc.data.models.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderRepository {

    private List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public List<Order> getAllOrders() {
        return Collections.unmodifiableList(this.orders);
    }

    public List<Order> getAllOrdersSortedByDate() {
        this.orders.sort((order1, order2) -> order2.getMadeOn().compareTo(order1.getMadeOn()));
        return Collections.unmodifiableList(this.orders);
    }
}
