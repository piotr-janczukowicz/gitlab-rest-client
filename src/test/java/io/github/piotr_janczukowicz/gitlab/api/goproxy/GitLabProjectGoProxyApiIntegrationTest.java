package io.github.piotr_janczukowicz.gitlab.api.goproxy;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectGoProxyApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void callVList_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/list",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectGoProxyApi(GitLabCaller.of(client)).callVList("group/sub/project", "module_name");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/list");
    }

    @Test
    void callVList_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/list",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectGoProxyApi api = new GitLabProjectGoProxyApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callVList("group/sub/project", "module_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/list");
    }

    @Test
    void getVModuleVersionInfo_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/module_version.info",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabGoModuleVersion.class, "go-module-version.json")));

        final Optional<GitLabGoModuleVersion> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectGoProxyApi(GitLabCaller.of(client))
                    .getVModuleVersionInfo("group/sub/project", "module_name", "module_version");
        }

        assertThat(result).contains(GoproxyCatalogFixtures.goModuleVersion());
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/module_version.info");
    }

    @Test
    void getVModuleVersionInfo_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/module_version.info",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectGoProxyApi(GitLabCaller.of(client))
                    .getVModuleVersionInfo("group/sub/project", "module_name", "module_version")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/module_version.info");
    }

    @Test
    void callVModuleVersionMod_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/module_version.mod",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectGoProxyApi(GitLabCaller.of(client))
                    .callVModuleVersionMod("group/sub/project", "module_name", "module_version");
        }

        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/module_version.mod");
    }

    @Test
    void callVModuleVersionMod_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/module_version.mod",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectGoProxyApi api = new GitLabProjectGoProxyApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.callVModuleVersionMod("group/sub/project", "module_name", "module_version"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/module_version.mod");
    }

    @Test
    void callVModuleVersionZip_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/module_version.zip",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectGoProxyApi(GitLabCaller.of(client))
                    .callVModuleVersionZip("group/sub/project", "module_name", "module_version");
        }

        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/module_version.zip");
    }

    @Test
    void callVModuleVersionZip_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/module_version.zip",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectGoProxyApi api = new GitLabProjectGoProxyApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.callVModuleVersionZip("group/sub/project", "module_name", "module_version"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/module_version.zip");
    }
}
