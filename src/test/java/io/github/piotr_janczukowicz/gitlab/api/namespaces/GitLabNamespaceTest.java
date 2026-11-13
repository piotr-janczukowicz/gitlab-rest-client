package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNamespaceTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .id(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .name(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .path(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKindIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .kind(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.kind()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullPathIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .fullPath(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.fullPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParentIdIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .parentId(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.parentId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .avatarUrl(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .webUrl(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMembersCountWithDescendantsIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .membersCountWithDescendants(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.membersCountWithDescendants()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRootRepositorySizeIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .rootRepositorySize(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.rootRepositorySize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectsCountIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .projectsCount(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.projectsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedRunnersMinutesLimitIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .sharedRunnersMinutesLimit(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.sharedRunnersMinutesLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiMinutesUsageIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .ciMinutesUsage(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.ciMinutesUsage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExtraSharedRunnersMinutesLimitIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .extraSharedRunnersMinutesLimit(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.extraSharedRunnersMinutesLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdditionalPurchasedStorageSizeIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .additionalPurchasedStorageSize(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.additionalPurchasedStorageSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdditionalPurchasedStorageEndsOnIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .additionalPurchasedStorageEndsOn(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.additionalPurchasedStorageEndsOn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBillableMembersCountIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .billableMembersCount(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.billableMembersCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSeatsInUseIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .seatsInUse(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.seatsInUse()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxSeatsUsedIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .maxSeatsUsed(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.maxSeatsUsed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxSeatsUsedChangedAtIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .maxSeatsUsedChangedAt(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.maxSeatsUsedChangedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndDateIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .endDate(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.endDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlanIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .plan(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.plan()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTrialEndsOnIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .trialEndsOn(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.trialEndsOn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTrialIsNullable() {
        final GitLabNamespaceBuilder builder = GitLabNamespaceBuilder.builder(NamespacesCatalogFixtures.namespace())
                .trial(null);

        final GitLabNamespace built = builder.build();

        assertThat(built.trial()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNamespace value = NamespacesCatalogFixtures.namespace();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("project");
            softly.assertThat(value.path()).isEqualTo("my_project");
            softly.assertThat(value.kind()).isEqualTo("project");
            softly.assertThat(value.fullPath()).isEqualTo("group/my_project");
            softly.assertThat(value.parentId()).isEqualTo(1L);
            softly.assertThat(value.avatarUrl()).isEqualTo("https://example.com/avatar/12345");
            softly.assertThat(value.webUrl()).isEqualTo("https://example.com/group/my_project");
            softly.assertThat(value.membersCountWithDescendants()).isEqualTo(1);
            softly.assertThat(value.rootRepositorySize()).isEqualTo(1L);
            softly.assertThat(value.projectsCount()).isEqualTo(1);
            softly.assertThat(value.sharedRunnersMinutesLimit()).isEqualTo(1);
            softly.assertThat(value.ciMinutesUsage()).isEqualTo(NamespacesCatalogFixtures.ciMinutesUsage());
            softly.assertThat(value.extraSharedRunnersMinutesLimit()).isEqualTo(1);
            softly.assertThat(value.additionalPurchasedStorageSize()).isEqualTo(1L);
            softly.assertThat(value.additionalPurchasedStorageEndsOn()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.billableMembersCount()).isEqualTo(1);
            softly.assertThat(value.seatsInUse()).isEqualTo(1);
            softly.assertThat(value.maxSeatsUsed()).isEqualTo(1);
            softly.assertThat(value.maxSeatsUsedChangedAt()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.endDate()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.plan()).isEqualTo("default");
            softly.assertThat(value.trialEndsOn()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.trial()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNamespace original = NamespacesCatalogFixtures.namespace();

        final GitLabNamespace rebuilt = GitLabNamespaceBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNamespace.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "name",
                        "path",
                        "kind",
                        "fullPath",
                        "parentId",
                        "avatarUrl",
                        "webUrl",
                        "membersCountWithDescendants",
                        "rootRepositorySize",
                        "projectsCount",
                        "sharedRunnersMinutesLimit",
                        "ciMinutesUsage",
                        "extraSharedRunnersMinutesLimit",
                        "additionalPurchasedStorageSize",
                        "additionalPurchasedStorageEndsOn",
                        "billableMembersCount",
                        "seatsInUse",
                        "maxSeatsUsed",
                        "maxSeatsUsedChangedAt",
                        "endDate",
                        "plan",
                        "trialEndsOn",
                        "trial");
    }
}
