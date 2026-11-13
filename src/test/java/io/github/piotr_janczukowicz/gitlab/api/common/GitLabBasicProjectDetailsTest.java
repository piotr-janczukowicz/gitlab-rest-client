package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBasicProjectDetailsTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .id(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .description(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .name(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameWithNamespaceIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .nameWithNamespace(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.nameWithNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .path(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathWithNamespaceIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .pathWithNamespace(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.pathWithNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .createdAt(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultBranchIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .defaultBranch(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.defaultBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagListIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .tagList(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.tagList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTopicsIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .topics(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.topics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSshUrlToRepoIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .sshUrlToRepo(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.sshUrlToRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHttpUrlToRepoIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .httpUrlToRepo(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.httpUrlToRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .webUrl(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadmeUrlIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .readmeUrl(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.readmeUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForksCountIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .forksCount(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.forksCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLicenseUrlIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .licenseUrl(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.licenseUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLicenseIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .license(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.license()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .avatarUrl(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStarCountIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .starCount(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.starCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastActivityAtIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .lastActivityAt(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.lastActivityAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .visibility(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .namespace(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.namespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .customAttributes(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryStorageIsNullable() {
        final GitLabBasicProjectDetailsBuilder builder = GitLabBasicProjectDetailsBuilder.builder(
                        CommonCatalogFixtures.basicProjectDetails())
                .repositoryStorage(null);

        final GitLabBasicProjectDetails built = builder.build();

        assertThat(built.repositoryStorage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBasicProjectDetails value = CommonCatalogFixtures.basicProjectDetails();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.description()).isEqualTo("desc");
            softly.assertThat(value.name()).isEqualTo("project1");
            softly.assertThat(value.nameWithNamespace()).isEqualTo("John Doe / project1");
            softly.assertThat(value.path()).isEqualTo("project1");
            softly.assertThat(value.pathWithNamespace()).isEqualTo("namespace1/project1");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.defaultBranch()).isEqualTo("main");
            softly.assertThat(value.tagList()).isEqualTo(List.of("tag"));
            softly.assertThat(value.topics()).isEqualTo(List.of("topic"));
            softly.assertThat(value.sshUrlToRepo()).isEqualTo("git@gitlab.example.com:gitlab/gitlab.git");
            softly.assertThat(value.httpUrlToRepo()).isEqualTo("https://gitlab.example.com/gitlab/gitlab.git");
            softly.assertThat(value.webUrl()).isEqualTo("https://gitlab.example.com/gitlab/gitlab");
            softly.assertThat(value.readmeUrl())
                    .isEqualTo("https://gitlab.example.com/gitlab/gitlab/blob/master/README.md");
            softly.assertThat(value.forksCount()).isEqualTo(1);
            softly.assertThat(value.licenseUrl())
                    .isEqualTo("https://gitlab.example.com/gitlab/gitlab/blob/master/LICENCE");
            softly.assertThat(value.license()).isEqualTo(CommonCatalogFixtures.licenseBasic());
            softly.assertThat(value.avatarUrl())
                    .isEqualTo("http://example.com/uploads/project/avatar/3/uploads/avatar.png");
            softly.assertThat(value.starCount()).isEqualTo(1);
            softly.assertThat(value.lastActivityAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.visibility()).isEqualTo("public");
            softly.assertThat(value.namespace()).isEqualTo(CommonCatalogFixtures.namespaceBasic());
            softly.assertThat(value.customAttributes()).isEqualTo(CommonCatalogFixtures.customAttribute());
            softly.assertThat(value.repositoryStorage()).isEqualTo("default");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBasicProjectDetails original = CommonCatalogFixtures.basicProjectDetails();

        final GitLabBasicProjectDetails rebuilt =
                GitLabBasicProjectDetailsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBasicProjectDetails.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "description",
                        "name",
                        "nameWithNamespace",
                        "path",
                        "pathWithNamespace",
                        "createdAt",
                        "defaultBranch",
                        "tagList",
                        "topics",
                        "sshUrlToRepo",
                        "httpUrlToRepo",
                        "webUrl",
                        "readmeUrl",
                        "forksCount",
                        "licenseUrl",
                        "license",
                        "avatarUrl",
                        "starCount",
                        "lastActivityAt",
                        "visibility",
                        "namespace",
                        "customAttributes",
                        "repositoryStorage");
    }
}
