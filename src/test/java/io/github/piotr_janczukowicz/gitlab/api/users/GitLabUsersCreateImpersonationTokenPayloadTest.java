package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUsersCreateImpersonationTokenPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabUsersCreateImpersonationTokenPayloadBuilder builder =
                GitLabUsersCreateImpersonationTokenPayloadBuilder.builder(
                                UsersCatalogFixtures.usersCreateImpersonationTokenPayload())
                        .name(null);

        final GitLabUsersCreateImpersonationTokenPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabUsersCreateImpersonationTokenPayloadBuilder builder =
                GitLabUsersCreateImpersonationTokenPayloadBuilder.builder(
                                UsersCatalogFixtures.usersCreateImpersonationTokenPayload())
                        .description(null);

        final GitLabUsersCreateImpersonationTokenPayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabUsersCreateImpersonationTokenPayloadBuilder builder =
                GitLabUsersCreateImpersonationTokenPayloadBuilder.builder(
                                UsersCatalogFixtures.usersCreateImpersonationTokenPayload())
                        .expiresAt(null);

        final GitLabUsersCreateImpersonationTokenPayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopesIsNullable() {
        final GitLabUsersCreateImpersonationTokenPayloadBuilder builder =
                GitLabUsersCreateImpersonationTokenPayloadBuilder.builder(
                                UsersCatalogFixtures.usersCreateImpersonationTokenPayload())
                        .scopes(null);

        final GitLabUsersCreateImpersonationTokenPayload built = builder.build();

        assertThat(built.scopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularScopesIsNullable() {
        final GitLabUsersCreateImpersonationTokenPayloadBuilder builder =
                GitLabUsersCreateImpersonationTokenPayloadBuilder.builder(
                                UsersCatalogFixtures.usersCreateImpersonationTokenPayload())
                        .granularScopes(null);

        final GitLabUsersCreateImpersonationTokenPayload built = builder.build();

        assertThat(built.granularScopes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUsersCreateImpersonationTokenPayload value =
                UsersCatalogFixtures.usersCreateImpersonationTokenPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.scopes()).isEqualTo(List.of("scopes"));
            softly.assertThat(value.granularScopes())
                    .isEqualTo(List.of(UsersCatalogFixtures.usersCreateImpersonationTokenGranularScope()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUsersCreateImpersonationTokenPayload original =
                UsersCatalogFixtures.usersCreateImpersonationTokenPayload();

        final GitLabUsersCreateImpersonationTokenPayload rebuilt =
                GitLabUsersCreateImpersonationTokenPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenScopesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("scopes"));
        final GitLabUsersCreateImpersonationTokenPayload built =
                GitLabUsersCreateImpersonationTokenPayloadBuilder.builder(
                                UsersCatalogFixtures.usersCreateImpersonationTokenPayload())
                        .scopes(source)
                        .build();
        source.clear();

        assertThat(built.scopes()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenScopesIsRead() {
        final GitLabUsersCreateImpersonationTokenPayload built =
                UsersCatalogFixtures.usersCreateImpersonationTokenPayload();
        final List<String> values = built.scopes();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenGranularScopesSourceChangesLater() {
        final List<GitLabUsersCreateImpersonationTokenGranularScope> source =
                new ArrayList<>(List.of(UsersCatalogFixtures.usersCreateImpersonationTokenGranularScope()));
        final GitLabUsersCreateImpersonationTokenPayload built =
                GitLabUsersCreateImpersonationTokenPayloadBuilder.builder(
                                UsersCatalogFixtures.usersCreateImpersonationTokenPayload())
                        .granularScopes(source)
                        .build();
        source.clear();

        assertThat(built.granularScopes()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGranularScopesIsRead() {
        final GitLabUsersCreateImpersonationTokenPayload built =
                UsersCatalogFixtures.usersCreateImpersonationTokenPayload();
        final List<GitLabUsersCreateImpersonationTokenGranularScope> values = built.granularScopes();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUsersCreateImpersonationTokenPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "description", "expiresAt", "scopes", "granularScopes");
    }
}
