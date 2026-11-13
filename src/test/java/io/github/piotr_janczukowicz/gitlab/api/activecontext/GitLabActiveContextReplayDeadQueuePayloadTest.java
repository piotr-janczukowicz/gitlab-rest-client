package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabActiveContextReplayDeadQueuePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenQueueIsNullable() {
        final GitLabActiveContextReplayDeadQueuePayloadBuilder builder =
                GitLabActiveContextReplayDeadQueuePayloadBuilder.builder(
                                ActivecontextCatalogFixtures.activeContextReplayDeadQueuePayload())
                        .queue(null);

        final GitLabActiveContextReplayDeadQueuePayload built = builder.build();

        assertThat(built.queue()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabActiveContextReplayDeadQueuePayload value =
                ActivecontextCatalogFixtures.activeContextReplayDeadQueuePayload();

        assertThat(value.queue()).isEqualTo("queue");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabActiveContextReplayDeadQueuePayload original =
                ActivecontextCatalogFixtures.activeContextReplayDeadQueuePayload();

        final GitLabActiveContextReplayDeadQueuePayload rebuilt =
                GitLabActiveContextReplayDeadQueuePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabActiveContextReplayDeadQueuePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("queue");
    }
}
