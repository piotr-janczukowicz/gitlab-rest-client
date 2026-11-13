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
class GitLabProjectDeployTokensCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectDeployTokensCreatePayloadBuilder builder =
                GitLabProjectDeployTokensCreatePayloadBuilder.builder(
                                DeploytokensCatalogFixtures.projectDeployTokensCreatePayload())
                        .name(null);

        final GitLabProjectDeployTokensCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenScopesIsNull() {
        final GitLabProjectDeployTokensCreatePayloadBuilder builder =
                GitLabProjectDeployTokensCreatePayloadBuilder.builder(
                                DeploytokensCatalogFixtures.projectDeployTokensCreatePayload())
                        .scopes(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("scopes");
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabProjectDeployTokensCreatePayloadBuilder builder =
                GitLabProjectDeployTokensCreatePayloadBuilder.builder(
                                DeploytokensCatalogFixtures.projectDeployTokensCreatePayload())
                        .expiresAt(null);

        final GitLabProjectDeployTokensCreatePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectDeployTokensCreatePayloadBuilder builder =
                GitLabProjectDeployTokensCreatePayloadBuilder.builder(
                                DeploytokensCatalogFixtures.projectDeployTokensCreatePayload())
                        .username(null);

        final GitLabProjectDeployTokensCreatePayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDeployTokensCreatePayload value =
                DeploytokensCatalogFixtures.projectDeployTokensCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.scopes()).isEqualTo(List.of(GitLabProjectDeployTokensCreateScopes.READ_REPOSITORY));
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.username()).isEqualTo("username");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDeployTokensCreatePayload original =
                DeploytokensCatalogFixtures.projectDeployTokensCreatePayload();

        final GitLabProjectDeployTokensCreatePayload rebuilt =
                GitLabProjectDeployTokensCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenScopesSourceChangesLater() {
        final List<GitLabProjectDeployTokensCreateScopes> source =
                new ArrayList<>(List.of(GitLabProjectDeployTokensCreateScopes.READ_REPOSITORY));
        final GitLabProjectDeployTokensCreatePayload built = GitLabProjectDeployTokensCreatePayloadBuilder.builder(
                        DeploytokensCatalogFixtures.projectDeployTokensCreatePayload())
                .scopes(source)
                .build();
        source.clear();

        assertThat(built.scopes()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenScopesIsRead() {
        final GitLabProjectDeployTokensCreatePayload built =
                DeploytokensCatalogFixtures.projectDeployTokensCreatePayload();
        final List<GitLabProjectDeployTokensCreateScopes> values = built.scopes();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDeployTokensCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "scopes", "expiresAt", "username");
    }
}
