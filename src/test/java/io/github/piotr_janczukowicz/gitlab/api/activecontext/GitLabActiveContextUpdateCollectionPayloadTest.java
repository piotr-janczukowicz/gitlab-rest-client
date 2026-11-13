package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabActiveContextUpdateCollectionPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenQueueShardCountIsNullable() {
        final GitLabActiveContextUpdateCollectionPayloadBuilder builder =
                GitLabActiveContextUpdateCollectionPayloadBuilder.builder(
                                ActivecontextCatalogFixtures.activeContextUpdateCollectionPayload())
                        .queueShardCount(null);

        final GitLabActiveContextUpdateCollectionPayload built = builder.build();

        assertThat(built.queueShardCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenQueueShardLimitIsNullable() {
        final GitLabActiveContextUpdateCollectionPayloadBuilder builder =
                GitLabActiveContextUpdateCollectionPayloadBuilder.builder(
                                ActivecontextCatalogFixtures.activeContextUpdateCollectionPayload())
                        .queueShardLimit(null);

        final GitLabActiveContextUpdateCollectionPayload built = builder.build();

        assertThat(built.queueShardLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConnectionIdIsNullable() {
        final GitLabActiveContextUpdateCollectionPayloadBuilder builder =
                GitLabActiveContextUpdateCollectionPayloadBuilder.builder(
                                ActivecontextCatalogFixtures.activeContextUpdateCollectionPayload())
                        .connectionId(null);

        final GitLabActiveContextUpdateCollectionPayload built = builder.build();

        assertThat(built.connectionId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabActiveContextUpdateCollectionPayload value =
                ActivecontextCatalogFixtures.activeContextUpdateCollectionPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.queueShardCount()).isEqualTo(1);
            softly.assertThat(value.queueShardLimit()).isEqualTo(1);
            softly.assertThat(value.connectionId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabActiveContextUpdateCollectionPayload original =
                ActivecontextCatalogFixtures.activeContextUpdateCollectionPayload();

        final GitLabActiveContextUpdateCollectionPayload rebuilt =
                GitLabActiveContextUpdateCollectionPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabActiveContextUpdateCollectionPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("queueShardCount", "queueShardLimit", "connectionId");
    }
}
