

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.script.ScriptException;

import org.apache.activemq.ActiveMQConnectionFactory;

public class blogController {
	
	private blogView theView;
	private blogModel theModel;
	
	public blogController(blogView theView,blogModel theModel){
		
		this.theView=theView;
		this.theModel=theModel;
		
		this.theView.subscribeListener(new subscribeListener());
		this.theView.producerListener(new producerListener());
	}
	class producerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			theModel.publisher(theView);
		}
	}
	class subscribeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			theModel.subscriber(theView);
	
		}
	}
}