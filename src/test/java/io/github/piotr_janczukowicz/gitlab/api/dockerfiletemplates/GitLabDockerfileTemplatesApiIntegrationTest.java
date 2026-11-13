package io.github.piotr_janczukowicz.gitlab.api.dockerfiletemplates;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabTemplate;
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
class GitLabDockerfileTemplatesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/templates/dockerfiles",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabTemplateList.class, "template-list.json") + "]")
                        .header("Link", "<" + base + "/api/v4/templates/dockerfiles?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabTemplateList.class, "template-list.json") + "]"));

        final List<GitLabTemplateList> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabDockerfileTemplatesApi(GitLabCaller.of(client))
                    .list()
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.templateList(), CommonCatalogFixtures.templateList());
        HTTP.verifyRequested(GET, "/api/v4/templates/dockerfiles", 2);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/templates/dockerfiles/name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabTemplate.class, "template.json")));

        final Optional<GitLabTemplate> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabDockerfileTemplatesApi(GitLabCaller.of(client)).get("name");
        }

        assertThat(result).contains(CommonCatalogFixtures.template());
        HTTP.verifyRequested(GET, "/api/v4/templates/dockerfiles/name");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/templates/dockerfiles/name", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabDockerfileTemplatesApi(GitLabCaller.of(client))
                    .get("name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/templates/dockerfiles/name");
    }
}
