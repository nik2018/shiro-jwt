package club.nogn.shirojwt.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author 16225
 * @Title: UserEntityPK
 * @ProjectName shiro-jwt
 * @Description: TODO
 * @date 2018/11/1720:06
 */

public class UserEntityPK implements Serializable {
    private int id;
    private String username;

    @Column(name = "id", nullable = false)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "username", nullable = false, length = 255)
    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntityPK that = (UserEntityPK) o;
        return id == that.id &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
