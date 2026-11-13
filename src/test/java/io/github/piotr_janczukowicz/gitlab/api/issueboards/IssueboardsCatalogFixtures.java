package io.github.piotr_janczukowicz.gitlab.api.issueboards;

public final class IssueboardsCatalogFixtures {

    private IssueboardsCatalogFixtures() {}

    public static GitLabProjectIssueBoardsCreateListPayload projectIssueBoardsCreateListPayload() {
        return GitLabProjectIssueBoardsCreateListPayloadBuilder.builder()
                .labelId(1L)
                .milestoneId(1L)
                .iterationId(1L)
                .assigneeId(1L)
                .statusId(1L)
                .build();
    }

    public static GitLabProjectIssueBoardsCreatePayload projectIssueBoardsCreatePayload() {
        return GitLabProjectIssueBoardsCreatePayloadBuilder.builder()
                .name("name")
                .build();
    }

    public static GitLabProjectIssueBoardsUpdateListPayload projectIssueBoardsUpdateListPayload() {
        return GitLabProjectIssueBoardsUpdateListPayloadBuilder.builder()
                .position(1)
                .build();
    }

    public static GitLabProjectIssueBoardsUpdatePayload projectIssueBoardsUpdatePayload() {
        return GitLabProjectIssueBoardsUpdatePayloadBuilder.builder()
                .name("name")
                .hideBacklogList(true)
                .hideClosedList(true)
                .assigneeId(1L)
                .milestoneId(1L)
                .labels("labels")
                .weight(1)
                .build();
    }
}
