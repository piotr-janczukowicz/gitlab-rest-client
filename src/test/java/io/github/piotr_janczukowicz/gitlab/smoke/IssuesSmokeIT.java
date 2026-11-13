package io.github.piotr_janczukowicz.gitlab.smoke;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.GitLab;
import io.github.piotr_janczukowicz.gitlab.api.issues.GitLabIssue;
import io.github.piotr_janczukowicz.gitlab.api.issues.GitLabProjectIssuesCreatePayloadBuilder;
import io.github.piotr_janczukowicz.gitlab.api.issues.GitLabProjectIssuesUpdatePayloadBuilder;
import io.github.piotr_janczukowicz.gitlab.api.issues.GitLabProjectIssuesUpdateStateEvent;
import io.github.piotr_janczukowicz.gitlab.api.labels.GitLabProjectLabelsCreatePayloadBuilder;
import io.github.piotr_janczukowicz.gitlab.api.labels.GitLabProjectLabelsDeleteFilterBuilder;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class IssuesSmokeIT {

    private static final SmokeEnvironment ENV = SmokeEnvironment.fromEnv();

    @BeforeAll
    static void requireToken() {
        ENV.requireConfigured();
    }

    @Test
    void issue_shouldRoundTrip_whenCreatedLabeledClosedAndDeleted() throws IOException {
        final GitLab gitLab = ENV.gitLab();
        final String labelName = ENV.name("issue-label");
        gitLab.labels()
                .create(
                        ENV.project(),
                        GitLabProjectLabelsCreatePayloadBuilder.builder()
                                .name(labelName)
                                .color("#ededed")
                                .build());
        Long iid = null;
        try {
            final GitLabIssue created = gitLab.issues()
                    .project()
                    .create(
                            ENV.project(),
                            GitLabProjectIssuesCreatePayloadBuilder.builder()
                                    .title(ENV.name("issue"))
                                    .description("created by a smoke test")
                                    .labels(List.of(labelName))
                                    .build());
            iid = created.iid();
            final GitLabIssue fetched =
                    gitLab.issues().project().get(ENV.project(), iid).orElseThrow();
            gitLab.issues()
                    .project()
                    .update(
                            ENV.project(),
                            iid,
                            GitLabProjectIssuesUpdatePayloadBuilder.builder()
                                    .stateEvent(GitLabProjectIssuesUpdateStateEvent.CLOSE)
                                    .labels(List.of())
                                    .build());
            final GitLabIssue closed =
                    gitLab.issues().project().get(ENV.project(), iid).orElseThrow();

            assertSoftly(softly -> {
                softly.assertThat(fetched.title()).isEqualTo(ENV.name("issue"));
                softly.assertThat(fetched.labels()).containsExactly(labelName);
                softly.assertThat(closed.state()).isEqualTo("closed");
                softly.assertThat(closed.labels()).isEmpty();
            });
        } finally {
            if (iid != null) {
                gitLab.issues().project().delete(ENV.project(), iid);
            }
            gitLab.labels()
                    .delete(
                            ENV.project(),
                            GitLabProjectLabelsDeleteFilterBuilder.builder()
                                    .name(labelName)
                                    .build());
        }
    }

    @Test
    void get_shouldBeEmpty_whenTheIssueWasDeleted() throws IOException {
        final GitLab gitLab = ENV.gitLab();
        final long iid = gitLab.issues()
                .project()
                .create(
                        ENV.project(),
                        GitLabProjectIssuesCreatePayloadBuilder.builder()
                                .title(ENV.name("gone"))
                                .build())
                .iid();
        gitLab.issues().project().delete(ENV.project(), iid);

        final Optional<GitLabIssue> issue = gitLab.issues().project().get(ENV.project(), iid);

        assertThat(issue).isEmpty();
    }
}
