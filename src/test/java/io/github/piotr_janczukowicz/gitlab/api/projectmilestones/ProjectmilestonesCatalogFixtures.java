package io.github.piotr_janczukowicz.gitlab.api.projectmilestones;

public final class ProjectmilestonesCatalogFixtures {

    private ProjectmilestonesCatalogFixtures() {}

    public static GitLabProjectProjectMilestonesCreatePayload projectProjectMilestonesCreatePayload() {
        return GitLabProjectProjectMilestonesCreatePayloadBuilder.builder()
                .title("title")
                .description("description")
                .dueDate("due_date")
                .startDate("start_date")
                .build();
    }

    public static GitLabProjectProjectMilestonesUpdatePayload projectProjectMilestonesUpdatePayload() {
        return GitLabProjectProjectMilestonesUpdatePayloadBuilder.builder()
                .title("title")
                .stateEvent(GitLabProjectProjectMilestonesUpdateStateEvent.CLOSE)
                .description("description")
                .dueDate("due_date")
                .startDate("start_date")
                .build();
    }
}
