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
    }


    public static boolean saveCustomer(Customer customer) {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }
    }
}
