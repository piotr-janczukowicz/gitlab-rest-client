package io.github.piotr_janczukowicz.gitlab.api.userapplications;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabApplication;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabApplicationWithSecret;
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
class GitLabUserApplicationsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/user/applications",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabApplication.class, "application.json") + "]"));

        final List<GitLabApplication> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUserApplicationsApi(GitLabCaller.of(client)).list();
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.application());
        HTTP.verifyRequested(GET, "/api/v4/user/applications");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/user/applications",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabApplicationWithSecret.class, "application-with-secret.json")));

        final GitLabApplicationWithSecret result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUserApplicationsApi(GitLabCaller.of(client))
                    .create(UserapplicationsCatalogFixtures.userApplicationsCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.applicationWithSecret());
        HTTP.verifyRequested(POST, "/api/v4/user/applications");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/user/applications", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUserApplicationsApi api = new GitLabUserApplicationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(UserapplicationsCatalogFixtures.userApplicationsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/user/applications");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/user/applications/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabApplication.class, "application.json")));

        final Optional<GitLabApplication> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUserApplicationsApi(GitLabCaller.of(client)).get(1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.application());
        HTTP.verifyRequested(GET, "/api/v4/user/applications/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/user/applications/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabUserApplicationsApi(GitLabCaller.of(client))
                    .get(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/user/applications/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/user/applications/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabApplication.class, "application.json")));

        final GitLabApplication result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUserApplicationsApi(GitLabCaller.of(client))
                    .update(1L, UserapplicationsCatalogFixtures.userApplicationsUpdatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.application());
        HTTP.verifyRequested(PUT, "/api/v4/user/applications/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/user/applications/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUserApplicationsApi api = new GitLabUserApplicationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.update(1L, UserapplicationsCatalogFixtures.userApplicationsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/user/applications/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/user/applications/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabUserApplicationsApi(GitLabCaller.of(client)).delete(1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/user/applications/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/user/applications/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUserApplicationsApi api = new GitLabUserApplicationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/user/applications/1");
    }
}
