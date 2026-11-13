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
class GitLabProjectProtectedBranchesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProtectedBranchesCreatePayloadBuilder builder =
                GitLabProjectProtectedBranchesCreatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesCreatePayload())
                        .name(null);

        final GitLabProjectProtectedBranchesCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushAccessLevelIsNullable() {
        final GitLabProjectProtectedBranchesCreatePayloadBuilder builder =
                GitLabProjectProtectedBranchesCreatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesCreatePayload())
                        .pushAccessLevel(null);

        final GitLabProjectProtectedBranchesCreatePayload built = builder.build();

        assertThat(built.pushAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeAccessLevelIsNullable() {
        final GitLabProjectProtectedBranchesCreatePayloadBuilder builder =
                GitLabProjectProtectedBranchesCreatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesCreatePayload())
                        .mergeAccessLevel(null);

        final GitLabProjectProtectedBranchesCreatePayload built = builder.build();

        assertThat(built.mergeAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowForcePushIsNullable() {
        final GitLabProjectProtectedBranchesCreatePayloadBuilder builder =
                GitLabProjectProtectedBranchesCreatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesCreatePayload())
                        .allowForcePush(null);

        final GitLabProjectProtectedBranchesCreatePayload built = builder.build();

        assertThat(built.allowForcePush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedToPushIsNullable() {
        final GitLabProjectProtectedBranchesCreatePayloadBuilder builder =
                GitLabProjectProtectedBranchesCreatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesCreatePayload())
                        .allowedToPush(null);

        final GitLabProjectProtectedBranchesCreatePayload built = builder.build();

        assertThat(built.allowedToPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUnprotectAccessLevelIsNullable() {
        final GitLabProjectProtectedBranchesCreatePayloadBuilder builder =
                GitLabProjectProtectedBranchesCreatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesCreatePayload())
                        .unprotectAccessLevel(null);

        final GitLabProjectProtectedBranchesCreatePayload built = builder.build();

        assertThat(built.unprotectAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedToMergeIsNullable() {
        final GitLabProjectProtectedBranchesCreatePayloadBuilder builder =
                GitLabProjectProtectedBranchesCreatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesCreatePayload())
                        .allowedToMerge(null);

        final GitLabProjectProtectedBranchesCreatePayload built = builder.build();

        assertThat(built.allowedToMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedToUnprotectIsNullable() {
        final GitLabProjectProtectedBranchesCreatePayloadBuilder builder =
                GitLabProjectProtectedBranchesCreatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesCreatePayload())
                        .allowedToUnprotect(null);

        final GitLabProjectProtectedBranchesCreatePayload built = builder.build();

        assertThat(built.allowedToUnprotect()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCodeOwnerApprovalRequiredIsNullable() {
        final GitLabProjectProtectedBranchesCreatePayloadBuilder builder =
                GitLabProjectProtectedBranchesCreatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesCreatePayload())
                        .codeOwnerApprovalRequired(null);

        final GitLabProjectProtectedBranchesCreatePayload built = builder.build();

        assertThat(built.codeOwnerApprovalRequired()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProtectedBranchesCreatePayload value =
                ProtectedbranchesCatalogFixtures.projectProtectedBranchesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("main");
            softly.assertThat(value.pushAccessLevel())
                    .isEqualTo(GitLabProjectProtectedBranchesCreatePushAccessLevel.DEVELOPER);
            softly.assertThat(value.mergeAccessLevel())
                    .isEqualTo(GitLabProjectProtectedBranchesCreateMergeAccessLevel.DEVELOPER);
            softly.assertThat(value.allowForcePush()).isEqualTo(true);
            softly.assertThat(value.allowedToPush()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.unprotectAccessLevel())
                    .isEqualTo(GitLabProjectProtectedBranchesCreateUnprotectAccessLevel.DEVELOPER);
            softly.assertThat(value.allowedToMerge()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.allowedToUnprotect()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.codeOwnerApprovalRequired()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProtectedBranchesCreatePayload original =
                ProtectedbranchesCatalogFixtures.projectProtectedBranchesCreatePayload();

        final GitLabProjectProtectedBranchesCreatePayload rebuilt =
                GitLabProjectProtectedBranchesCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenAllowedToPushSourceChangesLater() {
        final List<Map<String, Object>> source = new ArrayList<>(List.of(Map.of("key", "value")));
        final GitLabProjectProtectedBranchesCreatePayload built =
                GitLabProjectProtectedBranchesCreatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesCreatePayload())
                        .allowedToPush(source)
                        .build();
        source.clear();

        assertThat(built.allowedToPush()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAllowedToPushIsRead() {
        final GitLabProjectProtectedBranchesCreatePayload built =
                ProtectedbranchesCatalogFixtures.projectProtectedBranchesCreatePayload();
        final List<Map<String, Object>> values = built.allowedToPush();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenAllowedToMergeSourceChangesLater() {
        final List<Map<String, Object>> source = new ArrayList<>(List.of(Map.of("key", "value")));
        final GitLabProjectProtectedBranchesCreatePayload built =
                GitLabProjectProtectedBranchesCreatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesCreatePayload())
                        .allowedToMerge(source)
                        .build();
        source.clear();

        assertThat(built.allowedToMerge()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAllowedToMergeIsRead() {
        final GitLabProjectProtectedBranchesCreatePayload built =
                ProtectedbranchesCatalogFixtures.projectProtectedBranchesCreatePayload();
        final List<Map<String, Object>> values = built.allowedToMerge();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenAllowedToUnprotectSourceChangesLater() {
        final List<Map<String, Object>> source = new ArrayList<>(List.of(Map.of("key", "value")));
        final GitLabProjectProtectedBranchesCreatePayload built =
                GitLabProjectProtectedBranchesCreatePayloadBuilder.builder(
                                ProtectedbranchesCatalogFixtures.projectProtectedBranchesCreatePayload())
                        .allowedToUnprotect(source)
                        .build();
        source.clear();

        assertThat(built.allowedToUnprotect()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAllowedToUnprotectIsRead() {
        final GitLabProjectProtectedBranchesCreatePayload built =
                ProtectedbranchesCatalogFixtures.projectProtectedBranchesCreatePayload();
        final List<Map<String, Object>> values = built.allowedToUnprotect();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProtectedBranchesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name",
                        "pushAccessLevel",
                        "mergeAccessLevel",
                        "allowForcePush",
                        "allowedToPush",
                        "unprotectAccessLevel",
                        "allowedToMerge",
                        "allowedToUnprotect",
                        "codeOwnerApprovalRequired");
    }
}
