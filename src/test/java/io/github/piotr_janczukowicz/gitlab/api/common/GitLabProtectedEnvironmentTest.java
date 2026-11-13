package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProtectedEnvironmentTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProtectedEnvironmentBuilder builder = GitLabProtectedEnvironmentBuilder.builder(
                        CommonCatalogFixtures.protectedEnvironment())
                .name(null);

        final GitLabProtectedEnvironment built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeployAccessLevelsIsNullable() {
        final GitLabProtectedEnvironmentBuilder builder = GitLabProtectedEnvironmentBuilder.builder(
                        CommonCatalogFixtures.protectedEnvironment())
                .deployAccessLevels(null);

        final GitLabProtectedEnvironment built = builder.build();

        assertThat(built.deployAccessLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequiredApprovalCountIsNullable() {
        final GitLabProtectedEnvironmentBuilder builder = GitLabProtectedEnvironmentBuilder.builder(
                        CommonCatalogFixtures.protectedEnvironment())
                .requiredApprovalCount(null);

        final GitLabProtectedEnvironment built = builder.build();

        assertThat(built.requiredApprovalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalRulesIsNullable() {
        final GitLabProtectedEnvironmentBuilder builder = GitLabProtectedEnvironmentBuilder.builder(
                        CommonCatalogFixtures.protectedEnvironment())
                .approvalRules(null);

        final GitLabProtectedEnvironment built = builder.build();

        assertThat(built.approvalRules()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProtectedEnvironment value = CommonCatalogFixtures.protectedEnvironment();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("production");
            softly.assertThat(value.deployAccessLevels())
                    .isEqualTo(CommonCatalogFixtures.protectedEnvironmentsDeployAccessLevel());
            softly.assertThat(value.requiredApprovalCount()).isEqualTo(1);
            softly.assertThat(value.approvalRules())
                    .isEqualTo(CommonCatalogFixtures.protectedEnvironmentsApprovalRule());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProtectedEnvironment original = CommonCatalogFixtures.protectedEnvironment();

        final GitLabProtectedEnvironment rebuilt =
                GitLabProtectedEnvironmentBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProtectedEnvironment.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "deployAccessLevels", "requiredApprovalCount", "approvalRules");
    }
}
