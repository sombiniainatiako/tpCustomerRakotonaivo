
package mg.itu.rakotonaivo.tpcustomer.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import mg.itu.rakotonaivo.tpcustomer.entities.Customer;

/**
 * Gère la persistence des customers
 * @author Rakotonaivo
 */
@Stateless
public class CustomerManager {
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public List<Customer> getAllCustomers() {  
       Query query = em.createNamedQuery("Customer.findAll");
       return query.getResultList(); 
    }  
    
    public Customer findById(int idCustomer) {  
       return em.find(Customer.class, idCustomer);  
    }
    public Customer update(Customer customer) {
       return em.merge(customer);
    }

    public void persist(Customer customer) {
       em.persist(customer);
    }  
}
