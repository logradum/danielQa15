package Model;

public class ContactMessage {
  String email;
  String orderReferance;
  String message;

  public ContactMessage setEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactMessage setOrderReferance(String orderReferance) {
    this.orderReferance = orderReferance;
    return this;
  }

  public ContactMessage setMessage(String message) {
    this.message = message;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public String getOrderReferance() {
    return orderReferance;
  }

  public String getMessage() {
    return message;
  }
}
