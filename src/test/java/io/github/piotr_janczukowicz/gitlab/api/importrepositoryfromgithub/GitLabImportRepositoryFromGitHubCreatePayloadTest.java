package io.github.piotr_janczukowicz.gitlab.api.importrepositoryfromgithub;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabImportRepositoryFromGitHubCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenPersonalAccessTokenIsNullable() {
        final GitLabImportRepositoryFromGitHubCreatePayloadBuilder builder =
                GitLabImportRepositoryFromGitHubCreatePayloadBuilder.builder(
                                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload())
                        .personalAccessToken(null);

        final GitLabImportRepositoryFromGitHubCreatePayload built = builder.build();

        assertThat(built.personalAccessToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepoIdIsNullable() {
        final GitLabImportRepositoryFromGitHubCreatePayloadBuilder builder =
                GitLabImportRepositoryFromGitHubCreatePayloadBuilder.builder(
                                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload())
                        .repoId(null);

        final GitLabImportRepositoryFromGitHubCreatePayload built = builder.build();

        assertThat(built.repoId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewNameIsNullable() {
        final GitLabImportRepositoryFromGitHubCreatePayloadBuilder builder =
                GitLabImportRepositoryFromGitHubCreatePayloadBuilder.builder(
                                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload())
                        .newName(null);

        final GitLabImportRepositoryFromGitHubCreatePayload built = builder.build();

        assertThat(built.newName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetNamespaceIsNullable() {
        final GitLabImportRepositoryFromGitHubCreatePayloadBuilder builder =
                GitLabImportRepositoryFromGitHubCreatePayloadBuilder.builder(
                                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload())
                        .targetNamespace(null);

        final GitLabImportRepositoryFromGitHubCreatePayload built = builder.build();

        assertThat(built.targetNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGithubHostnameIsNullable() {
        final GitLabImportRepositoryFromGitHubCreatePayloadBuilder builder =
                GitLabImportRepositoryFromGitHubCreatePayloadBuilder.builder(
                                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload())
                        .githubHostname(null);

        final GitLabImportRepositoryFromGitHubCreatePayload built = builder.build();

        assertThat(built.githubHostname()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOptionalStagesIsNullable() {
        final GitLabImportRepositoryFromGitHubCreatePayloadBuilder builder =
                GitLabImportRepositoryFromGitHubCreatePayloadBuilder.builder(
                                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload())
                        .optionalStages(null);

        final GitLabImportRepositoryFromGitHubCreatePayload built = builder.build();

        assertThat(built.optionalStages()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimeoutStrategyIsNullable() {
        final GitLabImportRepositoryFromGitHubCreatePayloadBuilder builder =
                GitLabImportRepositoryFromGitHubCreatePayloadBuilder.builder(
                                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload())
                        .timeoutStrategy(null);

        final GitLabImportRepositoryFromGitHubCreatePayload built = builder.build();

        assertThat(built.timeoutStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPaginationLimitIsNullable() {
        final GitLabImportRepositoryFromGitHubCreatePayloadBuilder builder =
                GitLabImportRepositoryFromGitHubCreatePayloadBuilder.builder(
                                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload())
                        .paginationLimit(null);

        final GitLabImportRepositoryFromGitHubCreatePayload built = builder.build();

        assertThat(built.paginationLimit()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenPaginationLimitIsBelowTheMinimum() {
        final GitLabImportRepositoryFromGitHubCreatePayloadBuilder builder =
                GitLabImportRepositoryFromGitHubCreatePayloadBuilder.builder(
                                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload())
                        .paginationLimit(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenPaginationLimitIsTheMinimum() {
        final GitLabImportRepositoryFromGitHubCreatePayloadBuilder builder =
                GitLabImportRepositoryFromGitHubCreatePayloadBuilder.builder(
                                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload())
                        .paginationLimit(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenPaginationLimitIsAboveTheMaximum() {
        final GitLabImportRepositoryFromGitHubCreatePayloadBuilder builder =
                GitLabImportRepositoryFromGitHubCreatePayloadBuilder.builder(
                                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload())
                        .paginationLimit(101);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenPaginationLimitIsTheMaximum() {
        final GitLabImportRepositoryFromGitHubCreatePayloadBuilder builder =
                GitLabImportRepositoryFromGitHubCreatePayloadBuilder.builder(
                                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload())
                        .paginationLimit(100);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabImportRepositoryFromGitHubCreatePayload value =
                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.personalAccessToken()).isEqualTo("personal_access_token");
            softly.assertThat(value.repoId()).isEqualTo(1L);
            softly.assertThat(value.newName()).isEqualTo("new_name");
            softly.assertThat(value.targetNamespace()).isEqualTo("target_namespace");
            softly.assertThat(value.githubHostname()).isEqualTo("github_hostname");
            softly.assertThat(value.optionalStages()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.timeoutStrategy())
                    .isEqualTo(GitLabImportRepositoryFromGitHubCreateTimeoutStrategy.OPTIMISTIC);
            softly.assertThat(value.paginationLimit()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabImportRepositoryFromGitHubCreatePayload original =
                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload();

        final GitLabImportRepositoryFromGitHubCreatePayload rebuilt =
                GitLabImportRepositoryFromGitHubCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenOptionalStagesSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabImportRepositoryFromGitHubCreatePayload built =
                GitLabImportRepositoryFromGitHubCreatePayloadBuilder.builder(
                                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload())
                        .optionalStages(source)
                        .build();
        source.clear();

        assertThat(built.optionalStages()).isNotEmpty();
    }

    @Test
    void toString_shouldMaskTheValue_whenPersonalAccessTokenIsACredential() {
        final GitLabImportRepositoryFromGitHubCreatePayload value =
                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabImportRepositoryFromGitHubCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "personalAccessToken",
                        "repoId",
                        "newName",
                        "targetNamespace",
                        "githubHostname",
                        "optionalStages",
                        "timeoutStrategy",
                        "paginationLimit");
    }
}
