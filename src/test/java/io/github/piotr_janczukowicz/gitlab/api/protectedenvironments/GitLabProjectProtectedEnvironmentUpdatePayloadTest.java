package io.github.piotr_janczukowicz.gitlab.api.protectedenvironments;

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
class GitLabProjectProtectedEnvironmentUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenRequiredApprovalCountIsNullable() {
        final GitLabProjectProtectedEnvironmentUpdatePayloadBuilder builder =
                GitLabProjectProtectedEnvironmentUpdatePayloadBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdatePayload())
                        .requiredApprovalCount(null);

        final GitLabProjectProtectedEnvironmentUpdatePayload built = builder.build();

        assertThat(built.requiredApprovalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeployAccessLevelsIsNullable() {
        final GitLabProjectProtectedEnvironmentUpdatePayloadBuilder builder =
                GitLabProjectProtectedEnvironmentUpdatePayloadBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdatePayload())
                        .deployAccessLevels(null);

        final GitLabProjectProtectedEnvironmentUpdatePayload built = builder.build();

        assertThat(built.deployAccessLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalRulesIsNullable() {
        final GitLabProjectProtectedEnvironmentUpdatePayloadBuilder builder =
                GitLabProjectProtectedEnvironmentUpdatePayloadBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdatePayload())
                        .approvalRules(null);

        final GitLabProjectProtectedEnvironmentUpdatePayload built = builder.build();

        assertThat(built.approvalRules()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProtectedEnvironmentUpdatePayload value =
                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.requiredApprovalCount()).isEqualTo(1);
            softly.assertThat(value.deployAccessLevels())
                    .isEqualTo(List.of(
                            ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdateDeployAccessLevel()));
            softly.assertThat(value.approvalRules())
                    .isEqualTo(List.of(
                            ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdateApprovalRule()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProtectedEnvironmentUpdatePayload original =
                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdatePayload();

        final GitLabProjectProtectedEnvironmentUpdatePayload rebuilt =
                GitLabProjectProtectedEnvironmentUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenDeployAccessLevelsSourceChangesLater() {
        final List<GitLabProjectProtectedEnvironmentUpdateDeployAccessLevel> source = new ArrayList<>(
                List.of(ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdateDeployAccessLevel()));
        final GitLabProjectProtectedEnvironmentUpdatePayload built =
                GitLabProjectProtectedEnvironmentUpdatePayloadBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdatePayload())
                        .deployAccessLevels(source)
                        .build();
        source.clear();

        assertThat(built.deployAccessLevels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenDeployAccessLevelsIsRead() {
        final GitLabProjectProtectedEnvironmentUpdatePayload built =
                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdatePayload();
        final List<GitLabProjectProtectedEnvironmentUpdateDeployAccessLevel> values = built.deployAccessLevels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenApprovalRulesSourceChangesLater() {
        final List<GitLabProjectProtectedEnvironmentUpdateApprovalRule> source = new ArrayList<>(
                List.of(ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdateApprovalRule()));
        final GitLabProjectProtectedEnvironmentUpdatePayload built =
                GitLabProjectProtectedEnvironmentUpdatePayloadBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdatePayload())
                        .approvalRules(source)
                        .build();
        source.clear();

        assertThat(built.approvalRules()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenApprovalRulesIsRead() {
        final GitLabProjectProtectedEnvironmentUpdatePayload built =
                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdatePayload();
        final List<GitLabProjectProtectedEnvironmentUpdateApprovalRule> values = built.approvalRules();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProtectedEnvironmentUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("requiredApprovalCount", "deployAccessLevels", "approvalRules");
    }
}
