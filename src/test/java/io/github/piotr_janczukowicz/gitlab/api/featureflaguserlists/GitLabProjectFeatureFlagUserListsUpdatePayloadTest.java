package io.github.piotr_janczukowicz.gitlab.api.featureflaguserlists;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectFeatureFlagUserListsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectFeatureFlagUserListsUpdatePayloadBuilder builder =
                GitLabProjectFeatureFlagUserListsUpdatePayloadBuilder.builder(
                                FeatureflaguserlistsCatalogFixtures.projectFeatureFlagUserListsUpdatePayload())
                        .name(null);

        final GitLabProjectFeatureFlagUserListsUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserXidsIsNullable() {
        final GitLabProjectFeatureFlagUserListsUpdatePayloadBuilder builder =
                GitLabProjectFeatureFlagUserListsUpdatePayloadBuilder.builder(
                                FeatureflaguserlistsCatalogFixtures.projectFeatureFlagUserListsUpdatePayload())
                        .userXids(null);

        final GitLabProjectFeatureFlagUserListsUpdatePayload built = builder.build();

        assertThat(built.userXids()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectFeatureFlagUserListsUpdatePayload value =
                FeatureflaguserlistsCatalogFixtures.projectFeatureFlagUserListsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.userXids()).isEqualTo("user_xids");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectFeatureFlagUserListsUpdatePayload original =
                FeatureflaguserlistsCatalogFixtures.projectFeatureFlagUserListsUpdatePayload();

        final GitLabProjectFeatureFlagUserListsUpdatePayload rebuilt =
                GitLabProjectFeatureFlagUserListsUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectFeatureFlagUserListsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "userXids");
    }
}
