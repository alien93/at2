package session;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import entities.ACL;
import entities.AID;

/**
 * Session Bean implementation class MessageBean
 */
@Stateless
@Path("messages")
@LocalBean
public class MessageBean implements MessageBeanRemote {

	private Session session;
    /**
     * Default constructor. 
     */
    public MessageBean() {
        // TODO Auto-generated constructor stub
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Override
	public boolean sendACLMessage(@FormParam("acl") ACL message) {
		for(int i=0; i<message.getReceivers().size(); i++){
			if(message.getReceivers().get(i) == null)
				throw new IllegalArgumentException("AID cannot be null");
			AID aid = message.getReceivers().get(i);
				try {
					ObjectMessage jmsMsg = session.createObjectMessage(message);
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		}
		return false;
	}
	@Override
	public boolean getPerformatives() {
		// TODO Auto-generated method stub
		return false;
	}
    
    

}
