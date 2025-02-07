package lk.ijse.hibernate;

import lk.ijse.hibernate.config.FactoryConfiguration;
import lk.ijse.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer(
                5,
                "dimantha kaveen",
                "support@email.com",
                0771234567
        );

        boolean isSaved = saveCustomer(customer);
        if (isSaved) {
            System.out.println("Customer saved successfully");
        } else {
            System.out.println("Failed to save the customer");
        }

        Customer customerById = getCustomerById(5);
        System.out.println(customerById);

        deleteCustomer(5);

        updateCustomer(2, new Customer(
                2,
                "dimantha",
                "support@email.com",
                0771234567
        ));
    }

    public static boolean saveCustomer(Customer customer) {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }
    }

    public static Customer getCustomerById(int id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    public static boolean deleteCustomer(int id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            Transaction transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.delete(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }
    }

    public static boolean updateCustomer(int id, Customer newCustomer) {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            Customer customer = session.get(Customer.class, id);
            Transaction transaction = session.beginTransaction();

            customer.setName(newCustomer.getName());
            customer.setEmail(newCustomer.getEmail());
            customer.setPhone(newCustomer.getPhone());

            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }
    }
}
