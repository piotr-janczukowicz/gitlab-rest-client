package io.github.piotr_janczukowicz.gitlab.api.resourcegroup;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiResourceGroupTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiResourceGroupBuilder builder = GitLabCiResourceGroupBuilder.builder(
                        ResourcegroupCatalogFixtures.ciResourceGroup())
                .id(null);

        final GitLabCiResourceGroup built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabCiResourceGroupBuilder builder = GitLabCiResourceGroupBuilder.builder(
                        ResourcegroupCatalogFixtures.ciResourceGroup())
                .key(null);

        final GitLabCiResourceGroup built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProcessModeIsNullable() {
        final GitLabCiResourceGroupBuilder builder = GitLabCiResourceGroupBuilder.builder(
                        ResourcegroupCatalogFixtures.ciResourceGroup())
                .processMode(null);

        final GitLabCiResourceGroup built = builder.build();

        assertThat(built.processMode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiResourceGroupBuilder builder = GitLabCiResourceGroupBuilder.builder(
                        ResourcegroupCatalogFixtures.ciResourceGroup())
                .createdAt(null);

        final GitLabCiResourceGroup built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabCiResourceGroupBuilder builder = GitLabCiResourceGroupBuilder.builder(
                        ResourcegroupCatalogFixtures.ciResourceGroup())
                .updatedAt(null);

        final GitLabCiResourceGroup built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiResourceGroup value = ResourcegroupCatalogFixtures.ciResourceGroup();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.key()).isEqualTo("production");
            softly.assertThat(value.processMode()).isEqualTo("unordered");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiResourceGroup original = ResourcegroupCatalogFixtures.ciResourceGroup();

        final GitLabCiResourceGroup rebuilt =
                GitLabCiResourceGroupBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiResourceGroup.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "key", "processMode", "createdAt", "updatedAt");
    }
}
