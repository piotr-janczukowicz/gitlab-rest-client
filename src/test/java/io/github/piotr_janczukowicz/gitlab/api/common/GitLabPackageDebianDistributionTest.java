package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPackageDebianDistributionTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabPackageDebianDistributionBuilder builder = GitLabPackageDebianDistributionBuilder.builder(
                        CommonCatalogFixtures.packageDebianDistribution())
                .id(null);

        final GitLabPackageDebianDistribution built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCodenameIsNullable() {
        final GitLabPackageDebianDistributionBuilder builder = GitLabPackageDebianDistributionBuilder.builder(
                        CommonCatalogFixtures.packageDebianDistribution())
                .codename(null);

        final GitLabPackageDebianDistribution built = builder.build();

        assertThat(built.codename()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuiteIsNullable() {
        final GitLabPackageDebianDistributionBuilder builder = GitLabPackageDebianDistributionBuilder.builder(
                        CommonCatalogFixtures.packageDebianDistribution())
                .suite(null);

        final GitLabPackageDebianDistribution built = builder.build();

        assertThat(built.suite()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOriginIsNullable() {
        final GitLabPackageDebianDistributionBuilder builder = GitLabPackageDebianDistributionBuilder.builder(
                        CommonCatalogFixtures.packageDebianDistribution())
                .origin(null);

        final GitLabPackageDebianDistribution built = builder.build();

        assertThat(built.origin()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelIsNullable() {
        final GitLabPackageDebianDistributionBuilder builder = GitLabPackageDebianDistributionBuilder.builder(
                        CommonCatalogFixtures.packageDebianDistribution())
                .label(null);

        final GitLabPackageDebianDistribution built = builder.build();

        assertThat(built.label()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabPackageDebianDistributionBuilder builder = GitLabPackageDebianDistributionBuilder.builder(
                        CommonCatalogFixtures.packageDebianDistribution())
                .version(null);

        final GitLabPackageDebianDistribution built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabPackageDebianDistributionBuilder builder = GitLabPackageDebianDistributionBuilder.builder(
                        CommonCatalogFixtures.packageDebianDistribution())
                .description(null);

        final GitLabPackageDebianDistribution built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValidTimeDurationSecondsIsNullable() {
        final GitLabPackageDebianDistributionBuilder builder = GitLabPackageDebianDistributionBuilder.builder(
                        CommonCatalogFixtures.packageDebianDistribution())
                .validTimeDurationSeconds(null);

        final GitLabPackageDebianDistribution built = builder.build();

        assertThat(built.validTimeDurationSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenComponentsIsNullable() {
        final GitLabPackageDebianDistributionBuilder builder = GitLabPackageDebianDistributionBuilder.builder(
                        CommonCatalogFixtures.packageDebianDistribution())
                .components(null);

        final GitLabPackageDebianDistribution built = builder.build();

        assertThat(built.components()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchitecturesIsNullable() {
        final GitLabPackageDebianDistributionBuilder builder = GitLabPackageDebianDistributionBuilder.builder(
                        CommonCatalogFixtures.packageDebianDistribution())
                .architectures(null);

        final GitLabPackageDebianDistribution built = builder.build();

        assertThat(built.architectures()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPackageDebianDistribution value = CommonCatalogFixtures.packageDebianDistribution();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.codename()).isEqualTo("sid");
            softly.assertThat(value.suite()).isEqualTo("unstable");
            softly.assertThat(value.origin()).isEqualTo("Grep");
            softly.assertThat(value.label()).isEqualTo("grep.be");
            softly.assertThat(value.version()).isEqualTo("12");
            softly.assertThat(value.description()).isEqualTo("My description");
            softly.assertThat(value.validTimeDurationSeconds()).isEqualTo(1);
            softly.assertThat(value.components()).isEqualTo(List.of("main"));
            softly.assertThat(value.architectures()).isEqualTo(List.of("amd64"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPackageDebianDistribution original = CommonCatalogFixtures.packageDebianDistribution();

        final GitLabPackageDebianDistribution rebuilt =
                GitLabPackageDebianDistributionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPackageDebianDistribution.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "codename",
                        "suite",
                        "origin",
                        "label",
                        "version",
                        "description",
                        "validTimeDurationSeconds",
                        "components",
                        "architectures");
    }
}
