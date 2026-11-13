package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import java.time.LocalDate;
import java.util.List;

public final class NamespacesCatalogFixtures {

    private NamespacesCatalogFixtures() {}

    public static GitLabCiMinutesUsage ciMinutesUsage() {
        return GitLabCiMinutesUsageBuilder.builder()
                .totalMinutesUsed(1)
                .monthlyMinutesUsed(1)
                .purchasedMinutesUsed(1)
                .build();
    }

    public static GitLabGitlabSubscription gitlabSubscription() {
        return GitLabGitlabSubscriptionBuilder.builder()
                .plan(NamespacesCatalogFixtures.gitlabSubscriptionPlan())
                .usage(NamespacesCatalogFixtures.gitlabSubscriptionUsage())
                .billing(NamespacesCatalogFixtures.gitlabSubscriptionBilling())
                .build();
    }

    public static GitLabGitlabSubscriptionBilling gitlabSubscriptionBilling() {
        return GitLabGitlabSubscriptionBillingBuilder.builder()
                .subscriptionStartDate(LocalDate.parse("2026-01-01"))
                .subscriptionEndDate(LocalDate.parse("2026-01-01"))
                .trialEndsOn(LocalDate.parse("2026-01-01"))
                .build();
    }

    public static GitLabGitlabSubscriptionPlan gitlabSubscriptionPlan() {
        return GitLabGitlabSubscriptionPlanBuilder.builder()
                .code("code")
                .name("name")
                .trial(true)
                .autoRenew(true)
                .upgradable(true)
                .excludeGuests(true)
                .build();
    }

    public static GitLabGitlabSubscriptionUsage gitlabSubscriptionUsage() {
        return GitLabGitlabSubscriptionUsageBuilder.builder()
                .seatsInSubscription(1)
                .seatsInUse(1)
                .maxSeatsUsed(1)
                .seatsOwed(1)
                .build();
    }

    public static GitLabNamespace namespace() {
        return GitLabNamespaceBuilder.builder()
                .id(1L)
                .name("project")
                .path("my_project")
                .kind("project")
                .fullPath("group/my_project")
                .parentId(1L)
                .avatarUrl("https://example.com/avatar/12345")
                .webUrl("https://example.com/group/my_project")
                .membersCountWithDescendants(1)
                .rootRepositorySize(1L)
                .projectsCount(1)
                .sharedRunnersMinutesLimit(1)
                .ciMinutesUsage(NamespacesCatalogFixtures.ciMinutesUsage())
                .extraSharedRunnersMinutesLimit(1)
                .additionalPurchasedStorageSize(1L)
                .additionalPurchasedStorageEndsOn(LocalDate.parse("2026-01-01"))
                .billableMembersCount(1)
                .seatsInUse(1)
                .maxSeatsUsed(1)
                .maxSeatsUsedChangedAt(LocalDate.parse("2026-01-01"))
                .endDate(LocalDate.parse("2026-01-01"))
                .plan("default")
                .trialEndsOn(LocalDate.parse("2026-01-01"))
                .trial(true)
                .build();
    }

    public static GitLabNamespaceExistence namespaceExistence() {
        return GitLabNamespaceExistenceBuilder.builder()
                .exists(true)
                .suggests(List.of("my-group1"))
                .build();
    }

    public static GitLabNamespaceStorageLimitExclusion namespaceStorageLimitExclusion() {
        return GitLabNamespaceStorageLimitExclusionBuilder.builder()
                .id(1L)
                .namespaceId(1L)
                .namespaceName("GitLab")
                .reason("a reason")
                .build();
    }

    public static GitLabNamespacesCreateStorageLimitExclusionPayload namespacesCreateStorageLimitExclusionPayload() {
        return GitLabNamespacesCreateStorageLimitExclusionPayloadBuilder.builder()
                .reason("reason")
                .build();
    }

    public static GitLabNamespacesUpdateGitlabSubscriptionAttributes namespacesUpdateGitlabSubscriptionAttributes() {
        return GitLabNamespacesUpdateGitlabSubscriptionAttributesBuilder.builder()
                .startDate(LocalDate.parse("2026-01-01"))
                .seats(1)
                .maxSeatsUsed(1)
                .planCode("plan_code")
                .endDate(LocalDate.parse("2026-01-01"))
                .autoRenew(true)
                .trial(true)
                .trialEndsOn(LocalDate.parse("2026-01-01"))
                .trialStartsOn(LocalDate.parse("2026-01-01"))
                .trialExtensionType(1)
                .build();
    }

    public static GitLabNamespacesUpdatePayload namespacesUpdatePayload() {
        return GitLabNamespacesUpdatePayloadBuilder.builder()
                .sharedRunnersMinutesLimit(1)
                .extraSharedRunnersMinutesLimit(1)
                .additionalPurchasedStorageSize(1L)
                .additionalPurchasedStorageEndsOn(LocalDate.parse("2026-01-01"))
                .gitlabSubscriptionAttributes(NamespacesCatalogFixtures.namespacesUpdateGitlabSubscriptionAttributes())
                .build();
    }
}
