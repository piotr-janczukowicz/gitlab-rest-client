package io.github.piotr_janczukowicz.gitlab.api.issues;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIssuesTimeEstimatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDurationIsNullable() {
        final GitLabProjectIssuesTimeEstimatePayloadBuilder builder =
                GitLabProjectIssuesTimeEstimatePayloadBuilder.builder(
                                IssuesCatalogFixtures.projectIssuesTimeEstimatePayload())
                        .duration(null);

        final GitLabProjectIssuesTimeEstimatePayload built = builder.build();

        assertThat(built.duration()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIssuesTimeEstimatePayload value = IssuesCatalogFixtures.projectIssuesTimeEstimatePayload();

        assertThat(value.duration()).isEqualTo("3h30m");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIssuesTimeEstimatePayload original =
                IssuesCatalogFixtures.projectIssuesTimeEstimatePayload();

        final GitLabProjectIssuesTimeEstimatePayload rebuilt =
                GitLabProjectIssuesTimeEstimatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIssuesTimeEstimatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("duration");
    }
}
