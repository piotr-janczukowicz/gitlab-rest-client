package io.github.piotr_janczukowicz.gitlab.smoke;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.GitLab;
import io.github.piotr_janczukowicz.gitlab.api.branches.GitLabBranch;
import io.github.piotr_janczukowicz.gitlab.api.branches.GitLabProjectBranchesCreatePayloadBuilder;
import io.github.piotr_janczukowicz.gitlab.api.projects.GitLabProjectWithAccessAndCatalog;
import io.github.piotr_janczukowicz.gitlab.api.repositoryfiles.GitLabProjectRepositoryFilesCreateResponse;
import io.github.piotr_janczukowicz.gitlab.api.repositoryfiles.GitLabProjectRepositoryFilesGetRawFilter;
import io.github.piotr_janczukowicz.gitlab.api.repositoryfiles.GitLabProjectRepositoryFilesGetRawFilterBuilder;
import io.github.piotr_janczukowicz.gitlab.api.repositoryfiles.GitLabProjectRepositoryFilesGetResponse;
import io.github.piotr_janczukowicz.gitlab.api.repositoryfiles.GitLabProjectRepositoryFilesUpdateResponse;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class FilesSmokeIT {

    private static final SmokeEnvironment ENV = SmokeEnvironment.fromEnv();

    @BeforeAll
    static void requireToken() {
        ENV.requireConfigured();
    }

    private static MultipartFormData form(final String branch, final String content, final String message) {
        return MultipartFormData.builder()
                .text("branch", branch)
                .text("content", content)
                .text("commit_message", message)
                .build();
    }

    private static String raw(final GitLab gitLab, final String path, final String branch) throws IOException {
        final GitLabProjectRepositoryFilesGetRawFilter filter =
                GitLabProjectRepositoryFilesGetRawFilterBuilder.builder()
                        .ref(branch)
                        .build();
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        gitLab.repositoryfiles().getRaw(ENV.project(), path, filter, out);
        return out.toString(UTF_8);
    }

    @Test
    void file_shouldRoundTrip_whenCreatedUpdatedReadAndDeletedOnABranch() throws IOException {
        final GitLab gitLab = ENV.gitLab();
        final String defaultBranch = gitLab.projects()
                .project()
                .get(ENV.project())
                .map(GitLabProjectWithAccessAndCatalog::defaultBranch)
                .orElseThrow();
        final String branch = ENV.name("files");
        final String path = ENV.name("file") + ".txt";
        gitLab.branches()
                .create(
                        ENV.project(),
                        GitLabProjectBranchesCreatePayloadBuilder.builder()
                                .branch(branch)
                                .ref(defaultBranch)
                                .build());
        try {
            final GitLabProjectRepositoryFilesCreateResponse created =
                    gitLab.repositoryfiles().create(ENV.project(), path, form(branch, "first", "smoke: create"));
            final GitLabProjectRepositoryFilesGetResponse read =
                    gitLab.repositoryfiles().get(ENV.project(), path, branch).orElseThrow();
            final String first = raw(gitLab, path, branch);
            final GitLabProjectRepositoryFilesUpdateResponse updated =
                    gitLab.repositoryfiles().update(ENV.project(), path, form(branch, "second", "smoke: update"));
            final String second = raw(gitLab, path, branch);
            gitLab.repositoryfiles().delete(ENV.project(), path, branch, "smoke: delete");
            final Optional<GitLabBranch> afterDelete = gitLab.branches().get(ENV.project(), branch);

            assertSoftly(softly -> {
                softly.assertThat(created.filePath()).isEqualTo(path);
                softly.assertThat(created.branch()).isEqualTo(branch);
                softly.assertThat(read.fileName()).isEqualTo(path);
                softly.assertThat(read.executeFilemode()).isFalse();
                softly.assertThat(updated.filePath()).isEqualTo(path);
                softly.assertThat(first).isEqualTo("first");
                softly.assertThat(second).isEqualTo("second");
                softly.assertThat(afterDelete).isPresent();
            });
        } finally {
            gitLab.branches().delete(ENV.project(), branch);
        }
    }
}
