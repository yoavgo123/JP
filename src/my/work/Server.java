package my.work;

import java.io.*;
import java.net.*;
import java.util.HashMap;

public class Server {

	private static HashMap<String, Product> map = new HashMap<String, Product>();
	private static int count = 0;

	public static void main(String[] arg) {

		Message message = null;
		ServerSocket socketConnection = null;
		try {

			socketConnection = new ServerSocket(11111);
			ObjectInputStream serverInputStream = null;
			System.out.println("count:" + count);
			System.out.println("Server Waiting");
			Socket pipe = socketConnection.accept();
			
			while (count < 50) {
				
				count++;
				System.out.println("count:" + count);
				
				serverInputStream = new ObjectInputStream(pipe.getInputStream());
				message = (Message) serverInputStream.readObject();
				System.out.println("message= " + message);
				handleMessage(message);
				if ((count % 10) == 0)
					makeReport1();

			}
			makeReport2();
			System.out.println("server is pausing, stop accepting new messages");

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (!socketConnection.isClosed())
					socketConnection.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private static void makeReport2() {
		System.out.println("**************report-of-50:start******************");
		for (String s : map.keySet()) {
			System.out.println("product:" + s + " adjustments:" + map.get(s).getList());
		}
		System.out.println("**************report-of-50:end******************");

	}

	private static void makeReport1() {
		System.out.println("**************report-of-10:start******************");
		for (String s : map.keySet()) {
			System.out.println("product:" + s + " total:" + map.get(s).getTotal());
		}
		System.out.println("**************report-of-10:end******************");

	}

	private static void handleMessage(Message message) {
		if (message != null && message.getMessageType() != null) {
			Product product = null;
			if (message.getMessageType().equals(MessageType.TYPE1)) {
				product = map.get(message.getProductName());
				if (product == null) {
					product = new Product();
					product.setName(message.getProductName());
					product.setSales(1);
					product.setTotal(message.getProductValue());
					map.put(message.getProductName(), product);
				} else {
					product.setSales(product.getSales() + 1);
					product.setTotal(product.getTotal() + message.getProductValue());
					map.put(message.getProductName(), product);
				}

			} else if (message.getMessageType().equals(MessageType.TYPE2)) {
				product = map.get(message.getProductName());
				if (product == null) {
					product = new Product();
					product.setName(message.getProductName());
					product.setSales(message.getOccurrences());
					product.setTotal(message.getProductValue() * message.getOccurrences());
					map.put(message.getProductName(), product);
				} else {
					product.setSales(product.getSales() + message.getOccurrences());
					product.setTotal(product.getTotal() + (message.getProductValue() * message.getOccurrences()));
					map.put(message.getProductName(), product);
				}

			} else if (message.getMessageType().equals(MessageType.TYPE3)) {
				if (message.getAction() != null) {
					if (message.getAction().equals(Action.ADD)) {
						product = map.get(message.getProductName());
						if (product == null) {
							product = new Product();
							product.setName(message.getProductName());
							product.setTotal(message.getProductValue());
							product.setSales(1);
							map.put(message.getProductName(), product);
						} else {
							product.setTotal(product.getTotal() + message.getProductValue()
									+ (message.getActionValue() * product.getSales()));
							product.setSales(product.getSales() + 1);
							map.put(message.getProductName(), product);
						}
					} else if (message.getAction().equals(Action.SUBSTRACT)) {
						product = map.get(message.getProductName());
						if (product == null) {
							product = new Product();
							product.setName(message.getProductName());
							product.setTotal(message.getProductValue());
							product.setSales(1);
							map.put(message.getProductName(), product);
						} else {
							product.setTotal(product.getTotal() + message.getProductValue()
									- (message.getActionValue() * product.getSales()));
							product.setSales(product.getSales() + 1);
							map.put(message.getProductName(), product);
						}

					} else if (message.getAction().equals(Action.MULTIPLY)) {
						product = map.get(message.getProductName());
						if (product == null) {
							product = new Product();
							product.setName(message.getProductName());
							product.setTotal(message.getProductValue());
							product.setSales(1);
							map.put(message.getProductName(), product);
						} else {
							product.setTotal(
									(product.getTotal() * message.getActionValue()) + message.getProductValue());
							product.setSales(product.getSales() + 1);
							map.put(message.getProductName(), product);
						}

					} else {
						System.out.println("not a valid message= " + message);
					}

				} else {
					System.out.println("not a valid message= " + message);
				}

			} else {
				System.out.println("not a valid message= " + message);
			}
		} else {
			System.out.println("not a valid message= " + message);
		}

	}

}