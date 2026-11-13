package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

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
class GitLabGroupServiceAccountsCreatePersonalAccessTokenPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupServiceAccountsCreatePersonalAccessTokenPayloadBuilder builder =
                GitLabGroupServiceAccountsCreatePersonalAccessTokenPayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePersonalAccessTokenPayload())
                        .name(null);

        final GitLabGroupServiceAccountsCreatePersonalAccessTokenPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupServiceAccountsCreatePersonalAccessTokenPayloadBuilder builder =
                GitLabGroupServiceAccountsCreatePersonalAccessTokenPayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePersonalAccessTokenPayload())
                        .description(null);

        final GitLabGroupServiceAccountsCreatePersonalAccessTokenPayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabGroupServiceAccountsCreatePersonalAccessTokenPayloadBuilder builder =
                GitLabGroupServiceAccountsCreatePersonalAccessTokenPayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePersonalAccessTokenPayload())
                        .expiresAt(null);

        final GitLabGroupServiceAccountsCreatePersonalAccessTokenPayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenScopesIsNull() {
        final GitLabGroupServiceAccountsCreatePersonalAccessTokenPayloadBuilder builder =
                GitLabGroupServiceAccountsCreatePersonalAccessTokenPayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePersonalAccessTokenPayload())
                        .scopes(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("scopes");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupServiceAccountsCreatePersonalAccessTokenPayload value =
                ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePersonalAccessTokenPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("My token");
            softly.assertThat(value.description()).isEqualTo("A token used for k8s");
            softly.assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.scopes())
                    .isEqualTo(List.of(GitLabGroupServiceAccountsCreatePersonalAccessTokenScopes.API));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupServiceAccountsCreatePersonalAccessTokenPayload original =
                ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePersonalAccessTokenPayload();

        final GitLabGroupServiceAccountsCreatePersonalAccessTokenPayload rebuilt =
                GitLabGroupServiceAccountsCreatePersonalAccessTokenPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenScopesSourceChangesLater() {
        final List<GitLabGroupServiceAccountsCreatePersonalAccessTokenScopes> source =
                new ArrayList<>(List.of(GitLabGroupServiceAccountsCreatePersonalAccessTokenScopes.API));
        final GitLabGroupServiceAccountsCreatePersonalAccessTokenPayload built =
                GitLabGroupServiceAccountsCreatePersonalAccessTokenPayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePersonalAccessTokenPayload())
                        .scopes(source)
                        .build();
        source.clear();

        assertThat(built.scopes()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenScopesIsRead() {
        final GitLabGroupServiceAccountsCreatePersonalAccessTokenPayload built =
                ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePersonalAccessTokenPayload();
        final List<GitLabGroupServiceAccountsCreatePersonalAccessTokenScopes> values = built.scopes();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupServiceAccountsCreatePersonalAccessTokenPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "description", "expiresAt", "scopes");
    }
}
