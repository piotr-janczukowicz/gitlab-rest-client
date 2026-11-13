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
class GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenMaxResultsIsNullable() {
        final GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayloadBuilder builder =
                GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowExperimentPayload())
                        .maxResults(null);

        final GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayload built = builder.build();

        assertThat(built.maxResults()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayloadBuilder builder =
                GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowExperimentPayload())
                        .orderBy(null);

        final GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayload built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPageTokenIsNullable() {
        final GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayloadBuilder builder =
                GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowExperimentPayload())
                        .pageToken(null);

        final GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayload built = builder.build();

        assertThat(built.pageToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilterIsNullable() {
        final GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayloadBuilder builder =
                GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowExperimentPayload())
                        .filter(null);

        final GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayload built = builder.build();

        assertThat(built.filter()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayload value =
                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowExperimentPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.maxResults()).isEqualTo(1);
            softly.assertThat(value.orderBy()).isEqualTo(List.of("text"));
            softly.assertThat(value.pageToken()).isEqualTo("page_token");
            softly.assertThat(value.filter()).isEqualTo("filter");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayload original =
                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowExperimentPayload();

        final GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayload rebuilt =
                GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenOrderBySourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("text"));
        final GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayload built =
                GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowExperimentPayload())
                        .orderBy(source)
                        .build();
        source.clear();

        assertThat(built.orderBy()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenOrderByIsRead() {
        final GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayload built =
                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowExperimentPayload();
        final List<String> values = built.orderBy();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toString_shouldMaskTheValue_whenPageTokenIsACredential() {
        final GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayload value =
                ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowExperimentPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsSearchMlMlflowApiMlflowExperimentPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("maxResults", "orderBy", "pageToken", "filter");
    }
}
