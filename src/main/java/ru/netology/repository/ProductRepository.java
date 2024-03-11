package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.domain.Customers;
import ru.netology.domain.Orders;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(Customers customer) {
        entityManager.persist(customer);
    }

    @Transactional
    public void create(Orders orders) {
        entityManager.persist(orders);
    }

    @Transactional
    public List findByName(String name) {
        var query = entityManager.createQuery("select orders.product_name from Orders  orders join Customers customers on orders.customers.id = customers.id where LOWER(customers.name) = lower(name)");
        return query.getResultList();
    }

    @Transactional
    public void deleteCustomer(Long id) {
        var customer = entityManager.find(Customers.class, id);
        var orders = entityManager.find(Orders.class, customer);
        entityManager.remove(orders);
        entityManager.remove(customer);
    }

    @Transactional
    public void deleteOrder(Long id) {
        var order = entityManager.find(Orders.class, id);
        entityManager.remove(order);
    }
}

