package io.github.piotr_janczukowicz.gitlab.api.usertokens;

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
class GitLabUserTokensCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabUserTokensCreatePayloadBuilder builder = GitLabUserTokensCreatePayloadBuilder.builder(
                        UsertokensCatalogFixtures.userTokensCreatePayload())
                .name(null);

        final GitLabUserTokensCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabUserTokensCreatePayloadBuilder builder = GitLabUserTokensCreatePayloadBuilder.builder(
                        UsertokensCatalogFixtures.userTokensCreatePayload())
                .description(null);

        final GitLabUserTokensCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabUserTokensCreatePayloadBuilder builder = GitLabUserTokensCreatePayloadBuilder.builder(
                        UsertokensCatalogFixtures.userTokensCreatePayload())
                .expiresAt(null);

        final GitLabUserTokensCreatePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopesIsNullable() {
        final GitLabUserTokensCreatePayloadBuilder builder = GitLabUserTokensCreatePayloadBuilder.builder(
                        UsertokensCatalogFixtures.userTokensCreatePayload())
                .scopes(null);

        final GitLabUserTokensCreatePayload built = builder.build();

        assertThat(built.scopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularScopesIsNullable() {
        final GitLabUserTokensCreatePayloadBuilder builder = GitLabUserTokensCreatePayloadBuilder.builder(
                        UsertokensCatalogFixtures.userTokensCreatePayload())
                .granularScopes(null);

        final GitLabUserTokensCreatePayload built = builder.build();

        assertThat(built.granularScopes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserTokensCreatePayload value = UsertokensCatalogFixtures.userTokensCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("My token");
            softly.assertThat(value.description()).isEqualTo("A token used for k8s");
            softly.assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.scopes()).isEqualTo(List.of(GitLabUserTokensCreateScopes.API));
            softly.assertThat(value.granularScopes())
                    .isEqualTo(List.of(UsertokensCatalogFixtures.userTokensCreateGranularScope()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserTokensCreatePayload original = UsertokensCatalogFixtures.userTokensCreatePayload();

        final GitLabUserTokensCreatePayload rebuilt =
                GitLabUserTokensCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenScopesSourceChangesLater() {
        final List<GitLabUserTokensCreateScopes> source = new ArrayList<>(List.of(GitLabUserTokensCreateScopes.API));
        final GitLabUserTokensCreatePayload built = GitLabUserTokensCreatePayloadBuilder.builder(
                        UsertokensCatalogFixtures.userTokensCreatePayload())
                .scopes(source)
                .build();
        source.clear();

        assertThat(built.scopes()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenScopesIsRead() {
        final GitLabUserTokensCreatePayload built = UsertokensCatalogFixtures.userTokensCreatePayload();
        final List<GitLabUserTokensCreateScopes> values = built.scopes();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenGranularScopesSourceChangesLater() {
        final List<GitLabUserTokensCreateGranularScope> source =
                new ArrayList<>(List.of(UsertokensCatalogFixtures.userTokensCreateGranularScope()));
        final GitLabUserTokensCreatePayload built = GitLabUserTokensCreatePayloadBuilder.builder(
                        UsertokensCatalogFixtures.userTokensCreatePayload())
                .granularScopes(source)
                .build();
        source.clear();

        assertThat(built.granularScopes()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGranularScopesIsRead() {
        final GitLabUserTokensCreatePayload built = UsertokensCatalogFixtures.userTokensCreatePayload();
        final List<GitLabUserTokensCreateGranularScope> values = built.granularScopes();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserTokensCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "description", "expiresAt", "scopes", "granularScopes");
    }
}
