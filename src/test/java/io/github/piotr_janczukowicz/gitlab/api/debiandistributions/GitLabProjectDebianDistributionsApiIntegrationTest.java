package io.github.piotr_janczukowicz.gitlab.api.debiandistributions;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPackageDebianDistribution;
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
class GitLabProjectDebianDistributionsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabPackageDebianDistribution.class, "package-debian-distribution.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabPackageDebianDistribution.class, "package-debian-distribution.json")
                        + "]"));

        final List<GitLabPackageDebianDistribution> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectDebianDistributionsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        CommonCatalogFixtures.packageDebianDistribution(),
                        CommonCatalogFixtures.packageDebianDistribution());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageDebianDistribution.class, "package-debian-distribution.json")));

        final GitLabPackageDebianDistribution result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDebianDistributionsApi(GitLabCaller.of(client))
                    .create(
                            "group/sub/project",
                            DebiandistributionsCatalogFixtures.projectDebianDistributionsCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.packageDebianDistribution());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDebianDistributionsApi api =
                    new GitLabProjectDebianDistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project", DebiandistributionsCatalogFixtures.projectDebianDistributionsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions/codename",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageDebianDistribution.class, "package-debian-distribution.json")));

        final Optional<GitLabPackageDebianDistribution> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDebianDistributionsApi(GitLabCaller.of(client))
                    .get("group/sub/project", "codename");
        }

        assertThat(result).contains(CommonCatalogFixtures.packageDebianDistribution());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions/codename");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions/codename",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectDebianDistributionsApi(GitLabCaller.of(client))
                    .get("group/sub/project", "codename")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions/codename");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions/codename",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageDebianDistribution.class, "package-debian-distribution.json")));

        final GitLabPackageDebianDistribution result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDebianDistributionsApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            "codename",
                            DebiandistributionsCatalogFixtures.projectDebianDistributionsUpdatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.packageDebianDistribution());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions/codename");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions/codename",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDebianDistributionsApi api =
                    new GitLabProjectDebianDistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    "codename",
                    DebiandistributionsCatalogFixtures.projectDebianDistributionsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions/codename");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions/codename",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectDebianDistributionsApi(GitLabCaller.of(client)).delete("group/sub/project", "codename");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions/codename");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions/codename",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDebianDistributionsApi api =
                    new GitLabProjectDebianDistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "codename"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions/codename");
    }

    @Test
    void getKeyAsc_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions/codename/key.asc",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageDebianDistribution.class, "package-debian-distribution.json")));

        final Optional<GitLabPackageDebianDistribution> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDebianDistributionsApi(GitLabCaller.of(client))
                    .getKeyAsc("group/sub/project", "codename");
        }

        assertThat(result).contains(CommonCatalogFixtures.packageDebianDistribution());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions/codename/key.asc");
    }

    @Test
    void getKeyAsc_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions/codename/key.asc",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectDebianDistributionsApi(GitLabCaller.of(client))
                    .getKeyAsc("group/sub/project", "codename")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/debian_distributions/codename/key.asc");
    }
}
