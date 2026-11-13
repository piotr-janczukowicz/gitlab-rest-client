package io.github.piotr_janczukowicz.gitlab.api.topics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectTopicTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectTopicBuilder builder = GitLabProjectTopicBuilder.builder(
                        TopicsCatalogFixtures.projectTopic())
                .id(null);

        final GitLabProjectTopic built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectTopicBuilder builder = GitLabProjectTopicBuilder.builder(
                        TopicsCatalogFixtures.projectTopic())
                .name(null);

        final GitLabProjectTopic built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabProjectTopicBuilder builder = GitLabProjectTopicBuilder.builder(
                        TopicsCatalogFixtures.projectTopic())
                .title(null);

        final GitLabProjectTopic built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectTopicBuilder builder = GitLabProjectTopicBuilder.builder(
                        TopicsCatalogFixtures.projectTopic())
                .description(null);

        final GitLabProjectTopic built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTotalProjectsCountIsNullable() {
        final GitLabProjectTopicBuilder builder = GitLabProjectTopicBuilder.builder(
                        TopicsCatalogFixtures.projectTopic())
                .totalProjectsCount(null);

        final GitLabProjectTopic built = builder.build();

        assertThat(built.totalProjectsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationIdIsNullable() {
        final GitLabProjectTopicBuilder builder = GitLabProjectTopicBuilder.builder(
                        TopicsCatalogFixtures.projectTopic())
                .organizationId(null);

        final GitLabProjectTopic built = builder.build();

        assertThat(built.organizationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabProjectTopicBuilder builder = GitLabProjectTopicBuilder.builder(
                        TopicsCatalogFixtures.projectTopic())
                .avatarUrl(null);

        final GitLabProjectTopic built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectTopic value = TopicsCatalogFixtures.projectTopic();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("topic1");
            softly.assertThat(value.title()).isEqualTo("Topic 1");
            softly.assertThat(value.description()).isEqualTo("A description");
            softly.assertThat(value.totalProjectsCount()).isEqualTo(1);
            softly.assertThat(value.organizationId()).isEqualTo(1L);
            softly.assertThat(value.avatarUrl())
                    .isEqualTo("http://gitlab.example.com/uploads/topic/avatar/1/avatar.png");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectTopic original = TopicsCatalogFixtures.projectTopic();

        final GitLabProjectTopic rebuilt =
                GitLabProjectTopicBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectTopic.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id", "name", "title", "description", "totalProjectsCount", "organizationId", "avatarUrl");
    }
}
