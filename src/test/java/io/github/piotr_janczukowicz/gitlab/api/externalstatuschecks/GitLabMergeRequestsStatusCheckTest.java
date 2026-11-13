package io.github.piotr_janczukowicz.gitlab.api.externalstatuschecks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestsStatusCheckTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMergeRequestsStatusCheckBuilder builder = GitLabMergeRequestsStatusCheckBuilder.builder(
                        ExternalstatuschecksCatalogFixtures.mergeRequestsStatusCheck())
                .id(null);

        final GitLabMergeRequestsStatusCheck built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabMergeRequestsStatusCheckBuilder builder = GitLabMergeRequestsStatusCheckBuilder.builder(
                        ExternalstatuschecksCatalogFixtures.mergeRequestsStatusCheck())
                .name(null);

        final GitLabMergeRequestsStatusCheck built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalUrlIsNullable() {
        final GitLabMergeRequestsStatusCheckBuilder builder = GitLabMergeRequestsStatusCheckBuilder.builder(
                        ExternalstatuschecksCatalogFixtures.mergeRequestsStatusCheck())
                .externalUrl(null);

        final GitLabMergeRequestsStatusCheck built = builder.build();

        assertThat(built.externalUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabMergeRequestsStatusCheckBuilder builder = GitLabMergeRequestsStatusCheckBuilder.builder(
                        ExternalstatuschecksCatalogFixtures.mergeRequestsStatusCheck())
                .status(null);

        final GitLabMergeRequestsStatusCheck built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequestsStatusCheck value = ExternalstatuschecksCatalogFixtures.mergeRequestsStatusCheck();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("QA");
            softly.assertThat(value.externalUrl()).isEqualTo("https://www.example.com");
            softly.assertThat(value.status()).isEqualTo("passed");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeRequestsStatusCheck original = ExternalstatuschecksCatalogFixtures.mergeRequestsStatusCheck();

        final GitLabMergeRequestsStatusCheck rebuilt =
                GitLabMergeRequestsStatusCheckBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeRequestsStatusCheck.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "name", "externalUrl", "status");
    }
}
