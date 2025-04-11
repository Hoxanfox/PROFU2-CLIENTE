package dto.lobby;

import java.util.List;

public class ChannelDTO {
    private String name;
    private List<String> members;

    public ChannelDTO(String name, List<String> members) {
        this.name = name;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public List<String> getMembers() {
        return members;
    }
}
