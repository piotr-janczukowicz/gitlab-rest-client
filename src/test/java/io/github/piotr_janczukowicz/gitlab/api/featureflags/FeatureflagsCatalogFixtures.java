package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public final class FeatureflagsCatalogFixtures {

    private FeatureflagsCatalogFixtures() {}

    public static GitLabFeature feature() {
        return GitLabFeatureBuilder.builder()
                .name("experimental_feature")
                .state("off")
                .gates(List.of(CommonCatalogFixtures.featureGate()))
                .definition(CommonCatalogFixtures.featureDefinition())
                .build();
    }

    public static GitLabFeatureFlag featureFlag() {
        return GitLabFeatureFlagBuilder.builder()
                .name("merge_train")
                .description("merge train feature flag")
                .active(true)
                .version("new_version_flag")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .strategies(List.of(FeatureflagsCatalogFixtures.featureFlagStrategy()))
                .build();
    }

    public static GitLabFeatureFlagBasicUserList featureFlagBasicUserList() {
        return GitLabFeatureFlagBasicUserListBuilder.builder()
                .id(1L)
                .iid(1L)
                .name("user_list")
                .userXids("user1,user2")
                .build();
    }

    public static GitLabFeatureFlagScope featureFlagScope() {
        return GitLabFeatureFlagScopeBuilder.builder()
                .id(1L)
                .environmentScope("production")
                .build();
    }

    public static GitLabFeatureFlagSettings featureFlagSettings() {
        return GitLabFeatureFlagSettingsBuilder.builder()
                .minimumRole("developer")
                .build();
    }

    public static GitLabFeatureFlagStrategy featureFlagStrategy() {
        return GitLabFeatureFlagStrategyBuilder.builder()
                .id(1L)
                .name("userWithId")
                .parameters("{\"userIds\": \"user1\"}")
                .scopes(List.of(FeatureflagsCatalogFixtures.featureFlagScope()))
                .userList(FeatureflagsCatalogFixtures.featureFlagBasicUserList())
                .build();
    }

    public static GitLabInstanceFeatureFlagsCreatePayload instanceFeatureFlagsCreatePayload() {
        return GitLabInstanceFeatureFlagsCreatePayloadBuilder.builder()
                .value("text")
                .key(GitLabInstanceFeatureFlagsCreateKey.PERCENTAGE_OF_ACTORS)
                .featureGroup("feature_group")
                .user("user")
                .group("group")
                .namespace("namespace")
                .project("project")
                .organization("organization")
                .repository("repository")
                .runner("runner")
                .endpoint("endpoint")
                .force(true)
                .build();
    }

    public static GitLabProjectFeatureFlagsCreatePayload projectFeatureFlagsCreatePayload() {
        return GitLabProjectFeatureFlagsCreatePayloadBuilder.builder()
                .name("name")
                .description("description")
                .active(true)
                .strategies(List.of(FeatureflagsCatalogFixtures.projectFeatureFlagsCreateStrategy()))
                .build();
    }

    public static GitLabProjectFeatureFlagsCreateStrategy projectFeatureFlagsCreateStrategy() {
        return GitLabProjectFeatureFlagsCreateStrategyBuilder.builder()
                .name("name")
                .parameters(Map.of("key", "value"))
                .userListId(1L)
                .scopes(List.of(FeatureflagsCatalogFixtures.projectFeatureFlagsCreateStrategyScope()))
                .build();
    }

    public static GitLabProjectFeatureFlagsCreateStrategyScope projectFeatureFlagsCreateStrategyScope() {
        return GitLabProjectFeatureFlagsCreateStrategyScopeBuilder.builder()
                .environmentScope("environment_scope")
                .build();
    }

    public static GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingPayload
            projectFeatureFlagsUpdateFeatureFlagsSettingPayload() {
        return GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingPayloadBuilder.builder()
                .minimumRole(GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingMinimumRole.NO_ONE_ALLOWED)
                .build();
    }

    public static GitLabProjectFeatureFlagsUpdatePayload projectFeatureFlagsUpdatePayload() {
        return GitLabProjectFeatureFlagsUpdatePayloadBuilder.builder()
                .name("name")
                .description("description")
                .active(true)
                .strategies(List.of(FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategy()))
                .build();
    }

    public static GitLabProjectFeatureFlagsUpdateStrategy projectFeatureFlagsUpdateStrategy() {
        return GitLabProjectFeatureFlagsUpdateStrategyBuilder.builder()
                .id(1L)
                .name("name")
                .parameters(Map.of("key", "value"))
                .userListId(1L)
                .destroy(true)
                .scopes(List.of(FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategyScope()))
                .build();
    }

    public static GitLabProjectFeatureFlagsUpdateStrategyScope projectFeatureFlagsUpdateStrategyScope() {
        return GitLabProjectFeatureFlagsUpdateStrategyScopeBuilder.builder()
                .id(1L)
                .environmentScope("environment_scope")
                .destroy(true)
                .build();
    }
}
