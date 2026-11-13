package io.github.piotr_janczukowicz.gitlab.api.issues;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIssuesMovePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenToProjectIdIsNullable() {
        final GitLabProjectIssuesMovePayloadBuilder builder = GitLabProjectIssuesMovePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesMovePayload())
                .toProjectId(null);

        final GitLabProjectIssuesMovePayload built = builder.build();

        assertThat(built.toProjectId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIssuesMovePayload value = IssuesCatalogFixtures.projectIssuesMovePayload();

        assertThat(value.toProjectId()).isEqualTo(1L);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIssuesMovePayload original = IssuesCatalogFixtures.projectIssuesMovePayload();

        final GitLabProjectIssuesMovePayload rebuilt =
                GitLabProjectIssuesMovePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIssuesMovePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("toProjectId");
    }
}
