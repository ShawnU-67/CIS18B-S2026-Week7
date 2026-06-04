package edu.norcocollege.cis18b.week7.mini01;

import java.util.List;

public class ProcessVsThreadClinic {

    public static void main(String[] args) {
        for (Scenario scenario : defaultScenarios()) {
            System.out.println(scenario.name() + " -> " + scenario.recommendation());
        }
    }

    static List<Scenario> defaultScenarios() {
        return List.of(

            new Scenario(
                "student-code-runner",
                "Run untrusted student code with stronger fault isolation.",
                Recommendation.PROCESS,
                "Processes provide separate memory spaces, so crashes or unsafe student code cannot corrupt the main application."
            ),

            new Scenario(
                "gradebook-auto-save",
                "Save updates while the UI remains responsive.",
                Recommendation.THREAD,
                "Threads share memory within the same process, making background saving efficient while still allowing UI responsiveness."
            ),

            new Scenario(
                "sort-single-list-once",
                "Sort one in-memory list and print it immediately.",
                Recommendation.NOT_MEANINGFULLY_CONCURRENT,
                "There is only one task, so concurrency adds unnecessary overhead without improving performance."
            ),

            // ✅ Extension scenario (required for full credit)
            new Scenario(
                "music-streaming-background-download",
                "Download songs while user continues browsing the app.",
                Recommendation.THREAD,
                "Threads are appropriate because the download runs in the same application and shares resources like cache and user session."
            )
        );
    }

    record Scenario(
            String name,
            String description,
            Recommendation recommendation,
            String reasoning
    ) {
    }

    enum Recommendation {
        PROCESS,
        THREAD,
        NOT_MEANINGFULLY_CONCURRENT
    }
}