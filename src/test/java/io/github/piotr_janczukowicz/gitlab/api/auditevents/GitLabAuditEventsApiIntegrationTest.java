package io.github.piotr_janczukowicz.gitlab.api.auditevents;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabAuditEvent;
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
class GitLabAuditEventsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/audit_events",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabAuditEvent.class, "audit-event.json") + "]")
                        .header("Link", "<" + base + "/api/v4/audit_events?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabAuditEvent.class, "audit-event.json") + "]"));

        final List<GitLabAuditEvent> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabAuditEventsApi(GitLabCaller.of(client))
                    .list(GitLabAuditEventsListEntityType.PROJECT)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.auditEvent(), CommonCatalogFixtures.auditEvent());
        HTTP.verifyRequested(GET, "/api/v4/audit_events", 2);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/audit_events/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAuditEvent.class, "audit-event.json")));

        final Optional<GitLabAuditEvent> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabAuditEventsApi(GitLabCaller.of(client)).get(1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.auditEvent());
        HTTP.verifyRequested(GET, "/api/v4/audit_events/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/audit_events/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabAuditEventsApi(GitLabCaller.of(client)).get(1L).isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/audit_events/1");
    }
}
