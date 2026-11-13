package io.github.piotr_janczukowicz.gitlab.api.customattributes;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCustomAttribute;
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
class GitLabGroupCustomAttributesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/custom_attributes",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCustomAttribute.class, "custom-attribute.json") + "]"));

        final List<GitLabCustomAttribute> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupCustomAttributesApi(GitLabCaller.of(client)).list("group/sub/project");
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.customAttribute());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/custom_attributes");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/custom_attributes/key",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCustomAttribute.class, "custom-attribute.json")));

        final Optional<GitLabCustomAttribute> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupCustomAttributesApi(GitLabCaller.of(client)).get("group/sub/project", "key");
        }

        assertThat(result).contains(CommonCatalogFixtures.customAttribute());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/custom_attributes/key");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/custom_attributes/key", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupCustomAttributesApi(GitLabCaller.of(client))
                    .get("group/sub/project", "key")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/custom_attributes/key");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/custom_attributes/key",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCustomAttribute.class, "custom-attribute.json")));

        final GitLabCustomAttribute result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupCustomAttributesApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            "key",
                            CustomattributesCatalogFixtures.groupCustomAttributesUpdatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.customAttribute());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/custom_attributes/key");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/custom_attributes/key", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupCustomAttributesApi api = new GitLabGroupCustomAttributesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project", "key", CustomattributesCatalogFixtures.groupCustomAttributesUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/custom_attributes/key");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE, "/api/v4/groups/group%2Fsub%2Fproject/custom_attributes/key", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupCustomAttributesApi(GitLabCaller.of(client)).delete("group/sub/project", "key");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/custom_attributes/key");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE, "/api/v4/groups/group%2Fsub%2Fproject/custom_attributes/key", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupCustomAttributesApi api = new GitLabGroupCustomAttributesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "key"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/custom_attributes/key");
    }
}
