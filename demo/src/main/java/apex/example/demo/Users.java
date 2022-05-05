package apex.example.demo;
import javax.persistence.*;

@Entity
@Table(name= "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "usersId")
    private Integer usersId;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "type")
    private String type;

    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Investment investment;

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Users(String username, String password, String email, String zipcode) {
        this.password = password;
        this.username = username;
        this.email = email;
        this.zipcode = zipcode;
    }

    public Users() {
        this.password = "password";
        this.username = "username";
        this.email = "email";
        this.zipcode = "zipcode";
    }

    @Override
    public String toString() {
        return username + " " + password + " "+email +" "+ zipcode;
    }
}

