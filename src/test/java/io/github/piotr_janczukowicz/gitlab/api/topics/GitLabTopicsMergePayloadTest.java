package io.github.piotr_janczukowicz.gitlab.api.topics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTopicsMergePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenSourceTopicIdIsNullable() {
        final GitLabTopicsMergePayloadBuilder builder = GitLabTopicsMergePayloadBuilder.builder(
                        TopicsCatalogFixtures.topicsMergePayload())
                .sourceTopicId(null);

        final GitLabTopicsMergePayload built = builder.build();

        assertThat(built.sourceTopicId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetTopicIdIsNullable() {
        final GitLabTopicsMergePayloadBuilder builder = GitLabTopicsMergePayloadBuilder.builder(
                        TopicsCatalogFixtures.topicsMergePayload())
                .targetTopicId(null);

        final GitLabTopicsMergePayload built = builder.build();

        assertThat(built.targetTopicId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTopicsMergePayload value = TopicsCatalogFixtures.topicsMergePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.sourceTopicId()).isEqualTo(1L);
            softly.assertThat(value.targetTopicId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTopicsMergePayload original = TopicsCatalogFixtures.topicsMergePayload();

        final GitLabTopicsMergePayload rebuilt =
                GitLabTopicsMergePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTopicsMergePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sourceTopicId", "targetTopicId");
    }
}
