package model;
/**
 * 
 * @author nina
 *
 */
public class AgentType {

		String name;
		String module;
		
		public AgentType() {
			super();
			// TODO Auto-generated constructor stub
		}

		public AgentType(String name, String module) {
			super();
			this.name = name;
			this.module = module;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getModule() {
			return module;
		}

		public void setModule(String module) {
			this.module = module;
		}

		@Override
		public String toString() {
			return "AgentType [name=" + name + ", module=" + module + "]";
		}
}
