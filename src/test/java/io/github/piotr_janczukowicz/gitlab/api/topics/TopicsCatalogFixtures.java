package io.github.piotr_janczukowicz.gitlab.api.topics;

public final class TopicsCatalogFixtures {

    private TopicsCatalogFixtures() {}

    public static GitLabProjectTopic projectTopic() {
        return GitLabProjectTopicBuilder.builder()
                .id(1L)
                .name("topic1")
                .title("Topic 1")
                .description("A description")
                .totalProjectsCount(1)
                .organizationId(1L)
                .avatarUrl("http://gitlab.example.com/uploads/topic/avatar/1/avatar.png")
                .build();
    }

    public static GitLabTopicsMergePayload topicsMergePayload() {
        return GitLabTopicsMergePayloadBuilder.builder()
                .sourceTopicId(1L)
                .targetTopicId(1L)
                .build();
    }
}
