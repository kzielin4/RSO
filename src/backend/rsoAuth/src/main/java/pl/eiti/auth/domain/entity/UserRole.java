package pl.eiti.auth.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER_ROLES")
public class UserRole {
    Long id;
    String roleName;

    public UserRole() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ROLE")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
