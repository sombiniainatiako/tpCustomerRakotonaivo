
package mg.itu.rakotonaivo.tpcustomer.jsf;

import jakarta.ejb.EJB;
import mg.itu.rakotonaivo.tpcustomer.entities.Customer;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import mg.itu.rakotonaivo.tpcustomer.ejb.CustomerManager;
import mg.itu.rakotonaivo.tpcustomer.ejb.DiscountManager;
import mg.itu.rakotonaivo.tpcustomer.entities.Discount;
/**
 * Backing bean pour la page customerDetails.xhtml.
 */
@Named
@ViewScoped
public class CustomerDetailsBean implements Serializable {
  private int idCustomer;
  private Customer customer;

  @EJB
  private CustomerManager customerManager;
  @EJB
  private DiscountManager discountManager;
  
  public int getIdCustomer() {
    return idCustomer;
  }

  public void setIdCustomer(int idCustomer) {
    this.idCustomer = idCustomer;
  }

  /**
   * Retourne les détails du client courant (contenu dans l'attribut customer de
   * cette classe).
   */
    public Customer getCustomer() {
      return customer;
    }

  /**
   * Action handler - met à jour dans la base de données les données du client
   * contenu dans la variable d'instance customer.
   * @return la prochaine page à afficher, celle qui affiche la liste des clients.
   */
  public String update() {
    customer = customerManager.update(customer);
    return "customerList";
  }
  
  public void loadCustomer() {  
    this.customer = customerManager.findById(idCustomer);
  }
  
   /**
   * Retourne la liste de tous les Discount.
   */
  public List<Discount> getDiscounts() {
    return discountManager.getAllDiscounts();
  }
}