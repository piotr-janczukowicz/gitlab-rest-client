package io.github.piotr_janczukowicz.gitlab.api.issues;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIssuesReorderPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenMoveAfterIdIsNullable() {
        final GitLabProjectIssuesReorderPayloadBuilder builder = GitLabProjectIssuesReorderPayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesReorderPayload())
                .moveAfterId(null);

        final GitLabProjectIssuesReorderPayload built = builder.build();

        assertThat(built.moveAfterId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMoveBeforeIdIsNullable() {
        final GitLabProjectIssuesReorderPayloadBuilder builder = GitLabProjectIssuesReorderPayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesReorderPayload())
                .moveBeforeId(null);

        final GitLabProjectIssuesReorderPayload built = builder.build();

        assertThat(built.moveBeforeId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIssuesReorderPayload value = IssuesCatalogFixtures.projectIssuesReorderPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.moveAfterId()).isEqualTo(1L);
            softly.assertThat(value.moveBeforeId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIssuesReorderPayload original = IssuesCatalogFixtures.projectIssuesReorderPayload();

        final GitLabProjectIssuesReorderPayload rebuilt =
                GitLabProjectIssuesReorderPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIssuesReorderPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("moveAfterId", "moveBeforeId");
    }
}
