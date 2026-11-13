package io.github.piotr_janczukowicz.gitlab.api.projecttemplates;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabLicense;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabTemplateList;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectProjectTemplatesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/templates/dockerfiles",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabTemplateList.class, "template-list.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/templates/dockerfiles?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabTemplateList.class, "template-list.json") + "]"));

        final List<GitLabTemplateList> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectTemplatesApi(GitLabCaller.of(client))
                    .list("group/sub/project", GitLabProjectProjectTemplatesListType.DOCKERFILES)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.templateList(), CommonCatalogFixtures.templateList());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/templates/dockerfiles", 2);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/templates/dockerfiles/name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabLicense.class, "license.json")));

        final Optional<GitLabLicense> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectTemplatesApi(GitLabCaller.of(client))
                    .get("group/sub/project", GitLabProjectProjectTemplatesGetType.DOCKERFILES, "name");
        }

        assertThat(result).contains(CommonCatalogFixtures.license());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/templates/dockerfiles/name");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/templates/dockerfiles/name",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectProjectTemplatesApi(GitLabCaller.of(client))
                    .get("group/sub/project", GitLabProjectProjectTemplatesGetType.DOCKERFILES, "name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/templates/dockerfiles/name");
    }
}
