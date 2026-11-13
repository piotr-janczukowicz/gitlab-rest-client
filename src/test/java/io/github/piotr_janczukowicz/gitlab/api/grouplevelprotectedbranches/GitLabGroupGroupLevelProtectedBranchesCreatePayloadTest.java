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
class GitLabGroupGroupLevelProtectedBranchesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder builder =
                GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesCreatePayload())
                        .name(null);

        final GitLabGroupGroupLevelProtectedBranchesCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushAccessLevelIsNullable() {
        final GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder builder =
                GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesCreatePayload())
                        .pushAccessLevel(null);

        final GitLabGroupGroupLevelProtectedBranchesCreatePayload built = builder.build();

        assertThat(built.pushAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeAccessLevelIsNullable() {
        final GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder builder =
                GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesCreatePayload())
                        .mergeAccessLevel(null);

        final GitLabGroupGroupLevelProtectedBranchesCreatePayload built = builder.build();

        assertThat(built.mergeAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowForcePushIsNullable() {
        final GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder builder =
                GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesCreatePayload())
                        .allowForcePush(null);

        final GitLabGroupGroupLevelProtectedBranchesCreatePayload built = builder.build();

        assertThat(built.allowForcePush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUnprotectAccessLevelIsNullable() {
        final GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder builder =
                GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesCreatePayload())
                        .unprotectAccessLevel(null);

        final GitLabGroupGroupLevelProtectedBranchesCreatePayload built = builder.build();

        assertThat(built.unprotectAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedToPushIsNullable() {
        final GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder builder =
                GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesCreatePayload())
                        .allowedToPush(null);

        final GitLabGroupGroupLevelProtectedBranchesCreatePayload built = builder.build();

        assertThat(built.allowedToPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedToMergeIsNullable() {
        final GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder builder =
                GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesCreatePayload())
                        .allowedToMerge(null);

        final GitLabGroupGroupLevelProtectedBranchesCreatePayload built = builder.build();

        assertThat(built.allowedToMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedToUnprotectIsNullable() {
        final GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder builder =
                GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesCreatePayload())
                        .allowedToUnprotect(null);

        final GitLabGroupGroupLevelProtectedBranchesCreatePayload built = builder.build();

        assertThat(built.allowedToUnprotect()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCodeOwnerApprovalRequiredIsNullable() {
        final GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder builder =
                GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesCreatePayload())
                        .codeOwnerApprovalRequired(null);

        final GitLabGroupGroupLevelProtectedBranchesCreatePayload built = builder.build();

        assertThat(built.codeOwnerApprovalRequired()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupLevelProtectedBranchesCreatePayload value =
                GrouplevelprotectedbranchesCatalogFixtures.groupGroupLevelProtectedBranchesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("main");
            softly.assertThat(value.pushAccessLevel())
                    .isEqualTo(GitLabGroupGroupLevelProtectedBranchesCreatePushAccessLevel.DEVELOPER);
            softly.assertThat(value.mergeAccessLevel())
                    .isEqualTo(GitLabGroupGroupLevelProtectedBranchesCreateMergeAccessLevel.DEVELOPER);
            softly.assertThat(value.allowForcePush()).isEqualTo(true);
            softly.assertThat(value.unprotectAccessLevel())
                    .isEqualTo(GitLabGroupGroupLevelProtectedBranchesCreateUnprotectAccessLevel.DEVELOPER);
            softly.assertThat(value.allowedToPush()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.allowedToMerge()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.allowedToUnprotect()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.codeOwnerApprovalRequired()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupLevelProtectedBranchesCreatePayload original =
                GrouplevelprotectedbranchesCatalogFixtures.groupGroupLevelProtectedBranchesCreatePayload();

        final GitLabGroupGroupLevelProtectedBranchesCreatePayload rebuilt =
                GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenAllowedToPushSourceChangesLater() {
        final List<Map<String, Object>> source = new ArrayList<>(List.of(Map.of("key", "value")));
        final GitLabGroupGroupLevelProtectedBranchesCreatePayload built =
                GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesCreatePayload())
                        .allowedToPush(source)
                        .build();
        source.clear();

        assertThat(built.allowedToPush()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAllowedToPushIsRead() {
        final GitLabGroupGroupLevelProtectedBranchesCreatePayload built =
                GrouplevelprotectedbranchesCatalogFixtures.groupGroupLevelProtectedBranchesCreatePayload();
        final List<Map<String, Object>> values = built.allowedToPush();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenAllowedToMergeSourceChangesLater() {
        final List<Map<String, Object>> source = new ArrayList<>(List.of(Map.of("key", "value")));
        final GitLabGroupGroupLevelProtectedBranchesCreatePayload built =
                GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesCreatePayload())
                        .allowedToMerge(source)
                        .build();
        source.clear();

        assertThat(built.allowedToMerge()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAllowedToMergeIsRead() {
        final GitLabGroupGroupLevelProtectedBranchesCreatePayload built =
                GrouplevelprotectedbranchesCatalogFixtures.groupGroupLevelProtectedBranchesCreatePayload();
        final List<Map<String, Object>> values = built.allowedToMerge();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenAllowedToUnprotectSourceChangesLater() {
        final List<Map<String, Object>> source = new ArrayList<>(List.of(Map.of("key", "value")));
        final GitLabGroupGroupLevelProtectedBranchesCreatePayload built =
                GitLabGroupGroupLevelProtectedBranchesCreatePayloadBuilder.builder(
                                GrouplevelprotectedbranchesCatalogFixtures
                                        .groupGroupLevelProtectedBranchesCreatePayload())
                        .allowedToUnprotect(source)
                        .build();
        source.clear();

        assertThat(built.allowedToUnprotect()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAllowedToUnprotectIsRead() {
        final GitLabGroupGroupLevelProtectedBranchesCreatePayload built =
                GrouplevelprotectedbranchesCatalogFixtures.groupGroupLevelProtectedBranchesCreatePayload();
        final List<Map<String, Object>> values = built.allowedToUnprotect();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupLevelProtectedBranchesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name",
                        "pushAccessLevel",
                        "mergeAccessLevel",
                        "allowForcePush",
                        "unprotectAccessLevel",
                        "allowedToPush",
                        "allowedToMerge",
                        "allowedToUnprotect",
                        "codeOwnerApprovalRequired");
    }
}
