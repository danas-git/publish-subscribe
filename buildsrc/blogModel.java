

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class blogModel {

	String topic;
	
	public void validatetopic(String s1){
		if(!s1.equals(null)){
			topic=s1;
			System.out.println(topic);
			
		}
	}
	
	public String getmessage(){
		return topic;
	}
	
	public void publisher (blogView theView)
	{
		String topic;
		String message;
		try{
			
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory ("tcp://localhost:61616");
			Connection connection = factory.createConnection();
		
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			topic=theView.getUserName();
		//	theModel.validatetopic(topic);
			Topic topicLocal = session.createTopic(topic);
		
			MessageProducer producer = session.createProducer(topicLocal);
			System.out.println("producer" +theView.getCommentPane());
			TextMessage messageLocal = session.createTextMessage(theView.getCommentPane());
			producer.send(messageLocal);
			Matcher matcher=Pattern.compile("#\\s*(\\w+)").matcher(messageLocal.getText());
			
			while (matcher.find()) {
				System.out.println(matcher.group(1));
				
				Topic topicLocaltag = session.createTopic(matcher.group(1));
				
				MessageProducer producertag = session.createProducer(topicLocaltag);
				System.out.println("producer" +theView.getCommentPane());
				TextMessage messageLocaltag = session.createTextMessage(messageLocal.getText());
				producertag.send(messageLocaltag);
		
	
			}
			connection.stop();
			//System.exit(0);
		} catch (Exception ex){
			theView.displayErrorMessage("Improper value for topic");
		}
		
	}
	
	public void subscriber (final blogView theView)
	{
		String topic;
		String client;
		 try{
			 ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
				Connection connection = factory.createConnection();
				client=theView.getUserName();
				connection.setClientID(client);
				connection.start();
				
				Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				topic=theView.getTopicName();
				//theModel.validatetopic(topic);
				Topic topicLocal = session.createTopic(topic);
				
				MessageConsumer consumer = session.createDurableSubscriber(topicLocal, client+topic);
				
				MessageListener listener = new MessageListener(){

					public void onMessage(Message message) {
						// TODO Auto-generated method stub
						try{
							if(message instanceof TextMessage){
								TextMessage textmessage = (TextMessage)message;
								System.out.println("Received message" + textmessage.getText());
								theView.setEditorPane(textmessage.getText());
							}
						}catch (JMSException e){
							System.out.println("Caught:" + e);
							e.printStackTrace();
						}
					}
			 
		 //theView.setEditorPane(theModel.getmessage());
				};
				consumer.setMessageListener(listener);
				try { 
		            Thread.sleep(5); 
		        } catch (InterruptedException e) { 
		            // TODO Auto-generated catch block 
		            e.printStackTrace(); 
		        } 
				connection.close();
		 }
		catch(Exception ex){
			theView.displayErrorMessage("Improper value for topic");
		}
	
	}

}


	
	

