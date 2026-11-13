package io.github.piotr_janczukowicz.gitlab.api.jobsartifacts;

public final class JobsartifactsCatalogFixtures {

    private JobsartifactsCatalogFixtures() {}

    public static GitLabCiJobArtifactEntry ciJobArtifactEntry() {
        return GitLabCiJobArtifactEntryBuilder.builder()
                .name("index.html")
                .path("coverage/index.html")
                .type(GitLabCiJobArtifactEntryType.FILE)
                .size(1L)
                .mode("100644")
                .build();
    }
}
