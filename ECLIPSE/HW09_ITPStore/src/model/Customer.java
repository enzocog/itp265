 package model;

import java.util.*;


/**
 * Write description of class here
 *
 * @author Kendra Walther
 * ITP 265
 * Email: kwalther@usc.edu
 *
 */
public class Customer {
	private String name;
	private String email;
	private Map<Product, Integer> cart;
	private boolean isPrimeMember;

	public Customer(String name, String email) {
		this(name, email, new HashMap<>());
	}
	public Customer(String name, String email, Map<Product, Integer> cart) {
		this.name = name;
		this.email = email;
		this.cart = cart;
		isPrimeMember = false;
	}
	
	public boolean isPrimeMember() {
		return isPrimeMember;
	}
	public void upgradeToPrime() {
		isPrimeMember = true;
	}

	public void removePrimeMembership() {
		isPrimeMember = false;
	}
	public void emptyCart() {
		this.cart.clear();
	}
	public void addProductToCart(Product p) {
		addProductToCart(p, 1);
	}

	public void addProductToCart(Product p, int num) {
		if(p instanceof StreamableProduct) {
			cart.put(p, 1); // anything streamable can only appear in cart 1 time/
		}
		else { // not streamable...
			if(cart.containsKey(p)) { // already in cart, add additional
				int qtyInCart = cart.get(p).intValue();
				int newQty = qtyInCart + num;
				cart.put(p, newQty);
			
			}
			else { // put in cart
				cart.put(p, num);
			}
		}
	}

	@Override
	public String toString() {
		return "Customer  " + name + " with cart: " + cart ;
	}

	public String cartToString() {
		String cartString = name + "'s Shopping Cart";
		if(cart.isEmpty()) {
			cartString += "\n\tEMPTY";
		}
		else {
		for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
			Product key = entry.getKey();
			Integer value = entry.getValue();
			cartString += ("\n\t" + value + " of " + key);
		}
		}
		return cartString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return the cart
	 */
	public Map<Product, Integer> getCart() {
		return cart;
	}

}
