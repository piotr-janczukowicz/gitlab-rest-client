package io.github.piotr_janczukowicz.gitlab.api.mergerequestcontextcommits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestContextCommitsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenCommitsIsNullable() {
        final GitLabProjectMergeRequestContextCommitsCreatePayloadBuilder builder =
                GitLabProjectMergeRequestContextCommitsCreatePayloadBuilder.builder(
                                MergerequestcontextcommitsCatalogFixtures
                                        .projectMergeRequestContextCommitsCreatePayload())
                        .commits(null);

        final GitLabProjectMergeRequestContextCommitsCreatePayload built = builder.build();

        assertThat(built.commits()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestContextCommitsCreatePayload value =
                MergerequestcontextcommitsCatalogFixtures.projectMergeRequestContextCommitsCreatePayload();

        assertThat(value.commits()).isEqualTo(List.of("commits"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeRequestContextCommitsCreatePayload original =
                MergerequestcontextcommitsCatalogFixtures.projectMergeRequestContextCommitsCreatePayload();

        final GitLabProjectMergeRequestContextCommitsCreatePayload rebuilt =
                GitLabProjectMergeRequestContextCommitsCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenCommitsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("commits"));
        final GitLabProjectMergeRequestContextCommitsCreatePayload built =
                GitLabProjectMergeRequestContextCommitsCreatePayloadBuilder.builder(
                                MergerequestcontextcommitsCatalogFixtures
                                        .projectMergeRequestContextCommitsCreatePayload())
                        .commits(source)
                        .build();
        source.clear();

        assertThat(built.commits()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenCommitsIsRead() {
        final GitLabProjectMergeRequestContextCommitsCreatePayload built =
                MergerequestcontextcommitsCatalogFixtures.projectMergeRequestContextCommitsCreatePayload();
        final List<String> values = built.commits();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectMergeRequestContextCommitsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("commits");
    }
}
