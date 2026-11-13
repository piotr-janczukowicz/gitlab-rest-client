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
class GitLabProjectProjectsCreateApprovalSettingsRulePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .name(null);

        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsRequiredIsNullable() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .approvalsRequired(null);

        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.approvalsRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRuleTypeIsNullable() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .ruleType(null);

        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.ruleType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersIsNullable() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .users(null);

        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.users()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdsIsNullable() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .userIds(null);

        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.userIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupsIsNullable() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .groups(null);

        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.groups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdsIsNullable() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .groupIds(null);

        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.groupIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernamesIsNullable() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .usernames(null);

        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.usernames()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedBranchIdsIsNullable() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .protectedBranchIds(null);

        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.protectedBranchIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppliesToAllProtectedBranchesIsNullable() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .appliesToAllProtectedBranches(null);

        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.appliesToAllProtectedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReportTypeIsNullable() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .reportType(null);

        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.reportType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCoverageMinimumThresholdIsNullable() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .coverageMinimumThreshold(null);

        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.coverageMinimumThreshold()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilitiesAllowedIsNullable() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .vulnerabilitiesAllowed(null);

        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.vulnerabilitiesAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScannersIsNullable() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .scanners(null);

        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.scanners()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSeverityLevelsIsNullable() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .severityLevels(null);

        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.severityLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityStatesIsNullable() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .vulnerabilityStates(null);

        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.vulnerabilityStates()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload value =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload();

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
                    .isEqualTo(GitLabProjectProjectsCreateApprovalSettingsRuleReportType.CODE_COVERAGE);
            softly.assertThat(value.coverageMinimumThreshold()).isEqualTo(1.5);
            softly.assertThat(value.vulnerabilitiesAllowed()).isEqualTo(1);
            softly.assertThat(value.scanners()).isEqualTo(List.of("scanners"));
            softly.assertThat(value.severityLevels()).isEqualTo(List.of("severity_levels"));
            softly.assertThat(value.vulnerabilityStates()).isEqualTo(List.of("vulnerability_states"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload original =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload();

        final GitLabProjectProjectsCreateApprovalSettingsRulePayload rebuilt =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenUsersSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .users(source)
                        .build();
        source.clear();

        assertThat(built.users()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUsersIsRead() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload();
        final List<Integer> values = built.users();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenUserIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .userIds(source)
                        .build();
        source.clear();

        assertThat(built.userIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUserIdsIsRead() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload();
        final List<Long> values = built.userIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenGroupsSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .groups(source)
                        .build();
        source.clear();

        assertThat(built.groups()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGroupsIsRead() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload();
        final List<Integer> values = built.groups();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenGroupIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .groupIds(source)
                        .build();
        source.clear();

        assertThat(built.groupIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGroupIdsIsRead() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload();
        final List<Long> values = built.groupIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenUsernamesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("usernames"));
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .usernames(source)
                        .build();
        source.clear();

        assertThat(built.usernames()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUsernamesIsRead() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload();
        final List<String> values = built.usernames();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenProtectedBranchIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .protectedBranchIds(source)
                        .build();
        source.clear();

        assertThat(built.protectedBranchIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenProtectedBranchIdsIsRead() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload();
        final List<Long> values = built.protectedBranchIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenScannersSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("scanners"));
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .scanners(source)
                        .build();
        source.clear();

        assertThat(built.scanners()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenScannersIsRead() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload();
        final List<String> values = built.scanners();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenSeverityLevelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("severity_levels"));
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .severityLevels(source)
                        .build();
        source.clear();

        assertThat(built.severityLevels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSeverityLevelsIsRead() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload();
        final List<String> values = built.severityLevels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenVulnerabilityStatesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("vulnerability_states"));
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built =
                GitLabProjectProjectsCreateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload())
                        .vulnerabilityStates(source)
                        .build();
        source.clear();

        assertThat(built.vulnerabilityStates()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenVulnerabilityStatesIsRead() {
        final GitLabProjectProjectsCreateApprovalSettingsRulePayload built =
                ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload();
        final List<String> values = built.vulnerabilityStates();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsCreateApprovalSettingsRulePayload.class.getRecordComponents())
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
