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
class GitLabProjectAccessTokensCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectAccessTokensCreatePayloadBuilder builder =
                GitLabProjectAccessTokensCreatePayloadBuilder.builder(
                                AccesstokensCatalogFixtures.projectAccessTokensCreatePayload())
                        .name(null);

        final GitLabProjectAccessTokensCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectAccessTokensCreatePayloadBuilder builder =
                GitLabProjectAccessTokensCreatePayloadBuilder.builder(
                                AccesstokensCatalogFixtures.projectAccessTokensCreatePayload())
                        .description(null);

        final GitLabProjectAccessTokensCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabProjectAccessTokensCreatePayloadBuilder builder =
                GitLabProjectAccessTokensCreatePayloadBuilder.builder(
                                AccesstokensCatalogFixtures.projectAccessTokensCreatePayload())
                        .expiresAt(null);

        final GitLabProjectAccessTokensCreatePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenScopesIsNull() {
        final GitLabProjectAccessTokensCreatePayloadBuilder builder =
                GitLabProjectAccessTokensCreatePayloadBuilder.builder(
                                AccesstokensCatalogFixtures.projectAccessTokensCreatePayload())
                        .scopes(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("scopes");
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabProjectAccessTokensCreatePayloadBuilder builder =
                GitLabProjectAccessTokensCreatePayloadBuilder.builder(
                                AccesstokensCatalogFixtures.projectAccessTokensCreatePayload())
                        .accessLevel(null);

        final GitLabProjectAccessTokensCreatePayload built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectAccessTokensCreatePayload value =
                AccesstokensCatalogFixtures.projectAccessTokensCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("My token");
            softly.assertThat(value.description()).isEqualTo("A token used for k8s");
            softly.assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.scopes()).isEqualTo(List.of(GitLabProjectAccessTokensCreateScopes.API));
            softly.assertThat(value.accessLevel()).isEqualTo(GitLabProjectAccessTokensCreateAccessLevel.GUEST);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectAccessTokensCreatePayload original =
                AccesstokensCatalogFixtures.projectAccessTokensCreatePayload();

        final GitLabProjectAccessTokensCreatePayload rebuilt =
                GitLabProjectAccessTokensCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenScopesSourceChangesLater() {
        final List<GitLabProjectAccessTokensCreateScopes> source =
                new ArrayList<>(List.of(GitLabProjectAccessTokensCreateScopes.API));
        final GitLabProjectAccessTokensCreatePayload built = GitLabProjectAccessTokensCreatePayloadBuilder.builder(
                        AccesstokensCatalogFixtures.projectAccessTokensCreatePayload())
                .scopes(source)
                .build();
        source.clear();

        assertThat(built.scopes()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenScopesIsRead() {
        final GitLabProjectAccessTokensCreatePayload built =
                AccesstokensCatalogFixtures.projectAccessTokensCreatePayload();
        final List<GitLabProjectAccessTokensCreateScopes> values = built.scopes();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectAccessTokensCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "description", "expiresAt", "scopes", "accessLevel");
    }
}
