package io.github.piotr_janczukowicz.gitlab.api.resourcegroup;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiJobBasic;
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
class GitLabProjectResourceGroupApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/resource_groups",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabCiResourceGroup.class, "ci-resource-group.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/resource_groups?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCiResourceGroup.class, "ci-resource-group.json") + "]"));

        final List<GitLabCiResourceGroup> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectResourceGroupApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        ResourcegroupCatalogFixtures.ciResourceGroup(), ResourcegroupCatalogFixtures.ciResourceGroup());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/resource_groups", 2);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/resource_groups/key",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiResourceGroup.class, "ci-resource-group.json")));

        final Optional<GitLabCiResourceGroup> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectResourceGroupApi(GitLabCaller.of(client)).get("group/sub/project", "key");
        }

        assertThat(result).contains(ResourcegroupCatalogFixtures.ciResourceGroup());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/resource_groups/key");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/resource_groups/key", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectResourceGroupApi(GitLabCaller.of(client))
                    .get("group/sub/project", "key")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/resource_groups/key");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/resource_groups/key",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiResourceGroup.class, "ci-resource-group.json")));

        final GitLabCiResourceGroup result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectResourceGroupApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            "key",
                            ResourcegroupCatalogFixtures.projectResourceGroupUpdatePayload());
        }

        assertThat(result).isEqualTo(ResourcegroupCatalogFixtures.ciResourceGroup());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/resource_groups/key");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/resource_groups/key", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectResourceGroupApi api = new GitLabProjectResourceGroupApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project", "key", ResourcegroupCatalogFixtures.projectResourceGroupUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/resource_groups/key");
    }

    @Test
    void getCurrentJob_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/resource_groups/key/current_job",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiJobBasic.class, "ci-job-basic.json")));

        final Optional<GitLabCiJobBasic> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectResourceGroupApi(GitLabCaller.of(client))
                    .getCurrentJob("group/sub/project", "key");
        }

        assertThat(result).contains(CommonCatalogFixtures.ciJobBasic());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/resource_groups/key/current_job");
    }

    @Test
    void getCurrentJob_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/resource_groups/key/current_job",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectResourceGroupApi(GitLabCaller.of(client))
                    .getCurrentJob("group/sub/project", "key")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/resource_groups/key/current_job");
    }

    @Test
    void listUpcomingJobs_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/resource_groups/key/upcoming_jobs",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabCiJobBasic.class, "ci-job-basic.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/resource_groups/key/upcoming_jobs?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCiJobBasic.class, "ci-job-basic.json") + "]"));

        final List<GitLabCiJobBasic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectResourceGroupApi(GitLabCaller.of(client))
                    .listUpcomingJobs("group/sub/project", "key")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.ciJobBasic(), CommonCatalogFixtures.ciJobBasic());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/resource_groups/key/upcoming_jobs", 2);
    }
}
