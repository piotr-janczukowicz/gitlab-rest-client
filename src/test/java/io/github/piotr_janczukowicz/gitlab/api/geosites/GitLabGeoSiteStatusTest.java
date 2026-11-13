package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusTest {

    @Test
    void constructor_shouldRefuseNull_whenContainerIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .container(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("container");
    }

    @Test
    void constructor_shouldRefuseNull_whenAbuseIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .abuse(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("abuse");
    }

    @Test
    void constructor_shouldRefuseNull_whenAchievementIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .achievement(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("achievement");
    }

    @Test
    void constructor_shouldRefuseNull_whenAlertIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .alert(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("alert");
    }

    @Test
    void constructor_shouldRefuseNull_whenAppearanceIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .appearance(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("appearance");
    }

    @Test
    void constructor_shouldRefuseNull_whenBulkIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .bulk(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("bulk");
    }

    @Test
    void constructor_shouldRefuseNull_whenCiIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .ci(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("ci");
    }

    @Test
    void constructor_shouldRefuseNull_whenDependencyIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .dependency(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("dependency");
    }

    @Test
    void constructor_shouldRefuseNull_whenDesignIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .design(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("design");
    }

    @Test
    void constructor_shouldRefuseNull_whenGroupIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .group(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("group");
    }

    @Test
    void constructor_shouldRefuseNull_whenImportValueIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .importValue(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("importValue");
    }

    @Test
    void constructor_shouldRefuseNull_whenIssuableIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .issuable(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("issuable");
    }

    @Test
    void constructor_shouldRefuseNull_whenJobIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .job(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("job");
    }

    @Test
    void constructor_shouldRefuseNull_whenLfsIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .lfs(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("lfs");
    }

    @Test
    void constructor_shouldRefuseNull_whenMergeIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .merge(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("merge");
    }

    @Test
    void constructor_shouldRefuseNull_whenOrganizationIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .organization(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("organization");
    }

    @Test
    void constructor_shouldRefuseNull_whenPackageValueIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .packageValue(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("packageValue");
    }

    @Test
    void constructor_shouldRefuseNull_whenPackagesIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .packages(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("packages");
    }

    @Test
    void constructor_shouldRefuseNull_whenPagesIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .pages(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("pages");
    }

    @Test
    void constructor_shouldRefuseNull_whenPersonalIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .personal(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("personal");
    }

    @Test
    void constructor_shouldRefuseNull_whenPipelineIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .pipeline(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("pipeline");
    }

    @Test
    void constructor_shouldRefuseNull_whenProjectIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .project(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("project");
    }

    @Test
    void constructor_shouldRefuseNull_whenSnippetIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .snippet(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("snippet");
    }

    @Test
    void constructor_shouldRefuseNull_whenSupplyIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .supply(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("supply");
    }

    @Test
    void constructor_shouldRefuseNull_whenTerraformIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .terraform(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("terraform");
    }

    @Test
    void constructor_shouldRefuseNull_whenUploadsIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .uploads(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("uploads");
    }

    @Test
    void constructor_shouldRefuseNull_whenUserIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .user(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("user");
    }

    @Test
    void constructor_shouldRefuseNull_whenVulnerabilityIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .vulnerability(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("vulnerability");
    }

    @Test
    void constructor_shouldRefuseNull_whenAiIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .ai(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("ai");
    }

    @Test
    void constructor_shouldRefuseNull_whenOtherIsNull() {
        final GitLabGeoSiteStatusBuilder builder = GitLabGeoSiteStatusBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatus())
                .other(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("other");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatus value = GeositesCatalogFixtures.geoSiteStatus();

        assertSoftly(softly -> {
            softly.assertThat(value.container()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusContainer());
            softly.assertThat(value.abuse()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusAbuse());
            softly.assertThat(value.achievement()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusAchievement());
            softly.assertThat(value.alert()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusAlert());
            softly.assertThat(value.appearance()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusAppearance());
            softly.assertThat(value.bulk()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusBulk());
            softly.assertThat(value.ci()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusCi());
            softly.assertThat(value.dependency()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusDependency());
            softly.assertThat(value.design()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusDesign());
            softly.assertThat(value.group()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusGroup());
            softly.assertThat(value.importValue()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusImport());
            softly.assertThat(value.issuable()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusIssuable());
            softly.assertThat(value.job()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusJob());
            softly.assertThat(value.lfs()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusLfs());
            softly.assertThat(value.merge()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusMerge());
            softly.assertThat(value.organization()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusOrganization());
            softly.assertThat(value.packageValue()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusPackage());
            softly.assertThat(value.packages()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusPackages());
            softly.assertThat(value.pages()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusPages());
            softly.assertThat(value.personal()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusPersonal());
            softly.assertThat(value.pipeline()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusPipeline());
            softly.assertThat(value.project()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusProject());
            softly.assertThat(value.snippet()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusSnippet());
            softly.assertThat(value.supply()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusSupply());
            softly.assertThat(value.terraform()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusTerraform());
            softly.assertThat(value.uploads()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusUploads());
            softly.assertThat(value.user()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusUser());
            softly.assertThat(value.vulnerability()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusVulnerability());
            softly.assertThat(value.ai()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusAi());
            softly.assertThat(value.other()).isEqualTo(GeositesCatalogFixtures.geoSiteStatusOther());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSiteStatus original = GeositesCatalogFixtures.geoSiteStatus();

        final GitLabGeoSiteStatus rebuilt =
                GitLabGeoSiteStatusBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatus.class.getRecordComponents())
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
