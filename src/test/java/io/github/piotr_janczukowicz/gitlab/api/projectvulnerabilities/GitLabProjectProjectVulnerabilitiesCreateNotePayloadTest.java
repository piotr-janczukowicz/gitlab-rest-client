package io.github.piotr_janczukowicz.gitlab.api.projectvulnerabilities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectVulnerabilitiesCreateNotePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabProjectProjectVulnerabilitiesCreateNotePayloadBuilder builder =
                GitLabProjectProjectVulnerabilitiesCreateNotePayloadBuilder.builder(
                                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreateNotePayload())
                        .body(null);

        final GitLabProjectProjectVulnerabilitiesCreateNotePayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabProjectProjectVulnerabilitiesCreateNotePayloadBuilder builder =
                GitLabProjectProjectVulnerabilitiesCreateNotePayloadBuilder.builder(
                                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreateNotePayload())
                        .confidential(null);

        final GitLabProjectProjectVulnerabilitiesCreateNotePayload built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInternalIsNullable() {
        final GitLabProjectProjectVulnerabilitiesCreateNotePayloadBuilder builder =
                GitLabProjectProjectVulnerabilitiesCreateNotePayloadBuilder.builder(
                                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreateNotePayload())
                        .internal(null);

        final GitLabProjectProjectVulnerabilitiesCreateNotePayload built = builder.build();

        assertThat(built.internal()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectProjectVulnerabilitiesCreateNotePayloadBuilder builder =
                GitLabProjectProjectVulnerabilitiesCreateNotePayloadBuilder.builder(
                                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreateNotePayload())
                        .createdAt(null);

        final GitLabProjectProjectVulnerabilitiesCreateNotePayload built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffHeadShaIsNullable() {
        final GitLabProjectProjectVulnerabilitiesCreateNotePayloadBuilder builder =
                GitLabProjectProjectVulnerabilitiesCreateNotePayloadBuilder.builder(
                                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreateNotePayload())
                        .mergeRequestDiffHeadSha(null);

        final GitLabProjectProjectVulnerabilitiesCreateNotePayload built = builder.build();

        assertThat(built.mergeRequestDiffHeadSha()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectVulnerabilitiesCreateNotePayload value =
                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreateNotePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.confidential()).isEqualTo(true);
            softly.assertThat(value.internal()).isEqualTo(true);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.mergeRequestDiffHeadSha()).isEqualTo("merge_request_diff_head_sha");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectVulnerabilitiesCreateNotePayload original =
                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreateNotePayload();

        final GitLabProjectProjectVulnerabilitiesCreateNotePayload rebuilt =
                GitLabProjectProjectVulnerabilitiesCreateNotePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabProjectProjectVulnerabilitiesCreateNotePayloadBuilder builder =
                GitLabProjectProjectVulnerabilitiesCreateNotePayloadBuilder.builder(
                                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreateNotePayload())
                        .createdAt(instant);

        final GitLabProjectProjectVulnerabilitiesCreateNotePayload built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectVulnerabilitiesCreateNotePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "confidential", "internal", "createdAt", "mergeRequestDiffHeadSha");
    }
}
