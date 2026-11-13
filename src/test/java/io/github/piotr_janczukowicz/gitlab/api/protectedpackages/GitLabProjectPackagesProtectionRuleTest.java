package io.github.piotr_janczukowicz.gitlab.api.protectedpackages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPackagesProtectionRuleTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectPackagesProtectionRuleBuilder builder = GitLabProjectPackagesProtectionRuleBuilder.builder(
                        ProtectedpackagesCatalogFixtures.projectPackagesProtectionRule())
                .id(null);

        final GitLabProjectPackagesProtectionRule built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabProjectPackagesProtectionRuleBuilder builder = GitLabProjectPackagesProtectionRuleBuilder.builder(
                        ProtectedpackagesCatalogFixtures.projectPackagesProtectionRule())
                .projectId(null);

        final GitLabProjectPackagesProtectionRule built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageNamePatternIsNullable() {
        final GitLabProjectPackagesProtectionRuleBuilder builder = GitLabProjectPackagesProtectionRuleBuilder.builder(
                        ProtectedpackagesCatalogFixtures.projectPackagesProtectionRule())
                .packageNamePattern(null);

        final GitLabProjectPackagesProtectionRule built = builder.build();

        assertThat(built.packageNamePattern()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageTypeIsNullable() {
        final GitLabProjectPackagesProtectionRuleBuilder builder = GitLabProjectPackagesProtectionRuleBuilder.builder(
                        ProtectedpackagesCatalogFixtures.projectPackagesProtectionRule())
                .packageType(null);

        final GitLabProjectPackagesProtectionRule built = builder.build();

        assertThat(built.packageType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelForDeleteIsNullable() {
        final GitLabProjectPackagesProtectionRuleBuilder builder = GitLabProjectPackagesProtectionRuleBuilder.builder(
                        ProtectedpackagesCatalogFixtures.projectPackagesProtectionRule())
                .minimumAccessLevelForDelete(null);

        final GitLabProjectPackagesProtectionRule built = builder.build();

        assertThat(built.minimumAccessLevelForDelete()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelForPushIsNullable() {
        final GitLabProjectPackagesProtectionRuleBuilder builder = GitLabProjectPackagesProtectionRuleBuilder.builder(
                        ProtectedpackagesCatalogFixtures.projectPackagesProtectionRule())
                .minimumAccessLevelForPush(null);

        final GitLabProjectPackagesProtectionRule built = builder.build();

        assertThat(built.minimumAccessLevelForPush()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPackagesProtectionRule value =
                ProtectedpackagesCatalogFixtures.projectPackagesProtectionRule();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.packageNamePattern()).isEqualTo("flightjs/flight");
            softly.assertThat(value.packageType()).isEqualTo("npm");
            softly.assertThat(value.minimumAccessLevelForDelete()).isEqualTo("owner");
            softly.assertThat(value.minimumAccessLevelForPush()).isEqualTo("maintainer");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPackagesProtectionRule original =
                ProtectedpackagesCatalogFixtures.projectPackagesProtectionRule();

        final GitLabProjectPackagesProtectionRule rebuilt =
                GitLabProjectPackagesProtectionRuleBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPackagesProtectionRule.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "projectId",
                        "packageNamePattern",
                        "packageType",
                        "minimumAccessLevelForDelete",
                        "minimumAccessLevelForPush");
    }
}
