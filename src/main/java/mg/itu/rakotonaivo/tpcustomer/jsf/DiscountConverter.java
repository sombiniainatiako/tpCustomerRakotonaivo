/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.rakotonaivo.tpcustomer.jsf;

import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.FacesConverter;
import mg.itu.rakotonaivo.tpcustomer.ejb.DiscountManager;
import mg.itu.rakotonaivo.tpcustomer.entities.Discount;
import jakarta.faces.convert.Converter;
/**
 *
 * @author Administrator
 */
@FacesConverter(value = "discountConverter", managed=true)
public class DiscountConverter implements Converter<Discount> {
  @EJB
  private DiscountManager discountManager;

  /**
   * Convertit une String en Discount.
   *
   * @param value valeur à convertir
   */
  @Override
  public Discount getAsObject(FacesContext context, UIComponent component, String value) {
    if (value == null) return null;
    return discountManager.findById(value);
  }

  /**
   * Convertit un Discount en String.
   *
   * @param value valeur à convertir
   */
  @Override
  public String getAsString(FacesContext context, UIComponent component, Discount discount) {
    if (discount == null) return "";
    return discount.getCode();
  }
}
