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
class GitLabGroupProtectedEnvironmentCreatePayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenNameIsNull() {
        final GitLabGroupProtectedEnvironmentCreatePayloadBuilder builder =
                GitLabGroupProtectedEnvironmentCreatePayloadBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentCreatePayload())
                        .name(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("name");
    }

    @Test
    void constructor_shouldAcceptNull_whenRequiredApprovalCountIsNullable() {
        final GitLabGroupProtectedEnvironmentCreatePayloadBuilder builder =
                GitLabGroupProtectedEnvironmentCreatePayloadBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentCreatePayload())
                        .requiredApprovalCount(null);

        final GitLabGroupProtectedEnvironmentCreatePayload built = builder.build();

        assertThat(built.requiredApprovalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeployAccessLevelsIsNullable() {
        final GitLabGroupProtectedEnvironmentCreatePayloadBuilder builder =
                GitLabGroupProtectedEnvironmentCreatePayloadBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentCreatePayload())
                        .deployAccessLevels(null);

        final GitLabGroupProtectedEnvironmentCreatePayload built = builder.build();

        assertThat(built.deployAccessLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalRulesIsNullable() {
        final GitLabGroupProtectedEnvironmentCreatePayloadBuilder builder =
                GitLabGroupProtectedEnvironmentCreatePayloadBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentCreatePayload())
                        .approvalRules(null);

        final GitLabGroupProtectedEnvironmentCreatePayload built = builder.build();

        assertThat(built.approvalRules()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupProtectedEnvironmentCreatePayload value =
                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo(GitLabGroupProtectedEnvironmentCreateName.PRODUCTION);
            softly.assertThat(value.requiredApprovalCount()).isEqualTo(1);
            softly.assertThat(value.deployAccessLevels())
                    .isEqualTo(List.of(
                            GrouplevelprotectedenvironmentsCatalogFixtures
                                    .groupProtectedEnvironmentCreateDeployAccessLevel()));
            softly.assertThat(value.approvalRules())
                    .isEqualTo(List.of(
                            GrouplevelprotectedenvironmentsCatalogFixtures
                                    .groupProtectedEnvironmentCreateApprovalRule()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupProtectedEnvironmentCreatePayload original =
                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentCreatePayload();

        final GitLabGroupProtectedEnvironmentCreatePayload rebuilt =
                GitLabGroupProtectedEnvironmentCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenDeployAccessLevelsSourceChangesLater() {
        final List<GitLabGroupProtectedEnvironmentCreateDeployAccessLevel> source = new ArrayList<>(List.of(
                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentCreateDeployAccessLevel()));
        final GitLabGroupProtectedEnvironmentCreatePayload built =
                GitLabGroupProtectedEnvironmentCreatePayloadBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentCreatePayload())
                        .deployAccessLevels(source)
                        .build();
        source.clear();

        assertThat(built.deployAccessLevels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenDeployAccessLevelsIsRead() {
        final GitLabGroupProtectedEnvironmentCreatePayload built =
                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentCreatePayload();
        final List<GitLabGroupProtectedEnvironmentCreateDeployAccessLevel> values = built.deployAccessLevels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenApprovalRulesSourceChangesLater() {
        final List<GitLabGroupProtectedEnvironmentCreateApprovalRule> source = new ArrayList<>(
                List.of(GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentCreateApprovalRule()));
        final GitLabGroupProtectedEnvironmentCreatePayload built =
                GitLabGroupProtectedEnvironmentCreatePayloadBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentCreatePayload())
                        .approvalRules(source)
                        .build();
        source.clear();

        assertThat(built.approvalRules()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenApprovalRulesIsRead() {
        final GitLabGroupProtectedEnvironmentCreatePayload built =
                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentCreatePayload();
        final List<GitLabGroupProtectedEnvironmentCreateApprovalRule> values = built.approvalRules();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupProtectedEnvironmentCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "requiredApprovalCount", "deployAccessLevels", "approvalRules");
    }
}
