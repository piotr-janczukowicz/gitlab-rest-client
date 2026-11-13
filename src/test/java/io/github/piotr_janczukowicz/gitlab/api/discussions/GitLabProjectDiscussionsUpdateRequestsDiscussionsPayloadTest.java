package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDiscussionsUpdateRequestsDiscussionsPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenResolvedIsNullable() {
        final GitLabProjectDiscussionsUpdateRequestsDiscussionsPayloadBuilder builder =
                GitLabProjectDiscussionsUpdateRequestsDiscussionsPayloadBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsUpdateRequestsDiscussionsPayload())
                        .resolved(null);

        final GitLabProjectDiscussionsUpdateRequestsDiscussionsPayload built = builder.build();

        assertThat(built.resolved()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDiscussionsUpdateRequestsDiscussionsPayload value =
                DiscussionsCatalogFixtures.projectDiscussionsUpdateRequestsDiscussionsPayload();

        assertThat(value.resolved()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDiscussionsUpdateRequestsDiscussionsPayload original =
                DiscussionsCatalogFixtures.projectDiscussionsUpdateRequestsDiscussionsPayload();

        final GitLabProjectDiscussionsUpdateRequestsDiscussionsPayload rebuilt =
                GitLabProjectDiscussionsUpdateRequestsDiscussionsPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectDiscussionsUpdateRequestsDiscussionsPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("resolved");
    }
}
