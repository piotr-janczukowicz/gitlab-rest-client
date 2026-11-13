package io.github.piotr_janczukowicz.gitlab.api.groupmilestones;

public final class GroupmilestonesCatalogFixtures {

    private GroupmilestonesCatalogFixtures() {}

    public static GitLabGroupGroupMilestonesCreatePayload groupGroupMilestonesCreatePayload() {
        return GitLabGroupGroupMilestonesCreatePayloadBuilder.builder()
                .title("title")
                .description("description")
                .dueDate("due_date")
                .startDate("start_date")
                .build();
    }

    public static GitLabGroupGroupMilestonesUpdatePayload groupGroupMilestonesUpdatePayload() {
        return GitLabGroupGroupMilestonesUpdatePayloadBuilder.builder()
                .title("title")
                .stateEvent(GitLabGroupGroupMilestonesUpdateStateEvent.CLOSE)
                .description("description")
                .dueDate("due_date")
                .startDate("start_date")
                .build();
    }
}
