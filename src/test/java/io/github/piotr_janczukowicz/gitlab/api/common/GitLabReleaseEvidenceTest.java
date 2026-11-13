package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabReleaseEvidenceTest {

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabReleaseEvidenceBuilder builder = GitLabReleaseEvidenceBuilder.builder(
                        CommonCatalogFixtures.releaseEvidence())
                .sha(null);

        final GitLabReleaseEvidence built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilepathIsNullable() {
        final GitLabReleaseEvidenceBuilder builder = GitLabReleaseEvidenceBuilder.builder(
                        CommonCatalogFixtures.releaseEvidence())
                .filepath(null);

        final GitLabReleaseEvidence built = builder.build();

        assertThat(built.filepath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCollectedAtIsNullable() {
        final GitLabReleaseEvidenceBuilder builder = GitLabReleaseEvidenceBuilder.builder(
                        CommonCatalogFixtures.releaseEvidence())
                .collectedAt(null);

        final GitLabReleaseEvidence built = builder.build();

        assertThat(built.collectedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabReleaseEvidence value = CommonCatalogFixtures.releaseEvidence();

        assertSoftly(softly -> {
            softly.assertThat(value.sha()).isEqualTo("760d6cdfb0879c3ffedec13af470e0f71cf52c6cde4d");
            softly.assertThat(value.filepath())
                    .isEqualTo("https://gitlab.example.com/root/app/-/releases/v1.0/evidence.json");
            softly.assertThat(value.collectedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabReleaseEvidence original = CommonCatalogFixtures.releaseEvidence();

        final GitLabReleaseEvidence rebuilt =
                GitLabReleaseEvidenceBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabReleaseEvidence.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sha", "filepath", "collectedAt");
    }
}
