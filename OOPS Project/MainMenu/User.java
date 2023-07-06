package MainMenu;
import java.io.Serializable;

public abstract  class User implements Serializable{
    String Username;
    String Password;
    
  

    User(String Username , String Password){
        this.Username = Username;
        this.Password = Password;
    }
    
     User(){
        this.Username = "";
        this.Password = "";
    }
    public void setUsername(String Username){
        this.Username = Username;
    }

    public String getUsername(){
        return this.Username;
    }

      public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }

}
