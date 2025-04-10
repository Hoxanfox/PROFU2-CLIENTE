package dto;

import java.util.List;

public class ChannelDTO {
    private String channelName;
    private List<String> members;

    public ChannelDTO(String channelName, List<String> members) {
        this.channelName = channelName;
        this.members = members;
    }

    public String getChannelName() {
        return channelName;
    }

    public List<String> getMembers() {
        return members;
    }
}
