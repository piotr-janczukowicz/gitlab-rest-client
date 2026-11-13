package io.github.piotr_janczukowicz.gitlab.api.freezeperiods;

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
class GitLabProjectFreezePeriodsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabFreezePeriod.class, "freeze-period.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabFreezePeriod.class, "freeze-period.json") + "]"));

        final List<GitLabFreezePeriod> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectFreezePeriodsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        FreezeperiodsCatalogFixtures.freezePeriod(), FreezeperiodsCatalogFixtures.freezePeriod());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabFreezePeriod.class, "freeze-period.json")));

        final GitLabFreezePeriod result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectFreezePeriodsApi(GitLabCaller.of(client))
                    .create("group/sub/project", FreezeperiodsCatalogFixtures.projectFreezePeriodsCreatePayload());
        }

        assertThat(result).isEqualTo(FreezeperiodsCatalogFixtures.freezePeriod());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectFreezePeriodsApi api = new GitLabProjectFreezePeriodsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.create("group/sub/project", FreezeperiodsCatalogFixtures.projectFreezePeriodsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabFreezePeriod.class, "freeze-period.json")));

        final Optional<GitLabFreezePeriod> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectFreezePeriodsApi(GitLabCaller.of(client)).get("group/sub/project", 1L);
        }

        assertThat(result).contains(FreezeperiodsCatalogFixtures.freezePeriod());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectFreezePeriodsApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabFreezePeriod.class, "freeze-period.json")));

        final GitLabFreezePeriod result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectFreezePeriodsApi(GitLabCaller.of(client))
                    .update("group/sub/project", 1L, FreezeperiodsCatalogFixtures.projectFreezePeriodsUpdatePayload());
        }

        assertThat(result).isEqualTo(FreezeperiodsCatalogFixtures.freezePeriod());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectFreezePeriodsApi api = new GitLabProjectFreezePeriodsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project", 1L, FreezeperiodsCatalogFixtures.projectFreezePeriodsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods/1");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabFreezePeriod.class, "freeze-period.json")));

        final Optional<GitLabFreezePeriod> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectFreezePeriodsApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        assertThat(result).contains(FreezeperiodsCatalogFixtures.freezePeriod());
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectFreezePeriodsApi api = new GitLabProjectFreezePeriodsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods/1");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabFreezePeriod> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectFreezePeriodsApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/freeze_periods/1");
    }
}
