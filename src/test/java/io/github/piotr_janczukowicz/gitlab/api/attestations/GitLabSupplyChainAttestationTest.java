package io.github.piotr_janczukowicz.gitlab.api.attestations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSupplyChainAttestationTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabSupplyChainAttestationBuilder builder = GitLabSupplyChainAttestationBuilder.builder(
                        AttestationsCatalogFixtures.supplyChainAttestation())
                .id(null);

        final GitLabSupplyChainAttestation built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabSupplyChainAttestationBuilder builder = GitLabSupplyChainAttestationBuilder.builder(
                        AttestationsCatalogFixtures.supplyChainAttestation())
                .iid(null);

        final GitLabSupplyChainAttestation built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabSupplyChainAttestationBuilder builder = GitLabSupplyChainAttestationBuilder.builder(
                        AttestationsCatalogFixtures.supplyChainAttestation())
                .createdAt(null);

        final GitLabSupplyChainAttestation built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabSupplyChainAttestationBuilder builder = GitLabSupplyChainAttestationBuilder.builder(
                        AttestationsCatalogFixtures.supplyChainAttestation())
                .updatedAt(null);

        final GitLabSupplyChainAttestation built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpireAtIsNullable() {
        final GitLabSupplyChainAttestationBuilder builder = GitLabSupplyChainAttestationBuilder.builder(
                        AttestationsCatalogFixtures.supplyChainAttestation())
                .expireAt(null);

        final GitLabSupplyChainAttestation built = builder.build();

        assertThat(built.expireAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabSupplyChainAttestationBuilder builder = GitLabSupplyChainAttestationBuilder.builder(
                        AttestationsCatalogFixtures.supplyChainAttestation())
                .projectId(null);

        final GitLabSupplyChainAttestation built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildIdIsNullable() {
        final GitLabSupplyChainAttestationBuilder builder = GitLabSupplyChainAttestationBuilder.builder(
                        AttestationsCatalogFixtures.supplyChainAttestation())
                .buildId(null);

        final GitLabSupplyChainAttestation built = builder.build();

        assertThat(built.buildId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabSupplyChainAttestationBuilder builder = GitLabSupplyChainAttestationBuilder.builder(
                        AttestationsCatalogFixtures.supplyChainAttestation())
                .status(null);

        final GitLabSupplyChainAttestation built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPredicateKindIsNullable() {
        final GitLabSupplyChainAttestationBuilder builder = GitLabSupplyChainAttestationBuilder.builder(
                        AttestationsCatalogFixtures.supplyChainAttestation())
                .predicateKind(null);

        final GitLabSupplyChainAttestation built = builder.build();

        assertThat(built.predicateKind()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPredicateTypeIsNullable() {
        final GitLabSupplyChainAttestationBuilder builder = GitLabSupplyChainAttestationBuilder.builder(
                        AttestationsCatalogFixtures.supplyChainAttestation())
                .predicateType(null);

        final GitLabSupplyChainAttestation built = builder.build();

        assertThat(built.predicateType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubjectDigestIsNullable() {
        final GitLabSupplyChainAttestationBuilder builder = GitLabSupplyChainAttestationBuilder.builder(
                        AttestationsCatalogFixtures.supplyChainAttestation())
                .subjectDigest(null);

        final GitLabSupplyChainAttestation built = builder.build();

        assertThat(built.subjectDigest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSigningMethodIsNullable() {
        final GitLabSupplyChainAttestationBuilder builder = GitLabSupplyChainAttestationBuilder.builder(
                        AttestationsCatalogFixtures.supplyChainAttestation())
                .signingMethod(null);

        final GitLabSupplyChainAttestation built = builder.build();

        assertThat(built.signingMethod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDownloadUrlIsNullable() {
        final GitLabSupplyChainAttestationBuilder builder = GitLabSupplyChainAttestationBuilder.builder(
                        AttestationsCatalogFixtures.supplyChainAttestation())
                .downloadUrl(null);

        final GitLabSupplyChainAttestation built = builder.build();

        assertThat(built.downloadUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSupplyChainAttestation value = AttestationsCatalogFixtures.supplyChainAttestation();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.expireAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.buildId()).isEqualTo(1L);
            softly.assertThat(value.status()).isEqualTo("success");
            softly.assertThat(value.predicateKind()).isEqualTo("provenance");
            softly.assertThat(value.predicateType()).isEqualTo("https://slsa.dev/provenance/v1");
            softly.assertThat(value.subjectDigest())
                    .isEqualTo("5db1fee4b5703808c48078a76768b155b421b210c0761cd6a5d223f4d99f1eaa");
            softly.assertThat(value.signingMethod()).isEqualTo(GitLabSupplyChainAttestationSigningMethod.SIGSTORE);
            softly.assertThat(value.downloadUrl()).isEqualTo("download_url");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSupplyChainAttestation original = AttestationsCatalogFixtures.supplyChainAttestation();

        final GitLabSupplyChainAttestation rebuilt =
                GitLabSupplyChainAttestationBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSupplyChainAttestation.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "iid",
                        "createdAt",
                        "updatedAt",
                        "expireAt",
                        "projectId",
                        "buildId",
                        "status",
                        "predicateKind",
                        "predicateType",
                        "subjectDigest",
                        "signingMethod",
                        "downloadUrl");
    }
}
