package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customerName name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuffer output = new StringBuffer();

		// print headers
		output.append("======Printing Orders======\n");
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

		// prints lineItems
		double totalStateTax = 0d;
		double totalAmount = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			output = appendLineItemDetail(output, lineItem);
			// calculate sales tax @ rate of 10%
			totalStateTax += calSalesTex(lineItem);
            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmount += lineItem.totalAmount() + calSalesTex(lineItem);;
		}

		// prints the state tax
		output.append("Sales Tax").append('\t').append(totalStateTax);
        // print total amount
		output.append("Total Amount").append('\t').append(totalAmount);
		return output.toString();
	}

	public StringBuffer appendLineItemDetail(StringBuffer output, LineItem lineItem) {
		output.append(lineItem.getDescription());
		output.append('\t');
		output.append(lineItem.getPrice());
		output.append('\t');
		output.append(lineItem.getQuantity());
		output.append('\t');
		output.append(lineItem.totalAmount());
		output.append('\n');
		return output;
	}

	public double calSalesTex(LineItem lineItem) {
		return lineItem.totalAmount() * .10;
	}
}