package entities;
/**
 * 
 * @author nina
 * Agent ID
 */

public class AID {

	private String name;
	private AgentCenter agentCenter;
	private AgentType agentType;
	
	public static final String HOST_NAME = "xjaf";
	
	
	public AID() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AID(String name, AgentCenter agentCenter, AgentType agentType) {
		super();
		this.name = name;
		this.agentCenter = agentCenter;
		this.agentType = agentType;
	}
	
	public AID(String name, String agentCenterName, AgentType agentType) {
		super();
		this.name = name;
		this.agentCenter.setAlias(agentCenterName);
		this.agentType = agentType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AgentCenter getAgentCenter() {
		return agentCenter;
	}

	public void setAgentCenter(AgentCenter agentCenter) {
		this.agentCenter = agentCenter;
	}

	public AgentType getAgentType() {
		return agentType;
	}

	public void setAgentType(AgentType agentType) {
		this.agentType = agentType;
	}

	@Override
	public String toString() {
		return "AID [name=" + name + ", agentCenter=" + agentCenter + ", agentType=" + agentType + "]";
	}
}
