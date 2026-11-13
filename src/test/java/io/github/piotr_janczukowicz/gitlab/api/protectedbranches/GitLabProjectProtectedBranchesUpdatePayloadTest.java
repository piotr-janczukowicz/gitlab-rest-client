package io.github.piotr_janczukowicz.gitlab.api.protectedbranches;

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
class GitLabProjectProtectedBranchesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenAllowForcePushIsNullable() {
        final GitLabProjectProtectedBranchesUpdatePayloadBuilder builder =
                GitLabProjectProtectedBranchesUpdatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesUpdatePayload())
                        .allowForcePush(null);

        final GitLabProjectProtectedBranchesUpdatePayload built = builder.build();

        assertThat(built.allowForcePush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedToPushIsNullable() {
        final GitLabProjectProtectedBranchesUpdatePayloadBuilder builder =
                GitLabProjectProtectedBranchesUpdatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesUpdatePayload())
                        .allowedToPush(null);

        final GitLabProjectProtectedBranchesUpdatePayload built = builder.build();

        assertThat(built.allowedToPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUnprotectAccessLevelIsNullable() {
        final GitLabProjectProtectedBranchesUpdatePayloadBuilder builder =
                GitLabProjectProtectedBranchesUpdatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesUpdatePayload())
                        .unprotectAccessLevel(null);

        final GitLabProjectProtectedBranchesUpdatePayload built = builder.build();

        assertThat(built.unprotectAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedToMergeIsNullable() {
        final GitLabProjectProtectedBranchesUpdatePayloadBuilder builder =
                GitLabProjectProtectedBranchesUpdatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesUpdatePayload())
                        .allowedToMerge(null);

        final GitLabProjectProtectedBranchesUpdatePayload built = builder.build();

        assertThat(built.allowedToMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedToUnprotectIsNullable() {
        final GitLabProjectProtectedBranchesUpdatePayloadBuilder builder =
                GitLabProjectProtectedBranchesUpdatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesUpdatePayload())
                        .allowedToUnprotect(null);

        final GitLabProjectProtectedBranchesUpdatePayload built = builder.build();

        assertThat(built.allowedToUnprotect()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCodeOwnerApprovalRequiredIsNullable() {
        final GitLabProjectProtectedBranchesUpdatePayloadBuilder builder =
                GitLabProjectProtectedBranchesUpdatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesUpdatePayload())
                        .codeOwnerApprovalRequired(null);

        final GitLabProjectProtectedBranchesUpdatePayload built = builder.build();

        assertThat(built.codeOwnerApprovalRequired()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProtectedBranchesUpdatePayload value =
                ProtectedbranchesCatalogFixtures.projectProtectedBranchesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.allowForcePush()).isEqualTo(true);
            softly.assertThat(value.allowedToPush()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.unprotectAccessLevel())
                    .isEqualTo(GitLabProjectProtectedBranchesUpdateUnprotectAccessLevel.DEVELOPER);
            softly.assertThat(value.allowedToMerge()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.allowedToUnprotect()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.codeOwnerApprovalRequired()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProtectedBranchesUpdatePayload original =
                ProtectedbranchesCatalogFixtures.projectProtectedBranchesUpdatePayload();

        final GitLabProjectProtectedBranchesUpdatePayload rebuilt =
                GitLabProjectProtectedBranchesUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenAllowedToPushSourceChangesLater() {
        final List<Map<String, Object>> source = new ArrayList<>(List.of(Map.of("key", "value")));
        final GitLabProjectProtectedBranchesUpdatePayload built =
                GitLabProjectProtectedBranchesUpdatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesUpdatePayload())
                        .allowedToPush(source)
                        .build();
        source.clear();

        assertThat(built.allowedToPush()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAllowedToPushIsRead() {
        final GitLabProjectProtectedBranchesUpdatePayload built =
                ProtectedbranchesCatalogFixtures.projectProtectedBranchesUpdatePayload();
        final List<Map<String, Object>> values = built.allowedToPush();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenAllowedToMergeSourceChangesLater() {
        final List<Map<String, Object>> source = new ArrayList<>(List.of(Map.of("key", "value")));
        final GitLabProjectProtectedBranchesUpdatePayload built =
                GitLabProjectProtectedBranchesUpdatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesUpdatePayload())
                        .allowedToMerge(source)
                        .build();
        source.clear();

        assertThat(built.allowedToMerge()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAllowedToMergeIsRead() {
        final GitLabProjectProtectedBranchesUpdatePayload built =
                ProtectedbranchesCatalogFixtures.projectProtectedBranchesUpdatePayload();
        final List<Map<String, Object>> values = built.allowedToMerge();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenAllowedToUnprotectSourceChangesLater() {
        final List<Map<String, Object>> source = new ArrayList<>(List.of(Map.of("key", "value")));
        final GitLabProjectProtectedBranchesUpdatePayload built =
                GitLabProjectProtectedBranchesUpdatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesUpdatePayload())
                        .allowedToUnprotect(source)
                        .build();
        source.clear();

        assertThat(built.allowedToUnprotect()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAllowedToUnprotectIsRead() {
        final GitLabProjectProtectedBranchesUpdatePayload built =
                ProtectedbranchesCatalogFixtures.projectProtectedBranchesUpdatePayload();
        final List<Map<String, Object>> values = built.allowedToUnprotect();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProtectedBranchesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "allowForcePush",
                        "allowedToPush",
                        "unprotectAccessLevel",
                        "allowedToMerge",
                        "allowedToUnprotect",
                        "codeOwnerApprovalRequired");
    }
}
