package io.github.piotr_janczukowicz.gitlab.api.commits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCommitSignatureTest {

    @Test
    void constructor_shouldAcceptNull_whenSignatureTypeIsNullable() {
        final GitLabCommitSignatureBuilder builder = GitLabCommitSignatureBuilder.builder(
                        CommitsCatalogFixtures.commitSignature())
                .signatureType(null);

        final GitLabCommitSignature built = builder.build();

        assertThat(built.signatureType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSignatureIsNullable() {
        final GitLabCommitSignatureBuilder builder = GitLabCommitSignatureBuilder.builder(
                        CommitsCatalogFixtures.commitSignature())
                .signature(null);

        final GitLabCommitSignature built = builder.build();

        assertThat(built.signature()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitSourceIsNullable() {
        final GitLabCommitSignatureBuilder builder = GitLabCommitSignatureBuilder.builder(
                        CommitsCatalogFixtures.commitSignature())
                .commitSource(null);

        final GitLabCommitSignature built = builder.build();

        assertThat(built.commitSource()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCommitSignature value = CommitsCatalogFixtures.commitSignature();

        assertSoftly(softly -> {
            softly.assertThat(value.signatureType()).isEqualTo("PGP");
            softly.assertThat(value.signature()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.commitSource()).isEqualTo("gitaly");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCommitSignature original = CommitsCatalogFixtures.commitSignature();

        final GitLabCommitSignature rebuilt =
                GitLabCommitSignatureBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCommitSignature.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("signatureType", "signature", "commitSource");
    }
}
