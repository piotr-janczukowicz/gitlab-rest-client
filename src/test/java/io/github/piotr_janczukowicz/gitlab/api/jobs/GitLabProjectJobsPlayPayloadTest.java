package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectJobsPlayPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenJobVariablesAttributesIsNullable() {
        final GitLabProjectJobsPlayPayloadBuilder builder = GitLabProjectJobsPlayPayloadBuilder.builder(
                        JobsCatalogFixtures.projectJobsPlayPayload())
                .jobVariablesAttributes(null);

        final GitLabProjectJobsPlayPayload built = builder.build();

        assertThat(built.jobVariablesAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobInputsIsNullable() {
        final GitLabProjectJobsPlayPayloadBuilder builder = GitLabProjectJobsPlayPayloadBuilder.builder(
                        JobsCatalogFixtures.projectJobsPlayPayload())
                .jobInputs(null);

        final GitLabProjectJobsPlayPayload built = builder.build();

        assertThat(built.jobInputs()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectJobsPlayPayload value = JobsCatalogFixtures.projectJobsPlayPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.jobVariablesAttributes())
                    .isEqualTo(List.of(JobsCatalogFixtures.projectJobsPlayJobVariablesAttribute()));
            softly.assertThat(value.jobInputs()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectJobsPlayPayload original = JobsCatalogFixtures.projectJobsPlayPayload();

        final GitLabProjectJobsPlayPayload rebuilt =
                GitLabProjectJobsPlayPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenJobVariablesAttributesSourceChangesLater() {
        final List<GitLabProjectJobsPlayJobVariablesAttribute> source =
                new ArrayList<>(List.of(JobsCatalogFixtures.projectJobsPlayJobVariablesAttribute()));
        final GitLabProjectJobsPlayPayload built = GitLabProjectJobsPlayPayloadBuilder.builder(
                        JobsCatalogFixtures.projectJobsPlayPayload())
                .jobVariablesAttributes(source)
                .build();
        source.clear();

        assertThat(built.jobVariablesAttributes()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenJobVariablesAttributesIsRead() {
        final GitLabProjectJobsPlayPayload built = JobsCatalogFixtures.projectJobsPlayPayload();
        final List<GitLabProjectJobsPlayJobVariablesAttribute> values = built.jobVariablesAttributes();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheMap_whenJobInputsSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabProjectJobsPlayPayload built = GitLabProjectJobsPlayPayloadBuilder.builder(
                        JobsCatalogFixtures.projectJobsPlayPayload())
                .jobInputs(source)
                .build();
        source.clear();

        assertThat(built.jobInputs()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectJobsPlayPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("jobVariablesAttributes", "jobInputs");
    }
}
