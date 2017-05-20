package my.work;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Client {

	private static ArrayList<Message> list = new ArrayList<Message>();

	public static void main(String[] arg) {
		createMessages();
		Socket socketConnection = null;
		try {
			ObjectOutputStream clientOutputStream = null;
			socketConnection = new Socket("127.0.0.1", 11111);
			int i = 0;
			for (Message message : list) {
				//Thread.sleep(200);
				System.out.println(i + ":message= " + message);
				try {
					clientOutputStream = new ObjectOutputStream(socketConnection.getOutputStream());
					clientOutputStream.writeObject(message);
				} catch (SocketException e) {
					System.out.println(e);
					break;
				}
				i++;
			}

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

	private static void createMessages() {

		Message message = new Message();

		// apples
		message.setProductName("apples");
		message.setProductValue(20);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("apples");
		message.setProductValue(5);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("apples");
		message.setProductValue(73);
		message.setMessageType(MessageType.TYPE2);
		message.setOccurrences(3);
		list.add(message);

		message = new Message();
		message.setProductName("apples");
		message.setProductValue(7);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.ADD);
		message.setActionValue(47);
		list.add(message);

		message = new Message();
		message.setProductName("apples");
		message.setProductValue(4);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.MULTIPLY);
		message.setActionValue(2);
		list.add(message);

		message = new Message();
		message.setProductName("apples");
		message.setProductValue(5);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.SUBSTRACT);
		message.setActionValue(18);
		list.add(message);

		// rose
		message = new Message();
		message.setProductName("rose");
		message.setProductValue(20);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("rose");
		message.setProductValue(57);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("rose");
		message.setProductValue(79);
		message.setMessageType(MessageType.TYPE2);
		message.setOccurrences(31);
		list.add(message);

		message = new Message();
		message.setProductName("rose");
		message.setProductValue(77);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.ADD);
		message.setActionValue(44);
		list.add(message);

		message = new Message();
		message.setProductName("rose");
		message.setProductValue(4);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.MULTIPLY);
		message.setActionValue(2);
		list.add(message);

		message = new Message();
		message.setProductName("rose");
		message.setProductValue(56);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.SUBSTRACT);
		message.setActionValue(10);
		list.add(message);

		// banana
		message = new Message();
		message.setProductName("banana");
		message.setProductValue(88);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("banana");
		message.setProductValue(57);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("banana");
		message.setProductValue(7);
		message.setMessageType(MessageType.TYPE2);
		message.setOccurrences(3);
		list.add(message);

		message = new Message();
		message.setProductName("banana");
		message.setProductValue(71);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.ADD);
		message.setActionValue(49);
		list.add(message);

		message = new Message();
		message.setProductName("banana");
		message.setProductValue(47);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.MULTIPLY);
		message.setActionValue(22);
		list.add(message);

		message = new Message();
		message.setProductName("banana");
		message.setProductValue(56);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.SUBSTRACT);
		message.setActionValue(11);
		list.add(message);

		// car
		message = new Message();
		message.setProductName("car");
		message.setProductValue(20);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("car");
		message.setProductValue(5);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("car");
		message.setProductValue(7);
		message.setMessageType(MessageType.TYPE2);
		message.setOccurrences(3);
		list.add(message);

		message = new Message();
		message.setProductName("car");
		message.setProductValue(7);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.ADD);
		message.setActionValue(4);
		list.add(message);

		message = new Message();
		message.setProductName("car");
		message.setProductValue(4);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.MULTIPLY);
		message.setActionValue(2);
		list.add(message);

		message = new Message();
		message.setProductName("car");
		message.setProductValue(5);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.SUBSTRACT);
		message.setActionValue(1);
		list.add(message);

		// table
		message = new Message();
		message.setProductName("table");
		message.setProductValue(20);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("table");
		message.setProductValue(5);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("table");
		message.setProductValue(7);
		message.setMessageType(MessageType.TYPE2);
		message.setOccurrences(3);
		list.add(message);

		message = new Message();
		message.setProductName("table");
		message.setProductValue(7);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.ADD);
		message.setActionValue(4);
		list.add(message);

		message = new Message();
		message.setProductName("table");
		message.setProductValue(4);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.MULTIPLY);
		message.setActionValue(2);
		list.add(message);

		message = new Message();
		message.setProductName("table");
		message.setProductValue(54);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.SUBSTRACT);
		message.setActionValue(1);
		list.add(message);

		// key
		message = new Message();
		message.setProductName("key");
		message.setProductValue(20);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("key");
		message.setProductValue(5);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("key");
		message.setProductValue(7);
		message.setMessageType(MessageType.TYPE2);
		message.setOccurrences(3);
		list.add(message);

		message = new Message();
		message.setProductName("key");
		message.setProductValue(72);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.ADD);
		message.setActionValue(47);
		list.add(message);

		message = new Message();
		message.setProductName("key");
		message.setProductValue(4);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.MULTIPLY);
		message.setActionValue(2);
		list.add(message);

		message = new Message();
		message.setProductName("key");
		message.setProductValue(57);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.SUBSTRACT);
		message.setActionValue(17);
		list.add(message);

		// bed
		message = new Message();
		message.setProductName("bed");
		message.setProductValue(20);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("bed");
		message.setProductValue(5);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("bed");
		message.setProductValue(7);
		message.setMessageType(MessageType.TYPE2);
		message.setOccurrences(3);
		list.add(message);

		message = new Message();
		message.setProductName("bed");
		message.setProductValue(74);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.ADD);
		message.setActionValue(41);
		list.add(message);

		message = new Message();
		message.setProductName("bed");
		message.setProductValue(4);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.MULTIPLY);
		message.setActionValue(27);
		list.add(message);

		message = new Message();
		message.setProductName("bed");
		message.setProductValue(5);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.SUBSTRACT);
		message.setActionValue(1);
		list.add(message);

		// basket
		message = new Message();
		message.setProductName("basket");
		message.setProductValue(29);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("basket");
		message.setProductValue(5);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("basket");
		message.setProductValue(78);
		message.setMessageType(MessageType.TYPE2);
		message.setOccurrences(3);
		list.add(message);

		message = new Message();
		message.setProductName("basket");
		message.setProductValue(77);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.ADD);
		message.setActionValue(42);
		list.add(message);

		message = new Message();
		message.setProductName("basket");
		message.setProductValue(4);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.MULTIPLY);
		message.setActionValue(2);
		list.add(message);

		message = new Message();
		message.setProductName("basket");
		message.setProductValue(55);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.SUBSTRACT);
		message.setActionValue(19);
		list.add(message);

		// cup
		message = new Message();
		message.setProductName("cup");
		message.setProductValue(27);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("cup");
		message.setProductValue(54);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("cup");
		message.setProductValue(78);
		message.setMessageType(MessageType.TYPE2);
		message.setOccurrences(33);
		list.add(message);

		message = new Message();
		message.setProductName("cup");
		message.setProductValue(78);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.ADD);
		message.setActionValue(49);
		list.add(message);

		message = new Message();
		message.setProductName("cup");
		message.setProductValue(47);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.MULTIPLY);
		message.setActionValue(26);
		list.add(message);

		message = new Message();
		message.setProductName("cup");
		message.setProductValue(55);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.SUBSTRACT);
		message.setActionValue(13);
		list.add(message);

		// phone
		message = new Message();
		message.setProductName("phone");
		message.setProductValue(27);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("phone");
		message.setProductValue(57);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("phone");
		message.setProductValue(71);
		message.setMessageType(MessageType.TYPE2);
		message.setOccurrences(33);
		list.add(message);

		message = new Message();
		message.setProductName("phone");
		message.setProductValue(74);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.ADD);
		message.setActionValue(47);
		list.add(message);

		message = new Message();
		message.setProductName("phone");
		message.setProductValue(49);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.MULTIPLY);
		message.setActionValue(28);
		list.add(message);

		message = new Message();
		message.setProductName("phone");
		message.setProductValue(57);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.SUBSTRACT);
		message.setActionValue(16);
		list.add(message);

		// tea
		message = new Message();
		message.setProductName("tea");
		message.setProductValue(28);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("tea");
		message.setProductValue(33);
		message.setMessageType(MessageType.TYPE1);
		list.add(message);

		message = new Message();
		message.setProductName("tea");
		message.setProductValue(77);
		message.setMessageType(MessageType.TYPE2);
		message.setOccurrences(38);
		list.add(message);

		message = new Message();
		message.setProductName("tea");
		message.setProductValue(74);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.ADD);
		message.setActionValue(40);
		list.add(message);

		message = new Message();
		message.setProductName("tea");
		message.setProductValue(49);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.MULTIPLY);
		message.setActionValue(27);
		list.add(message);

		message = new Message();
		message.setProductName("tea");
		message.setProductValue(56);
		message.setMessageType(MessageType.TYPE3);
		message.setAction(Action.SUBSTRACT);
		message.setActionValue(12);
		list.add(message);

	}
}