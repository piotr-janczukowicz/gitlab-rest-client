package io.github.piotr_janczukowicz.gitlab.api.protectedcontainerregistry;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabContainerRegistryRuleCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenRepositoryPathPatternIsNullable() {
        final GitLabContainerRegistryRuleCreatePayloadBuilder builder =
                GitLabContainerRegistryRuleCreatePayloadBuilder.builder(
                                ProtectedcontainerregistryCatalogFixtures.containerRegistryRuleCreatePayload())
                        .repositoryPathPattern(null);

        final GitLabContainerRegistryRuleCreatePayload built = builder.build();

        assertThat(built.repositoryPathPattern()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelForPushIsNullable() {
        final GitLabContainerRegistryRuleCreatePayloadBuilder builder =
                GitLabContainerRegistryRuleCreatePayloadBuilder.builder(
                                ProtectedcontainerregistryCatalogFixtures.containerRegistryRuleCreatePayload())
                        .minimumAccessLevelForPush(null);

        final GitLabContainerRegistryRuleCreatePayload built = builder.build();

        assertThat(built.minimumAccessLevelForPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelForDeleteIsNullable() {
        final GitLabContainerRegistryRuleCreatePayloadBuilder builder =
                GitLabContainerRegistryRuleCreatePayloadBuilder.builder(
                                ProtectedcontainerregistryCatalogFixtures.containerRegistryRuleCreatePayload())
                        .minimumAccessLevelForDelete(null);

        final GitLabContainerRegistryRuleCreatePayload built = builder.build();

        assertThat(built.minimumAccessLevelForDelete()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabContainerRegistryRuleCreatePayload value =
                ProtectedcontainerregistryCatalogFixtures.containerRegistryRuleCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.repositoryPathPattern()).isEqualTo("repository_path_pattern");
            softly.assertThat(value.minimumAccessLevelForPush())
                    .isEqualTo(GitLabContainerRegistryRuleCreateMinimumAccessLevelForPush.MAINTAINER);
            softly.assertThat(value.minimumAccessLevelForDelete())
                    .isEqualTo(GitLabContainerRegistryRuleCreateMinimumAccessLevelForDelete.MAINTAINER);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabContainerRegistryRuleCreatePayload original =
                ProtectedcontainerregistryCatalogFixtures.containerRegistryRuleCreatePayload();

        final GitLabContainerRegistryRuleCreatePayload rebuilt =
                GitLabContainerRegistryRuleCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabContainerRegistryRuleCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("repositoryPathPattern", "minimumAccessLevelForPush", "minimumAccessLevelForDelete");
    }
}
