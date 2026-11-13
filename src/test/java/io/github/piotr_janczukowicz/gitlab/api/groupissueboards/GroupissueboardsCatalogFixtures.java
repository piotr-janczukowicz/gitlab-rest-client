package io.github.piotr_janczukowicz.gitlab.api.groupissueboards;

public final class GroupissueboardsCatalogFixtures {

    private GroupissueboardsCatalogFixtures() {}

    public static GitLabGroupGroupIssueBoardsCreateListPayload groupGroupIssueBoardsCreateListPayload() {
        return GitLabGroupGroupIssueBoardsCreateListPayloadBuilder.builder()
                .labelId(1L)
                .milestoneId(1L)
                .iterationId(1L)
                .assigneeId(1L)
                .statusId(1L)
                .build();
    }

    public static GitLabGroupGroupIssueBoardsCreatePayload groupGroupIssueBoardsCreatePayload() {
        return GitLabGroupGroupIssueBoardsCreatePayloadBuilder.builder()
                .name("name")
                .build();
    }

    public static GitLabGroupGroupIssueBoardsUpdateListPayload groupGroupIssueBoardsUpdateListPayload() {
        return GitLabGroupGroupIssueBoardsUpdateListPayloadBuilder.builder()
                .position(1)
                .build();
    }

    public static GitLabGroupGroupIssueBoardsUpdatePayload groupGroupIssueBoardsUpdatePayload() {
        return GitLabGroupGroupIssueBoardsUpdatePayloadBuilder.builder()
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
