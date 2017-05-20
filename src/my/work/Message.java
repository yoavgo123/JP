package my.work;

import java.io.Serializable;

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productName;
	private double productValue;
	private double actionValue;
	private int occurrences;
	private Action action;
	private MessageType messageType;

	Message() {

	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductValue() {
		return productValue;
	}

	public void setProductValue(double productValue) {
		this.productValue = productValue;
	}

	public double getActionValue() {
		return actionValue;
	}

	public void setActionValue(double actionValue) {
		this.actionValue = actionValue;
	}

	public int getOccurrences() {
		return occurrences;
	}

	public void setOccurrences(int occurrences) {
		this.occurrences = occurrences;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	@Override
	public String toString() {
		return "Message [productName=" + productName + ", productValue=" + productValue + ", actionValue=" + actionValue
				+ ", occurrences=" + occurrences + ", action=" + action + ", messageType=" + messageType + "]";
	}

	
}
