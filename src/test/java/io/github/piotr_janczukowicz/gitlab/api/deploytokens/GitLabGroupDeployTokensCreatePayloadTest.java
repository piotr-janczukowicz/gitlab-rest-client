package io.github.piotr_janczukowicz.gitlab.api.deploytokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupDeployTokensCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupDeployTokensCreatePayloadBuilder builder = GitLabGroupDeployTokensCreatePayloadBuilder.builder(
                        DeploytokensCatalogFixtures.groupDeployTokensCreatePayload())
                .name(null);

        final GitLabGroupDeployTokensCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenScopesIsNull() {
        final GitLabGroupDeployTokensCreatePayloadBuilder builder = GitLabGroupDeployTokensCreatePayloadBuilder.builder(
                        DeploytokensCatalogFixtures.groupDeployTokensCreatePayload())
                .scopes(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("scopes");
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabGroupDeployTokensCreatePayloadBuilder builder = GitLabGroupDeployTokensCreatePayloadBuilder.builder(
                        DeploytokensCatalogFixtures.groupDeployTokensCreatePayload())
                .expiresAt(null);

        final GitLabGroupDeployTokensCreatePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabGroupDeployTokensCreatePayloadBuilder builder = GitLabGroupDeployTokensCreatePayloadBuilder.builder(
                        DeploytokensCatalogFixtures.groupDeployTokensCreatePayload())
                .username(null);

        final GitLabGroupDeployTokensCreatePayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupDeployTokensCreatePayload value = DeploytokensCatalogFixtures.groupDeployTokensCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.scopes()).isEqualTo(List.of(GitLabGroupDeployTokensCreateScopes.READ_REPOSITORY));
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.username()).isEqualTo("username");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupDeployTokensCreatePayload original =
                DeploytokensCatalogFixtures.groupDeployTokensCreatePayload();

        final GitLabGroupDeployTokensCreatePayload rebuilt =
                GitLabGroupDeployTokensCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenScopesSourceChangesLater() {
        final List<GitLabGroupDeployTokensCreateScopes> source =
                new ArrayList<>(List.of(GitLabGroupDeployTokensCreateScopes.READ_REPOSITORY));
        final GitLabGroupDeployTokensCreatePayload built = GitLabGroupDeployTokensCreatePayloadBuilder.builder(
                        DeploytokensCatalogFixtures.groupDeployTokensCreatePayload())
                .scopes(source)
                .build();
        source.clear();

        assertThat(built.scopes()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenScopesIsRead() {
        final GitLabGroupDeployTokensCreatePayload built = DeploytokensCatalogFixtures.groupDeployTokensCreatePayload();
        final List<GitLabGroupDeployTokensCreateScopes> values = built.scopes();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupDeployTokensCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "scopes", "expiresAt", "username");
    }
}
