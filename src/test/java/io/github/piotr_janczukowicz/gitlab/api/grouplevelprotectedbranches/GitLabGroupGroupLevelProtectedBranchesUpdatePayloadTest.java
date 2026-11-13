package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedbranches;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupLevelProtectedBranchesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenAllowForcePushIsNullable() {
        final GitLabGroupGroupLevelProtectedBranchesUpdatePayloadBuilder builder =
                GitLabGroupGroupLevelProtectedBranchesUpdatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesUpdatePayload())
                        .allowForcePush(null);

        final GitLabGroupGroupLevelProtectedBranchesUpdatePayload built = builder.build();

        assertThat(built.allowForcePush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUnprotectAccessLevelIsNullable() {
        final GitLabGroupGroupLevelProtectedBranchesUpdatePayloadBuilder builder =
                GitLabGroupGroupLevelProtectedBranchesUpdatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesUpdatePayload())
                        .unprotectAccessLevel(null);

        final GitLabGroupGroupLevelProtectedBranchesUpdatePayload built = builder.build();

        assertThat(built.unprotectAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedToPushIsNullable() {
        final GitLabGroupGroupLevelProtectedBranchesUpdatePayloadBuilder builder =
                GitLabGroupGroupLevelProtectedBranchesUpdatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesUpdatePayload())
                        .allowedToPush(null);

        final GitLabGroupGroupLevelProtectedBranchesUpdatePayload built = builder.build();

        assertThat(built.allowedToPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedToMergeIsNullable() {
        final GitLabGroupGroupLevelProtectedBranchesUpdatePayloadBuilder builder =
                GitLabGroupGroupLevelProtectedBranchesUpdatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesUpdatePayload())
                        .allowedToMerge(null);

        final GitLabGroupGroupLevelProtectedBranchesUpdatePayload built = builder.build();

        assertThat(built.allowedToMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedToUnprotectIsNullable() {
        final GitLabGroupGroupLevelProtectedBranchesUpdatePayloadBuilder builder =
                GitLabGroupGroupLevelProtectedBranchesUpdatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesUpdatePayload())
                        .allowedToUnprotect(null);

        final GitLabGroupGroupLevelProtectedBranchesUpdatePayload built = builder.build();

        assertThat(built.allowedToUnprotect()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCodeOwnerApprovalRequiredIsNullable() {
        final GitLabGroupGroupLevelProtectedBranchesUpdatePayloadBuilder builder =
                GitLabGroupGroupLevelProtectedBranchesUpdatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesUpdatePayload())
                        .codeOwnerApprovalRequired(null);

        final GitLabGroupGroupLevelProtectedBranchesUpdatePayload built = builder.build();

        assertThat(built.codeOwnerApprovalRequired()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupLevelProtectedBranchesUpdatePayload value =
                GrouplevelprotectedbranchesCatalogFixtures.groupGroupLevelProtectedBranchesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.allowForcePush()).isEqualTo(true);
            softly.assertThat(value.unprotectAccessLevel())
                    .isEqualTo(GitLabGroupGroupLevelProtectedBranchesUpdateUnprotectAccessLevel.DEVELOPER);
            softly.assertThat(value.allowedToPush()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.allowedToMerge()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.allowedToUnprotect()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.codeOwnerApprovalRequired()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupLevelProtectedBranchesUpdatePayload original =
                GrouplevelprotectedbranchesCatalogFixtures.groupGroupLevelProtectedBranchesUpdatePayload();

        final GitLabGroupGroupLevelProtectedBranchesUpdatePayload rebuilt =
                GitLabGroupGroupLevelProtectedBranchesUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenAllowedToPushSourceChangesLater() {
        final List<Map<String, Object>> source = new ArrayList<>(List.of(Map.of("key", "value")));
        final GitLabGroupGroupLevelProtectedBranchesUpdatePayload built =
                GitLabGroupGroupLevelProtectedBranchesUpdatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesUpdatePayload())
                        .allowedToPush(source)
                        .build();
        source.clear();

        assertThat(built.allowedToPush()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAllowedToPushIsRead() {
        final GitLabGroupGroupLevelProtectedBranchesUpdatePayload built =
                GrouplevelprotectedbranchesCatalogFixtures.groupGroupLevelProtectedBranchesUpdatePayload();
        final List<Map<String, Object>> values = built.allowedToPush();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenAllowedToMergeSourceChangesLater() {
        final List<Map<String, Object>> source = new ArrayList<>(List.of(Map.of("key", "value")));
        final GitLabGroupGroupLevelProtectedBranchesUpdatePayload built =
                GitLabGroupGroupLevelProtectedBranchesUpdatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesUpdatePayload())
                        .allowedToMerge(source)
                        .build();
        source.clear();

        assertThat(built.allowedToMerge()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAllowedToMergeIsRead() {
        final GitLabGroupGroupLevelProtectedBranchesUpdatePayload built =
                GrouplevelprotectedbranchesCatalogFixtures.groupGroupLevelProtectedBranchesUpdatePayload();
        final List<Map<String, Object>> values = built.allowedToMerge();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenAllowedToUnprotectSourceChangesLater() {
        final List<Map<String, Object>> source = new ArrayList<>(List.of(Map.of("key", "value")));
        final GitLabGroupGroupLevelProtectedBranchesUpdatePayload built =
                GitLabGroupGroupLevelProtectedBranchesUpdatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesUpdatePayload())
                        .allowedToUnprotect(source)
                        .build();
        source.clear();

        assertThat(built.allowedToUnprotect()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAllowedToUnprotectIsRead() {
        final GitLabGroupGroupLevelProtectedBranchesUpdatePayload built =
                GrouplevelprotectedbranchesCatalogFixtures.groupGroupLevelProtectedBranchesUpdatePayload();
        final List<Map<String, Object>> values = built.allowedToUnprotect();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupLevelProtectedBranchesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "allowForcePush",
                        "unprotectAccessLevel",
                        "allowedToPush",
                        "allowedToMerge",
                        "allowedToUnprotect",
                        "codeOwnerApprovalRequired");
    }
}
