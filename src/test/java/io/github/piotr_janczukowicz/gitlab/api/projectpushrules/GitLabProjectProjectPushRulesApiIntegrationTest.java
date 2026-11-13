package io.github.piotr_janczukowicz.gitlab.api.projectpushrules;

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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectProjectPushRulesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/push_rule",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectPushRule.class, "project-push-rule.json")));

        final GitLabProjectPushRule result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectPushRulesApi(GitLabCaller.of(client)).get("group/sub/project");
        }

        assertThat(result).isEqualTo(ProjectpushrulesCatalogFixtures.projectPushRule());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/push_rule");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/push_rule", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectPushRulesApi api = new GitLabProjectProjectPushRulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.get("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/push_rule");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/push_rule",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectPushRule.class, "project-push-rule.json")));

        final GitLabProjectPushRule result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectPushRulesApi(GitLabCaller.of(client))
                    .create(
                            "group/sub/project",
                            ProjectpushrulesCatalogFixtures.projectProjectPushRulesCreatePayload());
        }

        assertThat(result).isEqualTo(ProjectpushrulesCatalogFixtures.projectPushRule());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/push_rule");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/push_rule", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectPushRulesApi api = new GitLabProjectProjectPushRulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project", ProjectpushrulesCatalogFixtures.projectProjectPushRulesCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/push_rule");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/push_rule",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectPushRule.class, "project-push-rule.json")));

        final GitLabProjectPushRule result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectPushRulesApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            ProjectpushrulesCatalogFixtures.projectProjectPushRulesUpdatePayload());
        }

        assertThat(result).isEqualTo(ProjectpushrulesCatalogFixtures.projectPushRule());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/push_rule");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/push_rule", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectPushRulesApi api = new GitLabProjectProjectPushRulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project", ProjectpushrulesCatalogFixtures.projectProjectPushRulesUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/push_rule");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/push_rule", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectPushRulesApi(GitLabCaller.of(client)).delete("group/sub/project");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/push_rule");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/push_rule", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectPushRulesApi api = new GitLabProjectProjectPushRulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/push_rule");
    }
}
