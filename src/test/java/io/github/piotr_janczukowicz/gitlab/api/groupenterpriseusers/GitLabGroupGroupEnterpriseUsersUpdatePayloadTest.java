package io.github.piotr_janczukowicz.gitlab.api.groupenterpriseusers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupEnterpriseUsersUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupGroupEnterpriseUsersUpdatePayloadBuilder builder =
                GitLabGroupGroupEnterpriseUsersUpdatePayloadBuilder.builder(
                                GroupenterpriseusersCatalogFixtures.groupGroupEnterpriseUsersUpdatePayload())
                        .name(null);

        final GitLabGroupGroupEnterpriseUsersUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailIsNullable() {
        final GitLabGroupGroupEnterpriseUsersUpdatePayloadBuilder builder =
                GitLabGroupGroupEnterpriseUsersUpdatePayloadBuilder.builder(
                                GroupenterpriseusersCatalogFixtures.groupGroupEnterpriseUsersUpdatePayload())
                        .email(null);

        final GitLabGroupGroupEnterpriseUsersUpdatePayload built = builder.build();

        assertThat(built.email()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectsLimitIsNullable() {
        final GitLabGroupGroupEnterpriseUsersUpdatePayloadBuilder builder =
                GitLabGroupGroupEnterpriseUsersUpdatePayloadBuilder.builder(
                                GroupenterpriseusersCatalogFixtures.groupGroupEnterpriseUsersUpdatePayload())
                        .projectsLimit(null);

        final GitLabGroupGroupEnterpriseUsersUpdatePayload built = builder.build();

        assertThat(built.projectsLimit()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenProjectsLimitIsBelowTheMinimum() {
        final GitLabGroupGroupEnterpriseUsersUpdatePayloadBuilder builder =
                GitLabGroupGroupEnterpriseUsersUpdatePayloadBuilder.builder(
                                GroupenterpriseusersCatalogFixtures.groupGroupEnterpriseUsersUpdatePayload())
                        .projectsLimit(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenProjectsLimitIsTheMinimum() {
        final GitLabGroupGroupEnterpriseUsersUpdatePayloadBuilder builder =
                GitLabGroupGroupEnterpriseUsersUpdatePayloadBuilder.builder(
                                GroupenterpriseusersCatalogFixtures.groupGroupEnterpriseUsersUpdatePayload())
                        .projectsLimit(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCanCreateGroupIsNullable() {
        final GitLabGroupGroupEnterpriseUsersUpdatePayloadBuilder builder =
                GitLabGroupGroupEnterpriseUsersUpdatePayloadBuilder.builder(
                                GroupenterpriseusersCatalogFixtures.groupGroupEnterpriseUsersUpdatePayload())
                        .canCreateGroup(null);

        final GitLabGroupGroupEnterpriseUsersUpdatePayload built = builder.build();

        assertThat(built.canCreateGroup()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupEnterpriseUsersUpdatePayload value =
                GroupenterpriseusersCatalogFixtures.groupGroupEnterpriseUsersUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.email()).isEqualTo("email");
            softly.assertThat(value.projectsLimit()).isEqualTo(1);
            softly.assertThat(value.canCreateGroup()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupEnterpriseUsersUpdatePayload original =
                GroupenterpriseusersCatalogFixtures.groupGroupEnterpriseUsersUpdatePayload();

        final GitLabGroupGroupEnterpriseUsersUpdatePayload rebuilt =
                GitLabGroupGroupEnterpriseUsersUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupEnterpriseUsersUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "email", "projectsLimit", "canCreateGroup");
    }
}
