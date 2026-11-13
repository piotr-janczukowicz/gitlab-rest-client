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
class GitLabProjectProjectsCreateApprovalRulePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProjectsCreateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .name(null);

        final GitLabProjectProjectsCreateApprovalRulePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsRequiredIsNullable() {
        final GitLabProjectProjectsCreateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .approvalsRequired(null);

        final GitLabProjectProjectsCreateApprovalRulePayload built = builder.build();

        assertThat(built.approvalsRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRuleTypeIsNullable() {
        final GitLabProjectProjectsCreateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .ruleType(null);

        final GitLabProjectProjectsCreateApprovalRulePayload built = builder.build();

        assertThat(built.ruleType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersIsNullable() {
        final GitLabProjectProjectsCreateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .users(null);

        final GitLabProjectProjectsCreateApprovalRulePayload built = builder.build();

        assertThat(built.users()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdsIsNullable() {
        final GitLabProjectProjectsCreateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .userIds(null);

        final GitLabProjectProjectsCreateApprovalRulePayload built = builder.build();

        assertThat(built.userIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupsIsNullable() {
        final GitLabProjectProjectsCreateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .groups(null);

        final GitLabProjectProjectsCreateApprovalRulePayload built = builder.build();

        assertThat(built.groups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdsIsNullable() {
        final GitLabProjectProjectsCreateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .groupIds(null);

        final GitLabProjectProjectsCreateApprovalRulePayload built = builder.build();

        assertThat(built.groupIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernamesIsNullable() {
        final GitLabProjectProjectsCreateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .usernames(null);

        final GitLabProjectProjectsCreateApprovalRulePayload built = builder.build();

        assertThat(built.usernames()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedBranchIdsIsNullable() {
        final GitLabProjectProjectsCreateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .protectedBranchIds(null);

        final GitLabProjectProjectsCreateApprovalRulePayload built = builder.build();

        assertThat(built.protectedBranchIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppliesToAllProtectedBranchesIsNullable() {
        final GitLabProjectProjectsCreateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .appliesToAllProtectedBranches(null);

        final GitLabProjectProjectsCreateApprovalRulePayload built = builder.build();

        assertThat(built.appliesToAllProtectedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReportTypeIsNullable() {
        final GitLabProjectProjectsCreateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .reportType(null);

        final GitLabProjectProjectsCreateApprovalRulePayload built = builder.build();

        assertThat(built.reportType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCoverageMinimumThresholdIsNullable() {
        final GitLabProjectProjectsCreateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .coverageMinimumThreshold(null);

        final GitLabProjectProjectsCreateApprovalRulePayload built = builder.build();

        assertThat(built.coverageMinimumThreshold()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilitiesAllowedIsNullable() {
        final GitLabProjectProjectsCreateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .vulnerabilitiesAllowed(null);

        final GitLabProjectProjectsCreateApprovalRulePayload built = builder.build();

        assertThat(built.vulnerabilitiesAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScannersIsNullable() {
        final GitLabProjectProjectsCreateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .scanners(null);

        final GitLabProjectProjectsCreateApprovalRulePayload built = builder.build();

        assertThat(built.scanners()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSeverityLevelsIsNullable() {
        final GitLabProjectProjectsCreateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .severityLevels(null);

        final GitLabProjectProjectsCreateApprovalRulePayload built = builder.build();

        assertThat(built.severityLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityStatesIsNullable() {
        final GitLabProjectProjectsCreateApprovalRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .vulnerabilityStates(null);

        final GitLabProjectProjectsCreateApprovalRulePayload built = builder.build();

        assertThat(built.vulnerabilityStates()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsCreateApprovalRulePayload value =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.approvalsRequired()).isEqualTo(1);
            softly.assertThat(value.ruleType()).isEqualTo("regular");
            softly.assertThat(value.users()).isEqualTo(List.of(1));
            softly.assertThat(value.userIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.groups()).isEqualTo(List.of(1));
            softly.assertThat(value.groupIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.usernames()).isEqualTo(List.of("usernames"));
            softly.assertThat(value.protectedBranchIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.appliesToAllProtectedBranches()).isEqualTo(true);
            softly.assertThat(value.reportType())
                    .isEqualTo(GitLabProjectProjectsCreateApprovalRuleReportType.CODE_COVERAGE);
            softly.assertThat(value.coverageMinimumThreshold()).isEqualTo(1.5);
            softly.assertThat(value.vulnerabilitiesAllowed()).isEqualTo(1);
            softly.assertThat(value.scanners()).isEqualTo(List.of("scanners"));
            softly.assertThat(value.severityLevels()).isEqualTo(List.of("severity_levels"));
            softly.assertThat(value.vulnerabilityStates()).isEqualTo(List.of("vulnerability_states"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsCreateApprovalRulePayload original =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload();

        final GitLabProjectProjectsCreateApprovalRulePayload rebuilt =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenUsersSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabProjectProjectsCreateApprovalRulePayload built =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .users(source)
                        .build();
        source.clear();

        assertThat(built.users()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUsersIsRead() {
        final GitLabProjectProjectsCreateApprovalRulePayload built =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload();
        final List<Integer> values = built.users();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenUserIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectProjectsCreateApprovalRulePayload built =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .userIds(source)
                        .build();
        source.clear();

        assertThat(built.userIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUserIdsIsRead() {
        final GitLabProjectProjectsCreateApprovalRulePayload built =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload();
        final List<Long> values = built.userIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenGroupsSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabProjectProjectsCreateApprovalRulePayload built =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .groups(source)
                        .build();
        source.clear();

        assertThat(built.groups()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGroupsIsRead() {
        final GitLabProjectProjectsCreateApprovalRulePayload built =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload();
        final List<Integer> values = built.groups();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenGroupIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectProjectsCreateApprovalRulePayload built =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .groupIds(source)
                        .build();
        source.clear();

        assertThat(built.groupIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGroupIdsIsRead() {
        final GitLabProjectProjectsCreateApprovalRulePayload built =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload();
        final List<Long> values = built.groupIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenUsernamesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("usernames"));
        final GitLabProjectProjectsCreateApprovalRulePayload built =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .usernames(source)
                        .build();
        source.clear();

        assertThat(built.usernames()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUsernamesIsRead() {
        final GitLabProjectProjectsCreateApprovalRulePayload built =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload();
        final List<String> values = built.usernames();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenProtectedBranchIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectProjectsCreateApprovalRulePayload built =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .protectedBranchIds(source)
                        .build();
        source.clear();

        assertThat(built.protectedBranchIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenProtectedBranchIdsIsRead() {
        final GitLabProjectProjectsCreateApprovalRulePayload built =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload();
        final List<Long> values = built.protectedBranchIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenScannersSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("scanners"));
        final GitLabProjectProjectsCreateApprovalRulePayload built =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .scanners(source)
                        .build();
        source.clear();

        assertThat(built.scanners()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenScannersIsRead() {
        final GitLabProjectProjectsCreateApprovalRulePayload built =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload();
        final List<String> values = built.scanners();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenSeverityLevelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("severity_levels"));
        final GitLabProjectProjectsCreateApprovalRulePayload built =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .severityLevels(source)
                        .build();
        source.clear();

        assertThat(built.severityLevels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSeverityLevelsIsRead() {
        final GitLabProjectProjectsCreateApprovalRulePayload built =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload();
        final List<String> values = built.severityLevels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenVulnerabilityStatesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("vulnerability_states"));
        final GitLabProjectProjectsCreateApprovalRulePayload built =
                GitLabProjectProjectsCreateApprovalRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload())
                        .vulnerabilityStates(source)
                        .build();
        source.clear();

        assertThat(built.vulnerabilityStates()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenVulnerabilityStatesIsRead() {
        final GitLabProjectProjectsCreateApprovalRulePayload built =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload();
        final List<String> values = built.vulnerabilityStates();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectsCreateApprovalRulePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name",
                        "approvalsRequired",
                        "ruleType",
                        "users",
                        "userIds",
                        "groups",
                        "groupIds",
                        "usernames",
                        "protectedBranchIds",
                        "appliesToAllProtectedBranches",
                        "reportType",
                        "coverageMinimumThreshold",
                        "vulnerabilitiesAllowed",
                        "scanners",
                        "severityLevels",
                        "vulnerabilityStates");
    }
}
