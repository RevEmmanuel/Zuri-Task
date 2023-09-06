package hng.zuriinternship.tasks.data.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InfoResponse {

    private String slackName;
    private String currentDay;
    private String utcTime;
    private String track;
    private String githubFileUrl;
    private String githubRepoUrl;
    private final int statusCode = 200;

}

