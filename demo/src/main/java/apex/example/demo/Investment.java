package apex.example.demo;
import javax.persistence.*;

@Entity
@Table(name = "Investment")
public class Investment {
        @Id
        @Column(name = "usersId")
        private Integer id;
        @OneToOne
        @MapsId
        @JoinColumn(name = "usersId")
        private Users users;
}
