package mg.itu.rakotonaivo.tpcustomer.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import mg.itu.rakotonaivo.tpcustomer.ejb.CustomerManager;
import mg.itu.rakotonaivo.tpcustomer.entities.Customer;


@Named(value = "customerBean")
@ViewScoped
public class CustomerBean implements Serializable {
    private List<Customer> customerList;
    @EJB  
    private CustomerManager customerManager;
    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
    }
    
    /** 
   * Retourne la liste des clients pour affichage dans une DataTable.
   */  
    public List<Customer> getCustomers() {
        if (customerList == null) {
          customerList = customerManager.getAllCustomers();
        }
        return customerList;
    } 
}
