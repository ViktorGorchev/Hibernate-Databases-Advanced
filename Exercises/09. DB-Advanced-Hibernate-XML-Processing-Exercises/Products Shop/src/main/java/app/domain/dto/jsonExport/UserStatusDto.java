package app.domain.dto.jsonExport;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class UserStatusDto {

    @Expose
    private Long usersCount;

    @Expose
    private List<UserDto> users;

    public UserStatusDto() {
        this.setUsers(new ArrayList<>());
    }

    public Long getUsersCount() {
        return this.usersCount;
    }

    public void setUsersCount(Long usersCount) {
        this.usersCount = usersCount;
    }

    public List<UserDto> getUsers() {
        return this.users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }
}
