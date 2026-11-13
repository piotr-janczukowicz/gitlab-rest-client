package io.github.piotr_janczukowicz.gitlab.api.composerdistributions;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectComposerDistributionsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void callGroupPackagesComposerPackages_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/group/group%2Fsub%2Fproject/-/packages/composer/packages",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectComposerDistributionsApi(GitLabCaller.of(client))
                    .callGroupPackagesComposerPackages("group/sub/project");
        }

        HTTP.verifyRequested(GET, "/api/v4/group/group%2Fsub%2Fproject/-/packages/composer/packages");
    }

    @Test
    void callGroupPackagesComposerPackages_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/group/group%2Fsub%2Fproject/-/packages/composer/packages",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectComposerDistributionsApi api =
                    new GitLabProjectComposerDistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callGroupPackagesComposerPackages("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/group/group%2Fsub%2Fproject/-/packages/composer/packages");
    }

    @Test
    void callGroupPackagesComposerP_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET, "/api/v4/group/group%2Fsub%2Fproject/-/packages/composer/p/sha", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectComposerDistributionsApi(GitLabCaller.of(client))
                    .callGroupPackagesComposerP("group/sub/project", "sha");
        }

        HTTP.verifyRequested(GET, "/api/v4/group/group%2Fsub%2Fproject/-/packages/composer/p/sha");
    }

    @Test
    void callGroupPackagesComposerP_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET, "/api/v4/group/group%2Fsub%2Fproject/-/packages/composer/p/sha", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectComposerDistributionsApi api =
                    new GitLabProjectComposerDistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callGroupPackagesComposerP("group/sub/project", "sha"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/group/group%2Fsub%2Fproject/-/packages/composer/p/sha");
    }

    @Test
    void callGroupPackagesComposerP2_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/group/group%2Fsub%2Fproject/-/packages/composer/p2/package_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectComposerDistributionsApi(GitLabCaller.of(client))
                    .callGroupPackagesComposerP2("group/sub/project", "package_name");
        }

        HTTP.verifyRequested(GET, "/api/v4/group/group%2Fsub%2Fproject/-/packages/composer/p2/package_name");
    }

    @Test
    void callGroupPackagesComposerP2_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/group/group%2Fsub%2Fproject/-/packages/composer/p2/package_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectComposerDistributionsApi api =
                    new GitLabProjectComposerDistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callGroupPackagesComposerP2("group/sub/project", "package_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/group/group%2Fsub%2Fproject/-/packages/composer/p2/package_name");
    }

    @Test
    void callGroupPackagesComposer_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/group/group%2Fsub%2Fproject/-/packages/composer/package_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectComposerDistributionsApi(GitLabCaller.of(client))
                    .callGroupPackagesComposer("group/sub/project", "package_name");
        }

        HTTP.verifyRequested(GET, "/api/v4/group/group%2Fsub%2Fproject/-/packages/composer/package_name");
    }

    @Test
    void callGroupPackagesComposer_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/group/group%2Fsub%2Fproject/-/packages/composer/package_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectComposerDistributionsApi api =
                    new GitLabProjectComposerDistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callGroupPackagesComposer("group/sub/project", "package_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/group/group%2Fsub%2Fproject/-/packages/composer/package_name");
    }

    @Test
    void create_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/composer", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectComposerDistributionsApi(GitLabCaller.of(client))
                    .create(
                            "group/sub/project",
                            ComposerdistributionsCatalogFixtures.projectComposerDistributionsCreatePayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/composer");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/composer", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectComposerDistributionsApi api =
                    new GitLabProjectComposerDistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project",
                    ComposerdistributionsCatalogFixtures.projectComposerDistributionsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/composer");
    }

    @Test
    void callArchive_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/composer/archives/package_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectComposerDistributionsApi(GitLabCaller.of(client))
                    .callArchive("group/sub/project", "package_name", "sha");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/composer/archives/package_name");
    }

    @Test
    void callArchive_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/composer/archives/package_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectComposerDistributionsApi api =
                    new GitLabProjectComposerDistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callArchive("group/sub/project", "package_name", "sha"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/composer/archives/package_name");
    }
}
