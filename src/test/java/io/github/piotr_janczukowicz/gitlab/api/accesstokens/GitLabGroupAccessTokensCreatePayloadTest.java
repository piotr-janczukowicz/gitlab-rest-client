package io.github.piotr_janczukowicz.gitlab.api.accesstokens;

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
class GitLabGroupAccessTokensCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupAccessTokensCreatePayloadBuilder builder = GitLabGroupAccessTokensCreatePayloadBuilder.builder(
                        AccesstokensCatalogFixtures.groupAccessTokensCreatePayload())
                .name(null);

        final GitLabGroupAccessTokensCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupAccessTokensCreatePayloadBuilder builder = GitLabGroupAccessTokensCreatePayloadBuilder.builder(
                        AccesstokensCatalogFixtures.groupAccessTokensCreatePayload())
                .description(null);

        final GitLabGroupAccessTokensCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabGroupAccessTokensCreatePayloadBuilder builder = GitLabGroupAccessTokensCreatePayloadBuilder.builder(
                        AccesstokensCatalogFixtures.groupAccessTokensCreatePayload())
                .expiresAt(null);

        final GitLabGroupAccessTokensCreatePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenScopesIsNull() {
        final GitLabGroupAccessTokensCreatePayloadBuilder builder = GitLabGroupAccessTokensCreatePayloadBuilder.builder(
                        AccesstokensCatalogFixtures.groupAccessTokensCreatePayload())
                .scopes(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("scopes");
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabGroupAccessTokensCreatePayloadBuilder builder = GitLabGroupAccessTokensCreatePayloadBuilder.builder(
                        AccesstokensCatalogFixtures.groupAccessTokensCreatePayload())
                .accessLevel(null);

        final GitLabGroupAccessTokensCreatePayload built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupAccessTokensCreatePayload value = AccesstokensCatalogFixtures.groupAccessTokensCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("My token");
            softly.assertThat(value.description()).isEqualTo("A token used for k8s");
            softly.assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.scopes()).isEqualTo(List.of(GitLabGroupAccessTokensCreateScopes.API));
            softly.assertThat(value.accessLevel()).isEqualTo(GitLabGroupAccessTokensCreateAccessLevel.GUEST);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupAccessTokensCreatePayload original =
                AccesstokensCatalogFixtures.groupAccessTokensCreatePayload();

        final GitLabGroupAccessTokensCreatePayload rebuilt =
                GitLabGroupAccessTokensCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenScopesSourceChangesLater() {
        final List<GitLabGroupAccessTokensCreateScopes> source =
                new ArrayList<>(List.of(GitLabGroupAccessTokensCreateScopes.API));
        final GitLabGroupAccessTokensCreatePayload built = GitLabGroupAccessTokensCreatePayloadBuilder.builder(
                        AccesstokensCatalogFixtures.groupAccessTokensCreatePayload())
                .scopes(source)
                .build();
        source.clear();

        assertThat(built.scopes()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenScopesIsRead() {
        final GitLabGroupAccessTokensCreatePayload built = AccesstokensCatalogFixtures.groupAccessTokensCreatePayload();
        final List<GitLabGroupAccessTokensCreateScopes> values = built.scopes();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupAccessTokensCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "description", "expiresAt", "scopes", "accessLevel");
    }
}
