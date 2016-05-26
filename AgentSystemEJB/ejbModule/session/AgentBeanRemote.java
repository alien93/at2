package session;

import java.util.ArrayList;

import javax.ejb.Remote;

import entities.AID;
import entities.Agent;
import entities.AgentType;

@Remote
public interface AgentBeanRemote {

	//dobavi listu svih tipova agenata na sistemu
	ArrayList<AgentType> getTypes();
	//dobavi sve pokrenute agente sa sistema
	ArrayList<Agent> getRunningAgents();
	//pokreni agenta određenog tipa sa zadatim imenom
	AID runAgent(AgentType type, String agentName);
	//zaustavi određenog agenta
	boolean stopAgent(AID aid);
}
