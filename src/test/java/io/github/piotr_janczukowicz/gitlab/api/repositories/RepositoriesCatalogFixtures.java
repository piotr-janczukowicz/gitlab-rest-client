package io.github.piotr_janczukowicz.gitlab.api.repositories;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public final class RepositoriesCatalogFixtures {

    private RepositoriesCatalogFixtures() {}

    public static GitLabBatchBlob batchBlob() {
        return GitLabBatchBlobBuilder.builder()
                .path("app/models/user.rb")
                .ref("main")
                .size(1L)
                .truncated(true)
                .encoding("base64")
                .content("VGhpcyBpcyBhIGZpbGU=")
                .build();
    }

    public static GitLabChangedPath changedPath() {
        return GitLabChangedPathBuilder.builder()
                .status("MODIFIED")
                .path("app/models/user.rb")
                .oldPath("app/models/user.rb")
                .oldMode("100644")
                .newMode("100644")
                .build();
    }

    public static GitLabChangelog changelog() {
        return GitLabChangelogBuilder.builder().notes("## 1.0.0 (2023-01-01)").build();
    }

    public static GitLabCompare compare() {
        return GitLabCompareBuilder.builder()
                .commit(CommonCatalogFixtures.commit())
                .commits(List.of(CommonCatalogFixtures.commit()))
                .diffs(List.of(CommonCatalogFixtures.diff()))
                .compareTimeout(true)
                .compareSameRef(true)
                .webUrl("https://gitlab.example.com/gitlab/gitlab-foss/-/compare/main...feature")
                .build();
    }

    public static GitLabContributor contributor() {
        return GitLabContributorBuilder.builder()
                .name("John Doe")
                .email("johndoe@example.com")
                .commits(1)
                .additions(1)
                .deletions(1)
                .build();
    }

    public static GitLabDiffStat diffStat() {
        return GitLabDiffStatBuilder.builder()
                .path("app/models/user.rb")
                .oldPath("app/models/user.rb")
                .additions(1)
                .deletions(1)
                .build();
    }

    public static GitLabDivergingCommitCount divergingCommitCount() {
        return GitLabDivergingCommitCountBuilder.builder().behind(1).ahead(1).build();
    }

    public static GitLabProjectRepositoriesBatchBlobFile projectRepositoriesBatchBlobFile() {
        return GitLabProjectRepositoriesBatchBlobFileBuilder.builder()
                .path("app/models/user.rb")
                .ref("main")
                .build();
    }

    public static GitLabProjectRepositoriesBatchBlobPayload projectRepositoriesBatchBlobPayload() {
        return GitLabProjectRepositoriesBatchBlobPayloadBuilder.builder()
                .files(List.of(RepositoriesCatalogFixtures.projectRepositoriesBatchBlobFile()))
                .build();
    }

    public static GitLabProjectRepositoriesCreateChangelogPayload projectRepositoriesCreateChangelogPayload() {
        return GitLabProjectRepositoriesCreateChangelogPayloadBuilder.builder()
                .fromValue("ed899a2f4b50b4370feeea94676502b42383c746")
                .to("6104942438c14ec7bd21c6cd5bd995272b3faff6")
                .date(Instant.parse("2026-01-01T00:00:00Z"))
                .trailer("Changelog")
                .configFile(".gitlab/changelog_config.yml")
                .configFileRef("main")
                .branch("main")
                .file("CHANGELOG.md")
                .message("Initial commit")
                .build();
    }

    public static GitLabRepositoryHealth repositoryHealth() {
        return GitLabRepositoryHealthBuilder.builder()
                .size(1L)
                .references(RepositoriesCatalogFixtures.repositoryHealthReferences())
                .objects(RepositoriesCatalogFixtures.repositoryHealthObjects())
                .commitGraph(RepositoriesCatalogFixtures.repositoryHealthCommitGraph())
                .bitmap(RepositoriesCatalogFixtures.repositoryHealthBitmap())
                .multiPackIndex(RepositoriesCatalogFixtures.repositoryHealthMultiPackIndex())
                .multiPackIndexBitmap(RepositoriesCatalogFixtures.repositoryHealthBitmap())
                .alternates(Map.of("key", "value"))
                .isObjectPool(true)
                .lastFullRepack(RepositoriesCatalogFixtures.repositoryHealthLastFullRepack())
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabRepositoryHealthBitmap repositoryHealthBitmap() {
        return GitLabRepositoryHealthBitmapBuilder.builder()
                .hasHashCache(true)
                .hasLookupTable(true)
                .version(1)
                .build();
    }

    public static GitLabRepositoryHealthCommitGraph repositoryHealthCommitGraph() {
        return GitLabRepositoryHealthCommitGraphBuilder.builder()
                .commitGraphChainLength(1)
                .hasBloomFilters(true)
                .hasGenerationData(true)
                .hasGenerationDataOverflow(true)
                .build();
    }

    public static GitLabRepositoryHealthLastFullRepack repositoryHealthLastFullRepack() {
        return GitLabRepositoryHealthLastFullRepackBuilder.builder()
                .seconds(1)
                .nanos(1)
                .build();
    }

    public static GitLabRepositoryHealthMultiPackIndex repositoryHealthMultiPackIndex() {
        return GitLabRepositoryHealthMultiPackIndexBuilder.builder()
                .packfileCount(1)
                .version(1)
                .build();
    }

    public static GitLabRepositoryHealthObjects repositoryHealthObjects() {
        return GitLabRepositoryHealthObjectsBuilder.builder()
                .size(1L)
                .recentSize(1L)
                .staleSize(1L)
                .keepSize(1L)
                .packfileCount(1)
                .reverseIndexCount(1)
                .cruftCount(1)
                .keepCount(1)
                .looseObjectsCount(1)
                .staleLooseObjectsCount(1)
                .looseObjectsGarbageCount(1)
                .build();
    }

    public static GitLabRepositoryHealthReferences repositoryHealthReferences() {
        return GitLabRepositoryHealthReferencesBuilder.builder()
                .looseCount(1)
                .packedSize(1L)
                .referenceBackend("reference_backend")
                .build();
    }

    public static GitLabTreeObject treeObject() {
        return GitLabTreeObjectBuilder.builder()
                .id("a1e8f8d745cc87e3a9248358d9352bb7f9a0aeba")
                .name("html")
                .type("tree")
                .path("files/html")
                .mode("040000")
                .lastCommit(CommonCatalogFixtures.commit())
                .build();
    }
}
