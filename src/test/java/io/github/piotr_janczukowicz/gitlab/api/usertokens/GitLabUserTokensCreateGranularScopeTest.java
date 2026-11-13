package io.github.piotr_janczukowicz.gitlab.api.usertokens;

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
class GitLabUserTokensCreateGranularScopeTest {

    @Test
    void constructor_shouldRefuseNull_whenAccessIsNull() {
        final GitLabUserTokensCreateGranularScopeBuilder builder = GitLabUserTokensCreateGranularScopeBuilder.builder(
                        UsertokensCatalogFixtures.userTokensCreateGranularScope())
                .access(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("access");
    }

    @Test
    void constructor_shouldAcceptNull_whenPermissionsIsNullable() {
        final GitLabUserTokensCreateGranularScopeBuilder builder = GitLabUserTokensCreateGranularScopeBuilder.builder(
                        UsertokensCatalogFixtures.userTokensCreateGranularScope())
                .permissions(null);

        final GitLabUserTokensCreateGranularScope built = builder.build();

        assertThat(built.permissions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdsIsNullable() {
        final GitLabUserTokensCreateGranularScopeBuilder builder = GitLabUserTokensCreateGranularScopeBuilder.builder(
                        UsertokensCatalogFixtures.userTokensCreateGranularScope())
                .projectIds(null);

        final GitLabUserTokensCreateGranularScope built = builder.build();

        assertThat(built.projectIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdsIsNullable() {
        final GitLabUserTokensCreateGranularScopeBuilder builder = GitLabUserTokensCreateGranularScopeBuilder.builder(
                        UsertokensCatalogFixtures.userTokensCreateGranularScope())
                .groupIds(null);

        final GitLabUserTokensCreateGranularScope built = builder.build();

        assertThat(built.groupIds()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserTokensCreateGranularScope value = UsertokensCatalogFixtures.userTokensCreateGranularScope();

        assertSoftly(softly -> {
            softly.assertThat(value.access()).isEqualTo(GitLabUserTokensCreateGranularScopeAccess.PERSONAL_PROJECTS);
            softly.assertThat(value.permissions()).isEqualTo(List.of("permissions"));
            softly.assertThat(value.projectIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.groupIds()).isEqualTo(List.of(1L));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserTokensCreateGranularScope original = UsertokensCatalogFixtures.userTokensCreateGranularScope();

        final GitLabUserTokensCreateGranularScope rebuilt =
                GitLabUserTokensCreateGranularScopeBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenPermissionsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("permissions"));
        final GitLabUserTokensCreateGranularScope built = GitLabUserTokensCreateGranularScopeBuilder.builder(
                        UsertokensCatalogFixtures.userTokensCreateGranularScope())
                .permissions(source)
                .build();
        source.clear();

        assertThat(built.permissions()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenPermissionsIsRead() {
        final GitLabUserTokensCreateGranularScope built = UsertokensCatalogFixtures.userTokensCreateGranularScope();
        final List<String> values = built.permissions();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenProjectIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabUserTokensCreateGranularScope built = GitLabUserTokensCreateGranularScopeBuilder.builder(
                        UsertokensCatalogFixtures.userTokensCreateGranularScope())
                .projectIds(source)
                .build();
        source.clear();

        assertThat(built.projectIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenProjectIdsIsRead() {
        final GitLabUserTokensCreateGranularScope built = UsertokensCatalogFixtures.userTokensCreateGranularScope();
        final List<Long> values = built.projectIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenGroupIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabUserTokensCreateGranularScope built = GitLabUserTokensCreateGranularScopeBuilder.builder(
                        UsertokensCatalogFixtures.userTokensCreateGranularScope())
                .groupIds(source)
                .build();
        source.clear();

        assertThat(built.groupIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGroupIdsIsRead() {
        final GitLabUserTokensCreateGranularScope built = UsertokensCatalogFixtures.userTokensCreateGranularScope();
        final List<Long> values = built.groupIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserTokensCreateGranularScope.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("access", "permissions", "projectIds", "groupIds");
    }
}
