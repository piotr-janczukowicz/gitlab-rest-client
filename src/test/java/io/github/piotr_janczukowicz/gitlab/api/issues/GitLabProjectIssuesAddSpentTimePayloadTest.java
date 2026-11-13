package io.github.piotr_janczukowicz.gitlab.api.issues;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIssuesAddSpentTimePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDurationIsNullable() {
        final GitLabProjectIssuesAddSpentTimePayloadBuilder builder =
                GitLabProjectIssuesAddSpentTimePayloadBuilder.builder(
                                IssuesCatalogFixtures.projectIssuesAddSpentTimePayload())
                        .duration(null);

        final GitLabProjectIssuesAddSpentTimePayload built = builder.build();

        assertThat(built.duration()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIssuesAddSpentTimePayload value = IssuesCatalogFixtures.projectIssuesAddSpentTimePayload();

        assertThat(value.duration()).isEqualTo("duration");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIssuesAddSpentTimePayload original =
                IssuesCatalogFixtures.projectIssuesAddSpentTimePayload();

        final GitLabProjectIssuesAddSpentTimePayload rebuilt =
                GitLabProjectIssuesAddSpentTimePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIssuesAddSpentTimePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("duration");
    }
}
