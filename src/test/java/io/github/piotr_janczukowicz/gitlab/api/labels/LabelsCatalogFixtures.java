package io.github.piotr_janczukowicz.gitlab.api.labels;

public final class LabelsCatalogFixtures {

    private LabelsCatalogFixtures() {}

    public static GitLabProjectLabel projectLabel() {
        return GitLabProjectLabelBuilder.builder()
                .id(1L)
                .name("bug")
                .description("Bug reported by user")
                .textColor("#FFFFFF")
                .descriptionHtml("<p>Bug reported by user</p>")
                .color("#FF0000")
                .archived(true)
                .openIssuesCount(1)
                .closedIssuesCount(1)
                .openMergeRequestsCount(1)
                .subscribed(true)
                .priority(1)
                .isProjectLabel(true)
                .build();
    }

    public static GitLabProjectLabelsCreatePayload projectLabelsCreatePayload() {
        return GitLabProjectLabelsCreatePayloadBuilder.builder()
                .name("name")
                .color("color")
                .description("description")
                .archived(true)
                .priority(1)
                .build();
    }

    public static GitLabProjectLabelsPromotePayload projectLabelsPromotePayload() {
        return GitLabProjectLabelsPromotePayloadBuilder.builder().name("name").build();
    }

    public static GitLabProjectLabelsUpdateByNamePayload projectLabelsUpdateByNamePayload() {
        return GitLabProjectLabelsUpdateByNamePayloadBuilder.builder()
                .newName("new_name")
                .color("color")
                .description("description")
                .archived(true)
                .priority(1)
                .build();
    }

    public static GitLabProjectLabelsUpdatePayload projectLabelsUpdatePayload() {
        return GitLabProjectLabelsUpdatePayloadBuilder.builder()
                .labelId(1L)
                .name("name")
                .newName("new_name")
                .color("color")
                .description("description")
                .archived(true)
                .priority(1)
                .build();
    }
}
