package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusTest {

    @Test
    void constructor_shouldRefuseNull_whenContainerIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .container(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("container");
    }

    @Test
    void constructor_shouldRefuseNull_whenAbuseIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .abuse(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("abuse");
    }

    @Test
    void constructor_shouldRefuseNull_whenAchievementIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .achievement(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("achievement");
    }

    @Test
    void constructor_shouldRefuseNull_whenAlertIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .alert(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("alert");
    }

    @Test
    void constructor_shouldRefuseNull_whenAppearanceIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .appearance(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("appearance");
    }

    @Test
    void constructor_shouldRefuseNull_whenBulkIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .bulk(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("bulk");
    }

    @Test
    void constructor_shouldRefuseNull_whenCiIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .ci(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("ci");
    }

    @Test
    void constructor_shouldRefuseNull_whenDependencyIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .dependency(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("dependency");
    }

    @Test
    void constructor_shouldRefuseNull_whenDesignIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .design(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("design");
    }

    @Test
    void constructor_shouldRefuseNull_whenGroupIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .group(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("group");
    }

    @Test
    void constructor_shouldRefuseNull_whenImportValueIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .importValue(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("importValue");
    }

    @Test
    void constructor_shouldRefuseNull_whenIssuableIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .issuable(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("issuable");
    }

    @Test
    void constructor_shouldRefuseNull_whenJobIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .job(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("job");
    }

    @Test
    void constructor_shouldRefuseNull_whenLfsIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .lfs(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("lfs");
    }

    @Test
    void constructor_shouldRefuseNull_whenMergeIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .merge(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("merge");
    }

    @Test
    void constructor_shouldRefuseNull_whenOrganizationIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .organization(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("organization");
    }

    @Test
    void constructor_shouldRefuseNull_whenPackageValueIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .packageValue(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("packageValue");
    }

    @Test
    void constructor_shouldRefuseNull_whenPackagesIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .packages(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("packages");
    }

    @Test
    void constructor_shouldRefuseNull_whenPagesIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .pages(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("pages");
    }

    @Test
    void constructor_shouldRefuseNull_whenPersonalIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .personal(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("personal");
    }

    @Test
    void constructor_shouldRefuseNull_whenPipelineIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .pipeline(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("pipeline");
    }

    @Test
    void constructor_shouldRefuseNull_whenProjectIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .project(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("project");
    }

    @Test
    void constructor_shouldRefuseNull_whenSnippetIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .snippet(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("snippet");
    }

    @Test
    void constructor_shouldRefuseNull_whenSupplyIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .supply(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("supply");
    }

    @Test
    void constructor_shouldRefuseNull_whenTerraformIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .terraform(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("terraform");
    }

    @Test
    void constructor_shouldRefuseNull_whenUploadsIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .uploads(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("uploads");
    }

    @Test
    void constructor_shouldRefuseNull_whenUserIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .user(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("user");
    }

    @Test
    void constructor_shouldRefuseNull_whenVulnerabilityIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .vulnerability(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("vulnerability");
    }

    @Test
    void constructor_shouldRefuseNull_whenAiIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .ai(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("ai");
    }

    @Test
    void constructor_shouldRefuseNull_whenOtherIsNull() {
        final GitLabGeoNodeStatusBuilder builder = GitLabGeoNodeStatusBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatus())
                .other(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("other");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatus value = CommonCatalogFixtures.geoNodeStatus();

        assertSoftly(softly -> {
            softly.assertThat(value.container()).isEqualTo(CommonCatalogFixtures.geoNodeStatusContainer());
            softly.assertThat(value.abuse()).isEqualTo(CommonCatalogFixtures.geoNodeStatusAbuse());
            softly.assertThat(value.achievement()).isEqualTo(CommonCatalogFixtures.geoNodeStatusAchievement());
            softly.assertThat(value.alert()).isEqualTo(CommonCatalogFixtures.geoNodeStatusAlert());
            softly.assertThat(value.appearance()).isEqualTo(CommonCatalogFixtures.geoNodeStatusAppearance());
            softly.assertThat(value.bulk()).isEqualTo(CommonCatalogFixtures.geoNodeStatusBulk());
            softly.assertThat(value.ci()).isEqualTo(CommonCatalogFixtures.geoNodeStatusCi());
            softly.assertThat(value.dependency()).isEqualTo(CommonCatalogFixtures.geoNodeStatusDependency());
            softly.assertThat(value.design()).isEqualTo(CommonCatalogFixtures.geoNodeStatusDesign());
            softly.assertThat(value.group()).isEqualTo(CommonCatalogFixtures.geoNodeStatusGroup());
            softly.assertThat(value.importValue()).isEqualTo(CommonCatalogFixtures.geoNodeStatusImport());
            softly.assertThat(value.issuable()).isEqualTo(CommonCatalogFixtures.geoNodeStatusIssuable());
            softly.assertThat(value.job()).isEqualTo(CommonCatalogFixtures.geoNodeStatusJob());
            softly.assertThat(value.lfs()).isEqualTo(CommonCatalogFixtures.geoNodeStatusLfs());
            softly.assertThat(value.merge()).isEqualTo(CommonCatalogFixtures.geoNodeStatusMerge());
            softly.assertThat(value.organization()).isEqualTo(CommonCatalogFixtures.geoNodeStatusOrganization());
            softly.assertThat(value.packageValue()).isEqualTo(CommonCatalogFixtures.geoNodeStatusPackage());
            softly.assertThat(value.packages()).isEqualTo(CommonCatalogFixtures.geoNodeStatusPackages());
            softly.assertThat(value.pages()).isEqualTo(CommonCatalogFixtures.geoNodeStatusPages());
            softly.assertThat(value.personal()).isEqualTo(CommonCatalogFixtures.geoNodeStatusPersonal());
            softly.assertThat(value.pipeline()).isEqualTo(CommonCatalogFixtures.geoNodeStatusPipeline());
            softly.assertThat(value.project()).isEqualTo(CommonCatalogFixtures.geoNodeStatusProject());
            softly.assertThat(value.snippet()).isEqualTo(CommonCatalogFixtures.geoNodeStatusSnippet());
            softly.assertThat(value.supply()).isEqualTo(CommonCatalogFixtures.geoNodeStatusSupply());
            softly.assertThat(value.terraform()).isEqualTo(CommonCatalogFixtures.geoNodeStatusTerraform());
            softly.assertThat(value.uploads()).isEqualTo(CommonCatalogFixtures.geoNodeStatusUploads());
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.geoNodeStatusUser());
            softly.assertThat(value.vulnerability()).isEqualTo(CommonCatalogFixtures.geoNodeStatusVulnerability());
            softly.assertThat(value.ai()).isEqualTo(CommonCatalogFixtures.geoNodeStatusAi());
            softly.assertThat(value.other()).isEqualTo(CommonCatalogFixtures.geoNodeStatusOther());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodeStatus original = CommonCatalogFixtures.geoNodeStatus();

        final GitLabGeoNodeStatus rebuilt =
                GitLabGeoNodeStatusBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatus.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "container",
                        "abuse",
                        "achievement",
                        "alert",
                        "appearance",
                        "bulk",
                        "ci",
                        "dependency",
                        "design",
                        "group",
                        "importValue",
                        "issuable",
                        "job",
                        "lfs",
                        "merge",
                        "organization",
                        "packageValue",
                        "packages",
                        "pages",
                        "personal",
                        "pipeline",
                        "project",
                        "snippet",
                        "supply",
                        "terraform",
                        "uploads",
                        "user",
                        "vulnerability",
                        "ai",
                        "other");
    }
}
