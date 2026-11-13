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
class GitLabProjectProtectedEnvironmentCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProtectedEnvironmentCreatePayloadBuilder builder =
                GitLabProjectProtectedEnvironmentCreatePayloadBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreatePayload())
                        .name(null);

        final GitLabProjectProtectedEnvironmentCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequiredApprovalCountIsNullable() {
        final GitLabProjectProtectedEnvironmentCreatePayloadBuilder builder =
                GitLabProjectProtectedEnvironmentCreatePayloadBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreatePayload())
                        .requiredApprovalCount(null);

        final GitLabProjectProtectedEnvironmentCreatePayload built = builder.build();

        assertThat(built.requiredApprovalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeployAccessLevelsIsNullable() {
        final GitLabProjectProtectedEnvironmentCreatePayloadBuilder builder =
                GitLabProjectProtectedEnvironmentCreatePayloadBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreatePayload())
                        .deployAccessLevels(null);

        final GitLabProjectProtectedEnvironmentCreatePayload built = builder.build();

        assertThat(built.deployAccessLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalRulesIsNullable() {
        final GitLabProjectProtectedEnvironmentCreatePayloadBuilder builder =
                GitLabProjectProtectedEnvironmentCreatePayloadBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreatePayload())
                        .approvalRules(null);

        final GitLabProjectProtectedEnvironmentCreatePayload built = builder.build();

        assertThat(built.approvalRules()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProtectedEnvironmentCreatePayload value =
                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.requiredApprovalCount()).isEqualTo(1);
            softly.assertThat(value.deployAccessLevels())
                    .isEqualTo(List.of(
                            ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreateDeployAccessLevel()));
            softly.assertThat(value.approvalRules())
                    .isEqualTo(List.of(
                            ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreateApprovalRule()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProtectedEnvironmentCreatePayload original =
                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreatePayload();

        final GitLabProjectProtectedEnvironmentCreatePayload rebuilt =
                GitLabProjectProtectedEnvironmentCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenDeployAccessLevelsSourceChangesLater() {
        final List<GitLabProjectProtectedEnvironmentCreateDeployAccessLevel> source = new ArrayList<>(
                List.of(ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreateDeployAccessLevel()));
        final GitLabProjectProtectedEnvironmentCreatePayload built =
                GitLabProjectProtectedEnvironmentCreatePayloadBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreatePayload())
                        .deployAccessLevels(source)
                        .build();
        source.clear();

        assertThat(built.deployAccessLevels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenDeployAccessLevelsIsRead() {
        final GitLabProjectProtectedEnvironmentCreatePayload built =
                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreatePayload();
        final List<GitLabProjectProtectedEnvironmentCreateDeployAccessLevel> values = built.deployAccessLevels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenApprovalRulesSourceChangesLater() {
        final List<GitLabProjectProtectedEnvironmentCreateApprovalRule> source = new ArrayList<>(
                List.of(ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreateApprovalRule()));
        final GitLabProjectProtectedEnvironmentCreatePayload built =
                GitLabProjectProtectedEnvironmentCreatePayloadBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreatePayload())
                        .approvalRules(source)
                        .build();
        source.clear();

        assertThat(built.approvalRules()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenApprovalRulesIsRead() {
        final GitLabProjectProtectedEnvironmentCreatePayload built =
                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreatePayload();
        final List<GitLabProjectProtectedEnvironmentCreateApprovalRule> values = built.approvalRules();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProtectedEnvironmentCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "requiredApprovalCount", "deployAccessLevels", "approvalRules");
    }
}
