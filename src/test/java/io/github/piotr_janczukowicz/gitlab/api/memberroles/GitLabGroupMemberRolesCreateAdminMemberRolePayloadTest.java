package io.github.piotr_janczukowicz.gitlab.api.memberroles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupMemberRolesCreateAdminMemberRolePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupMemberRolesCreateAdminMemberRolePayloadBuilder builder =
                GitLabGroupMemberRolesCreateAdminMemberRolePayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateAdminMemberRolePayload())
                        .name(null);

        final GitLabGroupMemberRolesCreateAdminMemberRolePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupMemberRolesCreateAdminMemberRolePayloadBuilder builder =
                GitLabGroupMemberRolesCreateAdminMemberRolePayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateAdminMemberRolePayload())
                        .description(null);

        final GitLabGroupMemberRolesCreateAdminMemberRolePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminCicdIsNullable() {
        final GitLabGroupMemberRolesCreateAdminMemberRolePayloadBuilder builder =
                GitLabGroupMemberRolesCreateAdminMemberRolePayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateAdminMemberRolePayload())
                        .readAdminCicd(null);

        final GitLabGroupMemberRolesCreateAdminMemberRolePayload built = builder.build();

        assertThat(built.readAdminCicd()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminGroupsIsNullable() {
        final GitLabGroupMemberRolesCreateAdminMemberRolePayloadBuilder builder =
                GitLabGroupMemberRolesCreateAdminMemberRolePayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateAdminMemberRolePayload())
                        .readAdminGroups(null);

        final GitLabGroupMemberRolesCreateAdminMemberRolePayload built = builder.build();

        assertThat(built.readAdminGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminProjectsIsNullable() {
        final GitLabGroupMemberRolesCreateAdminMemberRolePayloadBuilder builder =
                GitLabGroupMemberRolesCreateAdminMemberRolePayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateAdminMemberRolePayload())
                        .readAdminProjects(null);

        final GitLabGroupMemberRolesCreateAdminMemberRolePayload built = builder.build();

        assertThat(built.readAdminProjects()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminSubscriptionIsNullable() {
        final GitLabGroupMemberRolesCreateAdminMemberRolePayloadBuilder builder =
                GitLabGroupMemberRolesCreateAdminMemberRolePayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateAdminMemberRolePayload())
                        .readAdminSubscription(null);

        final GitLabGroupMemberRolesCreateAdminMemberRolePayload built = builder.build();

        assertThat(built.readAdminSubscription()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminMonitoringIsNullable() {
        final GitLabGroupMemberRolesCreateAdminMemberRolePayloadBuilder builder =
                GitLabGroupMemberRolesCreateAdminMemberRolePayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateAdminMemberRolePayload())
                        .readAdminMonitoring(null);

        final GitLabGroupMemberRolesCreateAdminMemberRolePayload built = builder.build();

        assertThat(built.readAdminMonitoring()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminUsersIsNullable() {
        final GitLabGroupMemberRolesCreateAdminMemberRolePayloadBuilder builder =
                GitLabGroupMemberRolesCreateAdminMemberRolePayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateAdminMemberRolePayload())
                        .readAdminUsers(null);

        final GitLabGroupMemberRolesCreateAdminMemberRolePayload built = builder.build();

        assertThat(built.readAdminUsers()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupMemberRolesCreateAdminMemberRolePayload value =
                MemberrolesCatalogFixtures.groupMemberRolesCreateAdminMemberRolePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.readAdminCicd()).isEqualTo(true);
            softly.assertThat(value.readAdminGroups()).isEqualTo(true);
            softly.assertThat(value.readAdminProjects()).isEqualTo(true);
            softly.assertThat(value.readAdminSubscription()).isEqualTo(true);
            softly.assertThat(value.readAdminMonitoring()).isEqualTo(true);
            softly.assertThat(value.readAdminUsers()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupMemberRolesCreateAdminMemberRolePayload original =
                MemberrolesCatalogFixtures.groupMemberRolesCreateAdminMemberRolePayload();

        final GitLabGroupMemberRolesCreateAdminMemberRolePayload rebuilt =
                GitLabGroupMemberRolesCreateAdminMemberRolePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupMemberRolesCreateAdminMemberRolePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name",
                        "description",
                        "readAdminCicd",
                        "readAdminGroups",
                        "readAdminProjects",
                        "readAdminSubscription",
                        "readAdminMonitoring",
                        "readAdminUsers");
    }
}
