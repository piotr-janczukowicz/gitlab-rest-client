package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupDiscussionsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenResolvedIsNullable() {
        final GitLabGroupDiscussionsUpdatePayloadBuilder builder = GitLabGroupDiscussionsUpdatePayloadBuilder.builder(
                        DiscussionsCatalogFixtures.groupDiscussionsUpdatePayload())
                .resolved(null);

        final GitLabGroupDiscussionsUpdatePayload built = builder.build();

        assertThat(built.resolved()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupDiscussionsUpdatePayload value = DiscussionsCatalogFixtures.groupDiscussionsUpdatePayload();

        assertThat(value.resolved()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupDiscussionsUpdatePayload original = DiscussionsCatalogFixtures.groupDiscussionsUpdatePayload();

        final GitLabGroupDiscussionsUpdatePayload rebuilt =
                GitLabGroupDiscussionsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupDiscussionsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("resolved");
    }
}
