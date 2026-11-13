package io.github.piotr_janczukowicz.gitlab.api.featureflaguserlists;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectFeatureFlagUserListsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectFeatureFlagUserListsCreatePayloadBuilder builder =
                GitLabProjectFeatureFlagUserListsCreatePayloadBuilder.builder(
                                FeatureflaguserlistsCatalogFixtures.projectFeatureFlagUserListsCreatePayload())
                        .name(null);

        final GitLabProjectFeatureFlagUserListsCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserXidsIsNullable() {
        final GitLabProjectFeatureFlagUserListsCreatePayloadBuilder builder =
                GitLabProjectFeatureFlagUserListsCreatePayloadBuilder.builder(
                                FeatureflaguserlistsCatalogFixtures.projectFeatureFlagUserListsCreatePayload())
                        .userXids(null);

        final GitLabProjectFeatureFlagUserListsCreatePayload built = builder.build();

        assertThat(built.userXids()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectFeatureFlagUserListsCreatePayload value =
                FeatureflaguserlistsCatalogFixtures.projectFeatureFlagUserListsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.userXids()).isEqualTo("user_xids");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectFeatureFlagUserListsCreatePayload original =
                FeatureflaguserlistsCatalogFixtures.projectFeatureFlagUserListsCreatePayload();

        final GitLabProjectFeatureFlagUserListsCreatePayload rebuilt =
                GitLabProjectFeatureFlagUserListsCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectFeatureFlagUserListsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "userXids");
    }
}
