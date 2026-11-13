package io.github.piotr_janczukowicz.gitlab.api.grouplabels;

public final class GrouplabelsCatalogFixtures {

    private GrouplabelsCatalogFixtures() {}

    public static GitLabGroupGroupLabelsCreatePayload groupGroupLabelsCreatePayload() {
        return GitLabGroupGroupLabelsCreatePayloadBuilder.builder()
                .name("name")
                .color("color")
                .description("description")
                .archived(true)
                .build();
    }

    public static GitLabGroupGroupLabelsUpdateByNamePayload groupGroupLabelsUpdateByNamePayload() {
        return GitLabGroupGroupLabelsUpdateByNamePayloadBuilder.builder()
                .newName("new_name")
                .color("color")
                .description("description")
                .archived(true)
                .build();
    }

    public static GitLabGroupGroupLabelsUpdatePayload groupGroupLabelsUpdatePayload() {
        return GitLabGroupGroupLabelsUpdatePayloadBuilder.builder()
                .labelId(1L)
                .name("name")
                .newName("new_name")
                .color("color")
                .description("description")
                .archived(true)
                .build();
    }
}
