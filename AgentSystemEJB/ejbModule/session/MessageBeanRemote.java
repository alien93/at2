package session;

import javax.ejb.Remote;

import entities.ACL;

@Remote
public interface MessageBeanRemote {

	//posalji ACL poruku
	boolean sendACLMessage(ACL message);
	//dobavi listu performativa
	boolean getPerformatives();
	
}
