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
class GitLabProjectProjectsUpdateApprovalSettingsRulePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .name(null);

        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsRequiredIsNullable() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .approvalsRequired(null);

        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.approvalsRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersIsNullable() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .users(null);

        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.users()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdsIsNullable() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .userIds(null);

        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.userIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupsIsNullable() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .groups(null);

        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.groups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdsIsNullable() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .groupIds(null);

        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.groupIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernamesIsNullable() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .usernames(null);

        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.usernames()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedBranchIdsIsNullable() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .protectedBranchIds(null);

        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.protectedBranchIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppliesToAllProtectedBranchesIsNullable() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .appliesToAllProtectedBranches(null);

        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.appliesToAllProtectedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveHiddenGroupsIsNullable() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .removeHiddenGroups(null);

        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.removeHiddenGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCoverageMinimumThresholdIsNullable() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .coverageMinimumThreshold(null);

        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.coverageMinimumThreshold()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilitiesAllowedIsNullable() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .vulnerabilitiesAllowed(null);

        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.vulnerabilitiesAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScannersIsNullable() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .scanners(null);

        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.scanners()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSeverityLevelsIsNullable() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .severityLevels(null);

        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.severityLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityStatesIsNullable() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder builder =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .vulnerabilityStates(null);

        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built = builder.build();

        assertThat(built.vulnerabilityStates()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload value =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload();

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
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload original =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload();

        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload rebuilt =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenUsersSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .users(source)
                        .build();
        source.clear();

        assertThat(built.users()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUsersIsRead() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload();
        final List<Integer> values = built.users();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenUserIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .userIds(source)
                        .build();
        source.clear();

        assertThat(built.userIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUserIdsIsRead() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload();
        final List<Long> values = built.userIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenGroupsSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .groups(source)
                        .build();
        source.clear();

        assertThat(built.groups()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGroupsIsRead() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload();
        final List<Integer> values = built.groups();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenGroupIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .groupIds(source)
                        .build();
        source.clear();

        assertThat(built.groupIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGroupIdsIsRead() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload();
        final List<Long> values = built.groupIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenUsernamesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("usernames"));
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .usernames(source)
                        .build();
        source.clear();

        assertThat(built.usernames()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUsernamesIsRead() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload();
        final List<String> values = built.usernames();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenProtectedBranchIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .protectedBranchIds(source)
                        .build();
        source.clear();

        assertThat(built.protectedBranchIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenProtectedBranchIdsIsRead() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload();
        final List<Long> values = built.protectedBranchIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenScannersSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("scanners"));
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .scanners(source)
                        .build();
        source.clear();

        assertThat(built.scanners()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenScannersIsRead() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload();
        final List<String> values = built.scanners();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenSeverityLevelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("severity_levels"));
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .severityLevels(source)
                        .build();
        source.clear();

        assertThat(built.severityLevels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSeverityLevelsIsRead() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload();
        final List<String> values = built.severityLevels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenVulnerabilityStatesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("vulnerability_states"));
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built =
                GitLabProjectProjectsUpdateApprovalSettingsRulePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload())
                        .vulnerabilityStates(source)
                        .build();
        source.clear();

        assertThat(built.vulnerabilityStates()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenVulnerabilityStatesIsRead() {
        final GitLabProjectProjectsUpdateApprovalSettingsRulePayload built =
                ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload();
        final List<String> values = built.vulnerabilityStates();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsUpdateApprovalSettingsRulePayload.class.getRecordComponents())
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
