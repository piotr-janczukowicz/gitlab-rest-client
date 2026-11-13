package io.github.piotr_janczukowicz.gitlab.api.applications;

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
class GitLabApplicationsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabApplicationsCreatePayloadBuilder builder = GitLabApplicationsCreatePayloadBuilder.builder(
                        ApplicationsCatalogFixtures.applicationsCreatePayload())
                .name(null);

        final GitLabApplicationsCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRedirectUriIsNullable() {
        final GitLabApplicationsCreatePayloadBuilder builder = GitLabApplicationsCreatePayloadBuilder.builder(
                        ApplicationsCatalogFixtures.applicationsCreatePayload())
                .redirectUri(null);

        final GitLabApplicationsCreatePayload built = builder.build();

        assertThat(built.redirectUri()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopesIsNullable() {
        final GitLabApplicationsCreatePayloadBuilder builder = GitLabApplicationsCreatePayloadBuilder.builder(
                        ApplicationsCatalogFixtures.applicationsCreatePayload())
                .scopes(null);

        final GitLabApplicationsCreatePayload built = builder.build();

        assertThat(built.scopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabApplicationsCreatePayloadBuilder builder = GitLabApplicationsCreatePayloadBuilder.builder(
                        ApplicationsCatalogFixtures.applicationsCreatePayload())
                .confidential(null);

        final GitLabApplicationsCreatePayload built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularScopesIsNullable() {
        final GitLabApplicationsCreatePayloadBuilder builder = GitLabApplicationsCreatePayloadBuilder.builder(
                        ApplicationsCatalogFixtures.applicationsCreatePayload())
                .granularScopes(null);

        final GitLabApplicationsCreatePayload built = builder.build();

        assertThat(built.granularScopes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationsCreatePayload value = ApplicationsCatalogFixtures.applicationsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("MyApplication");
            softly.assertThat(value.redirectUri()).isEqualTo("https://redirect.uri");
            softly.assertThat(value.scopes()).isEqualTo("scopes");
            softly.assertThat(value.confidential()).isEqualTo(true);
            softly.assertThat(value.granularScopes())
                    .isEqualTo(List.of(ApplicationsCatalogFixtures.applicationsCreateGranularScope()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationsCreatePayload original = ApplicationsCatalogFixtures.applicationsCreatePayload();

        final GitLabApplicationsCreatePayload rebuilt =
                GitLabApplicationsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenGranularScopesSourceChangesLater() {
        final List<GitLabApplicationsCreateGranularScope> source =
                new ArrayList<>(List.of(ApplicationsCatalogFixtures.applicationsCreateGranularScope()));
        final GitLabApplicationsCreatePayload built = GitLabApplicationsCreatePayloadBuilder.builder(
                        ApplicationsCatalogFixtures.applicationsCreatePayload())
                .granularScopes(source)
                .build();
        source.clear();

        assertThat(built.granularScopes()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGranularScopesIsRead() {
        final GitLabApplicationsCreatePayload built = ApplicationsCatalogFixtures.applicationsCreatePayload();
        final List<GitLabApplicationsCreateGranularScope> values = built.granularScopes();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "redirectUri", "scopes", "confidential", "granularScopes");
    }
}
