package club.nogn.shirojwt.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author 16225
 * @Title: UserEntity
 * @ProjectName shiro-jwt
 * @Description: TODO
 * @date 2018/11/1720:06
 */

@Entity
@Table(name = "user", schema = "myjwttest")
@IdClass(UserEntityPK.class)
public class UserEntity {
    private int id;
    private String email;
    private String username;
    private String password;
    private String role;
    private String permission;
    private Byte ban;
    private String headsculpture;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", permission='" + permission + '\'' +
                ", ban=" + ban +
                ", headsculpture='" + headsculpture + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Id
    @Column(name = "username", nullable = false, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role", nullable = true, length = 255)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "permission", nullable = true, length = 255)
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Basic
    @Column(name = "ban", nullable = true)
    public Byte getBan() {
        return ban;
    }

    public void setBan(Byte ban) {
        this.ban = ban;
    }

    @Basic
    @Column(name = "headsculpture", nullable = true, length = 255)
    public String getHeadsculpture() {
        return headsculpture;
    }

    public void setHeadsculpture(String headsculpture) {
        this.headsculpture = headsculpture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                Objects.equals(email, that.email) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(role, that.role) &&
                Objects.equals(permission, that.permission) &&
                Objects.equals(ban, that.ban) &&
                Objects.equals(headsculpture, that.headsculpture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, username, password, role, permission, ban, headsculpture);
    }
}
