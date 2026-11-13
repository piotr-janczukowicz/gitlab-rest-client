package io.github.piotr_janczukowicz.gitlab.api.jiraforgeinstallation;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicSuccess;
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
class GitLabJiraForgeInstallationApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void updateInstallation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/integrations/jira_forge/installation",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBasicSuccess.class, "basic-success.json")));

        final GitLabBasicSuccess result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabJiraForgeInstallationApi(GitLabCaller.of(client))
                    .updateInstallation(
                            JiraforgeinstallationCatalogFixtures.jiraForgeInstallationUpdateInstallationPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.basicSuccess());
        HTTP.verifyRequested(PUT, "/api/v4/integrations/jira_forge/installation");
    }

    @Test
    void updateInstallation_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/integrations/jira_forge/installation", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabJiraForgeInstallationApi api = new GitLabJiraForgeInstallationApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateInstallation(
                    JiraforgeinstallationCatalogFixtures.jiraForgeInstallationUpdateInstallationPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/integrations/jira_forge/installation");
    }

    @Test
    void deleteInstallation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/integrations/jira_forge/installation",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBasicSuccess.class, "basic-success.json")));

        final Optional<GitLabBasicSuccess> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabJiraForgeInstallationApi(GitLabCaller.of(client)).deleteInstallation();
        }

        assertThat(result).contains(CommonCatalogFixtures.basicSuccess());
        HTTP.verifyRequested(DELETE, "/api/v4/integrations/jira_forge/installation");
    }

    @Test
    void deleteInstallation_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/integrations/jira_forge/installation", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabJiraForgeInstallationApi api = new GitLabJiraForgeInstallationApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteInstallation());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/integrations/jira_forge/installation");
    }

    @Test
    void deleteInstallation_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/integrations/jira_forge/installation", GitLabApiStubSupport.noContent());

        final Optional<GitLabBasicSuccess> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabJiraForgeInstallationApi(GitLabCaller.of(client)).deleteInstallation();
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/integrations/jira_forge/installation");
    }

    @Test
    void forgeTokenInstallation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/integrations/jira_forge/installation/forge_token",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBasicSuccess.class, "basic-success.json")));

        final GitLabBasicSuccess result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabJiraForgeInstallationApi(GitLabCaller.of(client)).forgeTokenInstallation();
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.basicSuccess());
        HTTP.verifyRequested(POST, "/api/v4/integrations/jira_forge/installation/forge_token");
    }

    @Test
    void forgeTokenInstallation_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/integrations/jira_forge/installation/forge_token", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabJiraForgeInstallationApi api = new GitLabJiraForgeInstallationApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.forgeTokenInstallation());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/integrations/jira_forge/installation/forge_token");
    }
}
