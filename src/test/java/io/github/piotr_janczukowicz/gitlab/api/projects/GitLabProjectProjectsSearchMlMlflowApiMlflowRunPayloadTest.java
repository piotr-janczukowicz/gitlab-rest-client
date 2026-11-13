package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenExperimentIdsIsNullable() {
        final GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowRunPayload())
                        .experimentIds(null);

        final GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.experimentIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxResultsIsNullable() {
        final GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowRunPayload())
                        .maxResults(null);

        final GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.maxResults()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowRunPayload())
                        .orderBy(null);

        final GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPageTokenIsNullable() {
        final GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayloadBuilder builder =
                GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowRunPayload())
                        .pageToken(null);

        final GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayload built = builder.build();

        assertThat(built.pageToken()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayload value =
                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowRunPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.experimentIds()).isEqualTo(List.of("experiment_ids"));
            softly.assertThat(value.maxResults()).isEqualTo(1);
            softly.assertThat(value.orderBy()).isEqualTo(List.of("text"));
            softly.assertThat(value.pageToken()).isEqualTo("page_token");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayload original =
                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowRunPayload();

        final GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayload rebuilt =
                GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenExperimentIdsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("experiment_ids"));
        final GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayload built =
                GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowRunPayload())
                        .experimentIds(source)
                        .build();
        source.clear();

        assertThat(built.experimentIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenExperimentIdsIsRead() {
        final GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayload built =
                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowRunPayload();
        final List<String> values = built.experimentIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenOrderBySourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("text"));
        final GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayload built =
                GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowRunPayload())
                        .orderBy(source)
                        .build();
        source.clear();

        assertThat(built.orderBy()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenOrderByIsRead() {
        final GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayload built =
                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowRunPayload();
        final List<String> values = built.orderBy();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toString_shouldMaskTheValue_whenPageTokenIsACredential() {
        final GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayload value =
                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowRunPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsSearchMlMlflowApiMlflowRunPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("experimentIds", "maxResults", "orderBy", "pageToken");
    }
}
