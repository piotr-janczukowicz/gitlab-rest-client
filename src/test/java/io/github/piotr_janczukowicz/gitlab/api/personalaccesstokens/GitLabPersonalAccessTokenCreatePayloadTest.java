package io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens;

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
class GitLabPersonalAccessTokenCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabPersonalAccessTokenCreatePayloadBuilder builder =
                GitLabPersonalAccessTokenCreatePayloadBuilder.builder(
                                PersonalaccesstokensCatalogFixtures.personalAccessTokenCreatePayload())
                        .name(null);

        final GitLabPersonalAccessTokenCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabPersonalAccessTokenCreatePayloadBuilder builder =
                GitLabPersonalAccessTokenCreatePayloadBuilder.builder(
                                PersonalaccesstokensCatalogFixtures.personalAccessTokenCreatePayload())
                        .description(null);

        final GitLabPersonalAccessTokenCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabPersonalAccessTokenCreatePayloadBuilder builder =
                GitLabPersonalAccessTokenCreatePayloadBuilder.builder(
                                PersonalaccesstokensCatalogFixtures.personalAccessTokenCreatePayload())
                        .expiresAt(null);

        final GitLabPersonalAccessTokenCreatePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularScopesIsNullable() {
        final GitLabPersonalAccessTokenCreatePayloadBuilder builder =
                GitLabPersonalAccessTokenCreatePayloadBuilder.builder(
                                PersonalaccesstokensCatalogFixtures.personalAccessTokenCreatePayload())
                        .granularScopes(null);

        final GitLabPersonalAccessTokenCreatePayload built = builder.build();

        assertThat(built.granularScopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopesIsNullable() {
        final GitLabPersonalAccessTokenCreatePayloadBuilder builder =
                GitLabPersonalAccessTokenCreatePayloadBuilder.builder(
                                PersonalaccesstokensCatalogFixtures.personalAccessTokenCreatePayload())
                        .scopes(null);

        final GitLabPersonalAccessTokenCreatePayload built = builder.build();

        assertThat(built.scopes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPersonalAccessTokenCreatePayload value =
                PersonalaccesstokensCatalogFixtures.personalAccessTokenCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("My token");
            softly.assertThat(value.description()).isEqualTo("A token used for k8s");
            softly.assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.granularScopes())
                    .isEqualTo(List.of(PersonalaccesstokensCatalogFixtures.personalAccessTokenCreateGranularScope()));
            softly.assertThat(value.scopes()).isEqualTo(List.of(GitLabPersonalAccessTokenCreateScopes.K8S_PROXY));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPersonalAccessTokenCreatePayload original =
                PersonalaccesstokensCatalogFixtures.personalAccessTokenCreatePayload();

        final GitLabPersonalAccessTokenCreatePayload rebuilt =
                GitLabPersonalAccessTokenCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenGranularScopesSourceChangesLater() {
        final List<GitLabPersonalAccessTokenCreateGranularScope> source =
                new ArrayList<>(List.of(PersonalaccesstokensCatalogFixtures.personalAccessTokenCreateGranularScope()));
        final GitLabPersonalAccessTokenCreatePayload built = GitLabPersonalAccessTokenCreatePayloadBuilder.builder(
                        PersonalaccesstokensCatalogFixtures.personalAccessTokenCreatePayload())
                .granularScopes(source)
                .build();
        source.clear();

        assertThat(built.granularScopes()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGranularScopesIsRead() {
        final GitLabPersonalAccessTokenCreatePayload built =
                PersonalaccesstokensCatalogFixtures.personalAccessTokenCreatePayload();
        final List<GitLabPersonalAccessTokenCreateGranularScope> values = built.granularScopes();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenScopesSourceChangesLater() {
        final List<GitLabPersonalAccessTokenCreateScopes> source =
                new ArrayList<>(List.of(GitLabPersonalAccessTokenCreateScopes.K8S_PROXY));
        final GitLabPersonalAccessTokenCreatePayload built = GitLabPersonalAccessTokenCreatePayloadBuilder.builder(
                        PersonalaccesstokensCatalogFixtures.personalAccessTokenCreatePayload())
                .scopes(source)
                .build();
        source.clear();

        assertThat(built.scopes()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenScopesIsRead() {
        final GitLabPersonalAccessTokenCreatePayload built =
                PersonalaccesstokensCatalogFixtures.personalAccessTokenCreatePayload();
        final List<GitLabPersonalAccessTokenCreateScopes> values = built.scopes();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPersonalAccessTokenCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "description", "expiresAt", "granularScopes", "scopes");
    }
}
