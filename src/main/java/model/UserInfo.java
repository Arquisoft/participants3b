package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.*;

@Entity
@Table(name = "TUsers")
public class UserInfo {
	
	// Log
	private static final Logger LOG = LoggerFactory.getLogger(UserInfo.class);

	@Id
	private Long id;
	
    private final String name;
    private final Integer age;
    private final boolean admin;
    private final String pass; 
    private final String email;
    

    public UserInfo(String name, Integer age, boolean admin, String pass, String email) {
    	super();
    	LOG.info("Creating user " + name + ". age: " + age);
        this.name = name;
        this.age = age;
        this.admin=admin;
        this.email=email;
        this.pass=pass;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isAdmin() {
		return admin;
	}

	public String getPass() {
		return pass;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", age=" + age
				+ ", admin=" + admin + ", pass=" + pass + ", email=" + email
				+ "]";
	}
    
}