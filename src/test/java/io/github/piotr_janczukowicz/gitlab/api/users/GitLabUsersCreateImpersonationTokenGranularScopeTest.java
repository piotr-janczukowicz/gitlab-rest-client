package io.github.piotr_janczukowicz.gitlab.api.users;

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
class GitLabUsersCreateImpersonationTokenGranularScopeTest {

    @Test
    void constructor_shouldRefuseNull_whenAccessIsNull() {
        final GitLabUsersCreateImpersonationTokenGranularScopeBuilder builder =
                GitLabUsersCreateImpersonationTokenGranularScopeBuilder.builder(
                                UsersCatalogFixtures.usersCreateImpersonationTokenGranularScope())
                        .access(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("access");
    }

    @Test
    void constructor_shouldAcceptNull_whenPermissionsIsNullable() {
        final GitLabUsersCreateImpersonationTokenGranularScopeBuilder builder =
                GitLabUsersCreateImpersonationTokenGranularScopeBuilder.builder(
                                UsersCatalogFixtures.usersCreateImpersonationTokenGranularScope())
                        .permissions(null);

        final GitLabUsersCreateImpersonationTokenGranularScope built = builder.build();

        assertThat(built.permissions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdsIsNullable() {
        final GitLabUsersCreateImpersonationTokenGranularScopeBuilder builder =
                GitLabUsersCreateImpersonationTokenGranularScopeBuilder.builder(
                                UsersCatalogFixtures.usersCreateImpersonationTokenGranularScope())
                        .projectIds(null);

        final GitLabUsersCreateImpersonationTokenGranularScope built = builder.build();

        assertThat(built.projectIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdsIsNullable() {
        final GitLabUsersCreateImpersonationTokenGranularScopeBuilder builder =
                GitLabUsersCreateImpersonationTokenGranularScopeBuilder.builder(
                                UsersCatalogFixtures.usersCreateImpersonationTokenGranularScope())
                        .groupIds(null);

        final GitLabUsersCreateImpersonationTokenGranularScope built = builder.build();

        assertThat(built.groupIds()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUsersCreateImpersonationTokenGranularScope value =
                UsersCatalogFixtures.usersCreateImpersonationTokenGranularScope();

        assertSoftly(softly -> {
            softly.assertThat(value.access())
                    .isEqualTo(GitLabUsersCreateImpersonationTokenGranularScopeAccess.PERSONAL_PROJECTS);
            softly.assertThat(value.permissions()).isEqualTo(List.of("permissions"));
            softly.assertThat(value.projectIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.groupIds()).isEqualTo(List.of(1L));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUsersCreateImpersonationTokenGranularScope original =
                UsersCatalogFixtures.usersCreateImpersonationTokenGranularScope();

        final GitLabUsersCreateImpersonationTokenGranularScope rebuilt =
                GitLabUsersCreateImpersonationTokenGranularScopeBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenPermissionsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("permissions"));
        final GitLabUsersCreateImpersonationTokenGranularScope built =
                GitLabUsersCreateImpersonationTokenGranularScopeBuilder.builder(
                                UsersCatalogFixtures.usersCreateImpersonationTokenGranularScope())
                        .permissions(source)
                        .build();
        source.clear();

        assertThat(built.permissions()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenPermissionsIsRead() {
        final GitLabUsersCreateImpersonationTokenGranularScope built =
                UsersCatalogFixtures.usersCreateImpersonationTokenGranularScope();
        final List<String> values = built.permissions();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenProjectIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabUsersCreateImpersonationTokenGranularScope built =
                GitLabUsersCreateImpersonationTokenGranularScopeBuilder.builder(
                                UsersCatalogFixtures.usersCreateImpersonationTokenGranularScope())
                        .projectIds(source)
                        .build();
        source.clear();

        assertThat(built.projectIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenProjectIdsIsRead() {
        final GitLabUsersCreateImpersonationTokenGranularScope built =
                UsersCatalogFixtures.usersCreateImpersonationTokenGranularScope();
        final List<Long> values = built.projectIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenGroupIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabUsersCreateImpersonationTokenGranularScope built =
                GitLabUsersCreateImpersonationTokenGranularScopeBuilder.builder(
                                UsersCatalogFixtures.usersCreateImpersonationTokenGranularScope())
                        .groupIds(source)
                        .build();
        source.clear();

        assertThat(built.groupIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGroupIdsIsRead() {
        final GitLabUsersCreateImpersonationTokenGranularScope built =
                UsersCatalogFixtures.usersCreateImpersonationTokenGranularScope();
        final List<Long> values = built.groupIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabUsersCreateImpersonationTokenGranularScope.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("access", "permissions", "projectIds", "groupIds");
    }
}
