package io.github.piotr_janczukowicz.gitlab.api.issueboards;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIssueBoardsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectIssueBoardsCreatePayloadBuilder builder =
                GitLabProjectIssueBoardsCreatePayloadBuilder.builder(
                                IssueboardsCatalogFixtures.projectIssueBoardsCreatePayload())
                        .name(null);

        final GitLabProjectIssueBoardsCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIssueBoardsCreatePayload value =
                IssueboardsCatalogFixtures.projectIssueBoardsCreatePayload();

        assertThat(value.name()).isEqualTo("name");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIssueBoardsCreatePayload original =
                IssueboardsCatalogFixtures.projectIssueBoardsCreatePayload();

        final GitLabProjectIssueBoardsCreatePayload rebuilt =
                GitLabProjectIssueBoardsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIssueBoardsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name");
    }
}
