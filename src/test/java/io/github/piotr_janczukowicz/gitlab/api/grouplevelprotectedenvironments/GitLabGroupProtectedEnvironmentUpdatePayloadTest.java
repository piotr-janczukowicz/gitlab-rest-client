package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupProtectedEnvironmentUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenRequiredApprovalCountIsNullable() {
        final GitLabGroupProtectedEnvironmentUpdatePayloadBuilder builder =
                GitLabGroupProtectedEnvironmentUpdatePayloadBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentUpdatePayload())
                        .requiredApprovalCount(null);

        final GitLabGroupProtectedEnvironmentUpdatePayload built = builder.build();

        assertThat(built.requiredApprovalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeployAccessLevelsIsNullable() {
        final GitLabGroupProtectedEnvironmentUpdatePayloadBuilder builder =
                GitLabGroupProtectedEnvironmentUpdatePayloadBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentUpdatePayload())
                        .deployAccessLevels(null);

        final GitLabGroupProtectedEnvironmentUpdatePayload built = builder.build();

        assertThat(built.deployAccessLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalRulesIsNullable() {
        final GitLabGroupProtectedEnvironmentUpdatePayloadBuilder builder =
                GitLabGroupProtectedEnvironmentUpdatePayloadBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentUpdatePayload())
                        .approvalRules(null);

        final GitLabGroupProtectedEnvironmentUpdatePayload built = builder.build();

        assertThat(built.approvalRules()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupProtectedEnvironmentUpdatePayload value =
                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.requiredApprovalCount()).isEqualTo(1);
            softly.assertThat(value.deployAccessLevels())
                    .isEqualTo(List.of(
                            GrouplevelprotectedenvironmentsCatalogFixtures
                                    .groupProtectedEnvironmentUpdateDeployAccessLevel()));
            softly.assertThat(value.approvalRules())
                    .isEqualTo(List.of(
                            GrouplevelprotectedenvironmentsCatalogFixtures
                                    .groupProtectedEnvironmentUpdateApprovalRule()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupProtectedEnvironmentUpdatePayload original =
                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentUpdatePayload();

        final GitLabGroupProtectedEnvironmentUpdatePayload rebuilt =
                GitLabGroupProtectedEnvironmentUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenDeployAccessLevelsSourceChangesLater() {
        final List<GitLabGroupProtectedEnvironmentUpdateDeployAccessLevel> source = new ArrayList<>(List.of(
                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentUpdateDeployAccessLevel()));
        final GitLabGroupProtectedEnvironmentUpdatePayload built =
                GitLabGroupProtectedEnvironmentUpdatePayloadBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentUpdatePayload())
                        .deployAccessLevels(source)
                        .build();
        source.clear();

        assertThat(built.deployAccessLevels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenDeployAccessLevelsIsRead() {
        final GitLabGroupProtectedEnvironmentUpdatePayload built =
                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentUpdatePayload();
        final List<GitLabGroupProtectedEnvironmentUpdateDeployAccessLevel> values = built.deployAccessLevels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenApprovalRulesSourceChangesLater() {
        final List<GitLabGroupProtectedEnvironmentUpdateApprovalRule> source = new ArrayList<>(
                List.of(GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentUpdateApprovalRule()));
        final GitLabGroupProtectedEnvironmentUpdatePayload built =
                GitLabGroupProtectedEnvironmentUpdatePayloadBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentUpdatePayload())
                        .approvalRules(source)
                        .build();
        source.clear();

        assertThat(built.approvalRules()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenApprovalRulesIsRead() {
        final GitLabGroupProtectedEnvironmentUpdatePayload built =
                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentUpdatePayload();
        final List<GitLabGroupProtectedEnvironmentUpdateApprovalRule> values = built.approvalRules();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupProtectedEnvironmentUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("requiredApprovalCount", "deployAccessLevels", "approvalRules");
    }
}
