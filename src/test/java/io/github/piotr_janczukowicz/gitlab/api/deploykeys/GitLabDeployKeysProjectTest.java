package io.github.piotr_janczukowicz.gitlab.api.deploykeys;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDeployKeysProjectTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabDeployKeysProjectBuilder builder = GitLabDeployKeysProjectBuilder.builder(
                        DeploykeysCatalogFixtures.deployKeysProject())
                .id(null);

        final GitLabDeployKeysProject built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabDeployKeysProjectBuilder builder = GitLabDeployKeysProjectBuilder.builder(
                        DeploykeysCatalogFixtures.deployKeysProject())
                .title(null);

        final GitLabDeployKeysProject built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabDeployKeysProjectBuilder builder = GitLabDeployKeysProjectBuilder.builder(
                        DeploykeysCatalogFixtures.deployKeysProject())
                .createdAt(null);

        final GitLabDeployKeysProject built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabDeployKeysProjectBuilder builder = GitLabDeployKeysProjectBuilder.builder(
                        DeploykeysCatalogFixtures.deployKeysProject())
                .expiresAt(null);

        final GitLabDeployKeysProject built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedAtIsNullable() {
        final GitLabDeployKeysProjectBuilder builder = GitLabDeployKeysProjectBuilder.builder(
                        DeploykeysCatalogFixtures.deployKeysProject())
                .lastUsedAt(null);

        final GitLabDeployKeysProject built = builder.build();

        assertThat(built.lastUsedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabDeployKeysProjectBuilder builder = GitLabDeployKeysProjectBuilder.builder(
                        DeploykeysCatalogFixtures.deployKeysProject())
                .key(null);

        final GitLabDeployKeysProject built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsageTypeIsNullable() {
        final GitLabDeployKeysProjectBuilder builder = GitLabDeployKeysProjectBuilder.builder(
                        DeploykeysCatalogFixtures.deployKeysProject())
                .usageType(null);

        final GitLabDeployKeysProject built = builder.build();

        assertThat(built.usageType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFingerprintIsNullable() {
        final GitLabDeployKeysProjectBuilder builder = GitLabDeployKeysProjectBuilder.builder(
                        DeploykeysCatalogFixtures.deployKeysProject())
                .fingerprint(null);

        final GitLabDeployKeysProject built = builder.build();

        assertThat(built.fingerprint()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFingerprintSha256IsNullable() {
        final GitLabDeployKeysProjectBuilder builder = GitLabDeployKeysProjectBuilder.builder(
                        DeploykeysCatalogFixtures.deployKeysProject())
                .fingerprintSha256(null);

        final GitLabDeployKeysProject built = builder.build();

        assertThat(built.fingerprintSha256()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectsWithWriteAccessIsNullable() {
        final GitLabDeployKeysProjectBuilder builder = GitLabDeployKeysProjectBuilder.builder(
                        DeploykeysCatalogFixtures.deployKeysProject())
                .projectsWithWriteAccess(null);

        final GitLabDeployKeysProject built = builder.build();

        assertThat(built.projectsWithWriteAccess()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectsWithReadonlyAccessIsNullable() {
        final GitLabDeployKeysProjectBuilder builder = GitLabDeployKeysProjectBuilder.builder(
                        DeploykeysCatalogFixtures.deployKeysProject())
                .projectsWithReadonlyAccess(null);

        final GitLabDeployKeysProject built = builder.build();

        assertThat(built.projectsWithReadonlyAccess()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCanPushIsNullable() {
        final GitLabDeployKeysProjectBuilder builder = GitLabDeployKeysProjectBuilder.builder(
                        DeploykeysCatalogFixtures.deployKeysProject())
                .canPush(null);

        final GitLabDeployKeysProject built = builder.build();

        assertThat(built.canPush()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDeployKeysProject value = DeploykeysCatalogFixtures.deployKeysProject();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.title()).isEqualTo("Sample key 25");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.lastUsedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.key())
                    .isEqualTo(
                            "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAAAgQDNJAkI3Wdf0r13c8a5pEExB2YowPWCSVzfZV22pNBc1CuEbyYLHpUyaD0GwpGvFdx2aP7lMEk35k6Rz3ccBF6jRaVJyhsn5VNnW92PMpBJ/P1UebhXwsFHdQf5rTt082cSxWuk61kGWRQtk4ozt/J2DF/dIUVaLvc+z4HomT41fQ==");
            softly.assertThat(value.usageType()).isEqualTo("auth");
            softly.assertThat(value.fingerprint()).isEqualTo("4a:9d:64:15:ed:3a:e6:07:6e:89:36:b3:3b:03:05:d9");
            softly.assertThat(value.fingerprintSha256()).isEqualTo("Jrs3LD1Ji30xNLtTVf9NDCj7kkBgPBb2pjvTZ3HfIgU");
            softly.assertThat(value.projectsWithWriteAccess())
                    .isEqualTo(List.of(CommonCatalogFixtures.projectIdentity()));
            softly.assertThat(value.projectsWithReadonlyAccess())
                    .isEqualTo(List.of(CommonCatalogFixtures.projectIdentity()));
            softly.assertThat(value.canPush()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDeployKeysProject original = DeploykeysCatalogFixtures.deployKeysProject();

        final GitLabDeployKeysProject rebuilt =
                GitLabDeployKeysProjectBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDeployKeysProject.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "title",
                        "createdAt",
                        "expiresAt",
                        "lastUsedAt",
                        "key",
                        "usageType",
                        "fingerprint",
                        "fingerprintSha256",
                        "projectsWithWriteAccess",
                        "projectsWithReadonlyAccess",
                        "canPush");
    }
}
