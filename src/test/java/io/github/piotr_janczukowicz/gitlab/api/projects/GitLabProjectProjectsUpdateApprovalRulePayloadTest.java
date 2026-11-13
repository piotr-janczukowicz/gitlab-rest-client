package io.github.piotr_janczukowicz.gitlab.api.projects;

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
class GitLabProjectProjectsUpdateApprovalRulePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProjectsUpdateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .name(null);

        final GitLabProjectProjectsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsRequiredIsNullable() {
        final GitLabProjectProjectsUpdateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .approvalsRequired(null);

        final GitLabProjectProjectsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.approvalsRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersIsNullable() {
        final GitLabProjectProjectsUpdateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .users(null);

        final GitLabProjectProjectsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.users()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdsIsNullable() {
        final GitLabProjectProjectsUpdateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .userIds(null);

        final GitLabProjectProjectsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.userIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupsIsNullable() {
        final GitLabProjectProjectsUpdateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .groups(null);

        final GitLabProjectProjectsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.groups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdsIsNullable() {
        final GitLabProjectProjectsUpdateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .groupIds(null);

        final GitLabProjectProjectsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.groupIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernamesIsNullable() {
        final GitLabProjectProjectsUpdateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .usernames(null);

        final GitLabProjectProjectsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.usernames()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedBranchIdsIsNullable() {
        final GitLabProjectProjectsUpdateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .protectedBranchIds(null);

        final GitLabProjectProjectsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.protectedBranchIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppliesToAllProtectedBranchesIsNullable() {
        final GitLabProjectProjectsUpdateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .appliesToAllProtectedBranches(null);

        final GitLabProjectProjectsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.appliesToAllProtectedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveHiddenGroupsIsNullable() {
        final GitLabProjectProjectsUpdateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .removeHiddenGroups(null);

        final GitLabProjectProjectsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.removeHiddenGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCoverageMinimumThresholdIsNullable() {
        final GitLabProjectProjectsUpdateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .coverageMinimumThreshold(null);

        final GitLabProjectProjectsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.coverageMinimumThreshold()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilitiesAllowedIsNullable() {
        final GitLabProjectProjectsUpdateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .vulnerabilitiesAllowed(null);

        final GitLabProjectProjectsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.vulnerabilitiesAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScannersIsNullable() {
        final GitLabProjectProjectsUpdateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .scanners(null);

        final GitLabProjectProjectsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.scanners()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSeverityLevelsIsNullable() {
        final GitLabProjectProjectsUpdateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .severityLevels(null);

        final GitLabProjectProjectsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.severityLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityStatesIsNullable() {
        final GitLabProjectProjectsUpdateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .vulnerabilityStates(null);

        final GitLabProjectProjectsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.vulnerabilityStates()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsUpdateApprovalRulePayload value =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.approvalsRequired()).isEqualTo(1);
            softly.assertThat(value.users()).isEqualTo(List.of(1));
            softly.assertThat(value.userIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.groups()).isEqualTo(List.of(1));
            softly.assertThat(value.groupIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.usernames()).isEqualTo(List.of("usernames"));
            softly.assertThat(value.protectedBranchIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.appliesToAllProtectedBranches()).isEqualTo(true);
            softly.assertThat(value.removeHiddenGroups()).isEqualTo(true);
            softly.assertThat(value.coverageMinimumThreshold()).isEqualTo(1.5);
            softly.assertThat(value.vulnerabilitiesAllowed()).isEqualTo(1);
            softly.assertThat(value.scanners()).isEqualTo(List.of("scanners"));
            softly.assertThat(value.severityLevels()).isEqualTo(List.of("severity_levels"));
            softly.assertThat(value.vulnerabilityStates()).isEqualTo(List.of("vulnerability_states"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsUpdateApprovalRulePayload original =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload();

        final GitLabProjectProjectsUpdateApprovalRulePayload rebuilt =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenUsersSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabProjectProjectsUpdateApprovalRulePayload built =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .users(source)
                        .build();
        source.clear();

        assertThat(built.users()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUsersIsRead() {
        final GitLabProjectProjectsUpdateApprovalRulePayload built =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload();
        final List<Integer> values = built.users();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenUserIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectProjectsUpdateApprovalRulePayload built =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .userIds(source)
                        .build();
        source.clear();

        assertThat(built.userIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUserIdsIsRead() {
        final GitLabProjectProjectsUpdateApprovalRulePayload built =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload();
        final List<Long> values = built.userIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenGroupsSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabProjectProjectsUpdateApprovalRulePayload built =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .groups(source)
                        .build();
        source.clear();

        assertThat(built.groups()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGroupsIsRead() {
        final GitLabProjectProjectsUpdateApprovalRulePayload built =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload();
        final List<Integer> values = built.groups();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenGroupIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectProjectsUpdateApprovalRulePayload built =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .groupIds(source)
                        .build();
        source.clear();

        assertThat(built.groupIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGroupIdsIsRead() {
        final GitLabProjectProjectsUpdateApprovalRulePayload built =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload();
        final List<Long> values = built.groupIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenUsernamesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("usernames"));
        final GitLabProjectProjectsUpdateApprovalRulePayload built =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .usernames(source)
                        .build();
        source.clear();

        assertThat(built.usernames()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUsernamesIsRead() {
        final GitLabProjectProjectsUpdateApprovalRulePayload built =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload();
        final List<String> values = built.usernames();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenProtectedBranchIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectProjectsUpdateApprovalRulePayload built =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .protectedBranchIds(source)
                        .build();
        source.clear();

        assertThat(built.protectedBranchIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenProtectedBranchIdsIsRead() {
        final GitLabProjectProjectsUpdateApprovalRulePayload built =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload();
        final List<Long> values = built.protectedBranchIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenScannersSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("scanners"));
        final GitLabProjectProjectsUpdateApprovalRulePayload built =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .scanners(source)
                        .build();
        source.clear();

        assertThat(built.scanners()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenScannersIsRead() {
        final GitLabProjectProjectsUpdateApprovalRulePayload built =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload();
        final List<String> values = built.scanners();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenSeverityLevelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("severity_levels"));
        final GitLabProjectProjectsUpdateApprovalRulePayload built =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .severityLevels(source)
                        .build();
        source.clear();

        assertThat(built.severityLevels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSeverityLevelsIsRead() {
        final GitLabProjectProjectsUpdateApprovalRulePayload built =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload();
        final List<String> values = built.severityLevels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenVulnerabilityStatesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("vulnerability_states"));
        final GitLabProjectProjectsUpdateApprovalRulePayload built =
                GitLabProjectProjectsUpdateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload())
                        .vulnerabilityStates(source)
                        .build();
        source.clear();

        assertThat(built.vulnerabilityStates()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenVulnerabilityStatesIsRead() {
        final GitLabProjectProjectsUpdateApprovalRulePayload built =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload();
        final List<String> values = built.vulnerabilityStates();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectsUpdateApprovalRulePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name",
                        "approvalsRequired",
                        "users",
                        "userIds",
                        "groups",
                        "groupIds",
                        "usernames",
                        "protectedBranchIds",
                        "appliesToAllProtectedBranches",
                        "removeHiddenGroups",
                        "coverageMinimumThreshold",
                        "vulnerabilitiesAllowed",
                        "scanners",
                        "severityLevels",
                        "vulnerabilityStates");
    }
}
