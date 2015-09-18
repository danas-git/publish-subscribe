

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.IconView;

public class blogView extends JFrame {
	String s;
	int flag=0;
    public blogView() {
        initComponents();
    }
    private void initComponents() {
    	topicTextfield = new javax.swing.JTextField();
        topicLabel = new javax.swing.JLabel();
        SubscribeButton = new javax.swing.JButton();
        commentArea=new javax.swing.JTextArea("");
        jcommentPane= new javax.swing.JScrollPane(commentArea);
        WindowLabel = new javax.swing.JLabel();
        AddCommentButton = new javax.swing.JButton();
        BLOGLabel = new javax.swing.JLabel();
        jeditorPane = new javax.swing.JEditorPane();
        editorScrollPane = new javax.swing.JScrollPane(jeditorPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        topicLabel.setText("Subscribe to (User/tags)/Retrieve Message");
        SubscribeButton.setText("GO");
                
        jeditorPane.setEditable(false);      
        editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        editorScrollPane.setPreferredSize(new Dimension(300, 200));
        editorScrollPane.setMinimumSize(new Dimension(111, 110));
        WindowLabel.setText("Incoming Messages: Press 'GO' to refresh");
        AddCommentButton.setText("Post Message (append # for tags)");


        BLOGLabel.setFont(new java.awt.Font("Lucida Grande", 0,20)); // NOI18N
     //   BLOGLabel.setText("MicroBlog");   

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(topicLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(topicTextfield, javax.swing.GroupLayout.PREFERRED_SIZE,300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SubscribeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(BLOGLabel))))//microBLog
                            .addComponent(WindowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)//message Window
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(this.editorScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGap(100, 100, 100))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)                         
                                    ))))))
                    .addGroup(layout.createSequentialGroup()
                    		.addGap(50,50,50)
                        .addComponent(jcommentPane, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                       // .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.INDENT, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20,20,20)
                        .addComponent(AddCommentButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)//addcommment
                        .addGap(5, 5,5)))
        ;
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AddCommentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)//addcomment
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BLOGLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(topicLabel)
                            .addComponent(topicTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SubscribeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(25,25, 25)
                            .addComponent(WindowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(this.editorScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGap(20, 20, 20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jcommentPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    ))));

        pack();
        
    Object[] possibilities = {null};
     s=(String)JOptionPane.showInputDialog("Please Enter your NAME", possibilities[0]);
     setDefaultCloseOperation(JOptionPane.CANCEL_OPTION);
     while(flag!=1){
    	  s = s.replaceAll("\\W","");
       if ((s != null) && (s.length() > 0)) {
        System.out.println(""+s);   
        flag=1;
        }
       else{ s=(String)JOptionPane.showInputDialog("Entered name is not Valid; Please Re-enter a valid NAME", possibilities[0]);
       }
     }
     BLOGLabel.setText("Welcome " +getUserName());
    }       
    
    
    public String getTopicName(){
    	return (String)topicTextfield.getText();
    }
    public void setEditorPane(String ooe){
    	jeditorPane.setText(ooe);
    }
    public String getCommentPane(){
    	return (String)commentArea.getText();
    }
    public String getUserName(){
    	return s;
    }
    void subscribeListener(ActionListener listenForSubbutton){
    	SubscribeButton.addActionListener(listenForSubbutton);
    }
    void producerListener(ActionListener listenForAddCommentBotton){
    	AddCommentButton.addActionListener(listenForAddCommentBotton);
    }
    void displayErrorMessage(String errorMessage){
    	JOptionPane.showMessageDialog(this, errorMessage);
    }
    

    private javax.swing.JScrollPane jcommentPane;
    private javax.swing.JTextArea commentArea;
    private javax.swing.JButton SubscribeButton;
    private javax.swing.JLabel topicLabel;
    private javax.swing.JButton AddCommentButton;
    private javax.swing.JLabel WindowLabel;
    private javax.swing.JEditorPane jeditorPane;
    private javax.swing.JLabel BLOGLabel;
    private javax.swing.JTextField topicTextfield;
    private javax.swing.JScrollPane editorScrollPane;	
}
