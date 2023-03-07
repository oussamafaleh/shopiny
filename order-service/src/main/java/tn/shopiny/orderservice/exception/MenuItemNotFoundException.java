package tn.shopiny.orderservice.exception;



public class MenuItemNotFoundException extends RuntimeException {

    public MenuItemNotFoundException(String menuItemId) {
        super("Item not found" + menuItemId);
    }
}
