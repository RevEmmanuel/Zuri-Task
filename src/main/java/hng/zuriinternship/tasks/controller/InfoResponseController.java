package hng.zuriinternship.tasks.controller;

import hng.zuriinternship.tasks.data.models.InfoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("")
public class InfoResponseController {

    @GetMapping("/api/stage-1")
    public InfoResponse getInfo(
            @RequestParam String slack_name,
            @RequestParam String track
    ) {
        // Get current day of the week
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
        String currentDay = dayFormat.format(new Date());

        // Get current UTC time
        SimpleDateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String currentUtcTime = utcFormat.format(new Date());

        // GitHub URLs
        String githubFileUrl = "https://github.com/RevEmmanuel/Zuri-Task/blob/main/src/main/java/hng/zuriinternship/tasks/controller/InfoResponseController.java";
        String githubRepoUrl = "https://github.com/RevEmmanuel/Zuri-Task";

        return new InfoResponse(slack_name, currentDay, currentUtcTime, track, githubFileUrl, githubRepoUrl);
    }
}
