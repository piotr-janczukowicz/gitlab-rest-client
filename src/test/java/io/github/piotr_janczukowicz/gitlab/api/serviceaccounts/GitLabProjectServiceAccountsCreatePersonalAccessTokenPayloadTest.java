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
class GitLabProjectServiceAccountsCreatePersonalAccessTokenPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectServiceAccountsCreatePersonalAccessTokenPayloadBuilder builder =
                GitLabProjectServiceAccountsCreatePersonalAccessTokenPayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.projectServiceAccountsCreatePersonalAccessTokenPayload())
                        .name(null);

        final GitLabProjectServiceAccountsCreatePersonalAccessTokenPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectServiceAccountsCreatePersonalAccessTokenPayloadBuilder builder =
                GitLabProjectServiceAccountsCreatePersonalAccessTokenPayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.projectServiceAccountsCreatePersonalAccessTokenPayload())
                        .description(null);

        final GitLabProjectServiceAccountsCreatePersonalAccessTokenPayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabProjectServiceAccountsCreatePersonalAccessTokenPayloadBuilder builder =
                GitLabProjectServiceAccountsCreatePersonalAccessTokenPayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.projectServiceAccountsCreatePersonalAccessTokenPayload())
                        .expiresAt(null);

        final GitLabProjectServiceAccountsCreatePersonalAccessTokenPayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenScopesIsNull() {
        final GitLabProjectServiceAccountsCreatePersonalAccessTokenPayloadBuilder builder =
                GitLabProjectServiceAccountsCreatePersonalAccessTokenPayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.projectServiceAccountsCreatePersonalAccessTokenPayload())
                        .scopes(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("scopes");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectServiceAccountsCreatePersonalAccessTokenPayload value =
                ServiceaccountsCatalogFixtures.projectServiceAccountsCreatePersonalAccessTokenPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("My token");
            softly.assertThat(value.description()).isEqualTo("A token used for k8s");
            softly.assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.scopes())
                    .isEqualTo(List.of(GitLabProjectServiceAccountsCreatePersonalAccessTokenScopes.API));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectServiceAccountsCreatePersonalAccessTokenPayload original =
                ServiceaccountsCatalogFixtures.projectServiceAccountsCreatePersonalAccessTokenPayload();

        final GitLabProjectServiceAccountsCreatePersonalAccessTokenPayload rebuilt =
                GitLabProjectServiceAccountsCreatePersonalAccessTokenPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenScopesSourceChangesLater() {
        final List<GitLabProjectServiceAccountsCreatePersonalAccessTokenScopes> source =
                new ArrayList<>(List.of(GitLabProjectServiceAccountsCreatePersonalAccessTokenScopes.API));
        final GitLabProjectServiceAccountsCreatePersonalAccessTokenPayload built =
                GitLabProjectServiceAccountsCreatePersonalAccessTokenPayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.projectServiceAccountsCreatePersonalAccessTokenPayload())
                        .scopes(source)
                        .build();
        source.clear();

        assertThat(built.scopes()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenScopesIsRead() {
        final GitLabProjectServiceAccountsCreatePersonalAccessTokenPayload built =
                ServiceaccountsCatalogFixtures.projectServiceAccountsCreatePersonalAccessTokenPayload();
        final List<GitLabProjectServiceAccountsCreatePersonalAccessTokenScopes> values = built.scopes();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectServiceAccountsCreatePersonalAccessTokenPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "description", "expiresAt", "scopes");
    }
}
