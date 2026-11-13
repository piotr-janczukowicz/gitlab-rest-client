package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectFeatureFlagsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabFeatureFlag.class, "feature-flag.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/feature_flags?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabFeatureFlag.class, "feature-flag.json") + "]"));

        final List<GitLabFeatureFlag> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectFeatureFlagsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(FeatureflagsCatalogFixtures.featureFlag(), FeatureflagsCatalogFixtures.featureFlag());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabFeatureFlag.class, "feature-flag.json")));

        final GitLabFeatureFlag result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectFeatureFlagsApi(GitLabCaller.of(client))
                    .create("group/sub/project", FeatureflagsCatalogFixtures.projectFeatureFlagsCreatePayload());
        }

        assertThat(result).isEqualTo(FeatureflagsCatalogFixtures.featureFlag());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectFeatureFlagsApi api = new GitLabProjectFeatureFlagsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.create("group/sub/project", FeatureflagsCatalogFixtures.projectFeatureFlagsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags");
    }

    @Test
    void getFeatureFlagsSettings_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_settings",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabFeatureFlagSettings.class, "feature-flag-settings.json")));

        final GitLabFeatureFlagSettings result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectFeatureFlagsApi(GitLabCaller.of(client))
                    .getFeatureFlagsSettings("group/sub/project");
        }

        assertThat(result).isEqualTo(FeatureflagsCatalogFixtures.featureFlagSettings());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_settings");
    }

    @Test
    void getFeatureFlagsSettings_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_settings", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectFeatureFlagsApi api = new GitLabProjectFeatureFlagsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getFeatureFlagsSettings("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_settings");
    }

    @Test
    void updateFeatureFlagsSetting_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_settings",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabFeatureFlagSettings.class, "feature-flag-settings.json")));

        final GitLabFeatureFlagSettings result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectFeatureFlagsApi(GitLabCaller.of(client))
                    .updateFeatureFlagsSetting(
                            "group/sub/project",
                            FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateFeatureFlagsSettingPayload());
        }

        assertThat(result).isEqualTo(FeatureflagsCatalogFixtures.featureFlagSettings());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_settings");
    }

    @Test
    void updateFeatureFlagsSetting_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_settings", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectFeatureFlagsApi api = new GitLabProjectFeatureFlagsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateFeatureFlagsSetting(
                    "group/sub/project",
                    FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateFeatureFlagsSettingPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_settings");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags/feature_flag_name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabFeatureFlag.class, "feature-flag.json")));

        final Optional<GitLabFeatureFlag> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectFeatureFlagsApi(GitLabCaller.of(client))
                    .get("group/sub/project", "feature_flag_name");
        }

        assertThat(result).contains(FeatureflagsCatalogFixtures.featureFlag());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags/feature_flag_name");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags/feature_flag_name",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectFeatureFlagsApi(GitLabCaller.of(client))
                    .get("group/sub/project", "feature_flag_name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags/feature_flag_name");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags/feature_flag_name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabFeatureFlag.class, "feature-flag.json")));

        final GitLabFeatureFlag result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectFeatureFlagsApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            "feature_flag_name",
                            FeatureflagsCatalogFixtures.projectFeatureFlagsUpdatePayload());
        }

        assertThat(result).isEqualTo(FeatureflagsCatalogFixtures.featureFlag());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags/feature_flag_name");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags/feature_flag_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectFeatureFlagsApi api = new GitLabProjectFeatureFlagsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    "feature_flag_name",
                    FeatureflagsCatalogFixtures.projectFeatureFlagsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags/feature_flag_name");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags/feature_flag_name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabFeatureFlag.class, "feature-flag.json")));

        final Optional<GitLabFeatureFlag> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectFeatureFlagsApi(GitLabCaller.of(client))
                    .delete("group/sub/project", "feature_flag_name");
        }

        assertThat(result).contains(FeatureflagsCatalogFixtures.featureFlag());
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags/feature_flag_name");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags/feature_flag_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectFeatureFlagsApi api = new GitLabProjectFeatureFlagsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "feature_flag_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags/feature_flag_name");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags/feature_flag_name",
                GitLabApiStubSupport.noContent());

        final Optional<GitLabFeatureFlag> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectFeatureFlagsApi(GitLabCaller.of(client))
                    .delete("group/sub/project", "feature_flag_name");
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags/feature_flag_name");
    }
}
