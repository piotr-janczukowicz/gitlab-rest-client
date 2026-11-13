package io.github.piotr_janczukowicz.gitlab.api.issueboards;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIssueBoardsUpdateListPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenPositionIsNullable() {
        final GitLabProjectIssueBoardsUpdateListPayloadBuilder builder =
                GitLabProjectIssueBoardsUpdateListPayloadBuilder.builder(
                                IssueboardsCatalogFixtures.projectIssueBoardsUpdateListPayload())
                        .position(null);

        final GitLabProjectIssueBoardsUpdateListPayload built = builder.build();

        assertThat(built.position()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIssueBoardsUpdateListPayload value =
                IssueboardsCatalogFixtures.projectIssueBoardsUpdateListPayload();

        assertThat(value.position()).isEqualTo(1);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIssueBoardsUpdateListPayload original =
                IssueboardsCatalogFixtures.projectIssueBoardsUpdateListPayload();

        final GitLabProjectIssueBoardsUpdateListPayload rebuilt =
                GitLabProjectIssueBoardsUpdateListPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIssueBoardsUpdateListPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("position");
    }
}
