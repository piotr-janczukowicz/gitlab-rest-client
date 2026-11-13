package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabFeatureDefinition;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceFeatureFlagsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabInstanceFeatureFlagsApi api() {
        return new GitLabInstanceFeatureFlagsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabInstanceFeatureFlagsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabFeature.class, "feature.json") + "]"));

        final List<GitLabFeature> result = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(FeatureflagsCatalogFixtures.feature());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/features");
        });
    }

    @Test
    void listDefinitions_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabFeatureDefinition.class, "feature-definition.json") + "]"));

        final List<GitLabFeatureDefinition> result = api().listDefinitions();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(CommonCatalogFixtures.featureDefinition());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/features/definitions");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabFeature.class, "feature.json")));

        final GitLabFeature result =
                api().create("name", FeatureflagsCatalogFixtures.instanceFeatureFlagsCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(FeatureflagsCatalogFixtures.feature());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/features/name");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"value\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().create("name", FeatureflagsCatalogFixtures.instanceFeatureFlagsCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("name");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/features/name");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("name"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
