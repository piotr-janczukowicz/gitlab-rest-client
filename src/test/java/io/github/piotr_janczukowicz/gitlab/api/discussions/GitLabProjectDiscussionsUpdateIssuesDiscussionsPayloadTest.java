package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDiscussionsUpdateIssuesDiscussionsPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenResolvedIsNullable() {
        final GitLabProjectDiscussionsUpdateIssuesDiscussionsPayloadBuilder builder =
                GitLabProjectDiscussionsUpdateIssuesDiscussionsPayloadBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsUpdateIssuesDiscussionsPayload())
                        .resolved(null);

        final GitLabProjectDiscussionsUpdateIssuesDiscussionsPayload built = builder.build();

        assertThat(built.resolved()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDiscussionsUpdateIssuesDiscussionsPayload value =
                DiscussionsCatalogFixtures.projectDiscussionsUpdateIssuesDiscussionsPayload();

        assertThat(value.resolved()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDiscussionsUpdateIssuesDiscussionsPayload original =
                DiscussionsCatalogFixtures.projectDiscussionsUpdateIssuesDiscussionsPayload();

        final GitLabProjectDiscussionsUpdateIssuesDiscussionsPayload rebuilt =
                GitLabProjectDiscussionsUpdateIssuesDiscussionsPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectDiscussionsUpdateIssuesDiscussionsPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("resolved");
    }
}
