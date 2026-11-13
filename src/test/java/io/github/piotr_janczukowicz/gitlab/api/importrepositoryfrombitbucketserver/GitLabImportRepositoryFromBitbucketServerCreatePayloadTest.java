package io.github.piotr_janczukowicz.gitlab.api.importrepositoryfrombitbucketserver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabImportRepositoryFromBitbucketServerCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBitbucketServerUrlIsNullable() {
        final GitLabImportRepositoryFromBitbucketServerCreatePayloadBuilder builder =
                GitLabImportRepositoryFromBitbucketServerCreatePayloadBuilder.builder(
                                ImportrepositoryfrombitbucketserverCatalogFixtures
                                        .importRepositoryFromBitbucketServerCreatePayload())
                        .bitbucketServerUrl(null);

        final GitLabImportRepositoryFromBitbucketServerCreatePayload built = builder.build();

        assertThat(built.bitbucketServerUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBitbucketServerUsernameIsNullable() {
        final GitLabImportRepositoryFromBitbucketServerCreatePayloadBuilder builder =
                GitLabImportRepositoryFromBitbucketServerCreatePayloadBuilder.builder(
                                ImportrepositoryfrombitbucketserverCatalogFixtures
                                        .importRepositoryFromBitbucketServerCreatePayload())
                        .bitbucketServerUsername(null);

        final GitLabImportRepositoryFromBitbucketServerCreatePayload built = builder.build();

        assertThat(built.bitbucketServerUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPersonalAccessTokenIsNullable() {
        final GitLabImportRepositoryFromBitbucketServerCreatePayloadBuilder builder =
                GitLabImportRepositoryFromBitbucketServerCreatePayloadBuilder.builder(
                                ImportrepositoryfrombitbucketserverCatalogFixtures
                                        .importRepositoryFromBitbucketServerCreatePayload())
                        .personalAccessToken(null);

        final GitLabImportRepositoryFromBitbucketServerCreatePayload built = builder.build();

        assertThat(built.personalAccessToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBitbucketServerProjectIsNullable() {
        final GitLabImportRepositoryFromBitbucketServerCreatePayloadBuilder builder =
                GitLabImportRepositoryFromBitbucketServerCreatePayloadBuilder.builder(
                                ImportrepositoryfrombitbucketserverCatalogFixtures
                                        .importRepositoryFromBitbucketServerCreatePayload())
                        .bitbucketServerProject(null);

        final GitLabImportRepositoryFromBitbucketServerCreatePayload built = builder.build();

        assertThat(built.bitbucketServerProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBitbucketServerRepoIsNullable() {
        final GitLabImportRepositoryFromBitbucketServerCreatePayloadBuilder builder =
                GitLabImportRepositoryFromBitbucketServerCreatePayloadBuilder.builder(
                                ImportrepositoryfrombitbucketserverCatalogFixtures
                                        .importRepositoryFromBitbucketServerCreatePayload())
                        .bitbucketServerRepo(null);

        final GitLabImportRepositoryFromBitbucketServerCreatePayload built = builder.build();

        assertThat(built.bitbucketServerRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewNameIsNullable() {
        final GitLabImportRepositoryFromBitbucketServerCreatePayloadBuilder builder =
                GitLabImportRepositoryFromBitbucketServerCreatePayloadBuilder.builder(
                                ImportrepositoryfrombitbucketserverCatalogFixtures
                                        .importRepositoryFromBitbucketServerCreatePayload())
                        .newName(null);

        final GitLabImportRepositoryFromBitbucketServerCreatePayload built = builder.build();

        assertThat(built.newName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewNamespaceIsNullable() {
        final GitLabImportRepositoryFromBitbucketServerCreatePayloadBuilder builder =
                GitLabImportRepositoryFromBitbucketServerCreatePayloadBuilder.builder(
                                ImportrepositoryfrombitbucketserverCatalogFixtures
                                        .importRepositoryFromBitbucketServerCreatePayload())
                        .newNamespace(null);

        final GitLabImportRepositoryFromBitbucketServerCreatePayload built = builder.build();

        assertThat(built.newNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimeoutStrategyIsNullable() {
        final GitLabImportRepositoryFromBitbucketServerCreatePayloadBuilder builder =
                GitLabImportRepositoryFromBitbucketServerCreatePayloadBuilder.builder(
                                ImportrepositoryfrombitbucketserverCatalogFixtures
                                        .importRepositoryFromBitbucketServerCreatePayload())
                        .timeoutStrategy(null);

        final GitLabImportRepositoryFromBitbucketServerCreatePayload built = builder.build();

        assertThat(built.timeoutStrategy()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabImportRepositoryFromBitbucketServerCreatePayload value =
                ImportrepositoryfrombitbucketserverCatalogFixtures.importRepositoryFromBitbucketServerCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.bitbucketServerUrl()).isEqualTo("bitbucket_server_url");
            softly.assertThat(value.bitbucketServerUsername()).isEqualTo("bitbucket_server_username");
            softly.assertThat(value.personalAccessToken()).isEqualTo("personal_access_token");
            softly.assertThat(value.bitbucketServerProject()).isEqualTo("bitbucket_server_project");
            softly.assertThat(value.bitbucketServerRepo()).isEqualTo("bitbucket_server_repo");
            softly.assertThat(value.newName()).isEqualTo("new_name");
            softly.assertThat(value.newNamespace()).isEqualTo("new_namespace");
            softly.assertThat(value.timeoutStrategy())
                    .isEqualTo(GitLabImportRepositoryFromBitbucketServerCreateTimeoutStrategy.OPTIMISTIC);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabImportRepositoryFromBitbucketServerCreatePayload original =
                ImportrepositoryfrombitbucketserverCatalogFixtures.importRepositoryFromBitbucketServerCreatePayload();

        final GitLabImportRepositoryFromBitbucketServerCreatePayload rebuilt =
                GitLabImportRepositoryFromBitbucketServerCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPersonalAccessTokenIsACredential() {
        final GitLabImportRepositoryFromBitbucketServerCreatePayload value =
                ImportrepositoryfrombitbucketserverCatalogFixtures.importRepositoryFromBitbucketServerCreatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabImportRepositoryFromBitbucketServerCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "bitbucketServerUrl",
                        "bitbucketServerUsername",
                        "personalAccessToken",
                        "bitbucketServerProject",
                        "bitbucketServerRepo",
                        "newName",
                        "newNamespace",
                        "timeoutStrategy");
    }
}
