package entities;

public class Agent {

	private AID id;
	
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agent(AID id) {
		super();
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Agent [id=" + id + "]";
	}

	public AID getId() {
		return id;
	}

	public void setId(AID id) {
		this.id = id;
	}

	public void handleMessage(){}
	
}
