package io.github.piotr_janczukowicz.gitlab.api.orbit;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
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
class GitLabOrbitApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void context_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/orbit/context",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabOrbitContext.class, "orbit-context.json")));

        final GitLabOrbitContext result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabOrbitApi(GitLabCaller.of(client)).context(OrbitCatalogFixtures.orbitContextPayload());
        }

        assertThat(result).isEqualTo(OrbitCatalogFixtures.orbitContext());
        HTTP.verifyRequested(POST, "/api/v4/orbit/context");
    }

    @Test
    void context_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/orbit/context", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabOrbitApi api = new GitLabOrbitApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.context(OrbitCatalogFixtures.orbitContextPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/orbit/context");
    }

    @Test
    void getSkills_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/orbit/skills",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabOrbitSkillCollection.class, "orbit-skill-collection.json")));

        final GitLabOrbitSkillCollection result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabOrbitApi(GitLabCaller.of(client)).getSkills();
        }

        assertThat(result).isEqualTo(OrbitCatalogFixtures.orbitSkillCollection());
        HTTP.verifyRequested(GET, "/api/v4/orbit/skills");
    }

    @Test
    void getSkills_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/orbit/skills", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabOrbitApi api = new GitLabOrbitApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getSkills());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/orbit/skills");
    }

    @Test
    void getSkill_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/orbit/skills/name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabOrbitSkill.class, "orbit-skill.json")));

        final Optional<GitLabOrbitSkill> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabOrbitApi(GitLabCaller.of(client)).getSkill("name");
        }

        assertThat(result).contains(OrbitCatalogFixtures.orbitSkill());
        HTTP.verifyRequested(GET, "/api/v4/orbit/skills/name");
    }

    @Test
    void getSkill_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/orbit/skills/name", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabOrbitApi(GitLabCaller.of(client)).getSkill("name").isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/orbit/skills/name");
    }

    @Test
    void getSkillByPath_shouldReturnTheText_whenResponseIsOk() throws Exception {
        HTTP.stub(GET, "/api/v4/orbit/skills/name/path", GitLabApiStubSupport.okJson("echo hi"));

        final String text;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            text = new GitLabOrbitApi(GitLabCaller.of(client)).getSkillByPath("name", "path");
        }

        assertThat(text).isEqualTo("echo hi");
        HTTP.verifyRequested(GET, "/api/v4/orbit/skills/name/path");
    }
}
