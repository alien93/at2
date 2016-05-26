package session;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import entities.AID;
import entities.Agent;
import entities.AgentType;


/**
 * Session Bean implementation class AgentBean
 */
@Stateless
@LocalBean
@Path("agents")
public class AgentBean implements AgentBeanRemote {

	private ArrayList<AgentType> agentTypes = new ArrayList<>();
	private ArrayList<Agent> runningAgents = new ArrayList<>();
    /**
     * Default constructor. 
     */
    public AgentBean() {
        // TODO Auto-generated constructor stub
    }
    
    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(){
    	return "test";
    }

    @GET
    @Path("classes")
    @Produces(MediaType.APPLICATION_JSON)
	@Override
	public ArrayList<AgentType> getTypes() {
		return agentTypes;
	}

    @GET
    @Path("running")
    @Produces(MediaType.APPLICATION_JSON)
	@Override
	public ArrayList<Agent> getRunningAgents() {
		return runningAgents;
	}

    @PUT
    @Path("/running/{type}/{name}")
    @Produces(MediaType.TEXT_PLAIN)
	@Override
	public AID runAgent(@PathParam("type")AgentType type, @PathParam("name")String agentName) {
    	String host = AID.HOST_NAME;
    	AID aid = new AID(agentName, host, type);
    	Agent agent = new Agent(aid);
    	runningAgents.add(agent);
    	return aid;
	}

	@DELETE
    @Path("/running/{aid}")
	@Override
	public boolean stopAgent(AID aid) {
		boolean retVal = false;
		for(Agent agent:runningAgents){
			if(agent.getId().equals(aid)){
				runningAgents.remove(agent);
				retVal = true;
				break;
			}
		}
		return retVal;
	}

}
