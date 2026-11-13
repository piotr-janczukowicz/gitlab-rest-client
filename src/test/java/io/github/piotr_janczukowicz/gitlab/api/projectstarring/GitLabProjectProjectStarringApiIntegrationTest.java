package io.github.piotr_janczukowicz.gitlab.api.projectstarring;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProject;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectProjectStarringApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void createStar_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/star",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProject.class, "project.json")));

        final GitLabProject result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectStarringApi(GitLabCaller.of(client)).createStar("group/sub/project");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.project());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/star");
    }

    @Test
    void createStar_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/star", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectStarringApi api = new GitLabProjectProjectStarringApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createStar("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/star");
    }

    @Test
    void createUnstar_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/unstar",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProject.class, "project.json")));

        final GitLabProject result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectStarringApi(GitLabCaller.of(client)).createUnstar("group/sub/project");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.project());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/unstar");
    }

    @Test
    void createUnstar_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/unstar", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectStarringApi api = new GitLabProjectProjectStarringApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createUnstar("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/unstar");
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/starrers",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/projects/group%2Fsub%2Fproject/starrers?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final List<GitLabUserBasic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectStarringApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.userBasic(), CommonCatalogFixtures.userBasic());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/starrers", 2);
    }
}
