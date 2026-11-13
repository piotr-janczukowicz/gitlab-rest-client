package io.github.piotr_janczukowicz.gitlab.smoke;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.GitLab;
import io.github.piotr_janczukowicz.gitlab.api.labels.GitLabProjectLabel;
import io.github.piotr_janczukowicz.gitlab.api.labels.GitLabProjectLabelsCreatePayloadBuilder;
import io.github.piotr_janczukowicz.gitlab.api.labels.GitLabProjectLabelsDeleteFilterBuilder;
import io.github.piotr_janczukowicz.gitlab.api.labels.GitLabProjectLabelsUpdatePayloadBuilder;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import java.io.IOException;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class LabelsSmokeIT {

    private static final SmokeEnvironment ENV = SmokeEnvironment.fromEnv();

    @BeforeAll
    static void requireToken() {
        ENV.requireConfigured();
    }

    private static GitLabProjectLabel create(final GitLab gitLab, final String name) throws IOException {
        return gitLab.labels()
                .create(
                        ENV.project(),
                        GitLabProjectLabelsCreatePayloadBuilder.builder()
                                .name(name)
                                .color("#ededed")
                                .description("created by a smoke test")
                                .build());
    }

    private static void delete(final GitLab gitLab, final String name) throws IOException {
        gitLab.labels()
                .delete(
                        ENV.project(),
                        GitLabProjectLabelsDeleteFilterBuilder.builder()
                                .name(name)
                                .build());
    }

    @Test
    void label_shouldRoundTrip_whenCreatedRenamedAndDeleted() throws IOException {
        final GitLab gitLab = ENV.gitLab();
        final String name = ENV.name("label");
        final String renamed = ENV.name("renamed");
        String current = name;
        try {
            final GitLabProjectLabel created = create(gitLab, name);
            final Optional<GitLabProjectLabel> fetched = gitLab.labels().get(ENV.project(), name);
            final GitLabProjectLabel updated = gitLab.labels()
                    .update(
                            ENV.project(),
                            GitLabProjectLabelsUpdatePayloadBuilder.builder()
                                    .name(name)
                                    .newName(renamed)
                                    .build());
            current = renamed;
            final Optional<GitLabProjectLabel> refetched = gitLab.labels().get(ENV.project(), renamed);

            assertSoftly(softly -> {
                softly.assertThat(created.name()).isEqualTo(name);
                softly.assertThat(fetched).map(GitLabProjectLabel::description).contains("created by a smoke test");
                softly.assertThat(updated.name()).isEqualTo(renamed);
                softly.assertThat(refetched).map(GitLabProjectLabel::id).contains(created.id());
            });
        } finally {
            delete(gitLab, current);
        }
    }

    @Test
    void get_shouldBeEmpty_whenTheLabelWasDeleted() throws IOException {
        final GitLab gitLab = ENV.gitLab();
        final String name = ENV.name("gone");
        create(gitLab, name);
        delete(gitLab, name);

        final Optional<GitLabProjectLabel> label = gitLab.labels().get(ENV.project(), name);

        assertThat(label).isEmpty();
    }

    @Test
    void list_shouldReachASecondPage_whenPerPageIsOne() throws IOException {
        final GitLab gitLab = ENV.gitLab();
        final String first = ENV.name("page-one");
        final String second = ENV.name("page-two");
        create(gitLab, first);
        try {
            create(gitLab, second);
            try {
                final GitLabPage<GitLabProjectLabel> page =
                        gitLab.labels().list(ENV.project(), GitLabOffsetRequest.of(1, 1));
                final Optional<GitLabPage<GitLabProjectLabel>> next = page.next();

                assertSoftly(softly -> {
                    softly.assertThat(page.items()).hasSize(1);
                    softly.assertThat(next).isPresent();
                });
            } finally {
                delete(gitLab, second);
            }
        } finally {
            delete(gitLab, first);
        }
    }
}
