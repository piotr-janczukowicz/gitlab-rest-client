package io.github.piotr_janczukowicz.gitlab.api.groupsshcertificates;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSshCertificateTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabSshCertificateBuilder builder = GitLabSshCertificateBuilder.builder(
                        GroupsshcertificatesCatalogFixtures.sshCertificate())
                .id(null);

        final GitLabSshCertificate built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabSshCertificateBuilder builder = GitLabSshCertificateBuilder.builder(
                        GroupsshcertificatesCatalogFixtures.sshCertificate())
                .title(null);

        final GitLabSshCertificate built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabSshCertificateBuilder builder = GitLabSshCertificateBuilder.builder(
                        GroupsshcertificatesCatalogFixtures.sshCertificate())
                .key(null);

        final GitLabSshCertificate built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFingerprintIsNullable() {
        final GitLabSshCertificateBuilder builder = GitLabSshCertificateBuilder.builder(
                        GroupsshcertificatesCatalogFixtures.sshCertificate())
                .fingerprint(null);

        final GitLabSshCertificate built = builder.build();

        assertThat(built.fingerprint()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabSshCertificateBuilder builder = GitLabSshCertificateBuilder.builder(
                        GroupsshcertificatesCatalogFixtures.sshCertificate())
                .createdAt(null);

        final GitLabSshCertificate built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSshCertificate value = GroupsshcertificatesCatalogFixtures.sshCertificate();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.title()).isEqualTo("new ssh cert");
            softly.assertThat(value.key()).isEqualTo("key");
            softly.assertThat(value.fingerprint()).isEqualTo("SHA256:1CrrRznEotAVn+wfXVzYlDCaVcGoTvHIup4eNWBPK2k");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSshCertificate original = GroupsshcertificatesCatalogFixtures.sshCertificate();

        final GitLabSshCertificate rebuilt =
                GitLabSshCertificateBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSshCertificate.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "title", "key", "fingerprint", "createdAt");
    }
}
