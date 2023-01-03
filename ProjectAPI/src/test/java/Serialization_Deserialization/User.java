package Serialization_Deserialization;

public class User {
	
	public String name;
	public String job;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name= name;
	}
	
	public String getjob() {
		return job;
	}
	
	public void setjob(String job) {
		this.job = job;
	}
	
	public String userRecord()
	{
		return(this.name + " " + this.job);
	}

}
