package io.github.piotr_janczukowicz.gitlab.api.orbit;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOrbitApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabOrbitApi api() {
        return new GitLabOrbitApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabOrbitApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void context_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabOrbitApi lowTier = new GitLabOrbitApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.context(OrbitCatalogFixtures.orbitContextPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void context_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabOrbitApi lowTier = new GitLabOrbitApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.context(OrbitCatalogFixtures.orbitContextPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void context_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabOrbitContext.class, "orbit-context.json")));

        final GitLabOrbitContext result = api().context(OrbitCatalogFixtures.orbitContextPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(OrbitCatalogFixtures.orbitContext());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/orbit/context");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"tokens\":");
        });
    }

    @Test
    void context_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().context(OrbitCatalogFixtures.orbitContextPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getSkills_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabOrbitSkillCollection.class, "orbit-skill-collection.json")));

        final GitLabOrbitSkillCollection result = api().getSkills();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(OrbitCatalogFixtures.orbitSkillCollection());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/orbit/skills");
        });
    }

    @Test
    void getSkills_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getSkills());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getSkill_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabOrbitSkill.class, "orbit-skill.json")));

        final Optional<GitLabOrbitSkill> result = api().getSkill("name");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(OrbitCatalogFixtures.orbitSkill());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/orbit/skills/name");
        });
    }

    @Test
    void getSkill_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabOrbitSkill> result = api().getSkill("name");

        assertThat(result).isEmpty();
    }

    @Test
    void getSkillByPath_shouldReturnTheText_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, "echo hi"));

        final String text = api().getSkillByPath("name", "path");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(text).isEqualTo("echo hi");
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/orbit/skills/name/path");
        });
    }
}
