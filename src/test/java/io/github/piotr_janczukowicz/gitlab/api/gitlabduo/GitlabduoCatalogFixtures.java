package io.github.piotr_janczukowicz.gitlab.api.gitlabduo;

import java.util.Map;

public final class GitlabduoCatalogFixtures {

    private GitlabduoCatalogFixtures() {}

    public static GitLabDuoCreatePayload duoCreatePayload() {
        return GitLabDuoCreatePayloadBuilder.builder()
                .diffs("diffs")
                .mrTitle("mr_title")
                .mrDescription("mr_description")
                .filesContent(Map.of("key", "value"))
                .build();
    }

    public static GitLabDuoGitCommandPayload duoGitCommandPayload() {
        return GitLabDuoGitCommandPayloadBuilder.builder().prompt("prompt").build();
    }
}
